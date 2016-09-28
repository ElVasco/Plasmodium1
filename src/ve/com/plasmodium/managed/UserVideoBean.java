package ve.com.plasmodium.managed;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import ve.com.plasmodium.control.UserBean;
import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.manager.VideoManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.util.MailNotifier;


@ManagedBean(name="UserVideoBean")
@SessionScoped
public class UserVideoBean {

	public static final Logger logger = Logger.getLogger(UserVideoBean.class);


	private String name;
	private String lastname;
	private String pass;	
	private String mail;
	private String level;
	private String selectedUser;
	
	private List<SelectItem> levelList;
	private List<SelectItem> selectUser;
	


	public UserVideoBean() {
		logger.debug("entro a constructor UserVideoBean");
		resetUser();
		setMail(mail);
		//resetLevelList();
		setLevel("114");

	}
	
	public void resetUser(){
		if(selectUser==null){
			selectUser = new  ArrayList<SelectItem>();
		} else {
			selectUser.clear();
		}
		selectUser =  new ArrayList<SelectItem>();
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");	    
		int user = sessionUserBean.getUser();
		short company = sessionUserBean.getCompany();
		VideoManager videoManager = new VideoManager(SQLConstant.MYSQL);
		selectUser = videoManager.userList(company);
		setSelectedUser(user+"");

	}
	
	public void resetLevelList(){
		logger.debug("reset de lista de niveles");
		SelectItem si;
		si = new SelectItem("114","Visualizar Videos");
		if(levelList==null){
			levelList  =  new ArrayList<SelectItem>();
		}else{
			levelList.clear();
		}
		levelList.add(si);
		si = new SelectItem("115","Administrar videos");
		levelList.add(si);
		si = new SelectItem("116","Administrar usuarios");
		levelList.add(si);
	}

	private void mailNotify(String name, String login, String pass,String mail) {
		String subject = "Registro de usuario CMS";
		String body = "Estimado "+name+",\n\n"+
				"Su usuario en el sistema CMS ha sido creado con exito.\n"+
				"Ususario: "+login+"\n"+
				"Clave: "+pass+"\n"+
				"Pagina de acceso: https://devsco1.novared.net.ve:46015/CMS \n";
		String[] mailList = {mail};
		MailNotifier mn = new MailNotifier(mailList, subject, body);
		mn.send();
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
		short company = sessionUserBean.getCompany();
		Pattern email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//									     ^[_A-Za-z0-9-\ +]+(\ .[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\ .[A-Za-z0-9]+)*(\ .[A-Za-z]{2,})$
		Matcher fit = email.matcher(mail);
		if (!fit.matches())
			return navigation;
		String idUser = name.substring(0,1).toUpperCase()+lastname.substring(0,lastname.length()); //Change the first letter to uppercase
		String pass = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		userManager.addUser(company, company+"" ,"", mail, name, mail, "", level, pass);
		navigation = "successful_add";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación satisfactoria - El usuario: "+name+"!  ha sido agregado en el sistema. Ahora debe agregar contenido a este usuario"));
		//sessionUserBean.getMessages().add(0,"Operación satisfactoria - El usuario: "+name+" ha sido agregado en el sistema./n Ahora debe agregar contenido a este usuario");	    	
		//sessionUserBean.setMessageExit("");
		resetUser();
		name="";mail="";lastname="";
		VideoBean videoUserBean = (VideoBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("VideoBean");
		videoUserBean.resetUser();
		return navigation;
	}


	
	
	/**
	 * 
	 * @return
	 */
	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UserVideoBean");
		return navigation;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}

	public List<SelectItem> getLevelList() {
		return levelList;
	}

	public void setLevelList(List<SelectItem> levelList) {
		this.levelList = levelList;
	}

	public String getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public List<SelectItem> getSelectUser() {
		return selectUser;
	}


	public void setSelectUser(List<SelectItem> selectUser) {
		this.selectUser = selectUser;
	}


}