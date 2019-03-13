package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources",
		glue={"stepDefination"/*,"utitlity"*/},
		tags= {"@tag"},
		monochrome=true,
		plugin= {"utitlity.ExtentFormatterReporter"}
		)
public class RunnerAmazonIn extends AbstractTestNGCucumberTests{}
