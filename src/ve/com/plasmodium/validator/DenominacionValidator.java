package ve.com.plasmodium.validator;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;

import org.apache.log4j.Logger;

//import javax.faces.validator.ValidatorException;
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIInput;

public class DenominacionValidator implements Validator{

	public static final Logger logger = Logger.getLogger(DenominacionValidator.class);
	
	/**
	 * @param context La instancia
	 * @param component El componente de la GUI que especifica el atributo "validator"
	 * @param value El valor a ser Verificado
	 * @return
	 */
	public void validate(FacesContext context, UIComponent component, Object value) {
	    logger.debug ( "El Id es :" + component.getId()) ;
	


// Este es un metodo alternativo para enviar un mensaje a la GUI pero NO llega formateado con el estilo
//			context.addMessage(component.getClientId(context), new FacesMessage ("No hay conexion"));
//			((UIInput)component).setValid(false);

// Con esta forma si se logra que el mensaje llegue con el estilo correcto. 			
//			throw new ValidatorException(new FacesMessage ("No hay conexion. Verifique su conexion y/o notifique al Administrador de Sistema"));
			

		// A nivel de estas validaciones no usar los getter ya que dara nulo se usa el parametro "value"
		// Esta validacion es temporal pero se hace con caracter ilustrativo
		if (value != null) {
		
		    logger.debug("el valor es :" + value );
		} // end if value != null

	}
	
}