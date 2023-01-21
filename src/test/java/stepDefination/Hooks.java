package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import utility.ReportUtil;
import utility.ScenarioData;
import utility.WebDriverUtil;

import java.util.Objects;

public class Hooks {

    @Autowired
    ScenarioData scenarioData;

    @Autowired
    WebDriverUtil webDriverUtil;

    @Autowired
    ReportUtil reportUtil;

    @AfterStep
    public void afterStepHook(Scenario scenario) {
        if (scenario.isFailed() && !Objects.isNull(webDriverUtil.getWebDriver())) {
            reportUtil.attchScreenshotToReport();
        }
    }

    @Before
    public void beforeHook(Scenario scenario) {
        scenarioData.setScenario(scenario);
    }

    @After
    public void afterHook() {
        if (!Objects.isNull(webDriverUtil.getWebDriver())) {
            webDriverUtil.closeWebDriver();
        }
    }

}
