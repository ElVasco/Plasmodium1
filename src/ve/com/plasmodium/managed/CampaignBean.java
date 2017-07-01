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
import ve.com.plasmodium.model.vo.CampaignDTO;

@ManagedBean(name="CampaignBean")
@SessionScoped
public class CampaignBean {

	public static final Logger logger = Logger.getLogger(CampaignBean.class);
	
	private boolean showDetailNew;
	private boolean showDetail;
	private List<SelectItem> selectCampaign;
	private String selectedCampaign;
	private String nameCampaign;
	private String description;
	private String id;

	public CampaignBean() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
			resetSelectCampaign();
		logger.debug("parametro" + param + "----------");
		if(param!=null){
			setShowDetailNew(param.equals("0"));
			setShowDetail(param.equals("0"));
		}
	}

	public void resetSelectCampaign(){
		if(selectCampaign==null){
			selectCampaign =  new ArrayList<SelectItem>();
		}else{
			selectCampaign.clear();
		}
		logger.debug("BuscarCampaign");
		buscarCampaign();
	}
	
	public void buscarCampaign(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getCampaignList().size() == 0){
			gd.findCampaign();
		}
		for(CampaignDTO inty : gd.getCampaignList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectCampaign.add(e);
		}
	}

	public void campaignListenerMethod(){
		setNameCampaign("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			logger.debug("selectedCampaign -> " + selectedCampaign);
			if(gd.getMapCampaign_Type() == null || gd.getMapCampaign_Type().get(selectedCampaign).size() == 0){
				gd.findDetailCampaign(selectedCampaign);
			}
			setNameCampaign(gd.getCampaignDetail().getName());
			setDescription(gd.getCampaignDetail().getDescription());
	}

	public String actionAddCampaign() throws CustomException{
		String navigation = "fail";
		int result = -1;
		CampaignDTO campaignDTO = new CampaignDTO();
		campaignDTO.setName(this.getNameCampaign());
		campaignDTO.setDescription(this.getDescription());

		logger.debug("CampaignDTO to create" + campaignDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.addCampaign(campaignDTO);
		switch(result){
			case 0:
			navigation = "successful";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Campaña agregada con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo agregar campaña", ""));
			break;
			default:
				navigation = "fail";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo agregar campaña", ""));
				break;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CampaignBean");
		return navigation;
	}

	public String actionUpdateCampaign() throws CustomException{
		String navigation = "fail";
		int result = -1;
		CampaignDTO campaignDTO = new CampaignDTO();
		campaignDTO.setName(this.getNameCampaign());
		campaignDTO.setDescription(this.getDescription());

		logger.debug("CampaignDTO to create" + campaignDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updateCampaign(campaignDTO);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Campaña actualizada con exito.", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "No se pudo actualizar campaña.", ""));
			break;
		}
		
		return navigation;
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CampaignBean");
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

	public List<SelectItem> getSelectCampaign() {
		return selectCampaign;
	}

	public void setSelectCampaign(List<SelectItem> selectCampaign) {
		this.selectCampaign = selectCampaign;
	}

	public String getSelectedCampaign() {
		return selectedCampaign;
	}

	public void setSelectedCampaign(String selectedCampaign) {
		this.selectedCampaign = selectedCampaign;
	}

	public String getNameCampaign() {
		return nameCampaign;
	}

	public void setNameCampaign(String nameCampaign) {
		this.nameCampaign = nameCampaign;
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