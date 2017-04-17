package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.DAOException;

public class UtilsDAO {
	
	public static final Logger logger = Logger.getLogger(UtilsDAO.class);
	
	public UtilsDAO(){
			
	}

	/**
	 * Método para rellenar el cubo de liquidaciones para el reporte analítico.
	 * También se chequea el status de dicha tarjeta para decidir si se debe insertar o no en
	 * el cubo de recargas
	 * @param company
	 * @param denom
	 * @param cluster
	 * @param lot
	 * @param sublot
	 * @param serial
	 * @param date
	 * @param channel
	 * @param payment_type
	 * @param payment_method  
	 * @return
	 */
	public boolean fillLiquidationCube(Connection conn, short company, String denom, String cluster, String lot, String sublot, String serial, String date, String channel, String paymentType, String paymentMethod, String promotion){
		logger.debug("fillLiquidationCube!!!");
		boolean response=false;
		int execute_status=0;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		Vector<String> fetchLocationResponse=new Vector<String>();
		String industry,distributer,location,packing,method,network,time,money,amount;
		amount=null;
		packing=null;
		money=null;
		try {
			fetchLocationResponse = fetchLocation(conn, company, denom, cluster, lot, sublot, serial, channel, paymentType);
			location=fetchLocationResponse.elementAt(0);
			industry=fetchLocationResponse.elementAt(1);
			distributer=fetchLocationResponse.elementAt(2);
			if(channel=="2"){
				amount=fetchLocationResponse.elementAt(3);
			}
			
			if(channel=="1"){
				packing = fetchPacking(conn, company, denom, cluster, channel, "", promotion);
			} else if (channel=="2"){
				packing = fetchPacking(conn, company, denom, cluster, channel, amount, promotion);
			}

			method=fetchMethod(conn, company, channel, paymentType, paymentMethod);

			network=fetchNetwork(conn, company, distributer);

			time=fetchTime(conn, date);

			if(channel=="1"){
				money=fetchMoney(conn, company, denom);
			} else if (channel=="2"){
				money=amount;
			}		

			preparedStatement = conn.prepareStatement(SQLConstant.addLiquidationFact);
			preparedStatement.setShort(1, company);
			preparedStatement.setString(2, method);
			preparedStatement.setString(3, network);
			preparedStatement.setString(4, packing);
			preparedStatement.setString(5, industry);
			preparedStatement.setString(6, location);
			preparedStatement.setString(7, time);
			preparedStatement.setString(8, money);
			preparedStatement.setString(9, "1");
			preparedStatement.setString(10, money);
			logger.debug("El query a ejecutar es addLiquidationFact:  "+preparedStatement.toString());
			execute_status=preparedStatement.executeUpdate();
			if((execute_status==1) || (execute_status==2)){
				response=true;
			}

			//se revisa si ya tiene status 13 o 14 para ver si hay que agregarla al cubo de recargas
			preparedStatement2 = conn.prepareStatement(SQLConstant.searchStatus13or14);
			preparedStatement2.setShort(1, company);
			preparedStatement2.setString(2, denom);
			preparedStatement2.setString(3, cluster);
			preparedStatement2.setString(4, lot);
			preparedStatement2.setString(5, sublot);
			preparedStatement2.setString(6, serial);
			//logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
			resultSet = preparedStatement2.executeQuery();
			if(resultSet.next()){
				preparedStatement3 = conn.prepareStatement(SQLConstant.addRechargeFact);
				preparedStatement3.setShort(1, company);
				preparedStatement3.setString(2, method);
				preparedStatement3.setString(3, network);
				preparedStatement3.setString(4, packing);
				preparedStatement3.setString(5, industry);
				preparedStatement3.setString(6, location);
				preparedStatement3.setString(7, time);
				preparedStatement3.setString(8, money);
				preparedStatement3.setString(9, "1");
				preparedStatement3.setString(10, money);
				//logger.debug("El query a ejecutar es addRechargeFact:  "+preparedStatement.toString());
				execute_status=preparedStatement3.executeUpdate();
				if(response && ((execute_status==1) || (execute_status==2))){
					response=true;
				}
			}
			preparedStatement.close();
			preparedStatement2.close();
			if(preparedStatement3!=null){
				preparedStatement3.close();
			}
		} catch (SQLException e) {
			logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}		

		return response;		
	}
	
	/**
	 * Método para obtener el valor de las variables 'location', 'industry', 'distributer' (y 'amount')
	 * necesarias para llenar el cubo de liquidaciones 
	 * @param conn
	 * @param company
	 * @param denom
	 * @param cluster
	 * @param lot
	 * @param sublot
	 * @param serial
	 * @param channel
	 * @return
	 */
	 private Vector <String> fetchLocation( Connection conn, short company, String denom, String cluster, String lot, String sublot, String serial, String channel, String paymentType){
			PreparedStatement preparedStatement = null;
			PreparedStatement preparedStatement2 = null;
			ResultSet resultSet = null;
			Vector<String> result=new Vector<String>();
			String industry, state, municipaliy, city, distributer,amount = null,location;

			try {			
				if (channel=="1"){
					preparedStatement = conn.prepareStatement(SQLConstant.getIndustryAndLocation);
				}else if (channel=="2" && paymentType=="1"){
					preparedStatement = conn.prepareStatement(SQLConstant.getIndustryAndLocation2);
				}else if (channel=="2" && paymentType=="3"){
					preparedStatement = conn.prepareStatement(SQLConstant.getIndustryAndLocation3);
				}
		
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, denom);
				preparedStatement.setString(3, cluster);
				preparedStatement.setString(4, lot);
				preparedStatement.setString(5, sublot);
				preparedStatement.setString(6, serial);
				logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
				resultSet = preparedStatement.executeQuery();
				resultSet.next();
				industry=resultSet.getString(1);
				state=resultSet.getString(2);
				municipaliy=resultSet.getString(3);
				city=resultSet.getString(4);
				distributer=resultSet.getString(5);
				
				if(channel=="2"){
					amount=resultSet.getString(6);
				}
				
				preparedStatement2 = conn.prepareStatement(SQLConstant.getLocation);
				preparedStatement2.setString(1, state);
				preparedStatement2.setString(2, municipaliy);
				preparedStatement2.setString(3, city);
				resultSet = preparedStatement2.executeQuery();
				resultSet.next();
				location=resultSet.getString(1);
				
				result.add(location);
				result.add(industry);
				result.add(distributer);
				if(channel=="2"){
					result.add(amount);
				}
				preparedStatement.close();
				preparedStatement2.close();
			} catch (SQLException e) {
				logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
				new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
			}		

			return result;
	 }

	/**
	 * Método para obtener el valor de la variable 'packing' necesaria para llenar 
	 * el cubo de liquidaciones. 
	 * @param conn
	 * @param company
	 * @param denom
	 * @param cluster
	 * @param channel
	 * @param amount
	 * @param promotion
	 * @return
	 */
	 private String fetchPacking(Connection conn, short company,String denom, String cluster, String channel, String amount, String promotion){
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		String packing = null;
		
		try {		
			
			if (channel=="1"){
				preparedStatement = conn.prepareStatement(SQLConstant.getPacking);
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, denom);
				preparedStatement.setString(3, cluster);
				preparedStatement.setString(4, promotion);
			}else if (channel=="2"){
				preparedStatement = conn.prepareStatement(SQLConstant.getPacking2);
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, amount);
				preparedStatement.setString(3, promotion);
			}

			//logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				packing=resultSet.getString(1);
			}else {
				preparedStatement2 = conn.prepareStatement(SQLConstant.getNewPacking);
				preparedStatement2.setShort(1, company);
				resultSet = preparedStatement2.executeQuery();
				resultSet.next();
				packing=resultSet.getString(1);
				if(channel=="1"){
					preparedStatement3 = conn.prepareStatement(SQLConstant.addPacking);
				} else if(channel=="2"){
					preparedStatement3 = conn.prepareStatement(SQLConstant.addPacking2);
				}
				preparedStatement3.setShort(1, company);
				preparedStatement3.setString(2, packing);
				preparedStatement3.setString(3, denom);
				preparedStatement3.setString(4, cluster);
				preparedStatement3.setString(5, promotion);
				if(channel=="2"){
					preparedStatement3.setString(6, amount);
				}
				//logger.debug("Aqui: El query a ejecutar es:  "+preparedStatement.toString());
				preparedStatement3.executeUpdate();
			}
			preparedStatement.close();
			if(preparedStatement2!=null){
				preparedStatement2.close();
			}
			if(preparedStatement3!=null){
				preparedStatement3.close();
			}
		} catch (SQLException e) {
			logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}		
		 return packing;
	 }
	 
	/**
	 * Método para obtener el valor de la variable 'method' necesaria
	 * para llenar el cubo de liquidaciones 
	 * @param conn
	 * @param company
	 * @param channel
	 * @param paymentType
	 * @param paymentMethod
	 * @return
	 */
	 private String fetchMethod(Connection conn, short company, String channel, String paymentType, String paymentMethod){
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String method = null;
			
			try {
			preparedStatement = conn.prepareStatement(SQLConstant.getMethod);
			preparedStatement.setShort(1, company);
			preparedStatement.setString(2, channel); //channel
			preparedStatement.setString(3, paymentType); //payment_type
			preparedStatement.setString(4, paymentMethod); //payment_method
			logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			method=resultSet.getString(1);
			preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
				new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
			}
		 return method;
	 }
	 
	/**
	 * Método para obtener el valor de la variable 'network' necesaria
	 * para llenar el cubo de liquidaciones 
	 * @param conn
	 * @param company
	 * @param channel
	 * @param paymentType
	 * @param paymentMethod
	 * @return
	 */
	 private String fetchNetwork(Connection conn, short company, String distributer){
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String network = null;
			
			try {
				preparedStatement = conn.prepareStatement(SQLConstant.getNetwork);
				preparedStatement.setString(1, distributer);
				preparedStatement.setString(2, distributer);
				preparedStatement.setString(3, distributer);
				preparedStatement.setShort(4, company);
				preparedStatement.setString(5, distributer);
				logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
				resultSet = preparedStatement.executeQuery();	
				resultSet.next();
				network=resultSet.getString(1);
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
				new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
			}		 
		 return network;
	 }

	/**
	 * Método para obtener el valor de la variable 'time' necesaria
	 * para llenar el cubo de liquidaciones 
	 * @param conn
	 * @param date
	 * @return
	 */
	 private String fetchTime(Connection conn, String date){
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		ResultSet resultSet = null;
		String time = null;
		String query;
		
		try { 	
			preparedStatement = conn.prepareStatement(SQLConstant.getTime);
			preparedStatement.setString(1, date);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				time=resultSet.getString(1);
			} else {
				query="SELECT MAX(time)+1 FROM dim_time;";
				preparedStatement2 = conn.prepareStatement(query);
				resultSet = preparedStatement2.executeQuery();
				resultSet.next();
				time=resultSet.getString(1);
				preparedStatement3 = conn.prepareStatement(SQLConstant.addTime);
				preparedStatement3.setString(1, time);
				preparedStatement3.setString(2, date);
				//logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
				preparedStatement3.executeUpdate();
			}	
			preparedStatement.close();
			if(preparedStatement2!=null){
				preparedStatement2.close();
			}
			if(preparedStatement3!=null){
				preparedStatement3.close();
			}
		} catch (SQLException e) {
			logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		
		return time;
	 }

	/**
	 * Método para obtener el valor de la variable 'money' necesaria
	 * para llenar el cubo de liquidaciones 
	 * @param conn
	 * @param denom
	 * @return
	 */
	 private String fetchMoney(Connection conn, short company, String denom){
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String money = null;
			
			try {
				preparedStatement = conn.prepareStatement(SQLConstant.getPackingValue);
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, denom);
				resultSet = preparedStatement.executeQuery();	
				logger.debug("El query a ejecutar es:  "+preparedStatement.toString());
				resultSet.next();
				money=resultSet.getString(1);
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Exception MySQLReportDAO - fillLiquidationCube ", e);
				new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
			}
			
			return money;
	 }

}
