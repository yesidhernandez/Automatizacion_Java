package PaquetePrincipal;

//import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ManipulacionObjetos.GestorAdjuntos;

/*
 * Con este ejemplo de clase se está adjuntando un archivo llamado "DataPrueba.xlsx" que existe en las rutas
 * "D:\\AUTOESTUDIO\\AUTOMATIZACIÓN\\PRACTICAS\\AdjuntarArchivos\\Adjuntar Archivo\\DataPrueba.xlsx" o "C:\\DataPrueba.xlsx" 
 *  en el formulario existente en la página "http://toolsqa.com/automation-practice-form/". La lógica de adjuntar el archivo se encuentra en la clase GestorAdjuntos.java 
 *  y cabe aclarar que es útil cuando al momento de adjuntar se abre una ventana de windows (Nota: se puede adjuntar cualquier tipo de archivo).
*/
public class AdjuntarArchivosSelenium
{
	//Variable Global o "Estática" webDriver
	public static WebDriver webDriver = null;

	public static void main(String[] args) throws InterruptedException 
	{
		String URL = "http://toolsqa.com/automation-practice-form/";
		
		EjecutarBrowser(URL);
		
		Thread.sleep(1000);
		
		webDriver.findElement(By.id("photo")).click();
		
		Thread.sleep(250);
		
		//String path = "C:"+File.separator+"DataPrueba.xlsx";
		
		String path = "D:\\AUTOESTUDIO\\AUTOMATIZACIÓN\\PRACTICAS\\AdjuntarArchivos\\Adjuntar Archivo\\DataPrueba.xlsx";
		
		//Esta clase permite cargar cualquier tipo de adjunto mientras se le mande la ruta completa
		GestorAdjuntos.CargarArchivoDeWindows(path);
		
	}
	
	public static void EjecutarBrowser(String URL) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","Jars y Drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		webDriver.get(URL);
		
		Thread.sleep(1000);
	}

}
