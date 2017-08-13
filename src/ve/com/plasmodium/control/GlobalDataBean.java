package ve.com.plasmodium.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ve.com.plasmodium.manager.CampaignManager;
import ve.com.plasmodium.manager.DemarcationManager;
import ve.com.plasmodium.manager.GlobalManager;
import ve.com.plasmodium.manager.HatcheryManager;
import ve.com.plasmodium.manager.InstitutionManager;
import ve.com.plasmodium.manager.LocationManager;
import ve.com.plasmodium.manager.PhenomenonManager;
import ve.com.plasmodium.manager.PlasmodiumManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.CampaignDTO;
import ve.com.plasmodium.model.vo.DemarcationDTO;
import ve.com.plasmodium.model.vo.HatcheryDTO;
import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;
import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.model.vo.LocationDTO;
import ve.com.plasmodium.model.vo.PhenomenonDTO;
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.vo.PlasmodiumTypeDTO;
import ve.com.plasmodium.util.Utils;

@ManagedBean(name="GlobalData")
@SessionScoped
public class GlobalDataBean {

	public static final Logger logger = Logger.getLogger(GlobalDataBean.class);
	private List<InstitutionTypeDTO> institutionTypeList;
	private List<InstitutionDTO> institutionList;
	private Map<String,List<InstitutionDTO>> mapInstitution_Type;
	private Map<String,String> param;
	private List<PlasmodiumTypeDTO> plasmodiumTypeList;
	private List<LethalityDTO> lethalityList;
	private List<PlasmodiumDTO> plasmodiumList;
	private Map<String,List<PlasmodiumDTO>> mapPlasmodium_Type;
	private Map<String,List<LethalityDTO>> mapLetalidad;
	private PlasmodiumTypeDTO plasmodium;
	private PlasmodiumDTO plasmodiumDetail;
	private Map<String,List<PhenomenonTypeDTO>> mapPhenomenon_Type;
	private List<PhenomenonTypeDTO> phenomenonTypeList;
	private PhenomenonTypeDTO phenomenonTypeDetail;
	private Map<String,List<PhenomenonDTO>> mapPhenomenon;
	private List<PhenomenonDTO> phenomenonList;
	private PhenomenonDTO phenomenonDetail;
	private Map<String,LocationDTO> locationList;

	private Map<String,List<HatcheryDTO>> mapHatchery_Type;
	private List<HatcheryDTO> hatcheryList;
	private HatcheryDTO hatcheryDetail;
	private Map<String,List<DemarcationDTO>> mapDemarcation_Type;
	private List<DemarcationDTO> demarcationList;
	private DemarcationDTO demarcationDetail;
	private Map<String,List<CampaignDTO>> mapCampaign_Type;
	private List<CampaignDTO> campaignList;
	private CampaignDTO campaignDetail;

	public GlobalDataBean(){
		resetInstitutionTypeList();
		resetInstitutionList();
		param = new HashMap<String,String>();
		searchParameter(param);
		resetPlasmodiumTypeList();
		resetLetalidadList();
		resetPhenomenonTypeList();
		resetPhenomenonList();
		resetCampaignList();
		resetHatcheryList();
		resetDemarcationList();
	}

	private void searchParameter(Map<String, String> param2) {
		GlobalManager gm = new GlobalManager(SQLConstant.MYSQL);
		gm.searchParameter(param);		
	}

	public List<String> completeText(String query) {
		if(locationList == null || locationList.isEmpty())
			locationList = new HashMap<String,LocationDTO>();
		List<String> results = new ArrayList<String>();
		try {
			results.addAll(Utils.geocoding("Venezuela, "+query, locationList));
			if(results.size() == 0){
				results.add("No hay coincidencia");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public void findInstitution(String selectedInstitutionType) {
		mapInstitution_Type = new HashMap<String, List<InstitutionDTO>>();
		InstitutionManager institutionManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionList = resetInstitutionList();
		institutionManager.institutionList(institutionList, selectedInstitutionType);
		mapInstitution_Type.put(selectedInstitutionType, institutionList);
		logger.debug(mapInstitution_Type);
	}

	public void findPlasmodium(String selectedPlasmodiumType) {
		mapPlasmodium_Type = new HashMap<String, List<PlasmodiumDTO>>();
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		plasmodiumList = resetPlasmodiumList();
		plasmodiumManager.plasmodiumList(plasmodiumList, selectedPlasmodiumType);
		mapPlasmodium_Type.put(selectedPlasmodiumType, plasmodiumList);
		logger.debug(mapPlasmodium_Type);
	}

	public int addPlasmodium(PlasmodiumDTO plasmodium) {
		int result = -1;
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		result = plasmodiumManager.addPlasmodium(plasmodium);
		logger.debug("Adding Plasmodium"+plasmodium + "result: "+ result);
		return result;
	}
	
	public int updatePlasmodium(PlasmodiumDTO plasmodium) {
		int result = -1;
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		result = plasmodiumManager.updatePlasmodium(plasmodium);
		logger.debug("Update Plasmodium "+plasmodium + "result: "+ result);
		return result;
	}

	public void findInstitutionType() {
		InstitutionManager institutionManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		institutionManager.getIntitutionTypeList(institutionTypeList);
	}

	public int addInstitutionType(InstitutionTypeDTO instiType) {
		int result = -1;
		InstitutionManager instiTypeManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		result = instiTypeManager.addInstitutionType(instiType);
		logger.debug("Add InstitutionType "+instiType+ " result: "+ result);
		return result;
	}

	public int changeInstitutionType(InstitutionTypeDTO instiType) {
		int result = -1;
		InstitutionManager instiTypeManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		result = instiTypeManager.changeInstitutionType(instiType);
		logger.debug("Change InstitutionType "+instiType+ " result: "+ result);
		return result;
	}

	public int addInstitution(InstitutionDTO instiType) {
		int result = -1;
		InstitutionManager instiManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		result = instiManager.addInstitution(instiType);
		logger.debug("Add InstitutionType "+instiType+ " result: "+ result);
		return result;
	}

	public int changeInstitution(InstitutionDTO instiType) {
		int result = -1;
		InstitutionManager instiManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		result = instiManager.changeInstitution(instiType);
		logger.debug("Change InstitutionType "+instiType+ " result: "+ result);
		return result;
	}

	public void findPlasmodiumType() {
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		plasmodiumTypeInit();
		plasmodiumManager.getPlasmodiumTypeList(plasmodiumTypeList);
	}

	public void findLetalidad() {
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		plasmodiumLetalidadInit();
		plasmodiumManager.getLetalidadList(lethalityList);
	}

	public void findLetalidad(String selectedLetalidad) {
		mapLetalidad = new HashMap<String, List<LethalityDTO>>();
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		lethalityList = resetLetalidadList();
		plasmodiumManager.plasmodiumList(plasmodiumList, selectedLetalidad);
		mapLetalidad.put(selectedLetalidad, lethalityList);
		logger.debug(mapLetalidad);
	}

	public void setInstitutionList(List<InstitutionDTO> institutionList) {
		this.institutionList = institutionList;
	}

	public List<InstitutionTypeDTO> getInstitutionTypeList() {
		return institutionTypeList;
	}

	public void setInstitutionTypeList(List<InstitutionTypeDTO> institutionTypeList) {
		this.institutionTypeList = institutionTypeList;
	}

	public Map<String,List<InstitutionDTO>> getMapInstitution_Type() {
		return mapInstitution_Type;
	}

	public void setMapInstitution_Type(Map<String,List<InstitutionDTO>> mapInstitution_Type) {
		this.mapInstitution_Type = mapInstitution_Type;
	}

	public Map<String,String> getParam() {
		return param;
	}

	public void setParam(Map<String,String> param) {
		this.param = param;
	}

	public List<LethalityDTO> getLethalityList() {
		return lethalityList;
	}

	public void setLethalityList(List<LethalityDTO> lethalityList) {
		this.lethalityList = lethalityList;
	}
	
	public List<PlasmodiumTypeDTO> getPlasmodiumTypeList() {
		return plasmodiumTypeList;
	}

	public void setPlasmodiumTypeList(List<PlasmodiumTypeDTO> plasmodiumTypeList) {
		this.plasmodiumTypeList = plasmodiumTypeList;
	}

	public PlasmodiumTypeDTO plasmodiumTypeInit() {
		PlasmodiumTypeDTO plasmodiumType = new PlasmodiumTypeDTO();
		return plasmodiumType;
	}
	
	public LethalityDTO plasmodiumLetalidadInit() {
		LethalityDTO letalidad = new LethalityDTO();
		return letalidad;
	}
	
	public Map<String,List<PlasmodiumDTO>> getMapPlasmodium_Type() {
		return mapPlasmodium_Type;
	}

	public void setMapPlasmodium_Type(Map<String,List<PlasmodiumDTO>> mapPlasmodium_Type) {
		this.mapPlasmodium_Type = mapPlasmodium_Type;
	}

	public Map<String,List<PhenomenonTypeDTO>> getMapPhenomenon_Type() {
		return mapPhenomenon_Type;
	}

	public void setMapPhenomenon_Type(Map<String,List<PhenomenonTypeDTO>> mapPhenomenon_Type) {
		this.mapPhenomenon_Type = mapPhenomenon_Type;
	}

	public List<PlasmodiumDTO> resetPlasmodiumList() {
		if(plasmodiumList==null){
			plasmodiumList = new ArrayList<PlasmodiumDTO>();
		}else{
			plasmodiumList.clear();
		}
		return plasmodiumList;
	}
	
	public List<LethalityDTO> resetLetalidadList() {
		if(lethalityList==null){
			lethalityList = new ArrayList<LethalityDTO>();
		}else{
			lethalityList.clear();
		}
		return lethalityList;
	}

	public List<PlasmodiumTypeDTO> resetPlasmodiumTypeList() {
		if(plasmodiumTypeList==null){
			plasmodiumTypeList = new ArrayList<PlasmodiumTypeDTO>();
		}else{
			plasmodiumTypeList.clear();
		}
		return plasmodiumTypeList;
	}
	
	public List<PlasmodiumDTO> getPlasmodiumList() {
		return plasmodiumList;
	}

	public void setPlasmodiumList(List<PlasmodiumDTO> plasmodiumList) {
		this.plasmodiumList = plasmodiumList;
	}

	public Map<String, List<LethalityDTO>> getMapLetalidad() {
		return mapLetalidad;
	}

	public void setMapLetalidad(Map<String, List<LethalityDTO>> mapLetalidad) {
		this.mapLetalidad = mapLetalidad;
	}

	public PlasmodiumTypeDTO getPlasmodium() {
		return plasmodium;
	}
	
	public PlasmodiumDTO getPlasmodiumDetail() {
		return plasmodiumDetail;
	}

	public void setPlasmodiumDetail(PlasmodiumDTO plasmodiumDetail) {
		this.plasmodiumDetail = plasmodiumDetail;
	}

	public void setPlasmodium(PlasmodiumTypeDTO plasmodium) {
		this.plasmodium = plasmodium;
	}

	public void findDetailPlasmodium(String selectedPlasmodiumType) {
		PlasmodiumManager plasmodiumManager = new PlasmodiumManager(SQLConstant.MYSQL);
		plasmodiumDetail = plasmodiumManager.plasmodiumDetail(selectedPlasmodiumType);
	}

	public void findDetailPhenomenonType(String selectedPhenomenonType) {
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		phenomenonTypeDetail = phenomenonManager.phenomenonTypeDetail(selectedPhenomenonType);
	}

	public void findPhenomenonType(){
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		phenomenonTypeInit();
		resetPhenomenonTypeList();
		phenomenonManager.getPhenomenonTypeList(phenomenonTypeList);
	}

	public int addPhenomenonType(PhenomenonTypeDTO phenomenonType) {
		int result = -1;
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		result = phenomenonManager.addPhenomenonType(phenomenonType);
		logger.debug("Adding Phenomenon Type "+phenomenonType + "result: "+ result);
		return result;
	}

	public int updatePhenomenonType(PhenomenonTypeDTO phenomenonType, String selectPhenomenonType) {
		int result = -1;
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		result = phenomenonManager.updatePhenomenonType(phenomenonType,selectPhenomenonType);
		logger.debug("Adding Phenomenon Type "+phenomenonType + "result: "+ result);
		return result;
	}

	public int addPhenomenon(PhenomenonDTO phenomenon) {
		int result = -1;
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		result = phenomenonManager.addPhenomenon(phenomenon);
		logger.debug("Adding Phenomenon "+phenomenon + "result: "+ result);
		return result;
	}

	public int updatePhenomenon(PhenomenonDTO phenomenon) {
		int result = -1;
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		result = phenomenonManager.updatePhenomenon(phenomenon);
		logger.debug("Adding Phenomenon "+phenomenon + "result: "+ result);
		return result;
	}

	public void findDetailPhenomenon(String selectedPhenomenon) {
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		phenomenonDetail = phenomenonManager.phenomenonDetail(selectedPhenomenon);
	}

	public void findPhenomenon(){
		PhenomenonManager phenomenonManager = new PhenomenonManager(SQLConstant.MYSQL);
		phenomenonInit();
		phenomenonManager.getPhenomenonList(phenomenonList);
	}

	public List<PhenomenonTypeDTO> resetPhenomenonTypeList() {
		if(phenomenonTypeList==null){
			phenomenonTypeList = new ArrayList<PhenomenonTypeDTO>();
		}else{
			phenomenonTypeList.clear();
		}
		return phenomenonTypeList;
	}

	public List<PhenomenonDTO> resetPhenomenonList() {
		if(phenomenonList==null){
			phenomenonList = new ArrayList<PhenomenonDTO>();
		}else{
			phenomenonList.clear();
		}
		return phenomenonList;
	}

	public List<HatcheryDTO> resetHatcheryList() {
		if(hatcheryList==null){
			hatcheryList = new ArrayList<HatcheryDTO>();
		}else{
			hatcheryList.clear();
		}
		return hatcheryList;
	}
	
	public int addHatchery(HatcheryDTO hatchery) {
		int result = -1;
		HatcheryManager hatcheryManager = new HatcheryManager(SQLConstant.MYSQL);
		result = hatcheryManager.addHatchery(hatchery);
		logger.debug("Adding hatchery "+ hatchery + "result: "+ result);
		return result;
	}

	public int updateHatchery(HatcheryDTO hatchery) {
		int result = -1;
		HatcheryManager hatcheryManager = new HatcheryManager(SQLConstant.MYSQL);
		result = hatcheryManager.updateHatchery(hatchery);
		logger.debug("Adding Hatchery "+ hatchery + "result: "+ result);
		return result;
	}

	public void findDetailHatchery(String selectedHatchery) {
		HatcheryManager hatcheryManager = new HatcheryManager(SQLConstant.MYSQL);
		hatcheryDetail = hatcheryManager.hatcheryDetail(selectedHatchery);
	}

	public List<DemarcationDTO> resetDemarcationList() {
		if(demarcationList==null){
			demarcationList = new ArrayList<DemarcationDTO>();
		}else{
			demarcationList.clear();
		}
		return demarcationList;
	}

	public int addDemarcation(DemarcationDTO demarcation) {
		int result = -1;
		DemarcationManager demarcationManager = new DemarcationManager(SQLConstant.MYSQL);
		result = demarcationManager.addDemarcation(demarcation);
		logger.debug("Adding demarcation "+ demarcation + "result: "+ result);
		return result;
	}

	public int updateDemarcation(DemarcationDTO demarcation) {
		int result = -1;
		DemarcationManager demarcationManager = new DemarcationManager(SQLConstant.MYSQL);
		result = demarcationManager.updateDemarcation(demarcation);
		logger.debug("Adding demarcation "+ demarcation + "result: "+ result);
		return result;
	}

	public void findDetailDemarcation(String selectedDemarcation) {
		DemarcationManager demarcationManager = new DemarcationManager(SQLConstant.MYSQL);
		demarcationDetail = demarcationManager.demarcationDetail(selectedDemarcation);
	}

	public List<CampaignDTO> resetCampaignList() {
		if(campaignList==null){
			campaignList = new ArrayList<CampaignDTO>();
		}else{
			campaignList.clear();
		}
		return campaignList;
	}

	public int addCampaign(CampaignDTO campaign) {
		int result = -1;
		CampaignManager campaignManager = new CampaignManager(SQLConstant.MYSQL);
		result = campaignManager.addCampaign(campaign);
		logger.debug("Adding campaign "+ campaign + "result: "+ result);
		return result;
	}

	public int updateCampaign(CampaignDTO campaign) {
		int result = -1;
		CampaignManager campaignManager = new CampaignManager(SQLConstant.MYSQL);
		result = campaignManager.updateCampaign(campaign);
		logger.debug("Adding campaign "+ campaign + "result: "+ result);
		return result;
	}

	public void findDetailCampaign(String selectedCampaign) {
		CampaignManager campaignManager = new CampaignManager(SQLConstant.MYSQL);
		campaignDetail = campaignManager.campaignDetail(selectedCampaign);
	}

	public void findHatchery(){
		HatcheryManager hatcheryManager = new HatcheryManager(SQLConstant.MYSQL);
		hatcheryInit();
		resetHatcheryList();
		hatcheryManager.getHatcheryList(hatcheryList);
	}

	public void findDemarcation(){
		DemarcationManager demarcationManager = new DemarcationManager(SQLConstant.MYSQL);
		demarcationInit();
		resetDemarcationList();
		demarcationManager.getDemarcationList(demarcationList);
	}

	public void findCampaign(){
		CampaignManager campaignManager = new CampaignManager(SQLConstant.MYSQL);
		campaignInit();
		resetCampaignList();
		campaignManager.getCampaignList(campaignList);
	}

	public List<PhenomenonTypeDTO> getPhenomenonTypeList() {
		return phenomenonTypeList;
	}

	public void setPhenomenonList(List<PhenomenonDTO> phenomenonList) {
		this.phenomenonList = phenomenonList;
	}

	public List<PhenomenonDTO> getPhenomenonList() {
		return phenomenonList;
	}

	public void setPhenomenonTypeList(List<PhenomenonTypeDTO> phenomenonTypeList) {
		this.phenomenonTypeList = phenomenonTypeList;
	}

	public PhenomenonTypeDTO phenomenonTypeInit() {
		PhenomenonTypeDTO institutionType = new PhenomenonTypeDTO();
		return institutionType;
	}

	public void setPhenomenonTypeDetail(PhenomenonTypeDTO phenomenonTypeDetail){
		this.phenomenonTypeDetail = phenomenonTypeDetail;
	}

	public PhenomenonTypeDTO getPhenomenonTypeDetail(){
		return this.phenomenonTypeDetail;
	}
	
	public List<InstitutionTypeDTO> resetInstitutionTypeList() {
		if(institutionTypeList==null){
			institutionTypeList = new ArrayList<InstitutionTypeDTO>();
		}else{
			institutionTypeList.clear();
		}
		return institutionTypeList;
	}

	public List<InstitutionDTO> resetInstitutionList() {
		if(institutionList==null){
			institutionList = new ArrayList<InstitutionDTO>();
		}else{
			institutionList.clear();
		}
		return institutionList;
	}

	public InstitutionDTO institutionInit(){
		InstitutionDTO institution = new InstitutionDTO();
		institution.setInstitutionType(institutionTypeInit());
		institution.setLocation(locationInit());
		return institution;
	}
	

	public void getLocationDetail(String placeId, String txt1) {
		LocationManager locationManager = new LocationManager(SQLConstant.MYSQL);
		locationManager.getLocationDetail(placeId, txt1);
		
	}

	public InstitutionTypeDTO institutionTypeInit() {
		InstitutionTypeDTO institutionType = new InstitutionTypeDTO();
		return institutionType;
	}
	
	public DemarcationDTO demarcationInit() {
		DemarcationDTO demarcation = new DemarcationDTO();
		return demarcation;
	}

	public HatcheryDTO hatcheryInit() {
		HatcheryDTO hatchery = new HatcheryDTO();
		return hatchery;
	}

	public CampaignDTO campaignInit() {
		CampaignDTO campaign = new CampaignDTO();
		return campaign;
	}

	public LocationDTO locationInit() {
		LocationDTO location = new LocationDTO();
		return location;
	}

	public List<InstitutionDTO> getInstitutionList() {
		return institutionList;
	}

	public void setPhenomenonDetail(PhenomenonDTO phenomenonDetail){
		this.phenomenonDetail = phenomenonDetail;
	}

	public PhenomenonDTO getPhenomenonDetail(){
		return this.phenomenonDetail;
	}

	public PhenomenonDTO phenomenonInit() {
		PhenomenonDTO phenomenon = new PhenomenonDTO();
		return phenomenon;
	}

	public Map<String,List<PhenomenonDTO>> getMapPhenomenon() {
		return mapPhenomenon;
	}

	public void setMapPhenomenon(Map<String,List<PhenomenonDTO>> mapPhenomenon) {
		this.mapPhenomenon = mapPhenomenon;
	}

	public List<HatcheryDTO> getHatcheryList() {
		return hatcheryList;
	}

	public void setHatcheryList(List<HatcheryDTO> hatcheryList) {
		this.hatcheryList = hatcheryList;
	}

	public HatcheryDTO getHatcheryDetail() {
		return hatcheryDetail;
	}

	public void setHatcheryDetail(HatcheryDTO hatcheryDetail) {
		this.hatcheryDetail = hatcheryDetail;
	}

	public List<DemarcationDTO> getDemarcationList() {
		return demarcationList;
	}

	public void setDemarcationList(List<DemarcationDTO> demarcationList) {
		this.demarcationList = demarcationList;
	}

	public DemarcationDTO getDemarcationDetail() {
		return demarcationDetail;
	}

	public void setDemarcationDetail(DemarcationDTO demarcationDetail) {
		this.demarcationDetail = demarcationDetail;
	}

	public List<CampaignDTO> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<CampaignDTO> campaignList) {
		this.campaignList = campaignList;
	}

	public CampaignDTO getCampaignDetail() {
		return campaignDetail;
	}

	public void setCampaignDetail(CampaignDTO campaignDetail) {
		this.campaignDetail = campaignDetail;
	}

	public Map<String, List<HatcheryDTO>> getMapHatchery_Type() {
		return mapHatchery_Type;
	}

	public void setMapHatchery_Type(Map<String, List<HatcheryDTO>> mapHatchery_Type) {
		this.mapHatchery_Type = mapHatchery_Type;
	}

	public Map<String, List<DemarcationDTO>> getMapDemarcation_Type() {
		return mapDemarcation_Type;
	}

	public void setMapDemarcation_Type(Map<String, List<DemarcationDTO>> mapDemarcation_Type) {
		this.mapDemarcation_Type = mapDemarcation_Type;
	}

	public Map<String, List<CampaignDTO>> getMapCampaign_Type() {
		return mapCampaign_Type;
	}

	public void setMapCampaign_Type(Map<String, List<CampaignDTO>> mapCampaign_Type) {
		this.mapCampaign_Type = mapCampaign_Type;
	}

	public Map<String,LocationDTO> getLocationList() {
		return locationList;
	}

	public void setLocationList(Map<String,LocationDTO> locationList) {
		this.locationList = locationList;
	}

}