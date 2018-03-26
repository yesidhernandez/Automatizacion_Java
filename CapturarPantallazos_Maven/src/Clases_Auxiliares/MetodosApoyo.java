package Clases_Auxiliares;

//import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.cucumber.listener.Reporter;

public class MetodosApoyo {

	WebDriver driver = null;
	public static String numRadicado = "80114";
	private static String resulDomicilio = null;
	private static String resulFechaNacimiento = null;
	private static String resulGenero = null;
	private static String resulEstadoCivil = null;
	private static int FECHA_ACTUAL_ANIO = 0;
	private static int FECHA_ACTUAL_MES = 1;
	private static int FECHA_ACTUAL_DIA = 2;
	private static int FECHA_ACTUAL_HORA = 3;
	private static int FECHA_ACTUAL_MINUTO = 4;
	private static int FECHA_ACTUAL_SEGUNDO = 5;
	private String nombre_carpeta;
	private String aplicacion;
	private int contador = 1;
	public static int i = 0;
	String objEsperaFosfec = "loadingLogo";
	private final int TIMEOUT = 10;

	public void finalizarPrueba(WebDriver driver) {
		driver.close();
		driver.quit();
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String subdividirCadenaDomicilio(String cadena) {

		Pattern patron = Pattern.compile("<domicilio>(.*?)</localidad>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			System.out.println(cadena);
			Pattern patron1 = Pattern.compile("<domicilio>(.*?)</domicilio>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulDomicilio = equi1.group(1);
			}
		}
		return resulDomicilio;
	}

	public String subdividirFechaNacimiento(String cadena) {

		Pattern patron = Pattern.compile("<demografia>(.*?)</demografia>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			System.out.println(cadena);
			Pattern patron1 = Pattern.compile("<nacimientoFecha>(.*?)</nacimientoFecha>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulFechaNacimiento = equi1.group(1);
			}
		}
		return resulFechaNacimiento;
	}

	public String subdividirGenero(String cadena) {

		Pattern patron = Pattern.compile("<demografia>(.*?)</demografia>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			System.out.println(cadena);
			Pattern patron1 = Pattern.compile("<genero>(.*?)</genero>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulGenero = equi1.group(1);
			}
		}
		return resulGenero;
	}

	public String subdividirEstadoCivil(String cadena) {

		Pattern patron = Pattern.compile("<demografia>(.*?)</demografia>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			System.out.println(cadena);
			Pattern patron1 = Pattern.compile("<estadoCivil>(.*?)</estadoCivil>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulEstadoCivil = equi1.group(1);
			}
		}
		return resulEstadoCivil;
	}

	public String subdividirCadenaTelefono(String cadena) {

		Pattern patron = Pattern.compile("<telefono>(.*?)<domicilio>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			Pattern patron1 = Pattern.compile("<telefono>(.*?)</telefono>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulDomicilio = equi1.group(1);
			}
		}
		return resulDomicilio;
	}

	public String subdividirCadenaCiudad(String cadena) {

		Pattern patron = Pattern.compile("<domicilio>(.*?)</localidad>");
		Matcher equi = patron.matcher(cadena);
		if (equi.find()) {
			cadena = equi.group(1);
			System.out.println(cadena);
			Pattern patron1 = Pattern.compile("<nombre>(.*?)</nombre>");
			Matcher equi1 = patron1.matcher(cadena);
			if (equi1.find()) {
				resulDomicilio = equi1.group(1);
			}
		}
		return resulDomicilio;
	}

	public String cambiarGenero(String genero) {

		switch (genero) {
		case "M":
			genero = "MASCULINO";
			break;
		case "F":
			genero = "FEMENINO";
			break;
		}
		return genero;

	}

	public String cambiarEstadoCivil(String estado) {

		switch (estado) {
		case "SO":
			estado = "SOLTERO";
			break;
		case "CA":
			estado = "CASADO";
			break;
		case "UL":
			estado = "UNI�N LIBRE";
			break;
		}
		return estado;

	}

	public String cambiarTipoDocumento(String documento) {

		switch (documento) {
		case "CÉDULA DE CIUDADANÍA":
			documento = "1";
			break;
		case "NIT":
			documento = "2";
			break;
		}
		return documento;

	}

	public String formatearFecha(String fecha) throws ParseException {

		String date_s = fecha;
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
		Date date = dt.parse(date_s);
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		String fechaValidar = dt1.format(date);
		System.out.println(dt1.format(date));
		return fechaValidar;

	}

	public boolean elementoPresente(WebElement element) {
		boolean aux = false;
		aux = element.isDisplayed();
		return aux;
	}

	public void consolidarEvidencia(String Escenario) throws IOException {
		//int i;
		//LeerProperties leer = new LeerProperties();
		//String path = leer.obtenerUrlEvidencias() + "Ciclo" + "_" + Evidencias.tempNumCiclo + "_"
		//		+ setNombreCarpeta(Escenario) + "\\" + "img";
		//File fichero = new File(path);
		//String[] listaArchivos = fichero.list();
		//int numArchivos = listaArchivos.length;
		//for (i = 1; i <= numArchivos; i++) {
			//String ruta = path + "\\" + "Evidencia" + i + "_" + setNombreArchivo();
			//Reporter.addScreenCaptureFromPath(ruta + ".png");
		//}
	}

	public int[] getfechaHoySeparada() {
		Calendar cal = Calendar.getInstance();
		int[] resultado = new int[6];
		resultado[FECHA_ACTUAL_ANIO] = cal.get(Calendar.YEAR);
		resultado[FECHA_ACTUAL_MES] = (cal.get(Calendar.MONTH)) + 1;
		resultado[FECHA_ACTUAL_DIA] = cal.get(Calendar.DATE);
		resultado[FECHA_ACTUAL_HORA] = cal.get(Calendar.HOUR);
		resultado[FECHA_ACTUAL_MINUTO] = cal.get(Calendar.MINUTE);
		resultado[FECHA_ACTUAL_SEGUNDO] = cal.get(Calendar.SECOND);
		return resultado;
	}

	public void carpera(String carpeta) {
		int[] resultado = getfechaHoySeparada();
		nombre_carpeta = carpeta + "-" + resultado[FECHA_ACTUAL_ANIO] + "-" + resultado[FECHA_ACTUAL_MES] + "-"
				+ resultado[FECHA_ACTUAL_DIA] + "T" + resultado[FECHA_ACTUAL_HORA] + "-"
				+ resultado[FECHA_ACTUAL_MINUTO] + "-" + resultado[FECHA_ACTUAL_SEGUNDO];
	}

	public String getNombre_carpeta() {
		return nombre_carpeta;
	}

	public int getContador() {
		return contador;
	}

	public void setFuncionalidad(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getFuncionalidad() {
		return aplicacion;
	}

	public String setNombreCarpeta(String carpeta) {
		int[] resultado = getfechaHoySeparada();
		nombre_carpeta = carpeta + "-" + resultado[FECHA_ACTUAL_ANIO] + "-" + resultado[FECHA_ACTUAL_MES] + "-"
				+ resultado[FECHA_ACTUAL_DIA]; /*
												 * + "T" + resultado[FECHA_ACTUAL_HORA] + "-" +
												 * resultado[FECHA_ACTUAL_MINUTO] + "-" +
												 * resultado[FECHA_ACTUAL_SEGUNDO];
												 */
		return nombre_carpeta;
	}

	public String setFechaHoy() {
		int[] resultado = getfechaHoySeparada();
		String fecha = resultado[FECHA_ACTUAL_DIA] + "/" + resultado[FECHA_ACTUAL_MES] + "/"
				+ resultado[FECHA_ACTUAL_ANIO];
		return fecha;
	}

	public String setNombreArchivo() {
		int[] resultado = getfechaHoySeparada();
		nombre_carpeta = resultado[FECHA_ACTUAL_ANIO] + "_" + resultado[FECHA_ACTUAL_MES] + "_"
				+ resultado[FECHA_ACTUAL_DIA]; /*
												 * + "T" + resultado[FECHA_ACTUAL_HORA] + "-" +
												 * resultado[FECHA_ACTUAL_MINUTO] + "-" +
												 * resultado[FECHA_ACTUAL_SEGUNDO];
												 */
		return nombre_carpeta;
	}

	public void extraerTexto(WebDriver driver, String objeto, int inicio, int fin) {

		numRadicado = driver.findElement(By.xpath(objeto)).getText().substring(inicio, fin);
	}

	public void waitUntilElementNotDisplayed(final WebElement webElement, WebDriver driver)
			throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver arg0) {
				try {
					webElement.isDisplayed();
					return true;
				} catch (NoSuchElementException e) {
					return false;
				} catch (StaleElementReferenceException f) {
					return false;
				}
			}
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void esperarElemento(WebDriver driver) throws InterruptedException {
		try {
			Thread.sleep(1000);
			while (driver.findElement(By.id(objEsperaFosfec)).isDisplayed()) {
				Thread.sleep(1000);
			}
		} catch (NoSuchElementException e) {
			Thread.sleep(1000);
		}

	}
}