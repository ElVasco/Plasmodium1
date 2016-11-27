package ve.com.plasmodium.manager;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.InstitutionDAO;
import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.dao.DAOFactory;

public class InstitutionManager {

    public static final Logger logger = Logger.getLogger(InstitutionManager.class);

    final InstitutionDAO institutionDAO;

    public InstitutionManager(short aFactoryNumber) {
    	this.institutionDAO = DAOFactory.getDAOFactory(aFactoryNumber).getCardDAO();
    }

	public void institutionDetail(InstitutionDTO institutionDTO, String institution) {
		try {
	    	institutionDAO.institutionDetail(institutionDTO, institution);
		} catch (Exception e) {
			 logger.error("Exception institutionManager - institutionDetail ", e);
		}
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