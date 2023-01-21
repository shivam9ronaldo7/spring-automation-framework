package stepDefination;

import annotations.Log;
import exceptions.UnImplementedCallException;
import exceptions.UnmatchedCaseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import utility.ReportUtil;
import utility.WebDriverUtil;

public class TestFeaturesStep {

	@Log
	private Logger logger;

	@Autowired
	private WebDriverUtil webDriverUtil;

	@Autowired
	private ReportUtil reportUtil;

	@Given("open {string}")
	public void open(String string) throws UnImplementedCallException, UnmatchedCaseException {
		webDriverUtil.openUrl(string);
		reportUtil.attchLogToReport("Web page opened");
		reportUtil.attchScreenshotToReport();
	}
	@Then("I verify the {string} is loaded")
	public void i_verify_the_is_loaded(String string) {
		webDriverUtil.visibilityOfElement(By.xpath(string));
		reportUtil.attchLogToReport("Element searched");
		reportUtil.attchScreenshotToReport();
	}

}
