package ve.com.plasmodium.manager;

import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.AuthorizationDAO;
import ve.com.plasmodium.model.dao.DAOFactory;

public class AuthorizationManager {

	public static final Logger logger = Logger.getLogger(AuthorizationManager.class);
	final AuthorizationDAO authorizationDAO;


	public AuthorizationManager(short aFactoryNumber){
		this.authorizationDAO = DAOFactory.getDAOFactory(aFactoryNumber).getAuthorizationDAO();
	}


	public Map<String,Integer> getAllRoles() {
		Map<String,Integer> result = null;
		logger.debug("ENTRO EN EL MANAGER AUTHORIZATION");
		try {
			result = authorizationDAO.getAllRoles();
		} catch (Exception e) {
			logger.error("Exception AuthorizationManager - getAllRoles ", e);
		}
		return result;
	}


	//    
	//    public UserVo datosUsuario(String login) throws DAOException, CustomException {
	//	UserVo userVo = null;
	//	    try {
	//		userVo = userDAO.datosUsuario(login);
	//	    } catch (Exception e) {
	//		logger.error("Ocurrio un Excepcion: ", e);
	//	    }
	//	    return userVo;
	//    }


}
