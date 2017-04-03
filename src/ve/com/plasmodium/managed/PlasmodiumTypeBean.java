package ve.com.plasmodium.managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.PlasmodiumDTO;

@ManagedBean(name="PlasmodiumTypeBean")
@SessionScoped
public class PlasmodiumTypeBean {
	
	public static final Logger logger = Logger.getLogger(PlasmodiumTypeBean.class);
	
	private PlasmodiumDTO plasmodium;
	private String lethalitySeleced;
	
	
	
	public PlasmodiumTypeBean(){
		
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

}
