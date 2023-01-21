package utility;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class ReportUtil {

    @Autowired
    ScenarioData scenarioData;

    @Autowired
    WebDriverUtil webDriverUtil;

    public void attchScreenshotToReport() {
        scenarioData.getScenario().attach(((TakesScreenshot) webDriverUtil.getWebDriver()).getScreenshotAs(OutputType.BYTES),
                "image/png", String.format("URL: %s", webDriverUtil.getCurrentUrl()));
    }

    public void attchLogToReport(String log) {
        scenarioData.getScenario().log(log);
    }

}
