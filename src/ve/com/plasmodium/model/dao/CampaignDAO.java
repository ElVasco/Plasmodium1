package ve.com.plasmodium.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.CampaignDTO;


public interface CampaignDAO {

	public static final Logger logger = Logger.getLogger(CampaignDAO.class);

	public void getCampaignList(List<CampaignDTO> campaignList);

	public CampaignDTO campaignDetail(String campaign);

	public int addCampaign(CampaignDTO campaign);

	public int updateCampaign(CampaignDTO campaign);

}
