package ve.com.plasmodium.model.dao;

import java.util.List;
import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.PhenomenonDTO;
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;

public interface PhenomenonDAO {

	public static final Logger logger = Logger.getLogger(PhenomenonDAO.class);

	public void getPhenomenonTypeList(List<PhenomenonTypeDTO> phenomenonTypeList);

	public PhenomenonTypeDTO phenomenonTypeDetail(String phenomenon);

	public int addPhenomenonType(PhenomenonTypeDTO phenomenonType);

	public int updatePhenomenonType(PhenomenonTypeDTO phenomenonType, String selectedPhenomenonType);

	public void getPhenomenonList(List<PhenomenonDTO> phenomenonList);

	public PhenomenonDTO phenomenonDetail(String phenomenon);

	public int addPhenomenon(PhenomenonDTO phenomenon);

	public int updatePhenomenon(PhenomenonDTO phenomenonType);

}