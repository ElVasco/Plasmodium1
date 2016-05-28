package ve.com.plasmodium.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.VideoDAO;

import javax.faces.model.SelectItem;

public class VideoManager {

    public static final Logger logger = Logger.getLogger(VideoManager.class);
    final VideoDAO videoDAO;

    public VideoManager(short aFactoryNumber){
    	this.videoDAO = DAOFactory.getDAOFactory(aFactoryNumber).getVideoDAO();
    }
	
	public List<SelectItem> videoList(int user) throws IOException, ParseException{
		List<SelectItem> videos =  videoDAO.videoList(user);
		return videos;
	}

	public List<SelectItem> videoListComp(short company) {
		List<SelectItem> videos = videoDAO.videoListComp(company);
		return videos;
	}

	public List<SelectItem> userList(short company) {
		List<SelectItem> user = videoDAO.userList(company);
		return user;
	}

	public boolean updateUserVideos(int user, List<String> list) {
		boolean result = videoDAO.updateUserVideos(user, list);
		return result;
	}


}
