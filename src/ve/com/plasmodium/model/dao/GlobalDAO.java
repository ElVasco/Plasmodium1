package ve.com.plasmodium.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.LethalityDTO;


public interface GlobalDAO {
	
    public static final Logger logger = Logger.getLogger(GlobalDAO.class);

	public void searchParameter(Map<String, String> maps);

	public void searchLethality(List<LethalityDTO> lethalityList);

}
