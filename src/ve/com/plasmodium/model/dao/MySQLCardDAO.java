package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.to.CardTo;
import ve.com.plasmodium.model.vo.DispoVo;

public class MySQLCardDAO implements CardDAO {

	public List<CardTo> listAll() throws DAOException, CustomException {
		return null;
	}

	public CardTo listById(short cardId) throws DAOException, CustomException {
		return null;
	}

	public boolean update(CardTo card) throws DAOException, CustomException {
		return false;
	} 

	public List<DispoVo> DisponibleDistribHibrido() throws DAOException, CustomException{
		return null;
	}

	public List<DispoVo> DisponibleDistrib() throws DAOException, CustomException{
		return null;
	}

	public boolean updateDistributerManuf(short company, short distributer, int user, int from, int to) {
		boolean result = false;
		//  	System.out.println("Inicio el deleteBill");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updateDistributerManuf);
			preparedStatement.setInt(1, distributer);
			preparedStatement.setInt(2, user);
			preparedStatement.setInt(3, company);
			preparedStatement.setInt(4, company);
			preparedStatement.setInt(5, company);
			preparedStatement.setInt(6, from);
			preparedStatement.setInt(7, to);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result=preparedStatement.executeUpdate()==1;
		}catch (Exception e){
			logger.error("Exception MySQLCardDAO - updateDistributerManuf ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLCardDAO - updateDistributerManuf - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

}
