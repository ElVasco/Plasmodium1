package ve.com.plasmodium.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
@FacesConverter("PlaceConverter")
public class PlaceConverter implements Converter{
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("MyConverter getAsObject: " + value);
        return value;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("MyConverter getAsString: " + value);
    	if(value==null)
    		return "";
    	if(value instanceof SelectItem){
    		SelectItem si = (SelectItem)value;
    		return (String)si.getValue();
    	}
        return value.toString();
    }
    

}
