package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLGlobalDAO implements GlobalDAO {

	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public void initSQLData(){
		conn = MySQLDAOFactory.createConnection();
		preparedStatement = null;
		resultSet = null;
	}

	public void searchParameter(Map<String, String> maps) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getParameters);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			logger.debug(resultSet.getRow());
			while(resultSet.next()){
				logger.debug(resultSet.getString("id"));
				logger.debug(resultSet.getString("parameter"));
				maps.put(resultSet.getString("id"),resultSet.getString("parameter"));
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public void searchLethality(List<LethalityDTO> lethalityList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getLethality);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				LethalityDTO let = new LethalityDTO();
				let.setId(resultSet.getString("id"));
				let.setLethality(resultSet.getString("letalidad"));
				lethalityList.add(let);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

}

