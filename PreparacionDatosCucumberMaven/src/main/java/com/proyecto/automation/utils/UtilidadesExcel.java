package com.proyecto.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.proyecto.automation.LogAuditoria;
import com.ruta.utils.Constantes;

public class UtilidadesExcel {
	private static XSSFSheet hojaExcel;
	private static XSSFWorkbook libroExcel;
	private static XSSFCell celdaExcel;
	private static XSSFRow fila;
	
	public static void modificarArchivoExcel (String ruta, String nombreHoja) throws Exception{
		try {
			
			FileInputStream archivoExcel = new FileInputStream(ruta);
			libroExcel = new XSSFWorkbook(archivoExcel);
		}catch (Exception e) {
			LogAuditoria.error("Clase UtilidadesExcel - Metodo modificarArchivoExcel - Excepcion de " + e.getMessage());
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static String obtenerDatosCelda(int numeroFila, int numeroColumna, String nombreHoja) throws Exception{	
		try {
			hojaExcel = libroExcel.getSheet(nombreHoja);
			celdaExcel = hojaExcel.getRow(numeroFila).getCell(numeroColumna);
			int tipoCelda =  celdaExcel.getCellType();
			String datoCelda = "";
			if(tipoCelda == 1) {
				datoCelda = celdaExcel.getStringCellValue();
			}else if(tipoCelda == 0){
				int datoCeldaNum = (int) celdaExcel.getNumericCellValue();
				datoCelda = Integer.toString(datoCeldaNum);
			}
			return datoCelda;
		}catch (Exception e) {
			return "";	
		}
	}
	
	public static int obtenerNumeroFilas(String nombreHoja) {
		int numeroFilas = 0;
		try {
			hojaExcel = libroExcel.getSheet(nombreHoja);
			numeroFilas = hojaExcel.getLastRowNum();
		}catch (Exception e) {
			LogAuditoria.error("Clase UtilidadesExcel - Metodo obtenerNumeroFilas - Excepcion de " + e.getMessage());
		}
		return numeroFilas;
	}
	
	
	public static void modificarDatosCelda (String resultado, int numeroFila, int numeroColumna, String nombreCelda) throws Exception{
		try {
			hojaExcel = libroExcel.getSheet(nombreCelda);
			fila = hojaExcel.getRow(numeroFila);
			celdaExcel = fila.getCell(numeroColumna);
			if(celdaExcel == null) {
				celdaExcel = fila.createCell(numeroColumna);
				celdaExcel.setCellValue(resultado);
			}else {
				celdaExcel.setCellValue(resultado);
			}
			FileOutputStream salida = new FileOutputStream(Constantes.rutaDatos);
			libroExcel.write(salida);
			salida.close();
			libroExcel = new XSSFWorkbook(new FileInputStream(Constantes.rutaDatos));
		}catch (Exception e) {
			LogAuditoria.error("Clase UtilidadesExcel - Metodo modificarDatosCelda - Excepcion de " + e.getMessage());
		}
	}
	
}
