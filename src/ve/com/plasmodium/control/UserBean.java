package ve.com.plasmodium.control;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;

import ve.com.novared.model.vo.CryptoError;
import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.UserDTO;

@ManagedBean(name="UserBean")
@SessionScoped
public class UserBean {

	public static final Logger logger = Logger.getLogger(UserBean.class);

	private int user;
	private String login;
	private String userName;
	private String numDoc;
	private String email;
	private String cargo;
	private String message;
	private String creditLabel;
	private Short level;
	private String userNameNew = new String();
	private String userIdNew = new String();
	private String userLoginNew = new String();
	private String userPassNew = new String();
	private String userMailNew = new String();
	private String userJobtitleNew = new String();
	private String nameUser = new String();
	private String lastNameUser = new String();
	private String idUser = new String();
	private String loginUser = new String();
	private String passUser = new String();
	private String passUserNew = new String();
	private String confirmPassNew = new String();
	private String mailUser = new String();
	private String jobtitleUser = new String();
	private String maxUnsettledBalance = new String();
	private String maxSellingAmount = new String();
	private String maxDaysCardUnsettled = new String();
	private String companyName = new String();

	private String levelListUser;
	private String levelListUserNew;

	//private List<SelectItem> levelList;
	private List<SelectItem> selectUser;
	private String selectedUser;
	// antes era string
	private UserDTO userDetail;
	private UserDTO userDetail2;
	private Short company;
	private short employer;
	private Short distributer;
	private Short route;
	private int client;
	private int masterClient;
	private boolean showDetail=false; 
	private boolean showDetailNew=false;
	private boolean showTarven=false;
	private boolean showNvRd=false;
	private boolean showNvRdAdmin=false;
	private boolean showNoHibrido=false;
	private boolean showCreditOptions=false;
	private List<String> messages = new ArrayList<String>();
	private String messageExit;
	private String securityToken;
	private float balance = 0;
	private float unsettledBalance = 0;
	private float deduction = 0; 

	public UserBean()throws IOException, ParseException, CryptoError{
		messages.add("Ingreso al Sistema");
		userName="";
		selectedUser = new String();
		nameUser = new String();
		idUser = new String();
		loginUser = new String();
		mailUser = new String();
		jobtitleUser = new String(); 
		maxUnsettledBalance = new String();
		maxSellingAmount = new String();
		maxDaysCardUnsettled = new String();
		levelListUser = new String();
		passUser = new String();
		passUserNew = new String();
		//selectedUser = new SelectItem();
		userNameNew = new String();
		userIdNew = new String();
		userLoginNew = new String();
		userMailNew = new String();
		userJobtitleNew = new String(); 
		levelListUserNew = new String();
		setLogin(SecurityContextHolder.getContext().getAuthentication().getName());
		//setLogin(login);
	}



	/**
	 * Resetea (limpia) la pantalla de mostrar/ingresar usuario para nueva seleccion
	 */
	public void resetFaceUser(){
		if(confirmPassNew!=null){
			passUser = "";
			passUserNew = "";
			confirmPassNew = "";
		}else{
			selectedUser = "";
			nameUser = "";
			idUser = "";
			loginUser = "";
			mailUser = "";
			jobtitleUser = ""; 
			levelListUser = "";
			passUser = "";
			passUserNew = "";
			confirmPassNew = "";
			userNameNew = "";
			userIdNew = "";
			userLoginNew = "";
			userMailNew = "";
			userJobtitleNew = ""; 
			levelListUserNew = "";
			showDetail=false;
			showDetailNew=false;
		}
	}

	/**
	 * Coding of the processing executed at the time that
	 * and associated button is clicked
	 * the component that triggered the action event
	 * @param event
	 */
	public void pushed(ActionEvent event) {
		// Coding of the processing executed at the time that
		// and associated button is clicked
		// the component that triggered the action event
		UIComponent component = event.getComponent();
		logger.debug("The id of the component that fired the action event: " + component.getId());
		// the action command
		String eventSource = event.getSource().toString();
		logger.debug("Event Source: " + eventSource);
	}


	/**
	 * Permiter saber a que distribuidor pertenece el login con el que
	 * esta trabajando, busca el nombre de la compania en la tabla compania
	 * @param  login el nombre de usuario para ingresar al sistema
	 */
	public void cargarEmpleado(String login) {
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		logger.debug("CARGAR EMPLEADO!\n!");
		try {
			UserDTO userVo = new UserDTO();
			userManager.datosUsuario(userVo, login);
			logger.debug("el usuario es " + userVo.getUser());
			if(userVo!=null) {
				logger.debug("su compania es " + userVo.getCompanys().get(0).getName());
				logger.debug("su level es " + userVo.getLevel());
				setCompany((short) userVo.getCompanys().get(0).getInstitution());
				setUserName(userVo.getName());
				setUser(userVo.getUser());
				setLevel(userVo.getLevel());
				setPassUser(userVo.getPassword());
				setEmail(userVo.getEmail());
				setCompanyName(userVo.getCompanys().get(0).getName());
			} 			
		} catch (Exception e) {
			logger.error("Exception UserBean - cargarEmpleado ", e);
		}
	}

	/**
	 * Resetela (limpia) la lista de usuario para volverla a llenar segun el distribuidor seleccionado
	 */
	public void resetUserList(){			
		SelectItem si;
		si = new SelectItem("-1","Seleccione un Usuario");
		if(selectUser==null){
			selectUser  =  new ArrayList<SelectItem>();
		}else{
			selectUser.clear();
		}
		selectUser.add(si);	 
	}


	/**
	 * 
	 * @return
	 * @throws CustomException
	 */
	public String actionChangePass() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		String pwd, pwdNew;
		if(message!=null)
			message=null;
		if(passUser!=null && passUserNew !=null){
			pwd = passUser;
			pwdNew = passUserNew;
			logger.debug("passUser : " + passUser);
			logger.debug("passUserNew : " + passUserNew);
			if(userManager.validatePassword(login,pwd)){
				if(userManager.updatePass(login,pwdNew)){
					navigation = "successful";
					getMessages().add(0,"Operación satisfactoria - El usuario : \""+sessionUserBean.getUserName()+"\" ha cambiado su clave de acceso al sistema.");	    	
					setMessageExit("");
					resetFaceUser();
				}
			}else{
				navigation = "fail_current_pwd";
				resetFaceUser();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","La clave actual que introdujo es incorrecta."));
			}
		}
		return navigation;
	}

	/**
	 * 
	 * @return
	 */
	public String actionExit(){
		String navigation = "successful_exit";
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		sessionUserBean.setMessageExit("Operación finalizada - el usuario NO ha sido actualizado en el Sistema.");
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserBean");
		resetFaceUser();
		return navigation;
	}


	/**
	 * @return the user
	 */
	public int getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(int user) {
		this.user = user;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the numDoc
	 */
	public String getNumDoc() {
		return numDoc;
	}


	/**
	 * @param numDoc the numDoc to set
	 */
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}


	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	public void setCreditLabel(String creditLabel) {
		this.creditLabel = creditLabel;
	}

	public String getCreditLabel() {
		return creditLabel;
	}

	/**
	 * @return the level
	 */
	public Short getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(Short level) {
		this.level = level;
	}


	/**
	 * @return the userNameNew
	 */
	public String getUserNameNew() {
		return userNameNew;
	}


	/**
	 * @param userNameNew the userNameNew to set
	 */
	public void setUserNameNew(String userNameNew) {
		this.userNameNew = userNameNew;
	}


	/**
	 * @return the userIdNew
	 */
	public String getUserIdNew() {
		return userIdNew;
	}


	/**
	 * @param userIdNew the userIdNew to set
	 */
	public void setUserIdNew(String userIdNew) {
		this.userIdNew = userIdNew;
	}


	/**
	 * @return the userLoginNew
	 */
	public String getUserLoginNew() {
		return userLoginNew;
	}


	/**
	 * @param userLoginNew the userLoginNew to set
	 */
	public void setUserLoginNew(String userLoginNew) {
		this.userLoginNew = userLoginNew;
	}


	/**
	 * @return the userPassNew
	 */
	public String getUserPassNew() {
		return userPassNew;
	}


	/**
	 * @param userPassNew the userPassNew to set
	 */
	public void setUserPassNew(String userPassNew) {
		this.userPassNew = userPassNew;
	}


	/**
	 * @return the userMailNew
	 */
	public String getUserMailNew() {
		return userMailNew;
	}


	/**
	 * @param userMailNew the userMailNew to set
	 */
	public void setUserMailNew(String userMailNew) {
		this.userMailNew = userMailNew;
	}


	/**
	 * @return the userJobtitleNew
	 */
	public String getUserJobtitleNew() {
		return userJobtitleNew;
	}


	/**
	 * @param userJobtitleNew the userJobtitleNew to set
	 */
	public void setUserJobtitleNew(String userJobtitleNew) {
		this.userJobtitleNew = userJobtitleNew;
	}


	/**
	 * @return the nameUser
	 */
	public String getNameUser() {
		return nameUser;
	}


	/**
	 * @param nameUser the nameUser to set
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}


	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}


	/**
	 * @return the loginUser
	 */
	public String getLoginUser() {
		return loginUser;
	}


	/**
	 * @param loginUser the loginUser to set
	 */
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}


	/**
	 * @return the passUser
	 */
	public String getPassUser() {
		return passUser;
	}


	/**
	 * @param passUser the passUser to set
	 */
	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}

	public void printCredentials(Object credentials) {
		logger.debug("printCredentials : "+credentials);
	}

	/**
	 * @return the passUserNew
	 */
	public String getPassUserNew() {
		return passUserNew;
	}



	/**
	 * @param passUserNew the passUserNew to set
	 */
	public void setPassUserNew(String passUserNew) {
		this.passUserNew = passUserNew;
	}


	/**
	 * @return the confirmPassNew
	 */
	public String getConfirmPassNew() {
		return confirmPassNew;
	}




	/**
	 * @param confirmPassNew the confirmPassNew to set
	 */
	public void setConfirmPassNew(String confirmPassNew) {
		this.confirmPassNew = confirmPassNew;
	}


	/**
	 * @return the mailUser
	 */
	public String getMailUser() {
		return mailUser;
	}


	/**
	 * @param mailUser the mailUser to set
	 */
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}


	/**
	 * @return the jobtitleUser
	 */
	public String getJobtitleUser() {
		return jobtitleUser;
	}


	/**
	 * @param jobtitleUser the jobtitleUser to set
	 */
	public void setJobtitleUser(String jobtitleUser) {
		this.jobtitleUser = jobtitleUser;
	}


	public void setMaxUnsettledBalance(String maxUnsettledBalance) {
		this.maxUnsettledBalance = maxUnsettledBalance;
	}

	public void setMaxSellingAmount(String maxSellingAmount) {
		this.maxSellingAmount = maxSellingAmount;
	}

	public void setMaxDaysCardUnsettled(String maxDaysCardUnsettled) {
		this.maxDaysCardUnsettled = maxDaysCardUnsettled;
	}

	public String getMaxDaysCardUnsettled() {
		return maxDaysCardUnsettled;
	}

	public String getMaxSellingAmount() {
		return maxSellingAmount;
	}

	public String getMaxUnsettledBalance() {
		return maxUnsettledBalance;
	}

	/**
	 * @return the levelListUser
	 */
	public String getLevelListUser() {
		return levelListUser;
	}


	/**
	 * @param levelListUser the levelListUser to set
	 */
	public void setLevelListUser(String levelListUser) {
		this.levelListUser = levelListUser;
	}


	/**
	 * @return the levelListUserNew
	 */
	public String getLevelListUserNew() {
		return levelListUserNew;
	}


	/**
	 * @param levelListUserNew the levelListUserNew to set
	 */
	public void setLevelListUserNew(String levelListUserNew) {
		this.levelListUserNew = levelListUserNew;
	}


	/**
	 * @return the selectUser
	 */
	public List<SelectItem> getSelectUser() {
		return selectUser;
	}


	/**
	 * @param selectUser the selectUser to set
	 */
	public void setSelectUser(List<SelectItem> selectUser) {
		this.selectUser = selectUser;
	}

	/**
	 * @return the selectedUser
	 */
	public String getSelectedUser() {
		return selectedUser;
	}


	/**
	 * @param selectedUser the selectedUser to set
	 */
	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}

	/**
	 * @return the userDetail
	 */
	public UserDTO getUserDetail() {
		return userDetail;
	}


	/**
	 * @param userDetail the userDetail to set
	 */
	public void setUserDetail(UserDTO userDetail) {
		this.userDetail = userDetail;
	}


	/**
	 * @return the userDetail2
	 */
	public UserDTO getUserDetail2() {
		return userDetail2;
	}


	/**
	 * @param userDetail2 the userDetail2 to set
	 */
	public void setUserDetail2(UserDTO userDetail2) {
		this.userDetail2 = userDetail2;
	}


	/**
	 * @return the company
	 */
	public Short getCompany() {
		return company;
	}


	/**
	 * @param company the company to set
	 */
	public void setCompany(Short company) {
		this.company = company;
	}


	/**
	 * @return the distributer
	 */
	public Short getDistributer() {
		return distributer;
	}


	/**
	 * @param distributer the distributer to set
	 */
	public void setDistributer(Short distributer) {
		this.distributer = distributer;
	}


	/**
	 * @return the route
	 */
	public Short getRoute() {
		return route;
	}


	/**
	 * @param route the route to set
	 */
	public void setRoute(Short route) {
		this.route = route;
	}


	/**
	 * @return the client
	 */
	public int getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(int client) {
		this.client = client;
	}


	public void setMasterClient(int masterClient) {
		this.masterClient = masterClient;
	}

	public int getMasterClient() {
		return masterClient;
	}

	/**
	 * @return the showDetail
	 */
	public boolean isShowDetail() {
		return showDetail;
	}


	/**
	 * @param showDetail the showDetail to set
	 */
	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}


	/**
	 * @return the showDetailNew
	 */
	public boolean isShowDetailNew() {
		return showDetailNew;
	}


	/**
	 * @param showDetailNew the showDetailNew to set
	 */
	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}


	/**
	 * @return the showTarven
	 */
	public boolean isShowTarven() {
		return showTarven;
	}


	/**
	 * @param showTarven the showTarven to set
	 */
	public void setShowTarven(boolean showTarven) {
		this.showTarven = showTarven;
	}


	/**
	 * @return the showNvRd
	 */
	public boolean isShowNvRd() {
		return showNvRd;
	}


	/**
	 * @param showNvRd the showNvRd to set
	 */
	public void setShowNvRd(boolean showNvRd) {
		this.showNvRd = showNvRd;
	}


	/**
	 * @return the showNvRdAdmin
	 */
	public boolean isShowNvRdAdmin() {
		return showNvRdAdmin;
	}


	/**
	 * @param showNvRdAdmin the showNvRdAdmin to set
	 */
	public void setShowNvRdAdmin(boolean showNvRdAdmin) {
		this.showNvRdAdmin = showNvRdAdmin;
	}


	/**
	 * @return the showNoHibrido
	 */
	public boolean isShowNoHibrido() {
		return showNoHibrido;
	}


	/**
	 * @param showNoHibrido the showNoHibrido to set
	 */
	public void setShowNoHibrido(boolean showNoHibrido) {
		this.showNoHibrido = showNoHibrido;
	}


	public void setShowCreditOptions(boolean showCreditOptions) {
		this.showCreditOptions = showCreditOptions;
	}

	public boolean isShowCreditOptions() {
		return showCreditOptions;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}


	/**
	 * @return the messageExit
	 */
	public String getMessageExit() {
		return messageExit;
	}


	/**
	 * @param messageExit the messageExit to set
	 */
	public void setMessageExit(String messageExit) {
		this.messageExit = messageExit;
	}


	/**
	 * @return the securityToken
	 */
	public String getSecurityToken() {
		return securityToken;
	}


	/**
	 * @param securityToken the securityToken to set
	 */
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}


	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}


	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		logger.debug("setLogin!\n");
		if ((login == null) || (company == null)) {
			cargarEmpleado(login);
			this.login = login;
		}
	}

	/**
	 * @param unsettledBalance the unsettledBalance to set
	 */
	public void setUnsettledBalance(float unsettledBalance) {
		this.unsettledBalance = unsettledBalance;
	}

	/**
	 * @return the unsettledBalance
	 */
	public float getUnsettledBalance() {
		return unsettledBalance;
	}

	public float getDeduction() {
		return deduction;
	}

	public void setDeduction(float deduction) {
		this.deduction = deduction;
	}

	public short getEmployer() {
		return employer;
	}

	public void setEmployer(short employer) {
		this.employer = employer;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}