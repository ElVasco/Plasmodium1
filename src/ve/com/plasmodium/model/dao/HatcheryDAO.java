package ve.com.plasmodium.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.HatcheryDTO;

public interface HatcheryDAO {

	public static final Logger logger = Logger.getLogger(HatcheryDAO.class);

	public int addHatchery(HatcheryDTO hatchery);
	
	public int updateHatchery(HatcheryDTO hatchery);
	
	public HatcheryDTO hatcheryDetail(String hatchery);

	public void getHatcheryList(List<HatcheryDTO> hatchery);

}
