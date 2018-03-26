package Clases_Auxiliares;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Evidencias {

	WebDriver driver = null;
	public static int i = 1;
	public static int j = 0;
	public static String tempNumCiclo = "0";

	public void eliminarImagenes(String Escenario) {
		MetodosApoyo apoyo = new MetodosApoyo();
		GestionArchivos archivo = new GestionArchivos();
		LeerProperties leer = new LeerProperties();
		String nombreCarpetaEvidencia = apoyo.setNombreCarpeta(Escenario);
		File directory = new File(leer.obtenerUrlEvidencias() + "Ciclo" + "_" + leer.obtenerUrlNumCiclo() + "_"
				+ nombreCarpetaEvidencia + "\\" + "img");
		archivo.borrarArchivosDirectorio(directory);
	}

	public void capturarFotoPantalla(String imageName, WebDriver driver, String Escenario) throws IOException {
		MetodosApoyo apoyo = new MetodosApoyo();
		LeerProperties leer = new LeerProperties();
		String nombreCarpetaEvidencia = apoyo.setNombreCarpeta(Escenario);
		if (j == 0) {
			tempNumCiclo = leer.obtenerUrlNumCiclo();
			j++;
		}

		File directory = new File(leer.obtenerUrlEvidencias() + "Ciclo" + "_" + tempNumCiclo + "_"
				+ nombreCarpetaEvidencia + "\\" + "img");
		try {
			if (!directory.exists()) {
				directory.mkdirs();

				/*
				 * Considero que el método "leer.actualizarCiclo();" no debería ir aquí porque
				 * cada que se crea una nueva carpeta, se genera un nuevo ciclo. Esto genera un
				 * inconveniente en la ejecución de los ciclos porque un ciclo puede tener
				 * varios escenarios, y por ende, se van a crear varias carpetas pertenecientes
				 * al mismo ciclo, pero cuando realmente se quiere ejecutar otro ciclo, la
				 * propiedad ya ha aumentado una cantidad considerable de veces Nota: por tal
				 * motivo se comentarea la siguiente línea de código
				 */
				// leer.actualizarCiclo();
			}
			String nomVar = apoyo.setNombreArchivo();

			if (directory.isDirectory()) {
				File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(imagen,
						new File(directory.getAbsoluteFile() + "\\" + imageName + i + "_" + nomVar + ".png"));
				i = i + 1;
			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}
	}

}
