package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources",
		glue={"stepDefination","utitlity"},
		tags= {"@test1"},
		monochrome=true
		)
public class RunnerAmazonIn extends AbstractTestNGCucumberTests{
		
}
