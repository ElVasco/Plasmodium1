package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.PhenomenonDTO;
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLPhenomenonDAO implements PhenomenonDAO{

	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	@Override
	public void getPhenomenonTypeList(List<PhenomenonTypeDTO> phenomenonTypeList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPhenomenonTypeList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PhenomenonTypeDTO phenomenonType = new PhenomenonTypeDTO();
				phenomenonType.setId(resultSet.getString("id"));
				phenomenonType.setName(resultSet.getString("name"));
				phenomenonTypeList.add(phenomenonType);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public PhenomenonTypeDTO phenomenonTypeDetail(String phenomenon) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPhenomenonTypeDetail);
			preparedStatement.setString(1, phenomenon);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				PhenomenonTypeDTO phenomenonDetail = new PhenomenonTypeDTO();
				phenomenonDetail.setId(resultSet.getString("id"));
				phenomenonDetail.setName(resultSet.getString("name"));
				return phenomenonDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public int addPhenomenonType(PhenomenonTypeDTO phenomenonType) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addPhenomenonType);
			preparedStatement.setString(1, phenomenonType.getName().toUpperCase());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate();
			logger.debug("result " + result);
			if(result!=1){
				return result = -1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return 0;
	}

	@Override
	public int updatePhenomenonType(PhenomenonTypeDTO phenomenonType, String selectedPhenomenonType) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updatePhenomenonType);
			preparedStatement.setString(1, phenomenonType.getName().toUpperCase());
			preparedStatement.setInt(2, Integer.parseInt(selectedPhenomenonType));
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate();
			if(result != 1){
				result = -1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return 0;
	}

	@Override
	public void getPhenomenonList(List<PhenomenonDTO> phenomenonList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPhenomenonList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PhenomenonDTO phenomenon = new PhenomenonDTO();
				phenomenon.setId(resultSet.getString("id"));
				phenomenon.setName(resultSet.getString("name"));
				phenomenon.setDescription(resultSet.getString("descripcion"));
				phenomenon.setIdPhenomenonType(resultSet.getString("tipo_fenomeno"));
				phenomenonList.add(phenomenon);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public PhenomenonDTO phenomenonDetail(String phenomenon) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPhenomenonDetail);
			preparedStatement.setInt(1, Integer.parseInt(phenomenon));
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				PhenomenonDTO phenomenonDetail = new PhenomenonDTO();
				phenomenonDetail.setId(resultSet.getString("id"));
				phenomenonDetail.setName(resultSet.getString("name"));
				phenomenonDetail.setDescription(resultSet.getString("descripcion"));
				phenomenonDetail.setIdPhenomenonType(resultSet.getString("tipo_fenomeno"));
				return phenomenonDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public int addPhenomenon(PhenomenonDTO phenomenon) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addPhenomenon);
			preparedStatement.setString(1, phenomenon.getName());
			preparedStatement.setString(2, phenomenon.getDescription());
			preparedStatement.setString(3, phenomenon.getIdPhenomenonType());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate();
			logger.debug("result" + result);
			if(result != 1){
				result = -1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return 0;
	}

	@Override
	public int updatePhenomenon(PhenomenonDTO phenomenon) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updatePhenomenon);
			preparedStatement.setString(1, phenomenon.getDescription());
			preparedStatement.setInt(2, Integer.parseInt(phenomenon.getIdPhenomenonType()));
			preparedStatement.setString(3, phenomenon.getName());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			//resultSet = preparedStatement.executeQuery();
			result = preparedStatement.executeUpdate();
			if(result!=1){
				result = -1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return 0;
	}

	public void initSQLData(){
		conn = MySQLDAOFactory.createConnection();
		preparedStatement = null;
		resultSet = null;
	}
}