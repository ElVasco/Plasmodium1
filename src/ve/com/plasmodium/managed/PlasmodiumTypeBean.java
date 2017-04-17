package ve.com.plasmodium.managed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.vo.PlasmodiumTypeDTO;

@ManagedBean(name="PlasmodiumTypeBean")
@SessionScoped
public class PlasmodiumTypeBean {

	public static final Logger logger = Logger.getLogger(PlasmodiumTypeBean.class);

	private PlasmodiumDTO plasmodium;
	private String lethalitySeleced;

	private boolean showDetailNew;
	private boolean showDetail;
	private List<SelectItem> selectPlasmodiumType;
	private List<SelectItem> selectLetalidad;
	private String selectedPlasmodiumType;
	private String selectedLetalidad;
	private String namePlasmodiumType;
	private String letalidad;
	private String description;
	private String id;

	public PlasmodiumTypeBean(){
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
			resetSelectPLasmodiumType();
		resetSelectLetalidad();
		logger.debug("parametro" + param + "----------");
		if(param!=null){
			setShowDetailNew(param.equals("0"));
			setShowDetail(param.equals("0"));
		}
	}

	public String getLetalidad() {
		return letalidad;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setLetalidad(String letalidad) {
		this.letalidad = letalidad;
	}

	public List<SelectItem> getSelectLetalidad() {
		return selectLetalidad;
	}

	public void setSelectLetalidad(List<SelectItem> selectLetalidad) {
		this.selectLetalidad = selectLetalidad;
	}

	public void resetSelectPLasmodiumType(){
		if(selectPlasmodiumType==null){
			selectPlasmodiumType  =  new ArrayList<SelectItem>();
		}else{
			selectPlasmodiumType.clear();
		}
		logger.debug("BuscarPlasmodium");
		buscarPlasmodiumType();
	}

	public void resetSelectLetalidad(){
		if(selectLetalidad==null){
			selectLetalidad = new ArrayList<SelectItem>();
		}else{
			selectLetalidad.clear();
		}
		buscarLetalidad();
	}

	public PlasmodiumDTO getPlasmodium() {
		return plasmodium;
	}

	public void setPlasmodium(PlasmodiumDTO plasmodium) {
		this.plasmodium = plasmodium;
	}

	public String getLethalitySeleced() {
		return lethalitySeleced;
	}

	public void setLethalitySeleced(String lethalitySeleced) {
		this.lethalitySeleced = lethalitySeleced;
	}

	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}

	public boolean getShowDetailNew() {
		return this.showDetailNew;
	}

	public void resetSelectPlasmodiumType(){
		if(selectPlasmodiumType==null){
			selectPlasmodiumType  =  new ArrayList<SelectItem>();
		}else{
			selectPlasmodiumType.clear();
		}
		buscarPlasmodiumType();
	}

	public void buscarPlasmodiumType(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getPlasmodiumTypeList().size() == 0){
			gd.findPlasmodiumType();
		}
		for(PlasmodiumTypeDTO inty : gd.getPlasmodiumTypeList()){
			SelectItem e = new SelectItem( inty.getIdPlasmodiumType() + "", inty.getName());
			selectPlasmodiumType.add(e);
		}	    
	}

	public void buscarLetalidad(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getLethalityList().size() == 0){
			gd.findLetalidad();
		}
		for(LethalityDTO inty : gd.getLethalityList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getLethality());
			selectLetalidad.add(e);
		}
	}

	public void plasmodiumLetalidadListenerMethod(){
		//setShowDetail(false);
		setLetalidad("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			if(gd.getMapLetalidad() == null || gd.getMapLetalidad().get(selectedLetalidad).size() == 0){
				gd.findLetalidad(selectedLetalidad);
			}
			setLetalidad(gd.getMapLetalidad().get(selectedLetalidad).get(0).getLethality());
			//setShowDetail(true);
	}

	public void plasmodiumTypeListenerMethod(){
		setNamePlasmodiumType("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			logger.debug("selectedPlasmodiumType -> " + selectedPlasmodiumType);
			if(gd.getMapPlasmodium_Type() == null || gd.getMapPlasmodium_Type().get(selectedPlasmodiumType).size() == 0){
				gd.findDetailPlasmodium(selectedPlasmodiumType);
			}
			setNamePlasmodiumType(gd.getPlasmodiumDetail().getName());
			setDescription(gd.getPlasmodiumDetail().getDescription());
			setSelectedLetalidad(gd.getPlasmodiumDetail().getLetalidad());
	}

	public String getNamePlasmodiumType() {
		return namePlasmodiumType;
	}

	public void setNamePlasmodiumType(String namePlasmodiumType) {
		this.namePlasmodiumType = namePlasmodiumType;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

	public boolean getShowDetail() {
		return this.showDetail;
	}
	
	public List<SelectItem> getSelectPlasmodiumType(){
		return this.selectPlasmodiumType;
	}
	
	public void setSelectPlasmodiumType(List<SelectItem> selectPlasmodiumType){
		this.selectPlasmodiumType = selectPlasmodiumType;
	}

	public String getSelectedPlasmodiumType(){
		return this.selectedPlasmodiumType;
	}

	public void setSelectedPlasmodiumType(String selectedPlasmodiumType){
		this.selectedPlasmodiumType = selectedPlasmodiumType;
	}	

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Informaci�n","Operaci�n cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PlasmodiumTypeBean");
		return navigation;
	}

	public String actionAddPlasmodium() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PlasmodiumDTO plasmodiumDTO = new PlasmodiumDTO();
		plasmodiumDTO.setName(this.getNamePlasmodiumType());
		plasmodiumDTO.setDescription(this.getDescription());
		plasmodiumDTO.setLetalidad(this.getSelectedLetalidad());

		logger.debug("PlasmodiumDTO to create" + plasmodiumDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.addPlasmodium(plasmodiumDTO);
		switch(result){
			case 0:
			navigation = "successful";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Plasmodium Agregado con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Plasmodium no se pudo agregar", ""));
			break;
			default:
				navigation = "fail";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Plasmodium no se pudo agregar", ""));
				break;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PlasmodiumTypeBean");
		return navigation;
	}
	
	public String getSelectedLetalidad() {
		return selectedLetalidad;
	}

	public void setSelectedLetalidad(String selectedLetalidad) {
		this.selectedLetalidad = selectedLetalidad;
	}
	
	public String actionUpdatePlasmodium() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PlasmodiumDTO plasmodiumDTO = new PlasmodiumDTO();
		plasmodiumDTO.setName(this.getNamePlasmodiumType());
		plasmodiumDTO.setDescription(this.getDescription());
		plasmodiumDTO.setLetalidad(this.getSelectedLetalidad());

		logger.debug("PlasmodiumDTO to create" + plasmodiumDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updatePlasmodium(plasmodiumDTO);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Plasmodium actualizado con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Plasmodium no se pudo actualizar", ""));
			break;
		}
		
		return navigation;
	}
}