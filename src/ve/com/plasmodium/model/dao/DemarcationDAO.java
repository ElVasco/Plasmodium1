package ve.com.plasmodium.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.DemarcationDTO;

public interface DemarcationDAO {
	
	public static final Logger logger = Logger.getLogger(DemarcationDAO.class);

	public void getDemarcationList(List<DemarcationDTO> demarcationList);

	public DemarcationDTO demarcationDetail(String demarcation);

	public int addDemarcation(DemarcationDTO demarcation);

	public int updateDemarcation(DemarcationDTO demarcation);

}