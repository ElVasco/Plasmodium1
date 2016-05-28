package ve.com.plasmodium.managed;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import ve.com.plasmodium.control.UserBean;
import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.manager.VideoManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.UserVo;
import ve.com.plasmodium.util.MailNotifier;


@ManagedBean(name="VideoBean")
@SessionScoped
public class VideoBean {

	public static final Logger logger = Logger.getLogger(VideoBean.class);

	private List<SelectItem> videos;
	private List<SelectItem> videosComp;
	private List<SelectItem> selectUser;

	private DualListModel<String> videosEdit;

	private String selectedWarehouse;
	private String selectedUser;
	private String selectedVideo="";	
	private String video;

	private boolean showVideo=false;
	private boolean showMenu=false;
	private boolean showListVideo=false;
	private String htmlInput;
 
	public VideoBean() {
		logger.debug("entro a constructor VideoBean");
		selectedVideo = null;
		showMenu=false;
		setShowMenu(false);
		resetUser();
		resetVideos();
		resetVideosEdit();
		if(videos.size()>0)
			setShowMenu(true);
	}

	
	public void closeVideoMethod(){
		logger.debug("entro al closeVideoMethod");
		setShowVideo(false);
		FacesContext.getCurrentInstance().renderResponse();
	}
	/**
	 * 	
	 * @param e
	 */
	public void selectedVideoMethod(){
		logger.debug("entro al selectedVideoMethod");
		setShowVideo(false);
		for(int i = 0; i<videos.size(); i++){
			if(videos.get(i).getValue().equals(selectedVideo)){
				setVideo(videos.get(i).getDescription());
				setHtmlInput("<video width=\"500\" height=\"375\" controls><source src=\""+video+".mp4\" type=\"video/mp4\"><source src=\""+video+".webm\" type=\"video/WebM\">  Your browser does not support the video tag.</video>");
			}
		}
		setShowVideo(true);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void userListenerMethod(){
		logger.debug("entro al userListenerMethod");    
		int user = Integer.parseInt(selectedUser);
		VideoManager videoManager = new VideoManager(SQLConstant.MYSQL);
		resetVideosEdit(user, videoManager);
		FacesContext.getCurrentInstance().renderResponse();
	}
	/**
	 * 
	 * @return
	 */
	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación Finalizada - Asignación de tarjetas NO se han actualizado en el sistema."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("AsignarRutaBean");
		return navigation;
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

	public void update(){	    
		int user = Integer.parseInt(selectedUser);
		UserVo userVo = null;
		VideoManager videoManager = new VideoManager(SQLConstant.MYSQL);
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		if(videoManager.updateUserVideos(user,videosEdit.getTarget()))
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación finalizada con exito"));
		resetVideosEdit(user, videoManager);
		if(videos.size()>0)
			setShowMenu(true);
		String pass =randomString(8);
		boolean nuevo = false;
		try {
			userVo = userManager.datosUsuario(user);
			if(userVo.getPassword().equals("b9b3cc3f3a30d8ef2bb1e2e267ed97de")){
				userManager.updatePass(userVo.getLogin(), pass);
				nuevo=true;
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mailNotify(userVo.getName(),userVo.getLogin(),pass, userVo.getEmail(), nuevo);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("VideosBean");
	}

	
	static final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	String randomString( int len ){
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	
	public void resetVideos(){
		if(videos==null){
			videos = new  ArrayList<SelectItem>();
		} else {
			videos.clear();
		}
		videos =  new ArrayList<SelectItem>();
		if(videosComp==null){
			videosComp = new  ArrayList<SelectItem>();
		} else {
			videosComp.clear();
		}
		videosComp =  new ArrayList<SelectItem>();
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");	    
		int user = sessionUserBean.getUser();
		short company = sessionUserBean.getCompany();
		VideoManager videoManager = new VideoManager(SQLConstant.MYSQL);
		try {
			videos = videoManager.videoList(user);
			showListVideo=0<videos.size();
			videosComp = videoManager.videoListComp(company);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void resetVideosEdit(){
		List<String> videoCompany = new ArrayList<String>();
		videoCompany.clear();
		videoCompany =  new ArrayList<String>();
		List<String> videoUser = new ArrayList<String>();
		videoUser.clear();
		videoUser =  new ArrayList<String>();

		for(int i = 0; i<videosComp.size(); i++){
			if(!validation(videosComp.get(i),videos))
				videoCompany.add(videosComp.get(i).getLabel());
		}
		for(int i = 0; i<videos.size(); i++){
			videoUser.add(videos.get(i).getLabel());
		}
		videosEdit = new DualListModel<String>(videoCompany, videoUser);
	}

	public void resetVideosEdit(int user, VideoManager videoManager){
		List<String> videoCompany = new ArrayList<String>();
		videoCompany.clear();
		videoCompany =  new ArrayList<String>();
		List<String> videoUser = new ArrayList<String>();
		videoUser.clear();
		videoUser =  new ArrayList<String>();
		try {
			videos.clear();
			videos =  new ArrayList<SelectItem>();
			videos = videoManager.videoList(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<videosComp.size(); i++){
			if(!validation(videosComp.get(i),videos))
				videoCompany.add(videosComp.get(i).getLabel());
		}
		for(int i = 0; i<videos.size(); i++){
			videoUser.add(videos.get(i).getLabel());
		}
		videosEdit = new DualListModel<String>(videoCompany, videoUser);
		for(int i = 0; i<videosEdit.getSource().size(); i++)
		logger.debug(videosEdit.getSource().get(i));
		for(int i = 0; i<videosEdit.getTarget().size(); i++)
			logger.debug(videosEdit.getTarget());
	}

	private static boolean validation(SelectItem my, List<SelectItem> myList) {  
		Iterator<SelectItem> it = myList.iterator();  
		while (it.hasNext()) {  
			SelectItem meHere = it.next();  
			if (my.getValue().equals(meHere.getValue())) // calling overrides equals method  
				return true;  
		}
		return false;  
	}  
	
	private void mailNotify(String name, String login, String pass,String mail, boolean nuevo) {
		String subject = nuevo?"Registro de usuario CMS":"Actualizacion de lista de contenido";
		String body = "Estimado "+name+",\n\n";
		body += nuevo?"Su usuario en el sistema CMS ha sido creado con exito.\n":"Su lista de contenido para ver en el sistema CMS ha sido actualizada.\n";
		body += nuevo?"Ususario: "+login+"\n":"";
		body += nuevo?"Clave: "+pass+"\n":"";
		body +="Pagina de acceso: https://devsco1.novared.net.ve:46015/CMS \n";
		String[] mailList = {mail};
		MailNotifier mn = new MailNotifier(mailList, subject, body);
		mn.send();
	}


	public String getSelectedWarehouse() {
		return selectedWarehouse;
	}
	public void setSelectedWarehouse(String selectedWarehouse) {
		this.selectedWarehouse = selectedWarehouse;
	}
	public String getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getSelectedVideo() {
		return selectedVideo;
	}

	public void setSelectedVideo(String selectedVideo) {
		this.selectedVideo = selectedVideo;
	}

	public boolean isShowVideo() {
		return showVideo;
	}

	public void setShowVideo(boolean showVideo) {
		this.showVideo = showVideo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<SelectItem> getVideos() {
		return videos;
	}

	public void setVideos(List<SelectItem> videos) {
		this.videos = videos;
	}

	public DualListModel<String> getVideosEdit() {
		return videosEdit;
	}

	public void setVideosEdit(DualListModel<String> videosEdit) {
		this.videosEdit = videosEdit;
	}

	public List<SelectItem> getVideosComp() {
		return videosComp;
	}

	public void setVideosComp(List<SelectItem> videosComp) {
		this.videosComp = videosComp;
	}


	public List<SelectItem> getSelectUser() {
		return selectUser;
	}


	public void setSelectUser(List<SelectItem> selectUser) {
		this.selectUser = selectUser;
	}


	public boolean isShowMenu() {
		return showMenu;
	}


	public void setShowMenu(boolean showMenu) {
		this.showMenu = showMenu;
	}


	public boolean isShowListVideo() {
		return showListVideo;
	}


	public void setShowListVideo(boolean showListVideo) {
		this.showListVideo = showListVideo;
	}


	public String getHtmlInput() {
		return htmlInput;
	}


	public void setHtmlInput(String htmlInput) {
		this.htmlInput = htmlInput;
	}


}