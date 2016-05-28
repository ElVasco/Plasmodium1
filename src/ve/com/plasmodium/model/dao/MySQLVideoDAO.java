package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import ve.com.plasmodium.exception.DAOException;

public class MySQLVideoDAO implements VideoDAO {


	@Override
	public List<SelectItem> videoList(int user) {
		System.out.println("Inicio el videoList en videodao");
		List<SelectItem> result = new ArrayList<SelectItem>();
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id, label, link;
		SelectItem si;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.videoList);
			preparedStatement.setInt(1, user);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id=resultSet.getString(1);
				label=resultSet.getString(2);
				link=resultSet.getString(3);
				si = new SelectItem(id,label,link);
				result.add(si);
			}

		} catch (Exception e) {
			logger.error("Exception MySQLVideoDAO - videoList ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLVideoDAO - videoList - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;

	}

	@Override
	public List<SelectItem> videoListComp(short company) {
		System.out.println("Inicio el videoList en videodao");
		List<SelectItem> result = new ArrayList<SelectItem>();
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id, label;
		SelectItem si;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.videoListComp);
			preparedStatement.setInt(1, company);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id=resultSet.getString(1);
				label=resultSet.getString(2);
				si = new SelectItem(id,label);
				result.add(si);
			}

		} catch (Exception e) {
			logger.error("Exception MySQLVideoDAO - videoListComp ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLVideoDAO - videoListComp - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;

	}

	@Override
	public List<SelectItem> userList(short company) {
		System.out.println("Inicio el videoList en videodao");
		List<SelectItem> result = new ArrayList<SelectItem>();
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id, label;
		SelectItem si;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.userList);
			preparedStatement.setInt(1, company);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id=resultSet.getString(1);
				label=resultSet.getString(2);
				si = new SelectItem(id,label);
				result.add(si);
			}

		} catch (Exception e) {
			logger.error("Exception MySQLVideoDAO - userList ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLVideoDAO - userList - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;

	}

	public boolean updateUserVideos(int user, List<String> videosEdit) {
		System.out.println("Inicio el videoList en updateUserVideos");
		boolean result = false;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		String  query;
		try {
			query = "DELETE FROM user_video WHERE user_id="+user;
			preparedStatement = conn.prepareStatement(query);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result=preparedStatement.executeUpdate()>=1;
			int i = 0;
			while(videosEdit.size()>i){
				query = "INSERT into user_video values ("+user+",(SELECT id_video FROM video WHERE description='"+videosEdit.get(i)+"'));";
				preparedStatement = conn.prepareStatement(query);
				logger.debug("Statement a ejecutarse " + preparedStatement.toString());
				result=preparedStatement.executeUpdate()==1;
				i++;
			}
		} catch (Exception e) {
			logger.error("Exception MySQLVideoDAO - updateUserVideos ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLVideoDAO - updateUserVideos - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}


}

