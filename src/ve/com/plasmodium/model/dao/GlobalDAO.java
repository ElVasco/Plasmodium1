package ve.com.plasmodium.model.dao;

import java.util.Map;

import org.apache.log4j.Logger;


public interface GlobalDAO {
	
    public static final Logger logger = Logger.getLogger(GlobalDAO.class);

	public void searchParameter(Map<String, String> maps);

}
