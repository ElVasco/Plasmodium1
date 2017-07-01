package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.DemarcationDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLDemarcationDAO implements DemarcationDAO{

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
	public void getDemarcationList(List<DemarcationDTO> demarcationList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getDemarcacionesList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DemarcationDTO demarcationDTO = new DemarcationDTO();
				demarcationDTO.setId(resultSet.getString("id"));
				demarcationDTO.setName(resultSet.getString("demarcacion"));
				demarcationDTO.setDescription(resultSet.getString("description"));
				logger.debug("resultSet.getString(name)" + resultSet.getString("demarcacion"));
				demarcationList.add(demarcationDTO);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public DemarcationDTO demarcationDetail(String demarcation) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getDemarcacionesDetail);
			preparedStatement.setInt(1, Integer.parseInt(demarcation));
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				DemarcationDTO demarDetail = new DemarcationDTO();
				demarDetail.setId(resultSet.getString("id"));
				demarDetail.setName(resultSet.getString("demarcacion"));
				demarDetail.setDescription(resultSet.getString("description"));
				return demarDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public int addDemarcation(DemarcationDTO demarcation) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addDemarcaciones);
			preparedStatement.setString(1, demarcation.getName());
			preparedStatement.setString(2, demarcation.getDescription());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
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

	@Override
	public int updateDemarcation(DemarcationDTO demarcation) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updateDemarcaciones);
			preparedStatement.setString(1, demarcation.getDescription());
			preparedStatement.setString(2,demarcation.getName());
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