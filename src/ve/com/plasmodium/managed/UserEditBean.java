package ve.com.plasmodium.managed;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ve.com.plasmodium.control.AuthorizationBean;
import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.control.UserBean;
import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.UserVo;
import ve.com.plasmodium.util.MailNotifier;

@ManagedBean(name="UserEditBean")
@SessionScoped
public class UserEditBean {

	public static final Logger logger = Logger.getLogger(UserEditBean.class);


	private int user;
	private String login;
	private String userName;
	private String numDoc;
	//private String email;
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
	private String industryUser = new String();
	private String maxUnsettledBalance = new String();
	private String maxSellingAmount = new String();
	private String maxDaysCardUnsettled = new String();

	private String levelListUser;
	private String levelListUserNew;
	private List<String> serviceCompany;
	private List<SelectItem> selectSercviceCompany;

	//private List<SelectItem> levelList;
	private List<SelectItem> selectUser;
	private List<SelectItem> selectUserCallCenter;
	private List<SelectItem> selectDistributer;
	private String selectedDistributer;
	private String selectedDistributeru;
	private String selectedUser;
	private String selectedUserCallCenter;
	private UserVo userDetail;
	private UserVo userDetail2;
	private Short company;
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
	private boolean showPickUser=false;
	private boolean userEnabled=false;
	private boolean editDetail=false;
	private List<String> messages = new ArrayList<String>();
	private String messageExit;
	private String securityToken;
	private float balance = 0;
	private float unsettledBalance = 0;
	private String selectedState;
	private String selectedMunicipality;
	private String selectedCity;
	private List<SelectItem> selectState = new ArrayList<SelectItem>();
	private List<SelectItem> selectCity = new ArrayList<SelectItem>();
	private List<SelectItem> selectMunicipality = new ArrayList<SelectItem>();
	private List<SelectItem> levelList;


	public UserEditBean() throws ParseException {
		logger.debug("Entro al constructor de UserEditBean");
		userName="";
		selectedUser = new String();
		selectedUserCallCenter = new String();
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
		AuthorizationBean sessionAuthorizationBean = (AuthorizationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AuthorizationBean");
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		logger.debug(param + "----------");
		//short distributer = sessionUserBean.getDistributer();
		resetSelectDistributer();
		logger.debug(sessionUserBean.getCompany());
		logger.debug(sessionUserBean.getCompanyName());
		SelectItem si = new SelectItem(Short.toString(sessionUserBean.getCompany()),sessionUserBean.getCompanyName());
		selectDistributer.add(si);

		resetUserList();
		//resetUserCallCenterList();
		
		company = sessionUserBean.getCompany();
		resetServiceCompany();
		//resetselectSercviceCompany();
		resetLevelList();
		if(sessionAuthorizationBean.isIS_APPROVE_USER()) //es aprobador de usuarios
			resetAllLists(); 
	}

	private void resetAllLists() {
		getPendingStates();
		resetMunicipality();
		resetCity();
		resetUser();
	}

	public void resetState(){
		if(!selectState.isEmpty())	
			selectState.clear();
		selectState.add(new SelectItem("9999","Seleccione un Estado"));
		selectedState = "9999";
	}

	public void resetMunicipality(){
		if(!selectMunicipality.isEmpty())	
			selectMunicipality.clear();
		selectMunicipality.add(new SelectItem("9999","Seleccione un Municipio"));
		selectedMunicipality = "9999";
	}

	public void resetCity(){
		if(!selectCity.isEmpty())	
			selectCity.clear();
		selectCity.add(new SelectItem("9999","Seleccione una Ciudad"));
		selectedCity = "9999";
	}

	public void resetServiceCompany(){
		if(serviceCompany==null){
			serviceCompany =  new ArrayList<String>();
		}else{
			serviceCompany.clear();
		}
	}

	public void resetUser(){
		if(!selectUser.isEmpty())	
			selectUser.clear();
		selectUser.add(new SelectItem("9999","Seleccione un Usuario"));
		selectedUser = "9999";
	}

	public void clearDataUser(){
		showDetail=false;
		showDetailNew=false; 
		setIdUser("");
		setLoginUser("");
		setNameUser("");
		setPassUser("");
		setMailUser("");
		levelListUser = "9999";
		setJobtitleUser("");
		industryUser = null;
		userEnabled = false;
	}

	public List<SelectItem> getPendingStates() {
		resetState();
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		try {
			selectState.addAll(userManager.getPendingStates(company));
		} catch (Exception e) {
			logger.error("Exception UserEditBean - buscarState ", e);
		}	    
		return selectState;
	}


	public void selectedStateListener(){
		resetMunicipality();
		resetCity();
		resetUser();
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(!selectedState.equals("9999")){
			selectMunicipality.addAll(userManager.getPendingMunicipalities(company,Short.parseShort(selectedState)));
		}else{
			setShowDetail(false);
		}
	}

	public void selectedMunicipalityListener(){
		resetCity();
		resetUser();
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(!selectedMunicipality.equals("9999")){
			selectCity.addAll(userManager.getPendingCities(company,Short.parseShort(selectedState),Integer.parseInt(selectedMunicipality)));
		}else{
			setShowDetail(false);
		}
	}

	public void selectedCityListener(){
		resetUser();
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(!selectedCity.equals("9999")){
			selectUser.addAll(userManager.getUsersToApprove(company,Short.parseShort(selectedState),Integer.parseInt(selectedMunicipality),Integer.parseInt(selectedCity)));
		}else{
			setShowDetail(false);
		}
	}

	/**
	 * Busca la lista de usuario segun un Distribuidor
	 * @param distrib Distribuidor seleccionado.
	 * @return
	 */
	public List<SelectItem> buscarUsuario(short distrib){
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		try {
			selectUser = (List<SelectItem>) userManager.listaUsuarios(selectDistributer, distrib);
		} catch (Exception e) {
			logger.error("Exception UserEditBean - buscarUsuario ", e);
		}	    
		return selectUser;
	}
	
	public void serviceCompany(){
		logger.debug(serviceCompany+" ....................................");
	}
	
	/**
	 * Recibe el dato seleccionado de la lista de distribuidores para llenar lista de usuario segun ese distribuidor
	 * @param e Distribuidor seleccionado
	 */
	public void distribListenerMethod2 (){
		setShowPickUser(false);
		setShowDetail(false);
		setSelectedUser("");
		userListenerMethod();
		resetUserList();
		if(selectedDistributeru != null && !selectedDistributeru.equals("")){
			buscarUsuario(Short.parseShort(selectedDistributeru));
			setShowPickUser(true);
		}
		
	}

	/*	@SuppressWarnings("unchecked")
	public void sercviceCompanyListener(){
		resetServiceCompany();
		serviceCompany.addAll((List<String>)e.getNewValue());
	}*/

	public void resetselectSercviceCompany(){
		if(selectSercviceCompany==null){
			selectSercviceCompany =  new ArrayList<SelectItem>();
		}else{
			selectSercviceCompany.clear();
		}
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		selectSercviceCompany.addAll(userManager.getServiceCompany(company));
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
		logger.debug("Entre al metodo de busca de detalle de usuario  ");
		try{
			clearDataUser();
			showDetail=false;
			showDetailNew=false;
			if(selectedUser != null && !selectedUser.equals("")){
				short userIDS  = Short.parseShort(selectedUser);
				if(userIDS==999){
					showDetail=true;
					showDetailNew=true; 
					idUser = null;
					loginUser = null;
					nameUser = null;
					passUser = "";
					mailUser = null;
					levelListUser = "9999";
					jobtitleUser = null;
					industryUser = null;
					userEnabled = true;
				}else{
					UserManager userManager = new UserManager(SQLConstant.MYSQL);
					showDetail=true;
					showDetailNew=false;
					userDetail2 = userManager.usuarioDetail(userIDS);
					idUser = userDetail2.getDoc();
					loginUser = userDetail2.getLogin();
					passUser = ".....";
					nameUser = userDetail2.getName();
					mailUser = userDetail2.getEmail();
					levelListUser = userDetail2.getLevel()+"";
					jobtitleUser = userDetail2.getJobtitle();
					userEnabled = userDetail2.getActive();
				}
			}
			/*If an existent user is selected his details can't be edited unless the button with label "Modificar" is pressed*/
			editDetail=false; 
		}catch (Exception e){
			logger.error("Exception UserEditBean - userListenerMethod ", e);
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
		if(userIDS==999 || userIDS==9999){
			showDetail=false;
			showDetailNew=true;
		}else{
			showDetail=true;
			showDetailNew=false;
			userDetail2 = userManager.usuarioDetail(userIDS);
			idUser = userDetail2.getDoc();
			loginUser = userDetail2.getLogin();
			nameUser = userDetail2.getName();
			lastNameUser = userDetail2.getLastname();
			mailUser = userDetail2.getEmail();
			levelListUser = userDetail2.getLevel()+"";
			levelListUser = "9999";
			jobtitleUser = userDetail2.getJobtitle();
		}
	}

	/**
	 * Recibe el dato seleccionado de la lista de usuario para traer los datos del mismo
	 * @param e Usuario seleccionado
	 */
	public void creditListenerMethod(){
		setShowCreditOptions(false);
		String valor  = levelListUser;
		if(valor.compareTo("42")!=0 && valor.compareTo("999")!=0){
			if(valor.compareTo("43")==0){
				creditLabel = "Monto Limite Pre-aprobado";
			} else if(valor.compareTo("44")==0){
				creditLabel = "Limite de Credito";
			}
			setShowCreditOptions(true);
		} 
	}

	/**
	 * Cambia los datos usuario por los captados en pantalla 
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionChangeUser() throws CustomException{
		String navigation = "fail";
		if (!(this.editDetail)) {
			this.editDetail = true; 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modo Edición Habilitado","Modifique los campos necesarios y vuelva a presionar \"Modificar\" para guardar los cambios."));
		} else {
			UserManager userManager = new UserManager(SQLConstant.MYSQL);
			UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
			company = sessionUserBean.getCompany();
			String user,doc,login,name,mail,cargo,level,pass,max_unsettled_balance, max_selling_amount, max_days_card_unsettled;
			user = selectedUser==null || selectedUser.equals("")?selectedUserCallCenter:selectedUser;
			doc = idUser.substring(0,1).toUpperCase()+idUser.substring(1,idUser.length());
			login = loginUser;
			name = nameUser;
			mail = mailUser;
			cargo = jobtitleUser;
			level = levelListUser;
			pass =  passUser;
			max_unsettled_balance ="";
			max_selling_amount="0";
			max_days_card_unsettled="0";
			if(maxUnsettledBalance!=null) {
				max_unsettled_balance = maxUnsettledBalance;
				/*max_selling_amount = maxSellingAmount;
					max_days_card_unsettled = maxDaysCardUnsettled;	*/			
			} 		
			logger.debug(serviceCompany.size());
			if(userManager.changeUser(company, user, doc, login, name, mail, cargo, level,serviceCompany, pass, max_unsettled_balance, max_selling_amount, max_days_card_unsettled)){
				navigation = "successful_change";
				sessionUserBean.getMessages().add(0,"Operación satisfactoria - El usuario: "+nameUser+" "+lastNameUser+" ha sido actualizado en el sistema.");	    	
				sessionUserBean.setMessageExit("");
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
			}
		}
		return navigation;
	}

	/**
	 * Cambia los datos usuario por los captados en pantalla 
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionChangeUserApprove() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		AuthorizationBean sessionAuthorizationBean = (AuthorizationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AuthorizationBean");
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		company = sessionUserBean.getCompany();
		String user,level,max_unsettled_balance, max_selling_amount, max_days_card_unsettled;

		user = selectedUser==null || selectedUser.equals("")?selectedUserCallCenter:selectedUser;
		level = levelListUser;
		max_unsettled_balance ="0";
		max_selling_amount="0";
		max_days_card_unsettled="0";
		if(!levelListUser.equals("999")) {
			if(userManager.approveUser(company, user, level, serviceCompany, max_unsettled_balance, max_selling_amount, max_days_card_unsettled)){
				navigation = "successful_change";
				sessionUserBean.getMessages().add(0,"Operación satisfactoria - El usuario: "+nameUser+" "+lastNameUser+" ha sido aprobado.");	    	
				mailNotify(nameUser,lastNameUser,mailUser,maxUnsettledBalance,true);
			}
		} else {
			logger.debug("El usuario no ha sido aprobado por el vendedor");
			navigation = actionDeleteUser();
			mailNotify(nameUser,lastNameUser,mailUser,maxUnsettledBalance,true);
			sessionUserBean.getMessages().add(0,"Operacion Satisfactoria - El usuario: "+nameUser+" no ha sido aprobado");	    	
		}
		sessionUserBean.setMessageExit("");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
		try {
			if(sessionAuthorizationBean.isIS_APPROVE_USER()) //es aprobador de usuarios
				resetAllLists(); // actualizar la lista de usuarios por aprobar
		} catch (Exception e) {
			logger.error("Exception UserEditBean - actionChangeUser ", e);
		}
		return navigation;
	}

	private void mailNotify(String nameUser, String lastNameUser,
			String mail, String maxUnsettledBalance, boolean accept) {
		String subject = "Registro de Vendedor Externo";
		String body = "Estimado "+nameUser+" "+lastNameUser+",\n"+
				"Su usuario en el sistema de Vendedores Externos ha sido "+
				(accept?"aprobado. "+(maxUnsettledBalance.isEmpty()?"":"Su límite de crédito es de BsF. "+maxUnsettledBalance):"rechazado.");
		String[] mailList = {mail};
		MailNotifier mn = new MailNotifier(mailList, subject, body);
		mn.send();
	}

	/**
	 * Desactiva el usario que se encuentra mostrado en pantalla actualmente
	 * @return String Navigation que nos indica a que pantalla dirigirnos
	 * @throws CustomException
	 */
	public String actionDeleteUser() throws CustomException{
		String navigation = "fail";
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		company = sessionUserBean.getCompany();
		if(userManager.deleteUser(selectedUser,(userEnabled ? false:true))){
			navigation="successful_delete";
			sessionUserBean.getMessages().add(0,"Operación satisfactoria - El usuario: "+nameUser+" ha sido "+(userEnabled ? "borrado del sistema.":"reactivado en el sistema."));	    	
			sessionUserBean.setMessageExit("");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
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
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		company = sessionUserBean.getCompany();
		if(idUser!=null &&  idUser.length()!=0 && loginUser!=null && loginUser.length()!=0 && nameUser!=null && nameUser.length()!=0 && mailUser!=null && mailUser.length()!=0 && jobtitleUser!=null && jobtitleUser.length()!=0 && !levelListUser.equals("9999") && passUser!=null && passUser.length()!=0){
			Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher fit = email.matcher(mailUser);
			if (!fit.matches())
				return navigation;
			idUser = idUser.substring(0,1).toUpperCase()+idUser.substring(1,idUser.length()); //Change the first letter to uppercase
			switch(userManager.addUser(company, selectedDistributeru==null?"1":selectedDistributeru ,idUser, loginUser, nameUser, mailUser, jobtitleUser, levelListUser, passUser)){
			case -1:
				message=" ATENCION: El usuario \""+loginUser+"\" ya existe por favor intente con otro.";
				break;
			case 0:
				message=" ATENCION: La operacion no se pudo realizar, revise los datos.";
				break;
			case 1:
				navigation = "successful_add";
				sessionUserBean.getMessages().add(0,"Operación satisfactoria - El usuario: "+nameUser+" ha sido agregado en el sistema.");	    	
				sessionUserBean.setMessageExit("");
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
				break;

			}
		}
		return navigation;
	}



	/**
	 * Resetela (limpia) la lista de usuario para volverla a llenar segun el distribuidor seleccionado
	 */
	public void resetUserList(){			
		
		if(selectUser==null){
			selectUser  =  new ArrayList<SelectItem>();
		}else{
			selectUser.clear();
		}
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

	public void distribListenerMethod (){
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		GlobalDataBean global = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		short dis =  Short.parseShort(selectedDistributer);
		logger.debug("   "+dis+"   "+sessionUserBean.getLevel());
		if(sessionUserBean.getLevel()==99 || sessionUserBean.getLevel()==98){
			sessionUserBean.setDistributer(dis);
			if(global != null)
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("GlobalData");
		}else{
			short distrib = Short.parseShort(selectedDistributeru);
			buscarUsuario(distrib);
		}
		GlobalDataBean globalDataBean = new GlobalDataBean();
		logger.debug(selectedDistributeru);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("GlobalData", globalDataBean);
	}


	/**
	 * 
	 */
	public void resetSelectDistributer(){
		SelectItem si;
		//si = new SelectItem("9999","Seleccione un Distribuidor");
		if(selectDistributer==null){
			selectDistributer  =  new ArrayList<SelectItem>();
		}else{
			selectDistributer.clear();
		}
		//selectDistributer.add(si);
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
		String pwd, pwdNew, rePwdNew, loginUser = sessionUserBean.getLogin();
		if(message!=null)
			message=null;
		if(passUser!=null && passUserNew !=null && confirmPassNew!=null){
			pwd = passUser;
			pwdNew = passUserNew;
			rePwdNew = confirmPassNew;
			logger.debug("passUser : " + passUser);
			logger.debug("passUserNew : " + passUserNew);
			logger.debug("confirmPassNew : " + confirmPassNew);
			if(pwdNew.compareTo(rePwdNew)==0){
				if(userManager.validatePassword(loginUser,pwd)){
					if(userManager.updatePass(loginUser,pwdNew)){
						navigation = "successful";
						sessionUserBean.getMessages().add(0,"Operacion Satisfactoria - Usuario : \""+sessionUserBean.getUserName()+"\" Ha cambiado su clave de acceso al Sistema.");	    	
						setMessageExit("");
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
					}
				}else{
					navigation = "fail_current_pwd";
					resetFaceUser();
					message="ATENCIï¿½N: La clave actual que introdujo es Incorrecta ";
				}
			}else{
				navigation = "fail_confirm_pwd";
				resetFaceUser();
				message=" ATENCIï¿½N: La clave nueva que introdujo debe ser IGUAL en ambos campos ";
			}
		}
		return navigation;
	}

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

	public void resetLevelList(){
		logger.debug("reset de lista de niveles");
		SelectItem si;
		si = new SelectItem("9999","Seleccione un Nivel de Acceso");
		if(levelList==null){
			levelList  =  new ArrayList<SelectItem>();
		}else{
			levelList.clear();
		}
		levelList.add(si);
		si = new SelectItem("999","Usuario No Aprobado");
		levelList.add(si);
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		short level = sessionUserBean.getLevel();
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		logger.debug("busco los niveles de usuario");
		levelList.addAll(userManager.getLevels(level));
		/*AuthorizationBean sessionAuthorizationBean = (AuthorizationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AuthorizationBean");
		if(sessionAuthorizationBean.isCREATE_USER() && !sessionAuthorizationBean.isUSER_CALLCENTER()){
			si = new SelectItem("1","Administrador Tarven");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && !sessionAuthorizationBean.isUSER_CALLCENTER()){
			si = new SelectItem("36","Analista de Inventarios Tarven");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && !sessionAuthorizationBean.isUSER_CALLCENTER()){
			si = new SelectItem("37","Analista Depositos  Tarven");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && !sessionAuthorizationBean.isUSER_CALLCENTER()){
			si = new SelectItem("31","Supervisor de Distribuidor");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
			si = new SelectItem("8","Fabricante");
			levelList.add(si);
		}
		if((sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD())  || (sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isUSER_CALLCENTER())){
			si = new SelectItem("4","Analista Credito y Cobranzas DTV ");
			levelList.add(si);
		}
		if((sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()) || (sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isUSER_CALLCENTER())){
			si = new SelectItem("3","Asistente Credito y Cobranzas DTV");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
			si = new SelectItem("30","Finanzas Novared");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
			si = new SelectItem("99","Administrador Sistema");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD()){
			si = new SelectItem("98","Administrador Crypto-Web");
			levelList.add(si);
		}
		if((sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isUSER_CALLCENTER()) || (sessionAuthorizationBean.isCREATE_USER() && sessionAuthorizationBean.isCHANGE_STATUS_NVRD())){
			si = new SelectItem("12","Call Center");
			levelList.add(si);
		}
		if(sessionAuthorizationBean.isIS_APPROVE_USER()){
			getLevels();
		}*/
	}

	public List<SelectItem> getLevels() { 
		logger.debug("entro al getLevels en GobalDataBean \n");
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		short level=(short)sessionUserBean.getLevel();
		try {
			levelList = (List<SelectItem>) userManager.getLevels(level);
		} catch (Exception e) {
			logger.error("Exception GlobalDataBean - getLevels ", e);
		}	    
		return levelList;
	}

	/**
	 * 
	 * @return
	 */
	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserEditBean");
		return navigation;
	}

	public void setLevelList(List<SelectItem> levelList) {
		this.levelList = levelList;
	}

	public List<SelectItem> getLevelList() {
		return levelList;
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

	public String getMailUser() {
		return mailUser;
	}

	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}

	public String getJobtitleUser() {
		return jobtitleUser;
	}

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

	public String getIndustryUser() {
		return industryUser;
	}

	public void setIndustryUser(String industryUser) {
		this.industryUser = industryUser;
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

	public String getSelectedState() {
		return selectedState;
	}

	public void setSelectedState(String selectedState) {
		this.selectedState = selectedState;
	}

	public String getSelectedMunicipality() {
		return selectedMunicipality;
	}

	public void setSelectedMunicipality(String selectedMunicipality) {
		this.selectedMunicipality = selectedMunicipality;
	}

	public String getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}

	public List<SelectItem> getSelectState() {
		return selectState;
	}

	public void setSelectState(List<SelectItem> selectState) {
		this.selectState = selectState;
	}

	public List<SelectItem> getSelectCity() {
		return selectCity;
	}

	public void setSelectCity(List<SelectItem> selectCity) {
		this.selectCity = selectCity;
	}

	public List<SelectItem> getSelectMunicipality() {
		return selectMunicipality;
	}

	public void setSelectMunicipality(List<SelectItem> selectMunicipality) {
		this.selectMunicipality = selectMunicipality;
	}

	public List<String> getServiceCompany() {
		return serviceCompany;
	}

	public void setServiceCompany(List<String> serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	public List<SelectItem> getSelectSercviceCompany() {
		return selectSercviceCompany;
	}

	public void setSelectSercviceCompany(List<SelectItem> selectSercviceCompany) {
		this.selectSercviceCompany = selectSercviceCompany;
	}

	public boolean isShowPickUser() {
		return showPickUser;
	}

	public void setShowPickUser(boolean showPickUser) {
		this.showPickUser = showPickUser;
	}

	public boolean isUserEnabled() {
		return userEnabled;
	}

	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}

	public boolean isEditDetail() {
		return editDetail;
	}

	public void setEditDetail(boolean editDetail) {
		this.editDetail = editDetail;
	}
}