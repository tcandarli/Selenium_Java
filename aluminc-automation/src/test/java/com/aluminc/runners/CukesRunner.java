package com.aluminc.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@login", 
		features = "src/test/resources/features", 
		glue = "com/aluminc/step_definitions", 
		dryRun = false, 
		plugin = {
				"json: target/cucumber.json", 
				"pretty" })

public class CukesRunner {

}
