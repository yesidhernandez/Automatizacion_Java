package com.ruta.stepDefinition.preparacionDatos;

import com.ruta.utils.Constantes;
import com.proyecto.automation.LogAuditoria;
import com.proyecto.automation.utils.GestionArchivos;
import com.proyecto.automation.utils.UtilidadesExcel;
import com.ruta.utils.MensajesAuditorias;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PreparacionDatos {
	
	@Given("^Se realiza la lectura del archivo de datos preparado por el analista de pruebas$")
	public void se_realiza_la_lectura_del_archivo_de_datos_preparado_por_el_analista_de_pruebas() throws Throwable {
		LogAuditoria.iniciarCasoPrueba();
	}
	
	@When("^Se copia el \"([^\"]*)\" de la \"([^\"]*)\" a la  \"([^\"]*)\" con toda la data segun el \"([^\"]*)\" en la \"([^\"]*)\"$")
	public void se_copia_el_de_la_a_la_con_toda_la_data_segun_el_en_la(String Archivo, String RutaOrigen, String RutaDestino, int NumeroCampos, String HojaExcelDatos) throws Throwable {
		GestionArchivos gestorArchivos = new GestionArchivos();
		int totalFilas = 0;
		String data = "|";
		try {
			RutaOrigen = RutaOrigen.concat("\\");
			RutaDestino = RutaDestino.concat("\\");
			RutaOrigen = RutaOrigen.replace(".", "\\");
			RutaDestino = RutaDestino.replace(".", "\\");
			gestorArchivos.copiarArchivo(Archivo, RutaOrigen, RutaDestino);
			LogAuditoria.info(MensajesAuditorias.copiaArchivoExitosa + Archivo);
		}catch(Exception e){
			LogAuditoria.error(MensajesAuditorias.copiaArchivoFallido +  e.getMessage());
			assert(false);
		}
		try {
			String rutaDataExcel = Constantes.rutaDatos;
			UtilidadesExcel.modificarArchivoExcel(rutaDataExcel, HojaExcelDatos);
			int fila = 0;
			int columna = 0;
			while(UtilidadesExcel.obtenerDatosCelda(fila,columna,HojaExcelDatos)!= "") {
				fila = fila + 1;
			}
			totalFilas = fila-1;
			LogAuditoria.info(MensajesAuditorias.lecturaDataExitosa);
			
		}catch(Exception e){
			LogAuditoria.error(MensajesAuditorias.errorLecturaData +  e.getMessage());
			assert(false);
		}
		
		try {
			for (int j= 1;j<totalFilas;j++) {
				for (int k= 0;k<NumeroCampos;k++) {
						data = data.concat(UtilidadesExcel.obtenerDatosCelda(j+1, k, HojaExcelDatos)).concat("|");
				}
				gestorArchivos.escribirArchivoConservandoExistente(Archivo, data, RutaDestino);
				data = "|";
			}
			LogAuditoria.info(MensajesAuditorias.copiarDataExitoso + Archivo);
		}catch(Exception e){
			LogAuditoria.error(MensajesAuditorias.copiarDataFallido + Archivo + e.getMessage());
			assert(false);
		}		
	}
	
	@Then("^El archivo de escenarios funcionales es actualizado exitosamente$")
	public void el_archivo_de_escenarios_funcionales_es_actualizado_exitosamente() throws Throwable {
		LogAuditoria.finalizarCasosPrueba();
	}

}
