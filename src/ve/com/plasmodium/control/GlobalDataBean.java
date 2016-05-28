package ve.com.plasmodium.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;



import ve.com.plasmodium.model.dao.SQLConstant;


@ManagedBean(name="GlobalData")
@SessionScoped
public class GlobalDataBean {

	public static final Logger logger = Logger.getLogger(GlobalDataBean.class);

	public GlobalDataBean(){
		resetCity();
		setSelectPromotions(buscarPromociones());

		resetCity();
		resetMunicipality();

		resetClientList();
		resetRifList();
		resetDeposit();

	}



	// Used for the GUI
	private List<SelectItem> selectPromotions = new ArrayList<SelectItem>();
	private List<SelectItem> selectRutas = new ArrayList<SelectItem>();
	private List<SelectItem> selectState = new ArrayList<SelectItem>();
	private List<SelectItem> selectStateC = new ArrayList<SelectItem>();
	private List<SelectItem> selectCity = new ArrayList<SelectItem>();
	private List<SelectItem> selectCityC = new ArrayList<SelectItem>();
	private List<SelectItem> selectMunicipality = new ArrayList<SelectItem>();
	private List<SelectItem> selectMunicipalityC = new ArrayList<SelectItem>();
	private List<SelectItem> selectIndustry = new ArrayList<SelectItem>();
	private List<SelectItem> selectIndustryC = new ArrayList<SelectItem>();
	private List<SelectItem> selectDistribuidores = new ArrayList<SelectItem>();
	private List<SelectItem> selectPacking = new ArrayList<SelectItem>();
	private List<SelectItem> selectBanks = new ArrayList<SelectItem>();
	private List<SelectItem> selectClient = new ArrayList<SelectItem>();
	private List<SelectItem> selectRif = new ArrayList<SelectItem>();
	private List<SelectItem> selectDeposit = new ArrayList<SelectItem>();
	private List<SelectItem> selectManufacturer = new ArrayList<SelectItem>();
	private List<SelectItem> selectSellerCompanies = new ArrayList<SelectItem>();
	private String stateId;
	private String cityId;
	private String routeId;
	private String municipalityId;
	private String industryId;
	private String clientId;
	private String routeName;

	public void resetRifList(){
		SelectItem si;
		si = new SelectItem("9999","Seleccione un Cliente");
		if(selectRif==null){
			selectRif  =  new ArrayList<SelectItem>();
		}else{
			selectRif.clear();
		}
		selectRif.add(si);
	}
	public void setSelectRif(List<SelectItem> selectRif) {
		this.selectRif = selectRif;
	}

	public List<SelectItem> getSelectRif() {
		return selectRif;
	}
	public void resetClientList(){
		SelectItem si;
		si = new SelectItem("9999","Seleccione un Cliente");
		if(selectClient==null){
			selectClient  =  new ArrayList<SelectItem>();
		}else{
			selectClient.clear();
		}
		selectClient.add(si);
	}
	public void setSelectClient(List<SelectItem> selectClient) {
		this.selectClient = selectClient;
	}

	public List<SelectItem> getSelectClient() {
		return selectClient;
	}

	public void setSelectPromotions(List<SelectItem> selectPromotions) {
		this.selectPromotions = selectPromotions;
	}

	public List<SelectItem> getSelectPromotions() {
		return selectPromotions;
	}

	public List<SelectItem> getSelectDistribuidores() {
		return selectDistribuidores;
	}

	public List<SelectItem> getSelectPacking() {
		return selectPacking;
	}
	public void setSelectRutas(List<SelectItem> selectRutas) {
		this.selectRutas = selectRutas;
	}
	public List<SelectItem> getSelectRutas() {
		return selectRutas;
	}

	private List<SelectItem> buscarPromociones() {
		List<SelectItem> result = new ArrayList<SelectItem>();
		//Temporally while the Promotion Table is created in the DB.
		SelectItem prom = new SelectItem(999,"Seleccione");
		result.add(prom);
		for(int i=80; i<100; i++){
			prom = new SelectItem(""+i,""+i);
			result.add(prom);
		}
		return result;
	}

	public void setSelectState(List<SelectItem> selectState) {
		this.selectState = selectState;
	}

	public List<SelectItem> getSelectState() {
		return selectState;
	}

	public void setSelectStateC(List<SelectItem> selectStateC) {
		this.selectStateC = selectStateC;
	}
	public List<SelectItem> getSelectStateC() {
		return selectStateC;
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

	public void setSelectMunicipalityC(List<SelectItem> selectMunicipalityC) {
		this.selectMunicipalityC = selectMunicipalityC;
	}
	public List<SelectItem> getSelectMunicipalityC() {
		return selectMunicipalityC;
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

	public void setSelectCityC(List<SelectItem> selectCityC) {
		this.selectCityC = selectCityC;
	}
	public List<SelectItem> getSelectCityC() {
		return selectCityC;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientId() {
		return clientId;
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
	public void setSelectIndustryC(List<SelectItem> selectIndustryC) {
		this.selectIndustryC = selectIndustryC;
	}
	public List<SelectItem> getSelectIndustryC() {
		return selectIndustryC;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setSelectBanks(List<SelectItem> selectBanks) {
		this.selectBanks = selectBanks;
	}

	public List<SelectItem> getSelectBanks() {
		return selectBanks;
	}

	public void setSelectDeposit(List<SelectItem> selectDeposit) {
		this.selectDeposit = selectDeposit;
	}

	/**
	 * @return the selectManufacturer
	 */
	public List<SelectItem> getSelectManufacturer() {
		return selectManufacturer;
	}
	/**
	 * @param selectManufacturer the selectManufacturer to set
	 */
	public void setSelectManufacturer(List<SelectItem> selectManufacturer) {
		this.selectManufacturer = selectManufacturer;
	}
	public List<SelectItem> getSelectSellerCompanies() {
		return selectSellerCompanies;
	}
	public void setSelectSellerCompanies(List<SelectItem> selectSellerCompanies) {
		this.selectSellerCompanies = selectSellerCompanies;
	}
	public void resetDeposit(){
		SelectItem si;
		si = new SelectItem("9999","Seleccione un Deposito");
		if(selectDeposit==null){
			selectDeposit  =  new ArrayList<SelectItem>();
		}else{
			selectDeposit.clear();
		}
		selectDeposit.add(si);
	}

	public List<SelectItem> getSelectDeposit() {
		return selectDeposit;
	}

	

	public void resetState (){
		if(selectState.size()==0){	
			selectState.add(new SelectItem("9999","Seleccione un Estado"));
		}else{
			selectState.clear();
			selectState.add(new SelectItem("9999","Seleccione un Estado"));
		}
	}

	public void resetStateC (){

		if(selectStateC.size()==0){	
		}else{
			selectStateC.clear();
		}
	}

	public void resetCity (){
		if(selectCity.size()==0){	
			selectCity.add(new SelectItem("9999","Seleccione una Ciudad"));
		}else{
			selectCity.clear();
			selectCity.add(new SelectItem("9999","Seleccione una Ciudad"));
		}
		if(selectCityC.size()==0){	
			;
		}else{
			selectCityC.clear();

		}
	}

	public void resetMunicipality (){
		logger.debug("Reseteo municipalitys");
		if(selectMunicipality.size()==0){	
			selectMunicipality.add(new SelectItem("9999","Seleccione un Municipio"));
		}else{
			selectMunicipality.clear();
			selectMunicipality.add(new SelectItem("9999","Seleccione un Municipio"));
		}
		if(selectMunicipalityC.size()==0){	
			selectMunicipalityC.clear();
		}else{
			selectMunicipalityC.clear();

		}
	}
	//Busca las ciudades segun ruta
	

}