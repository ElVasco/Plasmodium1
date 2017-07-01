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
import ve.com.plasmodium.model.vo.DemarcationDTO;

@ManagedBean(name="DemarcationBean")
@SessionScoped
public class DemarcationBean {
	
	public static final Logger logger = Logger.getLogger(DemarcationBean.class);

	private boolean showDetailNew;
	private boolean showDetail;
	private List<SelectItem> selectDemarcation;
	private String selectedDemarcation;
	private String nameDemarcation;
	private String description;
	private String id;

	public DemarcationBean() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
			resetSelectDemarcation();
		logger.debug("parametro" + param + "----------");
		if(param!=null){
			setShowDetailNew(param.equals("0"));
			setShowDetail(param.equals("0"));
		}
	}

	public void resetSelectDemarcation(){
		if(selectDemarcation==null){
			selectDemarcation =  new ArrayList<SelectItem>();
		}else{
			selectDemarcation.clear();
		}
		logger.debug("BuscarDemarcation");
		buscarDemarcation();
	}
	
	public void buscarDemarcation(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getDemarcationList().size() == 0){
			gd.findDemarcation();
		}
		for(DemarcationDTO inty : gd.getDemarcationList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectDemarcation.add(e);
		}
	}

	public void demarcationListenerMethod(){
		setNameDemarcation("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			logger.debug("selectedDemarcation -> " + selectedDemarcation);
			if(gd.getMapDemarcation_Type() == null || gd.getMapDemarcation_Type().get(selectedDemarcation).size() == 0){
				gd.findDetailCampaign(selectedDemarcation);
			}
			setNameDemarcation(gd.getDemarcationDetail().getName());
			setDescription(gd.getDemarcationDetail().getDescription());
	}

	public String actionAddDemarcation() throws CustomException{
		String navigation = "fail";
		int result = -1;
		DemarcationDTO demarDTO = new DemarcationDTO();
		demarDTO.setName(this.getNameDemarcation());
		demarDTO.setDescription(this.getDescription());

		logger.debug("DemarcationDTO to create" + demarDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.addDemarcation(demarDTO);
		switch(result){
			case 0:
			navigation = "successful";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Demarcación agregada con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo agregar demarcación", ""));
			break;
			default:
				navigation = "fail";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo agregar demarcación", ""));
				break;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DemarcationBean");
		return navigation;
	}

	public String actionUpdateDemarcation() throws CustomException{
		String navigation = "fail";
		int result = -1;
		DemarcationDTO demarDTO = new DemarcationDTO();
		demarDTO.setName(this.getNameDemarcation());
		demarDTO.setDescription(this.getDescription());

		logger.debug("DemarcationDTO to create" + demarDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updateDemarcation(demarDTO);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Demarcación actualizada con exito.", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo actualizar demarcación.", ""));
			break;
		}
		
		return navigation;
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DemarcationBean");
		return navigation;
	}

	public boolean isShowDetailNew() {
		return showDetailNew;
	}

	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}

	public boolean isShowDetail() {
		return showDetail;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

	public List<SelectItem> getSelectDemarcation() {
		return selectDemarcation;
	}

	public void setSelectDemarcation(List<SelectItem> selectDemarcation) {
		this.selectDemarcation = selectDemarcation;
	}

	public String getSelectedDemarcation() {
		return selectedDemarcation;
	}

	public void setSelectedDemarcation(String selectedDemarcation) {
		this.selectedDemarcation = selectedDemarcation;
	}

	public String getNameDemarcation() {
		return nameDemarcation;
	}

	public void setNameDemarcation(String nameDemarcation) {
		this.nameDemarcation = nameDemarcation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}