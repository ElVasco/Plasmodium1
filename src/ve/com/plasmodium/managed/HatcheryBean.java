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
import ve.com.plasmodium.model.vo.HatcheryDTO;

@ManagedBean(name="HatcheryBean")
@SessionScoped
public class HatcheryBean {

	public static final Logger logger = Logger.getLogger(HatcheryBean.class);
	
	private boolean showDetailNew;
	private boolean showDetail;
	private List<SelectItem> selectHatchery;
	private String selectedHatchery;
	private String nameHatchery;
	private String description;
	private String id;

	public HatcheryBean() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = parameterMap.get("modify");
		if (param.equals("1"))
			resetSelectHatchery();
		logger.debug("parametro" + param + "----------");
		if(param!=null){
			setShowDetailNew(param.equals("0"));
			setShowDetail(param.equals("0"));
		}
	}

	public void resetSelectHatchery(){
		if(selectHatchery==null){
			selectHatchery =  new ArrayList<SelectItem>();
		}else{
			selectHatchery.clear();
		}
		logger.debug("BuscarHatchery");
		buscarHatchery();
	}

	public void buscarHatchery(){
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(gd.getHatcheryList().size() == 0){
			gd.findHatchery();
		}
		for(HatcheryDTO inty : gd.getHatcheryList()){
			SelectItem e = new SelectItem( inty.getId() + "", inty.getName());
			selectHatchery.add(e);
		}
	}

	public void hatcheryListenerMethod(){
		setNameHatchery("");
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			setShowDetail(false);
			logger.debug("selectedHatchery -> " + selectedHatchery);
			if(gd.getMapHatchery_Type() == null || gd.getMapHatchery_Type().get(selectedHatchery).size() == 0){
				gd.findDetailHatchery(selectedHatchery);
			}
			setNameHatchery(gd.getHatcheryDetail().getName());
			//setDescription(gd.getHatcheryDetail().getName());
	}

	public String actionAddHatchery() throws CustomException{
		String navigation = "fail";
		int result = -1;
		HatcheryDTO hatcheryDTO = new HatcheryDTO();
		hatcheryDTO.setName(this.getNameHatchery());

		logger.debug("HatcheryDTO to create" + hatcheryDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.addHatchery(hatcheryDTO);
		switch(result){
			case 0:
			navigation = "successful";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Criadero agregado con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Criadero no se pudo agregar", ""));
			break;
			default:
				navigation = "fail";
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Criadero no se pudo agregar", ""));
				break;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("HatcheryBean");
		return navigation;
	}

	public String actionUpdateHatchery() throws CustomException{
		String navigation = "fail";
		int result = -1;
		HatcheryDTO hatcheryDTO = new HatcheryDTO();
		hatcheryDTO.setName(this.getNameHatchery());

		logger.debug("HatcheryDTO to create" + hatcheryDTO.toString());
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		result = gd.updateHatchery(hatcheryDTO);
		switch(result){
			case 0:
			navigation = "successful_update";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Criadero actualizado con exito", ""));
			break;
			case -1:
			navigation = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Criadero no se pudo actualizar", ""));
			break;
		}
		
		return navigation;
	}

	public String actionExit(){
		String navigation = "successful_exit";
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Operación cancelada."));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("HatcheryBean");
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

	public List<SelectItem> getSelectHatchery() {
		return selectHatchery;
	}

	public void setSelectHatchery(List<SelectItem> selectHatchery) {
		this.selectHatchery = selectHatchery;
	}

	public String getSelectedHatchery() {
		return selectedHatchery;
	}

	public void setSelectedHatchery(String selectedHatchery) {
		this.selectedHatchery = selectedHatchery;
	}

	public String getNameHatchery() {
		return nameHatchery;
	}

	public void setNameHatchery(String nameHatchery) {
		this.nameHatchery = nameHatchery;
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