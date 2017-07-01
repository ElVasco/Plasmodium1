package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.CampaignDAO;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.vo.CampaignDTO;


public class CampaignManager {

	public static final Logger logger = Logger.getLogger(CampaignManager.class);

    final CampaignDAO campaignDAO;

	public CampaignManager(short aFactoryNumber){
    	this.campaignDAO = DAOFactory.getDAOFactory(aFactoryNumber).getCampaignDAO();
    }

	public void getCampaignList(List<CampaignDTO> campaignList){
		try {
	    	campaignDAO.getCampaignList(campaignList);
		} catch (Exception e) {
			logger.error("Exception campaignManager - campaignList NOT FOUND", e);
		}
	}

	public CampaignDTO campaignDetail(String campaign) {
		try {
	    	return campaignDAO.campaignDetail(campaign);
		} catch (Exception e) {
			 logger.error("Exception campaignManager - campaginDetail NOT FOUND", e);
			 return null;
		}
	}
	
	public int addCampaign(CampaignDTO campaign) {
	   	try{
    		return campaignDAO.addCampaign(campaign);
    	}catch (Exception e){
    		logger.error("Exception campaignManager - AddCampaign ", e);
    		return -1;
    	}
	}

	public int updateCampaign(CampaignDTO campaign) {
	   	try{
    		return campaignDAO.updateCampaign(campaign);
    	}catch (Exception e){
    		logger.error("Exception campaignManager - UpdateCampaign ", e);
    		return -1;
    	}
	}
}
