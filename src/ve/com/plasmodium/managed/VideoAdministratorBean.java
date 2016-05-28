package ve.com.plasmodium.managed;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import ve.com.plasmodium.control.UserBean;
import ve.com.plasmodium.manager.VideoManager;
import ve.com.plasmodium.model.dao.SQLConstant;


@ManagedBean(name="VideoAdministratorBean")
@SessionScoped
public class VideoAdministratorBean {

	public static final Logger logger = Logger.getLogger(VideoAdministratorBean.class);

	private List<SelectItem> videos;
	private List<SelectItem> videosComp;
	private List<SelectItem> selectUser;

	private DualListModel<String> videosEdit;

	private String selectedWarehouse;
	private String selectedUser;
	private String selectedVideo="";	
	private String video;

	private boolean showVideo=false;

	public VideoAdministratorBean() {
		logger.debug("entro a constructor VideoBean");
		selectedVideo = null;
		resetUser();
		resetVideos();
		resetVideosEdit();

	}


	/**
	 * 	
	 * @param e
	 */
	public void selectedVideoMethod(){
		logger.debug("entro al selectedVideoMethod");
		setShowVideo(false);
		setVideo(videos.get(Integer.parseInt(selectedVideo)-1).getDescription());	
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
		UserBean sessionUserBean = (UserBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("UserBean");	    
		int user = sessionUserBean.getUser();
		VideoManager videoManager = new VideoManager(SQLConstant.MYSQL);
		if(videoManager.updateUserVideos(user,videosEdit.getTarget()))
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación finalizada con exito"));
		setSelectedUser(user+"");

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


}