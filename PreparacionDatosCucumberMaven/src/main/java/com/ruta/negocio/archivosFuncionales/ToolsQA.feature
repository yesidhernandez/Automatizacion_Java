#Proyecto: Ejemplo de una preparación de datos básica pra un Proyecto con Cucumber
#Elaborado por: Yesid Hernández Hoyos
#Email: yesidhernandezhoyos@gmail.com
#Telefono: 301 397 54 49
@HistoriaUsuario01
Feature: Diligenciar formulario ToolsQA

  @Escenario1
  Scenario Outline: Ingresar datos al formulario ToolsQA para su posterior envio
  
    Given El usuario ingresa a la pagina ToolsQA seleccionando un "<Browser>"
    And El usuario diligencia el campo nombre "<FirstName>"
    And El usuario diligencia el campo apellido "<LastName>"
    And El usuario diligencia el campo nombre "<Sex>"
    And El usuario diligencia el campo nombre "<YearsOfExperience>"
    And El usuario diligencia el campo nombre "<Date>"
    And El usuario diligencia el campo nombre "<ManualTester>"
    And El usuario diligencia el campo nombre "<AutomationTester>"
    And El usuario diligencia el campo nombre "<QTP>"
    And El usuario diligencia el campo nombre "<SeleniumIDE>"
    And El usuario diligencia el campo nombre "<SeleniumWebdriver>"
    And El usuario diligencia el campo nombre "<Continents>"
    And El usuario diligencia el campo nombre "<BrowserCommands>"
    And El usuario diligencia el campo nombre "<NavigationCommands>"
    And El usuario diligencia el campo nombre "<SwitchCommands>"
    And El usuario diligencia el campo nombre "<WaitCommands>"
    And El usuario diligencia el campo nombre "<WebElementCommands>"
    When El usuario presiona el boton enviar
    Then La informacion es enviada correctamente

    Examples: 
      | Browser | FirstName | LastName | Sex | YearsOfExperience | Date | ManualTester | AutomationTester | QTP | SeleniumIDE | SeleniumWebdriver | Continents | BrowserCommands | NavigationCommands | SwitchCommands | WaitCommands | WebElementCommands |
      