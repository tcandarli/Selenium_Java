package com.bookit.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@login1, @login2, @smoke",
		features = "src/test/resources/features",
		glue = "com/bookit/step_definitions",
		dryRun = false  // if it is true it does not run, just checks step definitions if they are implemented or not				   
		)

public class CukesRunner {
	
	
}
