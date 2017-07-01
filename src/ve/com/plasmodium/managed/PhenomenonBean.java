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
import ve.com.plasmodium.model.vo.PhenomenonDTO;
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;

@ManagedBean(name="PhenomenonBean")
@SessionScoped
public class PhenomenonBean {

	public static final Logger logger = Logger.getLogger(PhenomenonBean.class);

	private boolean showDetailNew;
	private boolean showDetail;
	private PhenomenonDTO phenomenonDTO;
	private String selectedPhenomenon;
	private String selectedPhenomenonType;
	private List<SelectItem> selectPhenomenon;
	private List<SelectItem> selectPhenomenonType;
	private String namePhenomenon;
	private String description;
	private String idPhenomenonType;

	public PhenomenonBean() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
			resetSelectPhenomenon();
		resetSelectPhenomenonType();
		logger.debug("parametro" + param + "----------");
		if(param!=null){
			setShowDetailNew(param.equals("0"));
			setShowDetail(param.equals("0"));
		}
	}

	private void resetSelectPhenomenonType(){
		if(selectPhenomenonType==null){
			selectPhenomenonType = new ArrayList<SelectItem>();
		}else{
			selectPhenomenonType.clear();
		}
		buscarPhenomenonType();
	}

	private void resetSelectPhenomenon(){
		if(selectPhenomenon==null){
			selectPhenomenon = new ArrayList<SelectItem>();
		}else{
			selectPhenomenon.clear();
		}
		logger.debug("BuscarPhenomenon");
		buscarPhenomenon();
	}

	private void buscarPhenomenon(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getPhenomenonList() != null){
			gd.getPhenomenonList().clear();
		}
		gd.findPhenomenon();
		for(PhenomenonDTO inty : gd.getPhenomenonList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectPhenomenon.add(e);
		}
	}

	private void buscarPhenomenonType(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			gd.findPhenomenonType();
			selectPhenomenonType.clear();
		for(PhenomenonTypeDTO inty : gd.getPhenomenonTypeList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectPhenomenonType.add(e);
			logger.debug("e."+e.toString());
		}
	}

	public String actionAddPhenomenon() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PhenomenonDTO phenomenonDTO = new PhenomenonDTO();
		phenomenonDTO.setName(this.getNamePhenomenon());
		phenomenonDTO.setDescription(this.getDescription());
		phenomenonDTO.setIdPhenomenonType(this.selectedPhenomenonType.toString());

		logger.debug("PhenomenonDTO to create " + phenomenonDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");

		result = gd.addPhenomenon(phenomenonDTO);
		switch(result){
			case 0:
			navigation = "successful";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Fenomeno agregado con exito.", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo agregar Fenomeno.", ""));
			break;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PhenomenonBean");
		return navigation;
	}

	public String actionUpdatePhenomenon() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PhenomenonDTO phenomenonDTO = new PhenomenonDTO();
		
		phenomenonDTO.setName(this.getNamePhenomenon());
		phenomenonDTO.setDescription(this.getDescription());
		phenomenonDTO.setIdPhenomenonType(this.selectedPhenomenonType.toString());

		logger.debug("PlasmodiumDTO to create" + phenomenonDTO.toString() + " " + this.selectedPhenomenon);
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updatePhenomenon(phenomenonDTO);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Fenomeno actualizado con exito.", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo actualizar Fenomeno.", ""));
			break;
		}

		return navigation;
	}

	public void phenomenonListenerMethod(){
		//setNamePhenomenon("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			logger.debug("selectPlasmodium -> " + selectPhenomenon);
			if(gd.getMapPhenomenon() == null || gd.getMapPhenomenon().get(selectedPhenomenon).size() == 0){
				gd.findDetailPhenomenon(selectedPhenomenon);
			}
			setNamePhenomenon(gd.getPhenomenonDetail().getName());
			setDescription(gd.getPhenomenonDetail().getDescription());
			setIdPhenomenonType(gd.getPhenomenonDetail().getIdPhenomenonType());
			setSelectedPhenomenonType(gd.getPhenomenonDetail().getIdPhenomenonType());
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PhenomenonBean");
		return navigation;
	}

	public boolean isShowDetailNew() {
		return showDetailNew;
	}

	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}

	public String getNamePhenomenon() {
		return namePhenomenon;
	}

	public void setNamePhenomenon(String namePhenomenon) {
		this.namePhenomenon = namePhenomenon;
	}

	public boolean isShowDetail() {
		return showDetail;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

	public PhenomenonDTO getPhenomenonDTO() {
		return phenomenonDTO;
	}

	public void setPhenomenonDTO(PhenomenonDTO phenomenonDTO) {
		this.phenomenonDTO = phenomenonDTO;
	}

	public String getSelectedPhenomenon() {
		return selectedPhenomenon;
	}

	public void setSelectedPhenomenon(String selectedPhenomenon) {
		this.selectedPhenomenon = selectedPhenomenon;
	}

	public List<SelectItem> getSelectPhenomenon() {
		return selectPhenomenon;
	}

	public void setSelectPhenomenon(List<SelectItem> selectPhenomenon) {
		this.selectPhenomenon = selectPhenomenon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdPhenomenonType() {
		return idPhenomenonType;
	}

	public void setIdPhenomenonType(String idPhenomenonType) {
		this.idPhenomenonType = idPhenomenonType;
	}

	public String getSelectedPhenomenonType() {
		return selectedPhenomenonType;
	}

	public void setSelectedPhenomenonType(String selectedPhenomenonType) {
		this.selectedPhenomenonType = selectedPhenomenonType;
	}

	public List<SelectItem> getSelectPhenomenonType() {
		return selectPhenomenonType;
	}

	public void setSelectPhenomenonType(List<SelectItem> selectPhenomenonType) {
		this.selectPhenomenonType = selectPhenomenonType;
	}
}