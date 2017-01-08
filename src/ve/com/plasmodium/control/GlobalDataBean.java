package ve.com.plasmodium.control;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ve.com.plasmodium.manager.GlobalManager;
import ve.com.plasmodium.manager.InstitutionManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;
import ve.com.plasmodium.model.vo.LocationDTO;


@ManagedBean(name="GlobalData")
@SessionScoped
public class GlobalDataBean {

	public static final Logger logger = Logger.getLogger(GlobalDataBean.class);
	private List<InstitutionTypeDTO> institutionTypeList;
	private List<InstitutionDTO> institutionList;
	private Map<String,List<InstitutionDTO>> mapInstitution_Type;
	private Map<String,String> param;


	public GlobalDataBean(){
		resetInstitutionTypeList();
		resetInstitutionList();
		param = new HashMap<String,String>();
		searchParameter(param);
	}

	private void searchParameter(Map<String, String> param2) {
		GlobalManager gm = new GlobalManager(SQLConstant.MYSQL);
		gm.searchParameter(param);
		
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

	public InstitutionDTO institutionInit() {
		InstitutionDTO institution = new InstitutionDTO();
		institution.setInstitutionType(institutionTypeInit());
		institution.setLocation(locationInit());
		return institution;
	}

	public InstitutionTypeDTO institutionTypeInit() {
		InstitutionTypeDTO institutionType = new InstitutionTypeDTO();
		return institutionType;
	}
	

	public LocationDTO locationInit() {
		LocationDTO location = new LocationDTO();
		return location;
	}

	public List<InstitutionDTO> getInstitutionList() {
		return institutionList;
	}

	public void findInstitution(String selectedInstitutionType) {
		mapInstitution_Type = new HashMap<String, List<InstitutionDTO>>();
		InstitutionManager institutionManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionList = resetInstitutionList();
		institutionManager.institutionList(institutionList, selectedInstitutionType);
		mapInstitution_Type.put(selectedInstitutionType, institutionList);
		logger.debug(mapInstitution_Type);
	}
	
	public void findInstitutionType() {
		InstitutionManager institutionManager = new InstitutionManager(SQLConstant.MYSQL);
		institutionTypeInit();
		institutionManager.getIntitutionTypeList(institutionTypeList);
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

}