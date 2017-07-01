package ve.com.plasmodium.model.dao;

import org.apache.log4j.Logger;

import java.util.List;

import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.vo.PlasmodiumTypeDTO;

public interface PlasmodiumDAO {

	public static final Logger logger = Logger.getLogger(PlasmodiumDAO.class);

	public PlasmodiumDTO plasmodiumDetail(String plasmodium);

	public void plasmodiumList(List<PlasmodiumDTO> plasmodium, String selectedPlasmodiumType);

	public void getPlasmodiumTypeList(List<PlasmodiumTypeDTO> plasmodiumTypeList); 
	
	public int addPlasmodiumType(PlasmodiumTypeDTO plasmodiumType);
	
	public int addPlasmodium(PlasmodiumDTO plasmodium);
	
	public int updatePlasmodium(PlasmodiumDTO plasmodium);
	
	public void getLetalidadList(List<LethalityDTO> letalidadList);

}