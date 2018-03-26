package UsarPropiedades;

import java.io.IOException;

import propiedades.LeerProperties;

public class usarProperties 
{

	public static void main(String[] args) throws IOException 
	{
		String Ruta_Proyecto;
		String Usuario_BD;
		String Contrasena_BD;
		String Ruta_Evidencias;
		String Url_Aplicacion;
		
		LeerProperties Leer = new LeerProperties();
		
		/* LAS SIGIENTES SON INVOCACIONES DE MÉTODOS "getProperty" O DE LECTURA DE PROPIEDADES */
		
		Ruta_Proyecto = Leer.obtenerRutaProyecto();		
		Usuario_BD = Leer.obtenerUsuarioBD();	
		Contrasena_BD = Leer.obtenerContrasenaBD();		
		Ruta_Evidencias = Leer.obtenerRutaEvidencias();	
		Url_Aplicacion = Leer.obtenerUrlAplicacion();

		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("-------------------------- Valores guardados en variables ------------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(Ruta_Proyecto);
		System.out.println(Usuario_BD);
		System.out.println(Contrasena_BD);
		System.out.println(Ruta_Evidencias);
		System.out.println(Url_Aplicacion);
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("-------------------------- Métodos llamados directamente -------------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println(Leer.obtenerRutaProyecto());
		System.out.println(Leer.obtenerUsuarioBD());
		System.out.println(Leer.obtenerContrasenaBD());
		System.out.println(Leer.obtenerRutaEvidencias());
		System.out.println(Leer.obtenerUrlAplicacion());
		
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("----------------------- PROPIEDADES DEL ARCHIVO .PROPERTIES ----------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		
		Leer.ObtenerTodasLasPropiedades();    //Método para obtener todas las propiedades del archivo .properties
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		
		
		
		/* LAS SIGIENTES SON INVOCACIONES DE MÉTODOS "setProperty" O DE LECTURA DE PROPIEDADES */
		
		/* El método actualizarCiclo funciona muy bien pero decido comentarearlo porque el FileOutputStream con el que 
		 * guardamos los cambios genera problemas para los datos del archivo .properties que tienen tildes */
		//Leer.actualizarCiclo();
		
		Leer.actualizarUsuarioBD();
		
		Leer.actualizarContrasenaBD();
		
		Leer.actualizarUrlAplicacion();
		
		Leer.actualizarRutaEvidencias();
		
		/* LAS SIGUIENTES LÍNEAS DE CÓDIGO YA NO TIENEN QUE VER EL TEMA DE PROPIEDADES DEL PROYECTO, PERO
		 * PARA NO HACER UN PROYECTO NUEVO, SE INDICA LA FORMA EN LA QUE SE OBTIENE LA UBICACIÓN DEL PROYECTO */
		
		// la línea de código System.getProperty("user.dir"); retorna el workspace o location del proyecto 
		
		System.out.println("Ruta del proyecto extraída con propiedad user.dir");
		
		//Forma 1 de visualizar la ruta de mi proyecto
		System.out.println(System.getProperty("user.dir"));
		
		//Forma 2 de visualizar y usar como una variable la ruta de mi proyecto
		String ProjectLocation = System.getProperty("user.dir");
		System.out.println(ProjectLocation);
			
	}

}
