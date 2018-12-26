package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(  // package names
		features="src/test/java/features",  // what feature files
		glue="stepDefinitions")  // where future files mapping

public class TestRunner {

}
