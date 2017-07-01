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
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;

@ManagedBean(name="PhenomenonTypeBean")
@SessionScoped
public class PhenomenonTypeBean {

	public static final Logger logger = Logger.getLogger(PhenomenonTypeBean.class);

	private boolean showDetailNew;
	private boolean showDetail;
	private PhenomenonTypeDTO phenomenonTypeDTO;
	private String selectedPhenomenonType;
	private List<SelectItem> selectPhenomenonType;
	private String namePhenomenonType;
	
	public PhenomenonTypeBean() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
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
		logger.debug("BuscarPhenomenon");
		buscarPhenomenonType();
	}

	private void buscarPhenomenonType(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			gd.findPhenomenonType();
			selectPhenomenonType.clear();
		for(PhenomenonTypeDTO inty : gd.getPhenomenonTypeList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectPhenomenonType.add(e);
		}
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PhenomenonTypeBean");
		return navigation;
	}

	public String actionAddPhenomenonType() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PhenomenonTypeDTO phenomenonTypeDTO = new PhenomenonTypeDTO();
		phenomenonTypeDTO.setName(this.getNamePhenomenonType());
		logger.debug("PhenomenonTypeDTO to create" + phenomenonTypeDTO.toString());
		logger.debug("this.getNamePhenomenonType()" + this.getNamePhenomenonType());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");

		result = gd.addPhenomenonType(phenomenonTypeDTO);
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
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PhenomenonTypeBean");
		return navigation;
	}

	public String actionUpdateTypePhenomenon() throws CustomException{
		String navigation = "fail";
		int result = -1;
		PhenomenonTypeDTO phenomenonTypeDTO = new PhenomenonTypeDTO();
		phenomenonTypeDTO.setName(this.getNamePhenomenonType());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updatePhenomenonType(phenomenonTypeDTO, selectedPhenomenonType);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de Fenomeno actualizado con exito.", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo actualizar tipo de Fenomeno.", ""));
			break;
		}

		return navigation;
	}

	public void phenomenonTypeListenerMethod(){
		setNamePhenomenonType("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			if(gd.getMapPhenomenon_Type() == null || gd.getMapPhenomenon_Type().get(selectedPhenomenonType).size() == 0){
				gd.findDetailPhenomenonType(selectedPhenomenonType);
			}
			setNamePhenomenonType(gd.getPhenomenonTypeDetail().getName());
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

	public PhenomenonTypeDTO getPhenomenonTypeDTO() {
		return phenomenonTypeDTO;
	}

	public void setPhenomenonTypeDTO(PhenomenonTypeDTO phenomenonTypeDTO) {
		this.phenomenonTypeDTO = phenomenonTypeDTO;
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
	
	public void setNamePhenomenonType(String namePhenomenonType){
		this.namePhenomenonType = namePhenomenonType;
	}
	
	public String getNamePhenomenonType(){
		return this.namePhenomenonType;
	}
}
