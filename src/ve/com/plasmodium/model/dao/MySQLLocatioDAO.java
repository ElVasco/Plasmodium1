package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.vo.DemarcationDTO;
import ve.com.plasmodium.model.vo.LocationDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLLocatioDAO implements LocatioDAO {
	
	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public void initSQLData(){
		conn = MySQLDAOFactory.createConnection();
		preparedStatement = null;
		resultSet = null;
	}
	
	@Override
	public boolean getLocationDetail(String placeID, String txt1, GlobalDataBean gd) {
		initSQLData();
		boolean result = false;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getLocationDetail);
			preparedStatement.setString(1, placeID);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				gd.getLocationList().get(txt1).setIdLocation(resultSet.getInt("id_location"));
				gd.getLocationList().get(txt1).setCountry(resultSet.getString("country"));
				gd.getLocationList().get(txt1).setAdministrative_area_level_1(resultSet.getString("administrative_area_level_1"));
				gd.getLocationList().get(txt1).setAdministrative_area_level_2(resultSet.getString("administrative_area_level_2"));
				gd.getLocationList().get(txt1).setLocality(resultSet.getString("locality"));
				gd.getLocationList().get(txt1).setRoute(resultSet.getString("route"));
				gd.getLocationList().get(txt1).setLatitude(resultSet.getString("latitude"));
				gd.getLocationList().get(txt1).setLongitude(resultSet.getString("longitude"));
				gd.getLocationList().get(txt1).setDemarcation(resultSet.getString("demarcation"));
				result = true;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return result;
	}
	
	@Override
	public boolean newLocation(LocationDTO locationDTO){
		initSQLData();
		boolean result = false;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.insertLocation);
			preparedStatement.setString(1, locationDTO.getCountry());
			preparedStatement.setString(2, locationDTO.getAdministrative_area_level_1());
			preparedStatement.setString(3, locationDTO.getAdministrative_area_level_2());
			preparedStatement.setString(4, locationDTO.getLocality());
			preparedStatement.setString(5, locationDTO.getRoute());
			preparedStatement.setString(6, locationDTO.getLatitude());
			preparedStatement.setString(7, locationDTO.getLongitude());
			preparedStatement.setString(8, locationDTO.getPlaceId());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			preparedStatement.executeUpdate();
			preparedStatement = conn.prepareStatement("SELECT LAST_INSERT_ID();");
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				locationDTO.setIdLocation(resultSet.getInt(1));
				result=true;
			}
		}catch(Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return result;
	}

}
