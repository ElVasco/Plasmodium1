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
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;

@ManagedBean(name="InstitutionTypeBean")
@SessionScoped
public class InstitutionTypeBean {

	public static final Logger logger = Logger.getLogger(InstitutionTypeBean.class);

	private String nameInstitutionType;
	private List<SelectItem> selectInstitutionType;
	private String selectedInstitutionType;
	private boolean showDetailNew;
	private boolean showDetail;
	private boolean editDetail;
	private InstitutionTypeDTO instiType;
	private String msgFaces;

	public InstitutionTypeBean() {
		resetSelectInstitutionType();
		resetInstiType();
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		logger.debug(param + "----------");
		if(param!=null)
			setShowDetailNew(param.equals("0"));
	}

	public void resetSelectInstitutionType(){
		if(selectInstitutionType==null){
			selectInstitutionType  =  new ArrayList<SelectItem>();
		}else{
			selectInstitutionType.clear();
		}
		buscarInstitutionType();
	}
	
	public void resetInstiType(){
		if(instiType==null){
			instiType = new InstitutionTypeDTO();
		}
	}
	
	public void buscarInstitutionType(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		//if(gd.getInstitutionTypeList().size() == 0){
		if (gd.getInstitutionTypeList() != null)
			gd.getInstitutionTypeList().clear();
		gd.findInstitutionType();
		//}
		selectInstitutionType.clear();
		for(InstitutionTypeDTO inty : gd.getInstitutionTypeList()){
			SelectItem e = new SelectItem( inty.getIdIstitutionType() + "", inty.getName());
			selectInstitutionType.add(e);
		}
	}

	public void institutionTypeListenerMethod(){
		setShowDetail(false);
		setNameInstitutionType("");
		if(selectedInstitutionType!=null && !selectedInstitutionType.equalsIgnoreCase("")){
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			if(gd.getMapInstitution_Type() == null || gd.getMapInstitution_Type().get(selectedInstitutionType).size() == 0){
				gd.findInstitution(selectedInstitutionType);
			}

			setNameInstitutionType(gd.getMapInstitution_Type().get(selectedInstitutionType).get(0).getInstitutionType().getName());
			setShowDetail(true);
		}
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitutionTypeBean");
		return navigation;
	}

	public String actionAddInstitutionType(){
		String navigation = "successful_exit";
		InstitutionTypeDTO instiType = new InstitutionTypeDTO();
		//instiType.setName(this.getNameInstitutionType());
		instiType.setName(this.getInstiType().getName());
		logger.debug("InstitutionTypeDTO to create" + instiType.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		int result = gd.addInstitutionType(instiType);
		switch(result){
		case 0:
			navigation = "successful";
			msgFaces = "Tipo de institucion agregada con exito";
			break;
		case -1:
			navigation = "fail";
			msgFaces = "Error al intentar agregar tipo de Institución";
			break;
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",msgFaces));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitutionTypeBean");
		return navigation;
	}

	public String actionChangeInstitutionType(){
		String navigation = "successful_exit";
		InstitutionTypeDTO instiType = new InstitutionTypeDTO();
		instiType.setIdIstitutionType(Integer.parseInt(this.getSelectedInstitutionType()));
		instiType.setName(this.instiType.getName());
		logger.debug("InstitutionTypeDTO to modify" + this.instiType.getName());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		int result = gd.changeInstitutionType(instiType);
		switch(result){
		case 0:
			navigation = "successful";
			msgFaces = "Tipo de institucion cambiada con exito";
			break;
		case -1:
			navigation = "fail";
			msgFaces = "Error al intentar actualizar tipo de Institución";
			break;
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información",msgFaces));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitutionTypeBean");
		return navigation;
	}

	public String getNameInstitutionType() {
		return nameInstitutionType;
	}

	public void setNameInstitutionType(String nameInstitutionType) {
		this.nameInstitutionType = nameInstitutionType;
	}

	public String getSelectedInstitutionType() {
		return selectedInstitutionType;
	}

	public void setSelectedInstitutionType(String selectedInstitutionType) {
		this.selectedInstitutionType = selectedInstitutionType;
	}

	public List<SelectItem> getSelectInstitutionType() {
		return selectInstitutionType;
	}

	public void setSelectInstitutionType(List<SelectItem> selectInstitutionType) {
		this.selectInstitutionType = selectInstitutionType;
	}

	public boolean isShowDetailNew() {
		return showDetailNew;
	}

	public void setShowDetailNew(boolean showDetailNew) {
		this.showDetailNew = showDetailNew;
	}

	public boolean isEditDetail() {
		return editDetail;
	}

	public void setEditDetail(boolean editDetail) {
		this.editDetail = editDetail;
	}

	public InstitutionTypeDTO getInstiType() {
		return instiType;
	}

	public void setInstiType(InstitutionTypeDTO instiType) {
		this.instiType = instiType;
	}

	public boolean isShowDetail() {
		return showDetail;
	}

	public void setShowDetail(boolean showDetail) {
		this.showDetail = showDetail;
	}

}