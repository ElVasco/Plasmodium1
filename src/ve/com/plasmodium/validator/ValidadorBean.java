package ve.com.plasmodium.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.log4j.Logger;

import ve.com.plasmodium.control.AuthorizationBean;
import ve.com.plasmodium.manager.UserManager;
import ve.com.plasmodium.model.dao.SQLConstant;

import java.util.Hashtable;
import java.util.regex.*;

@ManagedBean(name="ValidadorBean")
@SessionScoped
public class ValidadorBean {


	public static final Logger logger = Logger.getLogger(ValidadorBean.class);

	/**
	 * Validador de correo donde se verifica la estructura del mismo y si el dominio existe al menos.
	 * @param e  e_Mail
	 */
	public boolean isValidMail(String email) {
		String validator = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$";
		if (!email.matches(validator)) {
			return false;
		}
		String[] parts = email.split("@");
		boolean retval=true;
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put("java.naming.factory.initial",
					"com.sun.jndi.dns.DnsContextFactory");
			DirContext context = new InitialDirContext(env);
			Attributes attributes =
					context.getAttributes(parts[1], new String[]{"MX"});
			Attribute attribute = attributes.get("MX");
			if (attribute.size() == 0) {
				retval=false;
			}
			context.close();
			return retval;

		} catch (Exception exception) {
			return false;
		}       
	}

	public int isValidRif(String rif) {
		String validator = "^[V,E,G,J]{1,1}-{1,1}\\d{6,8}-{1,1}\\d{1,1}$";
		boolean tt;
		try{
			tt=rif.matches(validator);
			if(!tt){
				if(rif.substring(0,1).matches("[V,E,G,J]$")){
					if(rif.substring(1,3).matches("-\\d$")){
						if(!rif.substring(4).matches("\\d-\\d$")){
							return 3;
						}else{
							return 0;
						}
					}else{
						return 2;
					}
				}else{
					return 1;
				}
			}else{
				return 0;
			}
		}catch(Exception exception){
			return 4;
		}
	}

	public boolean isValidPhone(String phone) {
		String validator = "\\d{4}-\\d{7}";
		return phone.matches(validator);
	}

	public boolean isValidPassRegx(String pass) {
		logger.debug("pass   "+pass);
		return pass.matches("^\\d{7}$");
	}

	public boolean isValidConfPass(String pass, String confPass) {
		boolean tt =pass.equals(confPass);
		return tt;
	}

	public boolean isValidUsers(String user) {
		UserManager userManager = new UserManager(SQLConstant.MYSQL);
		boolean tt = userManager.validUserExist(user);
		return tt;
	}
	/**
	 * @param context La instancia
	 * @param component El componente de la GUI que especifica el atributo "validator"
	 * @param value El valor a ser Verificado
	 * @return
	 */
	public void validate(FacesContext context, UIComponent component, Object value) {
		if (value instanceof String) {
			System.out.println("es un string");
		}
		logger.debug("El valor del componente a validar es: "+component.getId()+" y contiene:>>" + value.toString()+"<<");

		if ( component.getId().equalsIgnoreCase("distribuidorList")) { 
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Distribuidor")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Distribudor Valido")); 
				}	
		}else if ( component.getId().equalsIgnoreCase("selectAnalyticCompany")) { 
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una compañía")); 
			}
		}else if ( component.getId().equalsIgnoreCase("FormDate")) { 
			if (value.toString().equalsIgnoreCase("999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un periodo")); 
			}
		}else if ( component.getId().equalsIgnoreCase("selectCompanies")) { 
			if (value.toString().equalsIgnoreCase("999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo requerido. Seleccione una compañia")); 
			}		
		}else if ( component.getId().equalsIgnoreCase("denominacionList") || component.getId().equalsIgnoreCase("denomList") || component.getId().equalsIgnoreCase("denominacion")) { 
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo requerido. Seleccione una denominacion")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo requerido. Seleccione una denominacion valida")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("clientList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo requerido. Seleccione un cliente")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Cliente Valido")); 
				}
			/*} else if ( component.getId().equalsIgnoreCase("numerophone1") || component.getId().equalsIgnoreCase("numerophone1New")) {
			int j=0,i=0;
			boolean valid=false;
			while((value.toString().length()-1)>i){
				switch(i){
				case 4: 
					valid = value.toString().subSequence(i,i+1).equals("-")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 0: 
					valid = value.toString().subSequence(i,i+1).equals("0")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 1: case 2: case 3: case 5: case 6: case 7 : case 8: case 9: case 10: case 11:
					while(j<10){
						if(value.toString().subSequence(i, i+1).equals(""+j)){
							valid=true;
							j=10;
						}else{
							valid=false;
						}
						j++;
					}
					j=0;
					i=valid?i:value.toString().length();
					break;
				}
				i++;
			}
			if (value.toString().length()!=12 || (valid==false)){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Telefono es Requerido y Debe Estar en el Formato \"0212-1112233\"")); 
			}
			else
				if (value.toString().equals(null)){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Telefono es Requerido y Debe Estar en el Formato \"0212-1112233\"")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("numerophone2") || component.getId().equalsIgnoreCase("numerophone2New")) {
			int j=0,i=0;
			boolean valid=false;
			while((value.toString().length()-1)>i){
				switch(i){
				case 4: 
					valid = value.toString().subSequence(i,i+1).equals("-")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 0: 
					valid = value.toString().subSequence(i,i+1).equals("0")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 1: case 2: case 3: case 5: case 6: case 7 : case 8: case 9: case 10: case 11:
					while(j<10){
						if(value.toString().subSequence(i, i+1).equals(""+j)){
							valid=true;
							j=10;
						}else{
							valid=false;
						}
						j++;
					}
					j=0;
					i=valid?i:value.toString().length();
					break;

				}
				i++;
			}
			if (value.toString().length()!=12 || (valid==false)){
				throw new ValidatorException(new FacesMessage ("Error","  El Telefono  Debe Estar en el Formato \"0212-1112233\"")); 
			}
			else
				if (value.toString().equals(null)){
					throw new ValidatorException(new FacesMessage ("Error","  El Telefono  Debe Estar en el Formato \"0212-1112233\"")); 
				}	*/
		} else if ( component.getId().equalsIgnoreCase("Rif") || component.getId().equalsIgnoreCase("RifNew")) {
			int j=0,i=0;
			boolean valid=false;
			while((value.toString().length()-1)>i){
				logger.debug("entro en el while "+value.toString().subSequence(i, i+1));
				switch(i){
				case 0:
					if(value.toString().substring(i,i+1).equalsIgnoreCase("J") || value.toString().substring(i,i+1).equalsIgnoreCase("E") || value.toString().substring(i,i+1).equalsIgnoreCase("V") || value.toString().substring(i,i+1).equalsIgnoreCase("G")){
						valid=true;
					}else{
						valid=false;
						i=value.toString().length();
					}
					break;
				case 1: case 10:
					valid = value.toString().subSequence(i,i+1).equals("-")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 2: case 3: case 4: case 5: case 6: case 7 : case 8: case 9: case 11:
					while(j<10){
						if(value.toString().subSequence(i, i+1).equals(""+j)){
							valid=true;
							j=10;
						}else{
							valid=false;
						}
						j++;
					}
					j=0;
					i=valid?i:value.toString().length();
					break;

				}
				i++;
			}
			logger.debug("entro despues del while   "+valid );
			if (value.toString().length()!=12 || (valid==false)){
				logger.debug("entre a la condicion");
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Rif es Requerido y Debe Estar en el Formato \"J-31490722-0\"")); 
			}
			else
				if (value.toString().equals("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Rif es Requerido y Debe Estar en el Formato \"J-31490722-0\"")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("rif")) {
			int j=0,i=0;
			boolean valid=false;
			while((value.toString().length()-1)>i){
				logger.debug("entro en el while "+value.toString().subSequence(i, i+1));
				switch(i){
				case 0:
					if(value.toString().subSequence(i,i+1).equals("J") || value.toString().subSequence(i,i+1).equals("E") || value.toString().subSequence(i,i+1).equals("V") || value.toString().subSequence(i,i+1).equals("G")){
						valid=true;
					}else{
						valid=false;
						i=value.toString().length();
					}
					break;
				case 1: case 10:
					valid = value.toString().subSequence(i,i+1).equals("-")?true:false;
					i=valid?i:value.toString().length();
					break;
				case 2: case 3: case 4: case 5: case 6: case 7 : case 8: case 9: case 11:
					while(j<10){
						if(value.toString().subSequence(i, i+1).equals(""+j)){
							valid=true;
							j=10;
						}else{
							valid=false;
						}
						j++;
					}
					j=0;
					i=valid?i:value.toString().length();
					break;

				}
				i++;
			}
			logger.debug("entro despues del while   "+valid );
			if (value.toString().length()!=12 || (valid==false)){
				logger.debug("entre a la condicion");
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Rif es Requerido y Debe Estar en el Formato \"J-31490722-0\"")); 
			}
			else
				if (value.toString().equals("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Rif es Requerido y Debe Estar en el Formato \"J-31490722-0\"")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("rutaList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta Valida")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("rutaList2")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta Valida")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("rutaNewList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta Valida")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("depositList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Deposito")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ruta Valida")); 
				}	
		} else if ( component.getId().equalsIgnoreCase("selectStateNuevo") || component.getId().equalsIgnoreCase("selectState")  || component.getId().equalsIgnoreCase("selectStateNew")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Estado")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Estado")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectMunicipalityNuevo") ||  component.getId().equalsIgnoreCase("selectMunicipality")  ||  component.getId().equalsIgnoreCase("selectMunicipalityNew")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Municipio")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Municipio")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectCityNuevo")  || component.getId().equalsIgnoreCase("selectCity")   || component.getId().equalsIgnoreCase("selectCityNew")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ciudad")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Ciudad")); 
				}
		} else if ( component.getId().equalsIgnoreCase("nombrerutaNuevo")) {
			if (value.toString().equalsIgnoreCase("Nombre de la Ruta")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba un Nombre de Ruta")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba un Nombre de Ruta")); 
				}
		} else if ( component.getId().equalsIgnoreCase("name") ||  component.getId().equalsIgnoreCase("login")) {
			if (value.toString().equals("") || value.toString()==null){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba un Nombre")); 
			}
		} else if ( component.getId().equalsIgnoreCase("selectClientDetail") || component.getId().equalsIgnoreCase("selectClient")) {
			if (value.toString().equalsIgnoreCase("999") || value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Cliente")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Cliente")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectBillDetail")) {
			if (value.toString().equalsIgnoreCase("999") || value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Guía de Despacho")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Guía de Despacho")); 
				}
		} else if ( component.getId().equalsIgnoreCase("levelListNew")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Nivel de Acceso")); 
			}
			else
				if (value.toString().equalsIgnoreCase(null)){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Nivel de Acceso")); 
				}
		} else if ( component.getId().equalsIgnoreCase("levelList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Nivel de Acceso")); 
			}
			else
				if (value.toString().equalsIgnoreCase(null)){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Nivel de Acceso")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectIndustry") ||  component.getId().equalsIgnoreCase("selectIndustryNew")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Segmento es un campo requerido. Seleccione una industria")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Industria")); 
				}
		} else if ( component.getId().equalsIgnoreCase("nombrecalle")) {
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una Calle")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una Calle")); 
				}
		} else if ( component.getId().equalsIgnoreCase("numerophone1")) {
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba un Telefono")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba un Telefono")); 
				}
		} else if ( component.getId().equalsIgnoreCase("numeroTarjetasA") || component.getId().equalsIgnoreCase("numeroTarjetasB")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Rango de Tarjeta Valido")); 
			}
			else if (value.toString().equalsIgnoreCase("000")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Rango de Tarjeta Valido")); 
			}try{
				Integer.parseInt(value.toString());
			}catch (NumberFormatException e){
				logger.error("NumberFormatException ValidadorBean - validate - 1 ", e);
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Rango de Tarjeta Valido")); 
			}
		} else if ( component.getId().equalsIgnoreCase("bankList") || component.getId().equalsIgnoreCase("bankAuxList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Banco Válido")); 
			}
		} else if ( component.getId().equalsIgnoreCase("apDepositList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un estatus de deposito")); 
			}
		}else if ( component.getId().equalsIgnoreCase("companyList")) {
				if (value.toString().equalsIgnoreCase("999")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una compañia de servicio")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectDate") || component.getId().equalsIgnoreCase("selectAuxDate")) {
			if (value.toString().equalsIgnoreCase("DD/MM/YYYY")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Fecha Valida")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Fecha Valida")); 
				}
		} else if ( component.getId().equalsIgnoreCase("selectDateTo") || component.getId().equalsIgnoreCase("selectAuxDate")) {
			if (value.toString().equalsIgnoreCase("DD/MM/YYYY")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Fecha Valida")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Fecha Valida")); 
				}
		} else if ( component.getId().equalsIgnoreCase("Control")) {
			if (value.toString().equalsIgnoreCase("Ingrese Nro.Control")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Ingrese un Numero de Control")); 
			}
			else
				if (value.toString().equalsIgnoreCase("000")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Ingrese un Numero de Control")); 
				}
		} else if ( component.getId().equalsIgnoreCase("Monto") || component.getId().equalsIgnoreCase("MontoDepositoAjuste")) {
			try{
				if(Float.parseFloat(value.toString()) <= 0){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese un Monto Válido mayor a cero (0): Ejemplo: 123456.00"));
				}				
			}catch (NumberFormatException e){
				logger.error("NumberFormatException ValidadorBean - validate - 2 ", e);
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Monto Válido: Ejemplo: 123456.00")); 
			}
			if (value.toString().equalsIgnoreCase("Ingrese Monto del Deposito")){
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Monto Válido: Ejemplo: 123456.00"));
			}
			if (value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Monto Válido: Ejemplo: 123456.00"));
			}
		} else if ( component.getId().equalsIgnoreCase("Rafaga") || component.getId().equalsIgnoreCase("RafagaDepositoAjuste")) {
			if (value.toString().equalsIgnoreCase("Ingrese el Numero de Rafaga de Deposito")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Ingrese el Numero de Rafaga"));
			}
		} else if ( component.getId().equalsIgnoreCase("selectPromotion")) {
			if (value.toString().equalsIgnoreCase("999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione el Código de Promocion"));
			}
		} else if ( component.getId().equalsIgnoreCase("timePeriodList")) {
			if (value.toString().equalsIgnoreCase("999") || value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione una Unidad de Tiempo"));
			}
		}
		if ( component.getId().equalsIgnoreCase("confirmList")) {
			if (value.toString().equalsIgnoreCase("999") || value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione confirmacion"));
			}
		} else if ( component.getId().equalsIgnoreCase("consecutivoList")) {
			logger.debug("entro en el validor  "+(value==null || value.toString().length()==0));
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Inserte un Número de Consecutivo"));
			}
		} else if ( component.getId().equalsIgnoreCase("consecutivoListTo")) {
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Inserte un Número de Consecutivo"));
			}
		}
		if ( component.getId().equalsIgnoreCase("serialListTo")) {
			logger.debug("entro en el validor  "+(value==null || value.toString().length()==0));
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Inserte un Número de Serial"));
			}
		} else if ( component.getId().equalsIgnoreCase("statusList")  || component.getId().equalsIgnoreCase("FabricanteList")) {
			logger.debug("entra al if de validador statusList  ");
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo requerido. Seleccione un elemento de la lista"));
			}
		} else if ( component.getId().equals("totalcard")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","El campo Total es requerido.") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte \"Datos\" Validos, solo pueden ser números . "));
				}
			}
		} else if ( component.getId().equals("hastacard")  || component.getId().equalsIgnoreCase("hasta")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","El campo \"Hasta\" es requerido.") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte datos validos, solo pueden ser números . "));
				}
			}
		} else if ( component.getId().equals("desdecard") || component.getId().equalsIgnoreCase("desde")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","El campo \"Desde\" es requerido.") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte datos validos, solo pueden ser números. "));
				}
			}
		} 
		else if ( component.getId().equals("serialNumber")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","El campo \"Serial\" es requerido.") );
			else if(value.toString().length()!=16){
				throw new ValidatorException(new FacesMessage ("Error","El serial debe ser de 16 digitos.") );
			}else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches() || value.toString().length()!=16){
					throw new ValidatorException(new FacesMessage ("Error","Inserte un serial valido, solo pueden ser números. "));
				}
			}
		} 
		else if ( component.getId().equals("cantidad")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","El campo \"Cantidad\" es requerido.") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte Datos Validos, solo pueden ser números . "));
				}
			}
		} else if ( component.getId().equalsIgnoreCase("facialDesc")) {
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una Descripción del facial")); 
			}
		} else if ( component.getId().equalsIgnoreCase("fabricanteList")) {
			if (value.toString().equalsIgnoreCase("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Seleccione un Fabricante"));
			}
		} else if ( component.getId().equalsIgnoreCase("mail") || component.getId().equalsIgnoreCase("email") || component.getId().equalsIgnoreCase("mailNew") || component.getId().equalsIgnoreCase("emailNew")) {
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Inserte una Dirección de Correo Válida"));
			}else{
				Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese una Dirección de Correo Válida. e. g. nombre@dominio.com"));
				}
			}
		}else if (component.getId().equalsIgnoreCase("confEmail")) {
			if (value.toString().equals("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba la confirmación de contraseña")); 
			}else{
				Pattern email = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches())
					throw new ValidatorException(new FacesMessage ("Error","Ingrese una Dirección de Correo Válida. e. g. nombre@dominio.com"));

			}
		}else if ( component.getId().equalsIgnoreCase("RifNewL") || component.getId().equalsIgnoreCase("RifNewCI") || component.getId().equalsIgnoreCase("RifNewT")){
			if (component.getId().equalsIgnoreCase("RifNewCI")){
				Pattern email = Pattern.compile("(\\d+)");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El Rif es Requerido y Deben ser solo numeros"));					
				}
			}else if (component.getId().equalsIgnoreCase("RifNewT")){
				Pattern email = Pattern.compile("(\\d+)");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El terminal del Rif es Requerido y Deben ser solo numeros"));				
				}
			}
		} else if ( component.getId().equalsIgnoreCase("numerocode1New") || component.getId().equalsIgnoreCase("numerocode2New") || component.getId().equalsIgnoreCase("numerophone1New") || component.getId().equalsIgnoreCase("numerophone2New")){
			if (component.getId().equalsIgnoreCase("numerocode1New") || component.getId().equalsIgnoreCase("numerocode2New")){
				Pattern email = Pattern.compile("(\\d+)");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El codigo de area es Requerido y Deben ser solo numeros"));					
				}
			}else if (component.getId().equalsIgnoreCase("numerophone1New") || component.getId().equalsIgnoreCase("numerophone2New")){
				Pattern email = Pattern.compile("(\\d+)");
				//Pattern email = Pattern.compile("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+[.]{1}[a-zA-Z]{2,4}$/");
				Matcher fit = email.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. El numero de telefono es Requerido y Deben ser solo numeros"));				
				}
			}
		} else if ( component.getId().equals("Smartcard")) { //IS
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Cliente Válido ") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Cliente Válido "));
				}
			}
		} else if (component.getId().equalsIgnoreCase("passclienteNew")) {
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una contraseña")); 
			}else if(!isValidPassRegx(value.toString())){
				throw new ValidatorException(new FacesMessage ("Error"," La clave no cumple con el formato especificado.")); 
			}
		} else if(component.getId().equalsIgnoreCase("passclienteNewVE")){

			Pattern rep = Pattern.compile("(\\w)\\1{2}");
			Matcher fitr = rep.matcher(value.toString());
			Pattern num = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
			//("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
			Matcher fitn = num.matcher(value.toString());
			if (fitn.matches() || !fitr.matches()){
				throw new ValidatorException(new FacesMessage ("Error","La clave debe tener al menos una letra, un numero y un caracter especial, no puede contener caracteres repetidos 3 veces seguidos "));
			}
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una contraseña")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba una contraseña")); 
				}
		}else if (component.getId().equalsIgnoreCase("passcnfclienteNew")) {
			if (value.toString().equals("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba la confirmación de contraseña")); 
			}

		} else if ( component.getId().equals("cardEP")) {
			if ( value==null || (value.toString().length()!=15 && value.toString().length()!=16))
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Tarjeta Válido ") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Tarjeta Válido ") );
				}
			}
		} else if ( component.getId().equals("securityCode")) {
			if ( value==null || (value.toString().length()!=4 && value.toString().length()!=3))
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Seguridad Válido ") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese un Número de Seguridad Válido ") );
				}
			}
		} else if ( component.getId().equals("validThru")) {
			if ( value==null || value.toString().length()!=4)
				throw new ValidatorException(new FacesMessage ("Error","Ingrese una Fecha de Caducidad Válida ") );
			else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Ingrese una Fecha de Caducidad Válida ") );
				}
				else{
					int month = Integer.parseInt(value.toString().substring(0, 2));
					if (month<1 || month>12){
						throw new ValidatorException(new FacesMessage ("Error","Ingrese una Fecha de Caducidad Válida ") );
					}
				}
			}
		} else if ( component.getId().equals("cardHolderName")) {
			if ( value==null || value.toString().length()==0 )
				throw new ValidatorException(new FacesMessage ("Error","Ingrese el Nombre del Tarjetahabiente") );
		} else if ( component.getId().equalsIgnoreCase("cardHolderId")) {
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Inserte el número de Identificación del Tarjetahabiente"));
			}else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte un número de Identificación válido compuesto por solo numeros"));
				}
			}
		} else if ( component.getId().equalsIgnoreCase("cardHolderId")) {
			if (value==null || value.toString().length()==0){
				throw new ValidatorException(new FacesMessage ("Error","Inserte el número de Identificación del Tarjetahabiente"));
			}else{
				Pattern num = Pattern.compile("([0-9]*)");
				Matcher fit = num.matcher(value.toString());
				if (!fit.matches()){
					throw new ValidatorException(new FacesMessage ("Error","Inserte un número de Identificación válido"));
				}
			}
		} else if ( component.getId().equalsIgnoreCase("amount")) {
			try{
				Float.parseFloat(value.toString());
			}catch (NumberFormatException e){
				logger.error("NumberFormatException ValidadorBean - validate - 3 ", e);
				throw new ValidatorException(new FacesMessage ("Error","Ingrese un Monto Válido: Ejemplo: 123456.00")); 
			}
		} else if ( component.getId().equalsIgnoreCase("selectUserTerms")) {
			if (value==null || !(Boolean)value){
				throw new ValidatorException(new FacesMessage ("Error","Debe leer y aceptar los Términos y Condiciones de uso para poder registrarse"));
			}
		} else if ( component.getId().equalsIgnoreCase("selectUser")) {
			if (value.toString().equals("0")){
				throw new ValidatorException(new FacesMessage ("Error","Por favor seleccione un usuario"));
			}
		} else if ( component.getId().equalsIgnoreCase("selectUser")) {
			if (value.toString().equals("0")){
				throw new ValidatorException(new FacesMessage ("Error","Por favor seleccione un usuario"));
			}
		} else if ( component.getId().equalsIgnoreCase("channelList")) {
			if (value.toString().equals("9999")){
				throw new ValidatorException(new FacesMessage ("Error","Por favor seleccione un canal"));
			}	
		} else if ( component.getId().equalsIgnoreCase("clientContract")) {
			if (value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba número de Contrato del cliente")); 
			}
			else
				if (value.toString().equalsIgnoreCase("")){
					throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Escriba número de Contrato del cliente")); 
				}
		} else if (component.getId().equalsIgnoreCase("userName")) {
			if(value.toString() != null){
				for(int i=0; i<value.toString().length(); i++){
					if(Character.isWhitespace(value.toString().charAt(i))){
						throw new ValidatorException(new FacesMessage ("Error","El nombre de usuario no puede contener espacios."));
					}
				}
			}
		} else if ( component.getId().equalsIgnoreCase("pinNumber")) {
			if (value.toString().length()!=15 && value.toString().length()!=20){
				throw new ValidatorException(new FacesMessage ("Error","Introduzca pin valido "));
			}	
		} else { //Default case
			logger.debug("Entro en el default de ValidadorBean!!");
			if (value==null || value.toString().length()==0 || value.toString().equalsIgnoreCase("")){
				throw new ValidatorException(new FacesMessage ("Error","Campo Requerido. Introduzca un dato."));
			}
		}
	}
}
