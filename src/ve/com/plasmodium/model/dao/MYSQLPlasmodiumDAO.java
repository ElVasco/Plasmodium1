package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.vo.PlasmodiumTypeDTO;
import ve.com.plasmodium.util.Utils;

public class MYSQLPlasmodiumDAO implements PlasmodiumDAO{
	
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
	public PlasmodiumDTO plasmodiumDetail(String plasmodium) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPlasmodiumDetail);
			preparedStatement.setString(1, plasmodium);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			//TODO MEGA FUNCION PARSEADOR DE TODA MIERDA
			if(resultSet.next()){
				PlasmodiumDTO plasDetail = new PlasmodiumDTO();
				plasDetail.setId(resultSet.getString("id"));
				plasDetail.setName(resultSet.getString("name"));
				plasDetail.setDescription(resultSet.getString("description"));
				plasDetail.setLetalidad(resultSet.getString("letalidad"));
				return plasDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public void plasmodiumList(List<PlasmodiumDTO> plasmodium, String selectedPlasmodiumType) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPlasmodiumTypeList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			//TODO MEGA FUNCION PARSEADOR DE TODA MIERDA
			if(resultSet.next()){
				
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public void getPlasmodiumTypeList(List<PlasmodiumTypeDTO> plasmodiumTypeList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getPlasmodiumTypeList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PlasmodiumTypeDTO plasmodiumTypeDTO = new PlasmodiumTypeDTO();
				plasmodiumTypeDTO.setIdPlasmodiumType(resultSet.getInt("id"));
				plasmodiumTypeDTO.setName(resultSet.getString("name"));
				logger.debug("resultSet.getString(name)" + resultSet.getString("name"));
				plasmodiumTypeList.add(plasmodiumTypeDTO);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public int addPlasmodiumType(PlasmodiumTypeDTO plasmodiumType) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addPlasmodium);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			preparedStatement.setString(1, plasmodiumType.getName());
			preparedStatement.setString(1, plasmodiumType.getDescription());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				result = 1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return 0;
	}

	@Override
	public void getLetalidadList(List<LethalityDTO> letalidadList) {
		// TODO Auto-generated method stub
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getLetalidadList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				LethalityDTO letalidadDTO = new LethalityDTO();
				letalidadDTO.setId(resultSet.getString("id"));
				letalidadDTO.setLethality(resultSet.getString("letalidad"));
				letalidadList.add(letalidadDTO);
				logger.debug("letalidadDTO.id" + letalidadDTO.getId());
				logger.debug("letalidadDTO.letalidad" + letalidadDTO.getLethality());
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

	}

	@Override
	public int addPlasmodium(PlasmodiumDTO plasmodium) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addPlasmodium);
			preparedStatement.setString(1, plasmodium.getName());
			preparedStatement.setString(2, plasmodium.getDescription());
			preparedStatement.setInt(3, Integer.parseInt(plasmodium.getLetalidad()));
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			int result  = preparedStatement.executeUpdate();
			logger.debug("Resultado -> " + result);
			if(result > 0){
				return result = 0;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return -1;
	}

	@Override
	public int updatePlasmodium(PlasmodiumDTO plasmodium) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updatePlasmodium);
			preparedStatement.setString(1, plasmodium.getDescription());
			preparedStatement.setInt(2, Integer.parseInt(plasmodium.getLetalidad()));
			preparedStatement.setString(3,plasmodium.getName());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			int result  = preparedStatement.executeUpdate();
			logger.debug("Resultado -> " + result);
			if(result > 0){
				return result = 0;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return -1;
	}
}