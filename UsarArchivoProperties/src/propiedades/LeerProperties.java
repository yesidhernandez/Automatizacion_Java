package propiedades;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class LeerProperties {
	String RUTA_ARCHIVO_PROPERTIES = "D:\\AUTOESTUDIO\\AUTOMATIZACI�N\\PRACTICAS\\UsarArchivoProperties\\configuracion.properties";	
	String PROJECT_LOCATION = "ruta.ProjectLocation";
	String USUARIO_BD = "login.usuarioBD";
	String CONTRASENA_BD = "login.contrasenaBD";
	String RUTA_EVIDENCIAS = "ruta.evidencias";
	String URL_APLICACION = "url.aplicacion";
	String URL_NUMCICLO="evidencia.ciclo";

	
	private Properties iniciarProperties() 
	{
		Properties prop = new Properties();
		InputStream is = null;

		try 
		{
			is = new FileInputStream(RUTA_ARCHIVO_PROPERTIES);
			prop.load(is);
		} 
		catch (IOException e) 
		{
			System.out.println(e.toString());
		}
		
		return prop;
	}
	
	public String obtenerRutaProyecto()
	{
		Properties prop= iniciarProperties();
		return prop.getProperty(PROJECT_LOCATION);
	}
	
	public String obtenerUsuarioBD()
	{
		Properties prop= iniciarProperties();
		return prop.getProperty(USUARIO_BD);
	}
	
	public String obtenerContrasenaBD()
	{
		Properties prop= iniciarProperties();
		return prop.getProperty(CONTRASENA_BD);
	}
	
	public String obtenerRutaEvidencias()
	{
		Properties prop= iniciarProperties();
		return prop.getProperty(RUTA_EVIDENCIAS);
	}
	
	public String obtenerUrlAplicacion()
	{
		Properties prop= iniciarProperties();
		return prop.getProperty(URL_APLICACION);
	}
	
	//M�todo con el cual se pueden listar todas las propiedades existentes en el archivo .properties
	public void ObtenerTodasLasPropiedades()
	{
		Properties prop= iniciarProperties();
		Enumeration<Object> keys = prop.keys();
	
		while (keys.hasMoreElements())
		{
		   Object key = keys.nextElement();
		   System.out.println(key + " = "+ prop.get(key));
		}
	}
	
	// M�todo para actualizar el valor del ciclo (SET)
	public void actualizarCiclo() throws IOException
	{
		try 
		{
			Properties prop= iniciarProperties();
			String numCiclo=prop.getProperty(URL_NUMCICLO);
			int valor0=Integer.parseInt(numCiclo)+1;
			String valor1= Integer.toString(valor0);
			prop.setProperty(URL_NUMCICLO, valor1);
			
			/* En mi m�quina no es muy recomendable el FileOutputStream para modificar las propiedades 
			 * porque actualiza las tildes de todos los valores de las propiedades a "valores UNICODE". */
			FileOutputStream fos = new FileOutputStream(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
			prop.store(fos,null);
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	//As� se actualiza un par�metro existente en el archivo .PROPERTIES
	public void actualizarUsuarioBD() throws IOException 
	{
		try 
		{
			//Se crea el objeto prop para inicializar el archivo .properties
			Properties prop= iniciarProperties();

			//Coloco el valor a actualizar ya sea en una nueva variable o como segundo par�metro del m�todo 
			// "setProperty" y si es necesario, se usa l�gica como en el m�todo actualizarCiclo
			
			prop.setProperty(USUARIO_BD, "system");
			
			
			/* Para guardar los cambios, debemos llamar al m�tod store() pas�ndole un OutputStream o un Writer de java. En el siguiente trozo de c�digo pasamos un Writer 
			 * (YO RECOMIENDO PASAR UN Writer porque el OutputStream me genera un problema con las tildes existentes en el archivo .properties)
			 * 
			 * El m�todo store() admite un segundo par�metro que es un comentario que se a�adir� como una l�nea de cabecera en el fichero. */
			
			FileWriter fos = new FileWriter(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
			prop.store(fos,"Ac� se agrega un comentario en el archivo");
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	//As� se actualiza un par�metro existente en el archivo .PROPERTIES
	public void actualizarContrasenaBD() throws IOException 
	{
		try 
		{
			//Se crea el objeto prop para inicializar el archivo .properties
			Properties prop= iniciarProperties();

			//Coloco el valor a actualizar ya sea en una nueva variable o como segundo par�metro del m�todo 
			// "setProperty" y si es necesario, se usa l�gica como en el m�todo actualizarCiclo
			
			String NuevaContrasena= "Welcome1";
			prop.setProperty(CONTRASENA_BD, NuevaContrasena);
			
			
			/* Para guardar los cambios, debemos llamar al m�tod store() pas�ndole un OutputStream o un Writer de java. En el siguiente trozo de c�digo pasamos un Writer 
			 * (YO RECOMIENDO PASAR UN Writer porque el OutputStream me genera un problema con las tildes existentes en el archivo .properties)
			 * 
			 * El m�todo store() admite un segundo par�metro que es un comentario que se a�adir� como una l�nea de cabecera en el fichero. */
			
			FileWriter fos = new FileWriter(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
			prop.store(fos,"Este segundo par�metro es un comentario que si queremos lo dejamos null");
		
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	//As� quedar�a un setProperty sin tanto comentario
	public void actualizarUrlAplicacion() throws IOException 
	{
		try 
		{
			Properties prop= iniciarProperties();

			String NuevaUrl= "http://www.google.com";
			prop.setProperty(URL_APLICACION, NuevaUrl);
			FileWriter fos = new FileWriter(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
			prop.store(fos,null);		
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void actualizarRutaEvidencias() throws IOException 
	{
		try 
		{
			Properties prop= iniciarProperties();

			String NuevaRutaEvidencias= "D:\\AUTOESTUDIO\\AUTOMATIZACI�N\\PRACTICAS\\UsarArchivoProperties\\Evidencias";		
			prop.setProperty(RUTA_EVIDENCIAS, NuevaRutaEvidencias);
			FileWriter fos = new FileWriter(RUTA_ARCHIVO_PROPERTIES.replace("\\", "/"));
			prop.store(fos,null);		
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	

}
