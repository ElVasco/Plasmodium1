package ve.com.plasmodium.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;

@ManagedBean(name="InstitutionBean")
@SessionScoped
public class InstitutionBean {

	public static final Logger logger = Logger.getLogger(UserEditBean.class);

	private List<SelectItem> selectInstitutionType;
	private String selectedInstitutionType;
	private List<SelectItem> selectInstitution;
	private String selectedInstitution;
	private String center;
	private InstitutionDTO institution;

	private MapModel simpleModel;
	private Marker marker;

	private boolean showMap;
	private boolean showDetail;
	private boolean showDetailNew;
	private boolean editDetail;
	private boolean showInstitutionList;

	public InstitutionBean() {
		setShowMap(false);
		resetInstitutionType();
		resetInstitution();
	}

	private void resetInstitutionType() {
		if(selectInstitutionType == null)
			selectInstitutionType = new ArrayList<SelectItem>();
		else
			selectInstitutionType.clear();
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getInstitutionTypeList().size() == 0){
			gd.findInstitutionType();
		}
		for(InstitutionTypeDTO inty : gd.getInstitutionTypeList()){
			SelectItem e = new SelectItem( inty.getIdIstitutionType() + "", inty.getName());
			selectInstitutionType.add(e);
		}

	}

	private void resetInstitution() {
		if(selectInstitution == null)
			selectInstitution = new ArrayList<SelectItem>();
		else
			selectInstitution.clear();
	}

	public void institutionListenerMethod( ){
		logger.debug("Entre al metodo de busca de detalle de institucion  ");
		try{
			setShowDetail(false);
			setEditDetail(false);
			if(selectedInstitution != null && !selectedInstitution.equals("")){
				short instIDS  = Short.parseShort(selectedInstitution);
				if(instIDS==999){
					setShowDetail(true); 
					setEditDetail(true);
					institution = null;

				}else{
					GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
					for(InstitutionDTO inty :  gd.getMapInstitution_Type().get(selectedInstitutionType)){
						if(inty.getIdIstitution() == Integer.parseInt(selectedInstitution))
							institution = inty;
					}
					setShowDetail(true);
					setEditDetail(true);
					setShowMap(true);
					setGPS();
				}
			}

		}catch (Exception e){
			logger.error("Exception InstitutionBean - institutionListenerMethod ", e);
		}
	}

	public void institutionTypeListenerMethod(){
		setShowInstitutionList(false);
		if(selectedInstitutionType!=null || !selectedInstitutionType.equals("")){
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			if(gd.getMapInstitution_Type() == null || gd.getMapInstitution_Type().get(selectedInstitutionType).size() == 0){
				gd.findInstitution(selectedInstitutionType);
			}
			for(InstitutionDTO inty : gd.getMapInstitution_Type().get(selectedInstitutionType)){
				SelectItem e = new SelectItem( inty.getIdIstitution() + "", inty.getName());
				selectInstitution.add(e);
			}
			setShowInstitutionList(true);
		}
	}

	public void setGPS() {
		simpleModel = new DefaultMapModel();
		setCenter(institution.getLocation().getLatitude()+","+institution.getLocation().getLongitude());
		//Shared coordinates
		LatLng coord1 = new LatLng(Double.parseDouble(institution.getLocation().getLatitude()), 
				Double.parseDouble(institution.getLocation().getLongitude()));

		//Basic marker
		simpleModel.addOverlay(new Marker(coord1, institution.getInstitutionType().getName() + "-" + institution.getName()));

	}

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();

	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitutionBean");
		return navigation;
	}


	public List<SelectItem> getSelectInstitutionType() {
		return selectInstitutionType;
	}

	public void setSelectInstitutionType(List<SelectItem> selectInstitutionType) {
		this.selectInstitutionType = selectInstitutionType;
	}

	public String getSelectedInstitutionType() {
		return selectedInstitutionType;
	}

	public void setSelectedInstitutionType(String selectedInstitutionType) {
		this.selectedInstitutionType = selectedInstitutionType;
	}

	public List<SelectItem> getSelectInstitution() {
		return selectInstitution;
	}

	public void setSelectInstitution(List<SelectItem> selectInstitution) {
		this.selectInstitution = selectInstitution;
	}

	public String getSelectedInstitution() {
		return selectedInstitution;
	}

	public void setSelectedInstitution(String selectedInstitution) {
		this.selectedInstitution = selectedInstitution;
	}

	public Marker getMarker() {
		return marker;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public boolean isShowMap() {
		return showMap;
	}

	public void setShowMap(boolean showMap) {
		this.showMap = showMap;
	}

	public boolean isShowInstitutionList() {
		return showInstitutionList;
	}

	public void setShowInstitutionList(boolean showInstitutionList) {
		this.showInstitutionList = showInstitutionList;
	}

	public boolean isEditDetail() {
		return editDetail;
	}

	public void setEditDetail(boolean editDetail) {
		this.editDetail = editDetail;
	}

	public boolean isShowDetail() {
		return showDetail;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

	public boolean isShowDetailNew() {
		return showDetailNew;
	}

	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}

	public InstitutionDTO getInstitution() {
		return institution;
	}

	public void setInstitution(InstitutionDTO institution) {
		this.institution = institution;
	}

}
