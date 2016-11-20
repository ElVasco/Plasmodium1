package ve.com.plasmodium.manager;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.CardDAO;
import ve.com.plasmodium.model.dao.DAOFactory;

public class CardManager {

    public static final Logger logger = Logger.getLogger(CardManager.class);

    final CardDAO cardDAO;

    public CardManager(short aFactoryNumber) {
    	this.cardDAO = DAOFactory.getDAOFactory(aFactoryNumber).getCardDAO();
    }

	public boolean updateDistributerManuf(short company, short distributer, int user, int from, int to) {
		boolean result = false;
		try {
	    	result = cardDAO.updateDistributerManuf(company, distributer, user, from, to);
		} catch (Exception e) {
			 logger.error("Exception CardManager - updateDistributerManuf ", e);
		}
	    return result;
	}
//    public UserCompanyVo datosUsuario(String login) throws DAOException, CustomException {
//	UserCompanyVo userCompanyVo = null;
//	try {
//	    userCompanyVo = userDAO.datosUsuario(login);
//	} catch (Exception e) {
//	    logger.error("Ocurrio un Excepcion: ", e);
//	}
//	return userCompanyVo;
//    }

}