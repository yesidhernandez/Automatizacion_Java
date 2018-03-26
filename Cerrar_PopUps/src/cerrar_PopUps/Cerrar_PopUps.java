package cerrar_PopUps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cerrar_PopUps 
{
	//Variable Global o "Estática" webDriver
	public static WebDriver webDriver = null;

	public static void main(String[] args) throws InterruptedException 
	{
		String URL = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
		
		EjecutarBrowser(URL);
		
		OpenSimpleAlertPopUp();
		
		CerrarAlerta("Aceptar");
		
		OpenConfirmAlertBox();
		
		CerrarAlerta("Cancelar");
		
		OpenPromptAlertBox();
		
		CerrarAlerta("Aceptar");
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
	
	public static void CerrarAlerta(String Respuesta) throws InterruptedException
	{
		Alert alert = webDriver.switchTo().alert();
		
		if (Respuesta.equals("Cancelar")) 
		{
			alert.dismiss();
		}
		else
		{
			alert.accept();
		}
		
		Thread.sleep(1000);	
	}

	public static void OpenSimpleAlertPopUp() throws InterruptedException
	{
		webDriver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")).click();
		
		Thread.sleep(1000);
	}
	
	public static void OpenConfirmAlertBox() throws InterruptedException
	{
		JavascriptExecutor ejecutorJSP = (JavascriptExecutor) webDriver;
		ejecutorJSP.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@id=\"content\"]/p[8]/button")));
		
		Thread.sleep(1000);
	}
	
	public static void OpenPromptAlertBox() throws InterruptedException
	{
		JavascriptExecutor ejecutorJSP = (JavascriptExecutor) webDriver;
		ejecutorJSP.executeScript("arguments[0].click();", webDriver.findElement(By.xpath("//*[@id=\"content\"]/p[11]/button")));
		
		Thread.sleep(1000);
	}
	
	
}
