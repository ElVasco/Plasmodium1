package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.HatcheryDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLHatcheryDAO implements HatcheryDAO{

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
	public int addHatchery(HatcheryDTO hatchery) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addCriaderos);
			preparedStatement.setString(1, hatchery.getName());
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
	public int updateHatchery(HatcheryDTO hatchery) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updateCriaderos);
			preparedStatement.setString(1, hatchery.getName());
			preparedStatement.setString(2,hatchery.getName());
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
	public HatcheryDTO hatcheryDetail(String hatchery) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getCriaderosDetail);
			preparedStatement.setString(1, hatchery);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				HatcheryDTO hatDetail = new HatcheryDTO();
				hatDetail.setId(resultSet.getString("id"));
				hatDetail.setName(resultSet.getString("name"));
				return hatDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public void getHatcheryList(List<HatcheryDTO> hatchery) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getCriaderosList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				HatcheryDTO hatDTO = new HatcheryDTO();
				hatDTO.setId(resultSet.getString("id"));
				hatDTO.setName(resultSet.getString("name"));
				logger.debug("resultSet.getString(name)" + resultSet.getString("name"));
				hatchery.add(hatDTO);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

}