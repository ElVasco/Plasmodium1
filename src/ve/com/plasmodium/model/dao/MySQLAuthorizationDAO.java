package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import ve.com.plasmodium.exception.DAOException;

public class MySQLAuthorizationDAO implements AuthorizationDAO {

	public Map<String,Integer> getAllRoles() {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Map<String,Integer> result = new HashMap<String,Integer>();
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.getAllRoles);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result.put(resultSet.getString(1),resultSet.getInt(2));
			}
		}
		catch (Exception e) {
			logger.error("Exception MySQLAuthorizationDAO - getAllRoles ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLAuthorizationDAO - getAllRoles - close", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

}

