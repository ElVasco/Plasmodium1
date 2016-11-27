package ve.com.plasmodium.managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ve.com.plasmodium.manager.InstitutionManager;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.model.dao.SQLConstant;
import ve.com.plasmodium.model.vo.InstitutionDTO;

@ManagedBean(name="InstitutionBean")
@SessionScoped
public class InstitutionBean {
	
	public static final Logger logger = Logger.getLogger(UserEditBean.class);
	
	private List<SelectItem> selectInstitutionType;
	private String selectedInstitutionType;
	private List<SelectItem> selectInstitution;
	private String selectedInstitution;
	private String center;
	
    private MapModel model;
    private Marker marker;
    
    private boolean showMap;
    private boolean showDetail;
    private boolean editDetail;
    
    public InstitutionBean() {
    	setShowMap(false);
	}
    
    public void userListenerMethod( ){
		logger.debug("Entre al metodo de busca de detalle de usuario  ");
		try{
			clearDataUser();
			showDetail=false;
			editDetail=false;
			if(selectedInstitution != null && !selectedInstitution.equals("")){
				short instIDS  = Short.parseShort(selectedInstitution);
				if(instIDS==999){
					showDetail=true; 
					
				}else{
					InstitutionManager institutionManager = new InstitutionManager(SQLConstant.MYSQL);
					InstitutionDTO institution = new InstitutionDTO();
					showDetail=true;
					
					editDetail=true;
					institutionManager.institutionDetail(institution, selectedInstitution);
					
				}
			}
			/*If an existent user is selected his details can't be edited unless the button with label "Modificar" is pressed*/
			 
		}catch (Exception e){
			logger.error("Exception UserEditBean - userListenerMethod ", e);
		}
	}
    
	public void clearDataUser(){
		showDetail=false;

	}
	
    @PostConstruct
    public void init() {
    	
        model = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
        LatLng coord4 = new LatLng(36.885233, 30.702323);
          
        //Icons and Data
        model.addOverlay(new Marker(coord1, "Konyaalti", "konyaalti.png", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
        model.addOverlay(new Marker(coord2, "Ataturk Parki", "ataturkparki.png"));
        model.addOverlay(new Marker(coord4, "Kaleici", "kaleici.png", "http://maps.google.com/mapfiles/ms/micons/pink-dot.png"));
        model.addOverlay(new Marker(coord3, "Karaalioglu Parki", "karaalioglu.png", "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png"));
    }
	
	public MapModel getModel() {
		return model;
	}

	public void setModel(MapModel model) {
		this.model = model;
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

}
