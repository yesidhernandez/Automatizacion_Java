package Clases_Auxiliares;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeerProperties {
	String RUTA_ARCHIVO_PROPERTIES="C:\\Users\\Yesid\\Documents\\Q-VISION\\Automatización\\ProyectosSelenium\\CapturarPantallazos_Maven\\configuracion.properties";
	String URL_APLICACION ="url.aplicacion";
	String URL_EVIDENCIAS ="url.evidencias";
	String URL_NUMCICLO="evidencia.ciclo";
	
	private Properties iniciarProperties() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(RUTA_ARCHIVO_PROPERTIES);
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return prop;
	}
	
	public String obtenerUrlAplicacion(){
		Properties prop= iniciarProperties();
		return prop.getProperty(URL_APLICACION);
	}
	
	public String obtenerUrlEvidencias(){
		Properties prop= iniciarProperties();
		return prop.getProperty(URL_EVIDENCIAS);
	}
	
	public String obtenerUrlNumCiclo(){
		Properties prop= iniciarProperties();
		return prop.getProperty(URL_NUMCICLO);
	}
	
	public void actualizarCiclo() throws IOException {
		try {
		Properties prop= iniciarProperties();
		String numCiclo=prop.getProperty(URL_NUMCICLO);
		int valor0=Integer.parseInt(numCiclo)+1;
		String valor1= Integer.toString(valor0);
		prop.setProperty(URL_NUMCICLO, valor1);
		FileWriter fos = new FileWriter(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
		prop.store(fos,null);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
