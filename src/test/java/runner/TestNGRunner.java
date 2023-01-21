package runner;

import annotations.Log;
import io.cucumber.testng.*;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
		features = {
				"src/test/resources/testFeatures"
		},
		glue = {
				"stepDefination"
		},
		tags = "@test1",
		monochrome = true,
		plugin = {
				"pretty",
				"html:target/cucumber/report.html",
				"json:target/cucumber/report.json",
				"message:target/cucumber/report.ndjson",
		})
public class TestNGRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
