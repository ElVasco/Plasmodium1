package ve.com.plasmodium.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.UserDAO;
import ve.com.plasmodium.model.vo.UserVo;

public class UserManager {

	public static final Logger logger = Logger.getLogger(UserManager.class);
	final UserDAO userDAO;


	public UserManager(short aFactoryNumber){
		this.userDAO = DAOFactory.getDAOFactory(aFactoryNumber).getUserDAO();
	}



	public UserVo datosUsuario(String login) throws DAOException, CustomException {
		UserVo userVo = null;
		try {
			userVo = userDAO.datosUsuario(login);
		} catch (Exception e) {
			logger.error("ParseException UserManager - datosUsuario ", e);
		}
		return userVo;
	}

	public UserVo datosUsuario(int user) throws DAOException, CustomException {
		UserVo userVo = null;
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

	public UserVo usuarioDetail(short userIDS) {
		UserVo userVo = null;
		try {
			userVo = userDAO.usuarioDetail(userIDS);
		} catch (Exception e) {
			logger.error("ParseException UserManager - usuarioDetail ", e);
		}
		return userVo;
	}

	public boolean changeUser(Short company, String user, String doc, String login, String name, String mail, String cargo, String level, List<String> serviceCompany, String pass, String max_unsettled_balance, String max_selling_amount, String max_days_card_unsettled) {
		boolean result = false;
		try{
			result=userDAO.changeUser(company,user,doc,login,name,mail,cargo,level,serviceCompany, pass,max_unsettled_balance, max_selling_amount, max_days_card_unsettled);
		}catch (Exception e) {
			logger.error("ParseException UserManager - changeUser ", e);
		}
		return result;
	}

	public boolean approveUser(short company, String user, String level, List<String> serviceCompany, String max_unsettled_balance, String max_selling_amount, String max_days_card_unsettled) {
		boolean result = false;
		try{
			result=userDAO.approveUser(company,user,level,serviceCompany,max_unsettled_balance,max_selling_amount,max_days_card_unsettled);
		}catch (Exception e) {
			logger.error("ParseException UserManager - approveUser ", e);
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



	public int addUser(short company, String employer, String doc, String login, String name, String mail, String cargo, String level, String pass) {
		int result = 0;
		try{
			result=userDAO.addUser(company,employer, doc,login,name,mail,cargo,level,pass);
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

	public List<SelectItem> getLevels(short level) {
		List<SelectItem> userList = null;
		try {
			userList = userDAO.getLevels(level);
		} catch (Exception e) {
			logger.error("ParseException UserManager - getUsersToApprove ", e);
		}
		return userList;
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
