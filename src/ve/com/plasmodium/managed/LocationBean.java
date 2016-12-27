package ve.com.plasmodium.managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import ve.com.plasmodium.model.vo.LocationDTO;

@ManagedBean(name="LocationBean")
@SessionScoped
public class LocationBean {

	public static final Logger logger = Logger.getLogger(UserEditBean.class);
	
	private MapModel emptyModel;
	private String option;
	private String center;
	private LocationDTO location;
	
	private boolean showMap;
	private boolean showDetail;
	private boolean showDetailNew;
	private boolean editDetail;
	

	public void locationEntryListenerMethod() {
		RequestContext context = RequestContext.getCurrentInstance();
		
		switch (option) {
		case "1":
			
			break;
		case "2":
			
			break;
		case "3":
			context.execute("PF('dlg').show();");
			break;
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		setCenter(ec.getRequestParameterMap().get("LocationId:test"));
		logger.debug(center);
	}
	
	public void addMarkerListinerMethod(PointSelectEvent event){
		location.setLatitude(event.getLatLng().getLat() + "");
		location.setLongitude(event.getLatLng().getLng() + "");
		LatLng coord1 = new LatLng(event.getLatLng().getLat(), event.getLatLng().getLng());
		emptyModel.addOverlay(new Marker(coord1));
		
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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

	public boolean isEditDetail() {
		return editDetail;
	}

	public void setEditDetail(boolean editDetail) {
		this.editDetail = editDetail;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public MapModel getEmptyModel() {
		return emptyModel;
	}

	public void setEmptyModel(MapModel emptyModel) {
		this.emptyModel = emptyModel;
	}
}
