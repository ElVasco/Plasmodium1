package ve.com.plasmodium.listener; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class StartupListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger (StartupListener.class);

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute("cuentasContablesTo");
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();

		final String prefix =  servletContext.getRealPath(File.separator);
		final String logInt = servletContext.getInitParameter("log4jConfigLocation");
		final String as400Int = servletContext.getInitParameter("simdeConfigLocation");

		// Obtiene archivo de propiedades de log4j

		if((logInt != null) & (new File(prefix+logInt).exists())) {
			PropertyConfigurator.configure(prefix+logInt);
			logger.info("Encontrado archivo de propiedades log4j" );
		}
		else{
			BasicConfigurator.configure();
			logger.fatal("No encontrado archivo de propiedades log4j. Se utilizara configuracion basica");
		}

		if((as400Int != null) & (new File(prefix+as400Int).exists())) {
			logger.info("Encontrado archivo de propiedades de SIMDE");
		}
		else{
			logger.fatal("NO encontrado archivo de propiedades de SIMDE");
			System.exit(99); // Evita que se inicie la aplicacion
		}


		try {

		} catch (Exception e) {
			logger.error("Exception StartupListener - contextInitialized ", e);
		}
	}






	/**
	 * Pone los valores del System Usuario y Clave de para acceso de DB2 en AS400
	 * 
	 * Los valores los pondra en el beam y en el system properies de la aplicacion
	 * 
	 * 
	 */
	public void loadProperties(String as400ConfigFile, ServletContext servletContext  ){

		logger.info("Cargando archivo de propiedades para SIMDE ");
		//		 VALIDO UNA VES INICIADA APLICACION JSF NO DESDE UN LISTENER FacesContext facesContext = FacesContext.getCurrentInstance();

		Properties props = new Properties();
		// VALIDO UNA VES INICIADA APLICACION JSF NO DESDE UN LISTENER InputStream in = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/WEB-INF/config/novared.properties");



		try {
			InputStream in = servletContext.getResourceAsStream(as400ConfigFile);
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException StartupListener - loadProperties ", e);
		} catch (IOException e) {
			logger.error("IOException StartupListener - loadProperties ", e);
		}
	}


}
