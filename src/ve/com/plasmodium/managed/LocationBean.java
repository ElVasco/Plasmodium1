package ve.com.plasmodium.managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

@ManagedBean(name="LocationBean")
@SessionScoped
public class LocationBean {

	public static final Logger logger = Logger.getLogger(UserEditBean.class);
	
	private String option;
	private String center;


	public void changeLanguage() {
		RequestContext context = RequestContext.getCurrentInstance();
		switch (option) {
		case "1":
			context.execute("PF('dlg1').show();");
			break;
		case "2":
			context.execute("PF('dlg2').show();");
			break;
		case "3":
			context.execute("PF('dlg3').show();");
			break;
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		setCenter(ec.getRequestParameterMap().get("LocationId:test"));
		logger.debug(center);
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
}
