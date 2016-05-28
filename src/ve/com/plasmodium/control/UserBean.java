package ve.com.plasmodium.control;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import ve.com.plasmodium.model.vo.UserVo;

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
	private List<SelectItem> selectUserCallCenter;
	private List<SelectItem> selectDistributer;
	private List<SelectItem> selectMasterDistributer; //Selected master distributer to obtain the distributer list selected by a user of level 99,98
	private String selectedDistributer;
	private String selectedMasterDistributer; //Master distributer to obtain the distributer list selected by a user of level 99,98
	private String selectedDistributeru;
	private String selectedUser;
	private String selectedUserCallCenter;
	// antes era string
	private UserVo userDetail;
	private UserVo userDetail2;
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
		selectedUserCallCenter = new String();
		selectedMasterDistributer = new String();
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
		//passUser = new String();
		//short distributer = sessionUserBean.getDistributer();
		resetUserList();
		resetUserCallCenterList();

		if(company==null){
			setLogin(SecurityContextHolder.getContext().getAuthentication().getName());
			if(!login.equals("anonymousUser"))
				setLogin(login);
			resetSelectDistributer();
			selectMasterDistributer = new ArrayList<SelectItem>();
			SelectItem si = new SelectItem(Short.toString(getDistributer()),getCompanyName());
		}

	}

	public float buscarDeduction(short company){
		UserManager userManager = new UserManager(SQLConstant.MYSQL);		
		return userManager.bucarDeduction(company);

	}


	/**
	 * Busca la lista de usuario segun un Distribuidor
	 * @param distrib Distribuidor seleccionado.
	 * @return
	 */
	public List<SelectItem> buscarUsuario(short distrib){
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		try {
			resetUserList();
			selectUser.addAll((List<SelectItem>) userManager.listaUsuarios(selectDistributer, distrib));
		} catch (Exception e) {
			logger.error("Exception UserBean - buscarUsuario ", e);
		}	    
		return selectUser;
	}

	/**
	 * Recibe el dato seleccionado de la lista de distribuidores para simular sus funciones y contendo para el usuario maestro
	 * @param e Distribuidor seleccionado
	 */
	public void distribListenerMethod (){
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		short dis =  Short.parseShort(selectedDistributer);
		logger.debug("   "+dis+"   "+sessionUserBean.getLevel());
		if(sessionUserBean.getLevel()==99 || sessionUserBean.getLevel()==98){
			sessionUserBean.setDistributer(dis);
		}else{
			short distrib = Short.parseShort(selectedDistributeru);
			buscarUsuario(distrib);
		}
		logger.debug(selectedDistributeru);
		GlobalDataBean globalDataBean = new GlobalDataBean();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("GlobalData", globalDataBean);
	}

	/**
	 * Recibe el distribuidor raiz y consulta los distribuidores asociados a ese distribuidor usado para las listas
	 * de los usuarios de nivel 98, 99
	 * @param el Distribuidor seleccionado
	 */
	public void masterDistribListenerMethod (){
		resetSelectDistributer();
		setDistributer(Short.parseShort(this.selectedMasterDistributer));
		SelectItem si = new SelectItem(this.selectedMasterDistributer,"distribuidor del usuario");
		/*Remove the last element and reinsert it because the option "seleccione distribuidor" is placed last*/
		(this.selectDistributer).remove((this.selectDistributer).size()-1);
		(this.selectDistributer).add(0,new SelectItem("9999","Seleccione un Distribuidor"));
	}
	
	/**
	 * Recibe el dato seleccionado de la lista de distribuidores para llenar lista de usuario segun ese distribuidor
	 * @param e Distribuidor seleccionado
	 */
	public void distribListenerMethod2 (){
		resetUserList();
		short dis =  Short.parseShort(selectedDistributeru);
		AuthorizationBean sessionAuthorizationBean = (AuthorizationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AuthorizationBean");
		if(sessionAuthorizationBean!=null){
			if(!sessionAuthorizationBean.isUSER_CALLCENTER())
				buscarUsuario(dis);
		}
		GlobalDataBean globalDataBean = new GlobalDataBean();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("GlobalData", globalDataBean);
	}

	public void userListenerMethod1(){
		userListenerMethod();
	}
	public void userListenerMethod2(){
		userListenerMethod();
	}
	/**
	 * Recibe el dato seleccionado de la lista de usuario para traer los datos del mismo o mostrar pantalla de ingreso a nuevo usuario
	 * @param e Usuario seleccionado
	 */
	public void userListenerMethod( ){
		try{
			UserManager userManager = new UserManager(SQLConstant.MYSQL);		
			short userIDS  = selectedUser==null || selectedUser.equals("")?Short.parseShort(selectedUserCallCenter):Short.parseShort(selectedUser);
			if(userIDS!=9999){
				if(userIDS==999){
					showDetail=true;
					showDetailNew=false; 
					idUser = null;
					loginUser = null;
					nameUser = null;
					mailUser = null;
					levelListUser = "9999";
					jobtitleUser = null;
				}else{
					showDetail=true;
					showDetailNew=false;
					userDetail2 = userManager.usuarioDetail(userIDS);
					idUser = userDetail2.getDoc();
					loginUser = userDetail2.getLogin();
					nameUser = userDetail2.getName();
					mailUser = userDetail2.getEmail();
					levelListUser = userDetail2.getLevel()+"";
					jobtitleUser = userDetail2.getJobtitle();
				}
				FacesContext.getCurrentInstance().renderResponse();
				FacesContext.getCurrentInstance().responseComplete();
				FacesContext.getCurrentInstance().getExternalContext().redirect("User.jsf");
			}else{
				showDetail=false;
				showDetailNew=false;
			}
		}catch (Exception e){
			logger.error("Exception UserBean - userListenerMethod ", e);
		}

	}

	/**
	 * Recibe el dato seleccionado de la lista de usuario para traer los datos del mismo
	 * @param e Usuario seleccionado
	 */
	public void approveUserListenerMethod(){
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		selectedUserCallCenter = selectedUser;
		short userIDS  = selectedUser==null?Short.parseShort(selectedUserCallCenter):Short.parseShort(selectedUser);
		if(userIDS>0){
			showDetail=true;
			showDetailNew=false;
			userDetail2 = userManager.usuarioDetail(userIDS);
			idUser = userDetail2.getDoc();
			loginUser = userDetail2.getLogin();
			nameUser = userDetail2.getName();
			lastNameUser = userDetail2.getLastname();
			mailUser = userDetail2.getEmail();
			levelListUser = userDetail2.getLevel()+"";
			jobtitleUser = userDetail2.getJobtitle();
			FacesContext.getCurrentInstance().renderResponse();
		}else{
			showDetail=false;
			showDetailNew=false;
		}
	}

	/**
	 * Recibe el dato seleccionado de la lista de usuario para traer los datos del mismo
	 * @param e Usuario seleccionado
	 */
	public void creditListenerMethod(){
		setShowCreditOptions(false);
		String valor  = levelListUser;
		if(valor.compareTo("42")!=0){
			if(valor.compareTo("43")==0){
				creditLabel = "Monto Limite Pre-aprobado";
			} else if(valor.compareTo("44")==0){
				creditLabel = "Limite de Credito";
			}
			setShowCreditOptions(true);
			FacesContext.getCurrentInstance().renderResponse();
		} 
	}

	/**
	 * Cambia los datos usuario por los captados en pantalla 
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionChangeUser() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		String user,doc,login,name,mail,cargo,level,pass,max_unsettled_balance, max_selling_amount, max_days_card_unsettled;
		if((idUser!=null || idUser.compareTo("")!=0)&& loginUser!=null && nameUser!=null && mailUser!=null && jobtitleUser!=null && levelListUser.compareTo(9999+"")!=0){
			Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
			Matcher fit = email.matcher(mailUser);
			List<String> aux = null;
			Short company=0;
			user = selectedUser==null?selectedUserCallCenter:selectedUser;
			doc = idUser;
			login = loginUser;
			name = nameUser;
			mail = mailUser;
			cargo = jobtitleUser;
			level = levelListUser;
			pass =  "";
			max_unsettled_balance ="";
			max_selling_amount="0";
			max_days_card_unsettled="0";
			if(maxUnsettledBalance!=null) {
				max_unsettled_balance = maxUnsettledBalance;
				/*max_selling_amount = maxSellingAmount;
				max_days_card_unsettled = maxDaysCardUnsettled;	*/			
			} 
			if (!fit.matches())
				return navigation;
			if(userManager.changeUser(company,user, doc, login, name, mail, cargo, level,aux, pass, max_unsettled_balance, max_selling_amount, max_days_card_unsettled)){
				navigation = "successful_change";
				getMessages().add(0,"Operación satisfactoria - El usuario : "+nameUser+" "+lastNameUser+" ha sido actualizado en el sistema.");	    	
				setMessageExit("");
				resetFaceUser();
				idUser = "";
				loginUser = "";
				nameUser = "";
				mailUser = "";
				jobtitleUser = "";
				levelListUser = "";
				passUser = "";
				maxUnsettledBalance = "";
				maxSellingAmount = "";
				maxDaysCardUnsettled = "";
				selectedDistributeru = "9999";
				selectedUser = "9999";
				setShowDetail(false); 
				setShowCreditOptions(false); 
				setShowDetailNew(false);
				setShowTarven(false);
				setShowNvRd(false);
				setShowNvRdAdmin(false);
				setShowNoHibrido(false);

			}
		}
		return navigation;
	}

	/**
	 * Desactiva el usario que se encuentra mostrado en pantalla actualmente
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionDeleteUser() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(userManager.deleteUser(selectedUser,false)){
			navigation="successful_delete";
			getMessages().add(0,"Operación satisfactoria - El usuario : "+nameUser+" ha sido actualizado en el sistema.");	    	
			setMessageExit("");
			resetFaceUser();
		}
		return navigation;
	}

	/**
	 * Agrega un usuario nuevo al sistema 
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionAddUser() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(userIdNew!=null && userLoginNew!=null && userNameNew!=null && userMailNew!=null && userJobtitleNew!=null && levelListUserNew.compareTo(9999+"")!=0 && passUserNew!=null){
			logger.debug("entro "+company);
			logger.debug(selectedDistributeru);
			logger.debug(userIdNew);
			logger.debug(userLoginNew);
			Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
			Matcher fit = email.matcher(userMailNew);
			if (!fit.matches())
				return navigation;
			//userNameNewn+" "+userMailNew+" "+userJobtitleNew+" "+levelListUserNew+" "+passUserNew
			if(userManager.addUser(company, selectedDistributeru==null?"1":selectedDistributeru ,userIdNew, userLoginNew, userNameNew, userMailNew, userJobtitleNew, levelListUserNew, passUserNew)==1){
				navigation = "successful_add";
				getMessages().add(0,"Operación satisfactoria - el usuario : "+userNameNew+" ha sido agregado en el sistema.");	    	
				setMessageExit("");
				resetFaceUser();
				userIdNew = "";
				userLoginNew = "";
				userNameNew = "";
				userMailNew = "";
				userJobtitleNew = "";
				levelListUserNew = "";
				passUserNew = "";
				selectedDistributeru = "9999";
				selectedUser = "9999";
				setShowDetail(false); 
				setShowDetailNew(false);
				setShowTarven(false);
				setShowNvRd(false);
				setShowNvRdAdmin(false);
				setShowNoHibrido(false);
			}
		}
		return navigation;
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
			selectedDistributer = "";
			selectedUser = "";
			selectedUserCallCenter = "";
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
			UserVo userVo = (UserVo) userManager.datosUsuario(login);
			logger.debug("el usuario es " + userVo.getUser());
			if(userVo!=null) {
				if(userVo.getLevel()==1)
					showTarven=true;
				if(userVo.getLevel()==30)
					showNvRd=true;
				if(userVo.getLevel()==99)
					showNvRdAdmin=true;
					showNoHibrido=true;
				logger.debug("su compania es " + userVo.getCompany());
				logger.debug("su level es " + userVo.getLevel());
				setCompany(userVo.getCompany());
				setUserName(userVo.getName());
				setClient(userVo.getClient());
				setMasterClient(userVo.getMasterClient());
				setDistributer(userVo.getEmployer());
				setEmployer(userVo.getEmployer());
				setUser(userVo.getUser());
				setLevel(userVo.getLevel());
				setPassUser(userVo.getPassword());
				setRoute(userVo.getRoute());
				setEmail(userVo.getEmail());
				setCompanyName(userVo.getNameCompany());
				//setBalance(Float.parseFloat(userManager.getBalance(userVo.getCompany(),userVo.getUser())));
				if (getDistributer()<235) { //TODO ESTO ES TEMPORAL POR LA COMISION DE SMARTCALL
					setDeduction(buscarDeduction(getCompany()));
				}
				else {
					setDeduction(Float.parseFloat("0.932")); //TODO ESTO ES TEMPORAL POR LA COMISION DE SMARTCALL
				}
			//	SecurityContext sg = (SecurityContext) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SPRING_SECURITY_CONTEXT");
			//	if((sg.toString().indexOf("IS_APPROVE_DEPOSIT"))>0 || (sg.toString().indexOf("APPROVE_DEPOSIT_GRE"))>0 || (sg.toString().indexOf("IS_SHOW_BALANCE"))>0 
			//	|| (sg.toString().indexOf("IS_CREATE_POS_WEB"))>0 || (sg.toString().indexOf("IS_UPDATE_POS_WEB"))>0 || (sg.toString().indexOf("IS_DELETE_POS_WEB"))>0 ){
					logger.debug("busco el balance ");
					/*List<String> user_data = cryptoManager.getSecurityToken("001000", login, passUser);
					if(user_data.size()>=3 && user_data.get(2) != null)
						setSecurityToken(user_data.get(2));
					if(user_data.size()>=4 && user_data.get(3) != null)
						setBalance(Float.parseFloat(user_data.get(3))/100);*/
				//}
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
	 * Resetela (limpia) la lista de usuario para volverla a llenar segun el distribuidor seleccionado
	 */
	public void resetUserCallCenterList(){
		logger.debug("Entro al reset User del Bean UserCallCenter");
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		SelectItem si ;
		si = new SelectItem("9999","Seleccione un Usuario");

		if(selectUserCallCenter==null){
			selectUserCallCenter  =  new ArrayList<SelectItem>();
		}else{
			selectUserCallCenter.clear();
		}
		selectUserCallCenter.add(si);	 
		selectUserCallCenter = (List<SelectItem>) userManager.listaUsuarios(selectDistributer, Short.parseShort("1"));
	}



	/*	public void setLevelList(List<SelectItem> levelList) {
		this.levelList = levelList;
	}
	public List<SelectItem> getLevelList() {
		return levelList;
	}*/

	/*	public void resetLevelList(){
	    SelectItem si;
	    si = new SelectItem("9999","Seleccione un Nivel de Acceso");
	    if(levelList==null){
	    	levelList  =  new ArrayList<SelectItem>();
	    }else{
	    	levelList.clear();
	    }
	    levelList.add(si);
	    AuthorizationBean sessionAuthorizationBean = (AuthorizationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AuthorizationBean");
	    if(sessionAuthorizationBean.isCREATE_USER()){
	    	si = new SelectItem("1","Administrador Tarven");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER()){
	    	si = new SelectItem("36","Analista de Inventarios Tarven");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER()){
	    	si = new SelectItem("37","Analista Depositos  Tarven");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER()){
	    	si = new SelectItem("31","Supervisor de Distribuidor");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("8","Fabricante");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("8","Fabricante");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("4","Analista Credito y Cobranzas DTV ");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("3","Asistente Credito y Cobranzas DTV");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("99","Administrador Sistema");
	    	levelList.add(si);
	    }
	    if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
	    	si = new SelectItem("30","Finanzas");
	    	levelList.add(si);
	    }
	}*/

	/**
	 * Reset the list of distributers
	 */
	public void resetSelectDistributer(){
		SelectItem si;
		si = new SelectItem("9999","Seleccione un Distribuidor");
		if(selectDistributer==null){
			selectDistributer  =  new ArrayList<SelectItem>();
		}else{
			selectDistributer.clear();
		}
		selectDistributer.add(si);
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
	 * @return the selectUserCallCenter
	 */
	public List<SelectItem> getSelectUserCallCenter() {
		return selectUserCallCenter;
	}


	/**
	 * @param selectUserCallCenter the selectUserCallCenter to set
	 */
	public void setSelectUserCallCenter(List<SelectItem> selectUserCallCenter) {
		this.selectUserCallCenter = selectUserCallCenter;
	}


	/**
	 * @return the selectDistributer
	 */
	public List<SelectItem> getSelectDistributer() {
		return selectDistributer;
	}


	/**
	 * @param selectDistributer the selectDistributer to set
	 */
	public void setSelectDistributer(List<SelectItem> selectDistributer) {
		this.selectDistributer = selectDistributer;
	}


	/**
	 * @return the selectedDistributer
	 */
	public String getSelectedDistributer() {
		return selectedDistributer;
	}


	/**
	 * @param selectedDistributer the selectedDistributer to set
	 */
	public void setSelectedDistributer(String selectedDistributer) {
		this.selectedDistributer = selectedDistributer;
	}


	/**
	 * @return the selectedDistributeru
	 */
	public String getSelectedDistributeru() {
		return selectedDistributeru;
	}


	/**
	 * @param selectedDistributeru the selectedDistributeru to set
	 */
	public void setSelectedDistributeru(String selectedDistributeru) {
		this.selectedDistributeru = selectedDistributeru;
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
	 * @return the selectedUserCallCenter
	 */
	public String getSelectedUserCallCenter() {
		return selectedUserCallCenter;
	}


	/**
	 * @param selectedUserCallCenter the selectedUserCallCenter to set
	 */
	public void setSelectedUserCallCenter(String selectedUserCallCenter) {
		this.selectedUserCallCenter = selectedUserCallCenter;
	}


	/**
	 * @return the userDetail
	 */
	public UserVo getUserDetail() {
		return userDetail;
	}


	/**
	 * @param userDetail the userDetail to set
	 */
	public void setUserDetail(UserVo userDetail) {
		this.userDetail = userDetail;
	}


	/**
	 * @return the userDetail2
	 */
	public UserVo getUserDetail2() {
		return userDetail2;
	}


	/**
	 * @param userDetail2 the userDetail2 to set
	 */
	public void setUserDetail2(UserVo userDetail2) {
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

	public List<SelectItem> getSelectMasterDistributer() {
		return selectMasterDistributer;
	}

	public void setSelectMasterDistributer(List<SelectItem> selectMasterDistributer) {
		this.selectMasterDistributer = selectMasterDistributer;
	}

	public String getSelectedMasterDistributer() {
		return selectedMasterDistributer;
	}

	public void setSelectedMasterDistributer(String selectedMasterDistributer) {
		this.selectedMasterDistributer = selectedMasterDistributer;
	}

}