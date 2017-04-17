package ve.com.plasmodium.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;



import ve.com.plasmodium.model.dao.SQLConstant;


@ManagedBean(name="GlobalRegisterData")
@SessionScoped
public class GlobalRegisterDataBean {

	public static final Logger logger = Logger.getLogger(GlobalRegisterDataBean.class);

	private List<SelectItem> selectState = new ArrayList<SelectItem>();
	private List<SelectItem> selectCity = new ArrayList<SelectItem>();
	private List<SelectItem> selectMunicipality = new ArrayList<SelectItem>();
	private List<SelectItem> selectIndustry = new ArrayList<SelectItem>();
	private String stateId;
	private String cityId;
	private String municipalityId;
	private String industryId;


	public GlobalRegisterDataBean(){
		//resetCity();
		logger.debug("Entro en el constructor del GlobalRegisterDataBean");

		logger.debug("busco los estados");
		logger.debug("busco las ciudades");
		//selectCity = buscarCity();
		resetCity();
		logger.debug("busco los municipios");
		resetMunicipality();

		logger.debug("busco las Industrias");
	}




	
	public void resetState (){
		if(selectState.size()==0){	
			selectState.add(new SelectItem("9999","Seleccione un Estado"));
		}else{
			selectState.clear();
			selectState.add(new SelectItem("9999","Seleccione un Estado"));
		}
	}

	public void resetCity (){
		if(selectCity.size()==0){	
			selectCity.add(new SelectItem("9999","Seleccione una Ciudad"));
		}else{
			selectCity.clear();
			selectCity.add(new SelectItem("9999","Seleccione una Ciudad"));
		}
	}

	public void resetMunicipality (){
		logger.debug("voy a resetear muni");
		if(selectMunicipality.size()==0){	
			selectMunicipality.add(new SelectItem("9999","Seleccione un Municipio"));
		}else{
			selectMunicipality.clear();
			selectMunicipality.add(new SelectItem("9999","Seleccione un Municipio"));
		}
	}

	//Busca las ciudades segun ruta
	
	//Busca los Municipios


	//Busca las industrias



	public void setSelectState(List<SelectItem> selectState) {
		this.selectState = selectState;
	}

	public List<SelectItem> getSelectState() {
		return selectState;
	}

	public List<SelectItem> getSelectCity() {
		return selectCity;
	}	
	public void setSelectCity(List<SelectItem> selectCity) {
		this.selectCity = selectCity;
	}

	public List<SelectItem> getSelectMunicipality() {
		return selectMunicipality;
	}	
	public void setSelectMunicipality(List<SelectItem> selectMunicipality) {
		this.selectMunicipality = selectMunicipality;
	}

	public void setSelectIndustry(List<SelectItem> selectIndustry) {
		this.selectIndustry = selectIndustry;
	}
	public List<SelectItem> getSelectIndustry() {
		return selectIndustry;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setMunicipalityId(String municipalityId) {
		this.municipalityId = municipalityId;
	}
	public String getMunicipalityId() {
		return municipalityId;
	}
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	public String getIndustryId() {
		return industryId;
	}

}