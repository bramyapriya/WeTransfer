package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/", // specifies the path of feature file
		glue = { "stepDefinition" }, // Specifies the path of step definition file
		tags = { "@ramya" }, // Used to specify what all the scenarios to be run
		// generates html report using extent reporting
		plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/WeTransferSuiteReport.html" }, monochrome = true)

public class TestRunner {

}
