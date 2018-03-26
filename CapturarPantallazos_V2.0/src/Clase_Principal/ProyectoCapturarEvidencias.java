package Clase_Principal;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Clases_Auxiliares.Evidencias;
import Clases_Auxiliares.LeerProperties;

public class ProyectoCapturarEvidencias 
{
	// Variable Global o "Estática" webDriver
	public static WebDriver webDriver = null;

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		LeerProperties leer = new LeerProperties();
		Evidencias evd = new Evidencias();

		// Ejecutar un browser aquí
		EjecutarBrowser("https://www.wikipedia.org/");

		/* Capturo muchos pantallazos para distintos escenarios, con el fin de que se generen las carpetas correspondientes*/
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO1");
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO1");
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO2");
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO2");
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO3");
		evd.capturarFotoPantalla("Evidencia", webDriver, "ESCENARIO3");
		
		/* Se procede a eliminar las evidencias de una carpeta específica, en este caso, las que pertenezcan al escenario3 del ciclo actual */
		evd.eliminarImagenes("ESCENARIO3");
		
		/* Se procede a actualizar el ciclo al final del programa para que esté organizado en una siguiente ejecución */
		leer.actualizarCiclo();
	}

	public static void EjecutarBrowser(String URL) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "Jars y Drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();

		Thread.sleep(1000);

		webDriver.get(URL);

		Thread.sleep(1000);
	}

}
