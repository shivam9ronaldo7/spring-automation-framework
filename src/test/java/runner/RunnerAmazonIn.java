package runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.report.CucumberExtentOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources",
		glue={"stepDefination","utitlity"},
		tags= {"@ttag1.2"/*test1 amazonin*/},
		monochrome=true,
		plugin= {"com.report.CucumberExtent:target/cucumber-extent-reports/report.html"}
		)
public class RunnerAmazonIn extends AbstractTestNGCucumberTests{
	/*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
	private static final Logger LOG = LogManager.getLogger();
	
	@BeforeClass
	public void beforeMethod() {
		ThreadContext.put("logFileName", Thread.currentThread().getName());
		LOG.info("Execution Started");
		CucumberExtentOptions.getInstance().setDocumentTitle("Shivam document title");
		CucumberExtentOptions.getInstance().setReportLevel("Feature");
		CucumberExtentOptions.getInstance().setReportName("Shivam report name");		
	}
	@AfterClass
	public void afterMethod() {
		ThreadContext.remove("logFileName");
	}
}
