package com.ruta.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/com/ruta/negocio/preparacionDatos"
		,glue={"com/ruta/stepDefinition/preparacionDatos"}
		)
public class TestPreparacionDatos {

}