package validarExistenciaDePopUps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidarExistenciaDePopUps 
{
	//Variable Global o "Estática" webDriver
	public static WebDriver webDriver = null;
	
	public static void main(String[] args) throws InterruptedException 
	{
		/* Este métod principal lo que hace es invocar otros métodos que validan de una alerta o "Pop Up" está abierta 
		 * para proceder a cerrarla y continuar. */
		
		boolean AlertaExiste;        
		String URL = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
		
		EjecutarBrowser(URL);

		// Procedo a abrir una alerta de la página automatizada
		OpenSimpleAlertPopUp();
		
		//Invocando este método ÚNICAMENTE se valida si la alerta efectivamente existe o no (Recibiendo un valor booleano true o false como respuesta).
		AlertaExiste = isAlertPresent();
		
		// En caso de que la alerta SI exista, se procede a invocar el método "clásico" de cerrar alertas
		if(AlertaExiste)
		{
			CerrarAlerta("Aceptar");
		}
		
		// Se procede a abrir otro tipo de alerta para posteriormente cerrarla con otro método.
		OpenConfirmAlertBox();
		
		// Se usa este método para cerrar la alerta porque estamos 100% seguros que la alerta aparecerá (si no aparece la alerta, el programa fallaría).
		CerrarAlerta("Cancelar");
		
		// Se procede a abrir otro tipo de alerta para posteriormente cerrarla con otro método.
		OpenPromptAlertBox();
		
		// Este método cierra una alerta SI ESTA EXISTE, en caso de que NO EXISTA LA ALERTA no hace nada y la ejecución del programa continúa
		CerrarAlertaSiExiste();
		
		System.out.println("Si llega hasta acá, significa que el programa no falló");
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
	
	/* El método "CerrarAlertaSiExiste()" intenta cerrar una alerta (que aún no sabemos si existe o no existe) 
	 * y en caso de que la alerta que se intenta cerrar no exista, controla la excepción para que el programa 
	 * no falle en tiempo de ejecución. */
	public static void CerrarAlertaSiExiste() 
	{ 
	    try 
	    { 
	    	Alert alert = webDriver.switchTo().alert();
	    	alert.accept(); 

	    	System.out.println("La alerta SI existía: Escribir en el log de auditoría");
	    } 
	    catch (NoAlertPresentException e) 
	    { 
	    	System.out.println("La alerta NO existía: Escribir en el log de auditoría");
	    }
	}  
	
	/* El método "CerrarAlerta(String Respuesta)" intenta cerrar una alerta de la cual estamos seguros que existe
	 * 
	 * Nota: YO prefiero usar el método "CerrarAlertaSiExiste()" porque si controla la excepción y no falla en tiempo de ejecución */
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
	
	/* El método "isAlertPresent()" realiza la validación en el "webDriver" que se encuentra en ejecución para verificar si existe una alerta o "Pop Up" abierta. 
	 * Esté método retorna como respuesta un valor booleano (true o false) para confirmar o negar la existencia de la alerta. */
	public static boolean isAlertPresent()
	{
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(webDriver, 0 /*timeout in seconds*/);
	    
	    try 
	    {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } 
	    catch (TimeoutException e) 
	    {
	        foundAlert = false;
	    }
	    
	    return foundAlert;
	}
}
