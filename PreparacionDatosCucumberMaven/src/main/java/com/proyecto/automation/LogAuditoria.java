package com.proyecto.automation;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogAuditoria {
	
	private static Logger log = Logger.getLogger(LogAuditoria.class.getName());
	
	public static void iniciarCasoPrueba () {
		DOMConfigurator.configure("log4j.xml");
		log.info("*********************************************************************");
		log.info("*********************************************************************");
		log.info("******************** Inició el caso de prueba ***********************");
		log.info("*********************************************************************");
		log.info("*********************************************************************");
	}
	
	public static void finalizarCasosPrueba() {
		log.info("*********************************************************************");
		log.info("*********************************************************************");
		log.info("******************* Finalizó el caso de prueba **********************");
		log.info("*********************************************************************");
		log.info("*********************************************************************");

	}
	
	public static void error (String message) {
		log.error(message);
	}
	
	public static void info (String message) {
		log.info(message);
	}
	
	public static void warn (String message) {
		log.warn(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}

}
