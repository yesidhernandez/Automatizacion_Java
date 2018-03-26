#Proyecto: Preparación de datos para una historia de usuario Cucumber
#Elaborado por: Yesid Hernández Hoyos
#Email: yesidhernandezhoyos@gmail.com
#Telefono: 301 397 54 49

@HistoriaUsuario00
Feature: Ejecutar la preparacion de datos para la automatizacion

  @Escenario1
  Scenario Outline: 
    Given Se realiza la lectura del archivo de datos preparado por el analista de pruebas
    When Se copia el "<Archivo>" de la "<RutaOrigen>" a la  "<RutaDestino>" con toda la data segun el "<NumeroCampos>" en la "<HojaExcelDatos>"
    Then El archivo de escenarios funcionales es actualizado exitosamente

    Examples: 
      | Archivo         | RutaOrigen                                         | RutaDestino                               | NumeroCampos | HojaExcelDatos |
      | ToolsQA.feature | src.main.java.com.ruta.negocio.archivosFuncionales | src.main.java.com.ruta.negocio.HUproyecto |           17 | SetDatos       |
