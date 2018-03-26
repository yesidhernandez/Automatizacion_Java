package Clases_Auxiliares;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class GestionArchivos {
	private  String rutaArchivos = "c:\\temp\\";
	
	public String getRutaArchivos() {
		return rutaArchivos;
	}

	private void validarDirectorioArchivos() {
		File directorioJmeter = new File(rutaArchivos + "jmeter");
		File directorioConsulta = new File(rutaArchivos + "DatosConsulta");
		File directorioEvidencias = new File(rutaArchivos + "evidencias");
		if (!directorioJmeter.exists()) {
			directorioJmeter.mkdirs();
		}
		if (!directorioConsulta.exists()) {
			directorioConsulta.mkdirs();
		}
		if (!directorioEvidencias.exists()) {
			directorioEvidencias.mkdirs();
		}
	}
	
	public void borrarArchivosExistentes(){
		File directorioJmeter = new File(rutaArchivos + "jmeter");
		File directorioConsulta = new File(rutaArchivos + "DatosConsulta");
		borrarArchivosDirectorio(directorioJmeter);
		borrarArchivosDirectorio(directorioConsulta);
	}

	
	public void borrarEvidenciasExistentes(){
		File directorioEvidencias = new File(rutaArchivos + "evidencias");;
		borrarArchivosDirectorio(directorioEvidencias);
	}
	
	
	public boolean borrarArchivosDirectorio(File dir) {  
	    File[] children = dir.listFiles();  
	    boolean childrenDeleted = true;  
	    for (int i = 0; children != null && i < children.length; i++) {  
	        File child = children[i];  
	        if (child.isDirectory()) {  
	            childrenDeleted = this.borrarArchivosDirectorio(child) && childrenDeleted;  
	        }  
	        if (child.exists()) {  
	            childrenDeleted = child.delete() && childrenDeleted;  
	        }  
	    }  
	    return childrenDeleted;  
	}  
	
	

	public void escribirArchivo(String nombreArchivo, String datos) {
		validarDirectorioArchivos();
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(rutaArchivos + "DatosConsulta\\"+nombreArchivo);
			pw = new PrintWriter(fichero);
			pw.print(datos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void escribirArchivo(String nombreArchivo, String datos, String ruta) {
		validarDirectorioArchivos();
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(rutaArchivos + ruta +nombreArchivo);
			pw = new PrintWriter(fichero);
			pw.print(datos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void escribirArchivoConservandoExistente(String nombreArchivo, String datos, String ruta) {
		datos = datos.concat("\n");
		validarDirectorioArchivos();
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(ruta +nombreArchivo,true);
			pw = new PrintWriter(fichero);
			pw.print(datos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

	public String[] leerArchivo(String nombreArchivo) {
		validarDirectorioArchivos();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea="";
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(rutaArchivos + "jmeter/" + nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			
			//while ((linea = br.readLine()) != null) {	
			linea = br.readLine();
			
			//}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		String [] auxiliar=linea.split("\\n");
		
		return auxiliar;

	}
	
	public String[] leerArchivo(String nombreArchivo, String ruta) {
		validarDirectorioArchivos();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea="";
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(rutaArchivos + ruta + nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			
			//while ((linea = br.readLine()) != null) {	
			linea = br.readLine();
			

			//}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		String [] auxiliar=linea.split(";");
		
		return auxiliar;

	}
	
	public ArrayList<String> leerVariasLineasArchivo(String nombreArchivo, String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea="";
		ArrayList<String> registros= new ArrayList<>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(rutaArchivos + ruta + nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			
			while ((linea = br.readLine()) != null) {
				registros.add(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//String [] auxiliar=linea.split(";");
		
		return registros;

	}
	
	public void borrarArchivo(String nombreArchivo, String ruta) {
		File archivo = null;
		FileReader fr = null;
		try {
			archivo = new File(rutaArchivos + ruta + nombreArchivo);
			archivo.delete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void copiarArchivo(String archivo, String rutaorigen, String rutaDestino) throws IOException{
		File ficheroCopiar = new File(rutaorigen, archivo);
	    File ficheroDestino = new File(rutaDestino, archivo);
	    Files.copy(Paths.get(ficheroCopiar.getAbsolutePath()), Paths.get(ficheroDestino.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
	}
	
	
}
