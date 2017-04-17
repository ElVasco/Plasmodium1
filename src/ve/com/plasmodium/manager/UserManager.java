package ve.com.plasmodium.manager;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.UserDAO;
import ve.com.plasmodium.model.vo.UserDTO;

public class UserManager {

	public static final Logger logger = Logger.getLogger(UserManager.class);
	final UserDAO userDAO;


	public UserManager(short aFactoryNumber){
		this.userDAO = DAOFactory.getDAOFactory(aFactoryNumber).getUserDAO();
	}



	public void datosUsuario(UserDTO userVo, String login) throws DAOException, CustomException {
		try {
			userDAO.datosUsuario(userVo, login);
		} catch (Exception e) {
			logger.error("ParseException UserManager - datosUsuario ", e);
		}
	}

	public UserDTO datosUsuario(int user) throws DAOException, CustomException {
		UserDTO userVo = null;
		try {
			userVo = userDAO.datosUsuario(user);
		} catch (Exception e) {
			logger.error("ParseException UserManager - datosUsuario ", e);
		}
		return userVo;
	}
	
	/** Return the level that must be assigned to every new not approved user
	  * @param company	The company where the user will work 
	  * @return An int representing the level
	  **/
	public Short getNewUsersLevel() {
		Short level = 45;
		try {
			level = userDAO.getNewUsersLevel();
		} catch (Exception e) {
			logger.error("ParseException UserManager - getNewUsersLevel ", e);
		}
		return level;
	}
		
	public void listaInstutionType(List<SelectItem> selectInstitutionType) {
		try {
			userDAO.listaInstutionType(selectInstitutionType);
		} catch (Exception e) {
			logger.error("ParseException UserManager - listaInstution ", e);
		}
	}
	
	public void listaInstution(List<SelectItem> selectInstitution, short institutionType) {
		try {
			userDAO.listaInstution(selectInstitution, institutionType);
		} catch (Exception e) {
			logger.error("ParseException UserManager - listaInstution ", e);
		}
	}
	
	public List<SelectItem> listaUsuarios(List<SelectItem> distributer, short distrib) {
		List<SelectItem> userList = null;
		try {
			userList = userDAO.listaUsuario(distributer, distrib);
		} catch (Exception e) {
			logger.error("ParseException UserManager - listaUsuarios ", e);
		}
		return userList;
	}

	public List<String> listaUsuarioRecargasElect(Short company) {
		List<String> userList = null;
		try {
			userList = userDAO.listaUsuarioRecargasElect(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - listaUsuarioRecargasElect ", e);
		}
		return userList;
	}

	public UserDTO usuarioDetail(short userIDS) {
		UserDTO userVo = null;
		try {
			userVo = userDAO.usuarioDetail(userIDS);
		} catch (Exception e) {
			logger.error("ParseException UserManager - usuarioDetail ", e);
		}
		return userVo;
	}
			//(company, user, doc, login, name, mail, cargo, level, pass)){
	public boolean changeUser(Short company, String user, String doc, String login, String name, String mail, String cargo, String level, String pass) {
		boolean result = false;
		try{
			result=userDAO.changeUser(company,user,doc,login,name,mail,cargo,level, pass);
		}catch (Exception e) {
			logger.error("ParseException UserManager - changeUser ", e);
		}
		return result;
	}

	public boolean deleteUser(String user, boolean operacion) {
		boolean result = false;
		try{
			result=userDAO.deleteUser(user,operacion);
		}catch (Exception e) {
			logger.error("ParseException UserManager - deleteUser ", e);
		}
		return result;
	}

	public int addUser(String nameUser,String lastNameUser,String idUser,String phoneUser1, String mailUser, String selectedLevelUser, String jobtitleUser, String active, String loginUser, String passUser, String selectedInstitution) {
		int result = 0;
		try{
			result=userDAO.addUser(nameUser,lastNameUser,idUser,phoneUser1, mailUser, selectedLevelUser, jobtitleUser, active, loginUser, passUser, selectedInstitution);
		}catch (Exception e) {
			logger.error("ParseException UserManager - addUser ", e);
		}
		return result;
	}

	public boolean validatePassword(String login, String pwd) {
		boolean result = false;
		try{
			result=userDAO.validatePassword(login,pwd);
		}catch (Exception e) {
			logger.error("ParseException UserManager - validatePassword ", e);
		}
		return result;
	}

	public boolean updatePass(String login, String pwdNew) {
		boolean result = false;
		try{
			result=userDAO.updatePass(login, pwdNew);
		}catch (Exception e) {
			logger.error("ParseException UserManager - updatePass ", e);
		}
		return result;
	}


	public List<SelectItem> getUsersToApprove(Short company, Short state, Integer municipality, Integer city) {
		List<SelectItem> userList = null;
		try {
			userList = userDAO.getUsersToApprove(company,state,municipality,city);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getUsersToApprove ", e);
		}
		return userList;
	}

	public void getLevels(List<SelectItem> levelList, short level) {
		try {
			userDAO.getLevels(levelList, level);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getUsersToApprove ", e);
		}
	}

	public float bucarDeduction(short company) {
		float deduction = 1;
		try {
			deduction = userDAO.getDeduction(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - bucarDeduction ", e);
		}
		return deduction;
	}

	public List<SelectItem> getPendingStates(Short company) {
		List<SelectItem> stateList = null;
		try {
			stateList = userDAO.getPendingStates(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getPendingStates ", e);
		}
		return stateList;
	}

	public List<SelectItem> getPendingMunicipalities(Short company, Short state) {
		List<SelectItem> municipalityList = null;
		try {
			municipalityList = userDAO.getPendingMunicipalities(company, state);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getPendingMunicipalities ", e);
		}
		return municipalityList;
	}
	
	public List<SelectItem> getPendingCities(Short company, Short state, Integer municipality) {
		List<SelectItem> cityList = null;
		try {
			cityList = userDAO.getPendingCities(company, state, municipality);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getPendingCities ", e);
		}
		return cityList;
	}


	public List<String> getAuthorizedApproversMailList(Short company) {
		List<String> mailList = null;
		try {
			mailList = userDAO.getAuthorizedApproversMailList(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getPendingCities ", e);
		}
		return mailList;
	}

	public List<String> getAuthorizedDepApproversMailList(Short company) {
		List<String> mailList = null;
		try {
			mailList = userDAO.getAuthorizedDepApproversMailList(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getPendingCities ", e);
		}
		return mailList;
	}

	public List<SelectItem> getServiceCompany(Short company) {
		List<SelectItem> serviceCompany = null;
		try {
			serviceCompany = userDAO.getServiceCompany(company);
		} catch (Exception e) {
			logger.error("ParseException UserManager - listaUsuarios ", e);
		}
		return serviceCompany;
	}

	public boolean validUserExist(String login) {
		boolean result = false;
		try{
			result=userDAO.validUserExist(login);
		}catch (Exception e) {
			logger.error("ParseException UserManager - validatePassword ", e);
		}
		return result;
	}
}
