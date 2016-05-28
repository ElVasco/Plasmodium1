package ve.com.plasmodium.model.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

public interface VideoDAO {
    public static final Logger logger = Logger.getLogger(VideoDAO.class);

	public List<SelectItem> videoList(int user);

	public List<SelectItem> videoListComp(short company);

	public List<SelectItem> userList(short company);

	public boolean updateUserVideos(int user, List<String> list);
}
