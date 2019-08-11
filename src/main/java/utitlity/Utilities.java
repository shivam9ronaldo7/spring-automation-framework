package utitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Utilities {
	public WebDriver driver = null;
	private static final Logger LOG = LogManager.getLogger();

	//Method to return value of the key from property file
	public String getProperty(String fileName,String key) throws FileNotFoundException, IOException {
		LOG.traceEntry("getProperty(fileName,key)");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\main\\resources\\"+fileName+".properties"));
		LOG.traceExit("getProperty(fileName,key)");
		return prop.getProperty(key);
	}

	//Method to highlight a webelement
	public void highLighterMethod(WebDriver driver, WebElement element){
		LOG.traceEntry("highLighterMethod(driver, element)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		LOG.traceExit("highLighterMethod(driver, element)");
	}

	@AfterStep
	public void afterStepHook(Scenario scenario) throws IOException {
		LOG.traceEntry("afterStepHook(scenario)");
		if(scenario.isFailed()==true) {
			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		LOG.traceExit("afterStepHook(scenario)");
	}

	@Before
	public void beforeHook(Scenario scenario) {
		ThreadContext.put("logFileName", Thread.currentThread().getName());
		LOG.traceEntry("beforeHook(scenario)");
		/*browserSetup("firefox");*/
		LOG.traceExit("beforeHook(scenario)");
	}

	@After
	public void afterHook() {
		LOG.traceEntry("afterHook()");
		/*driver.quit();*/
		LOG.traceExit("afterHook()");
	}

	public void browserSetup(String browser) {
		LOG.traceEntry("browserSetup(browser)");
		switch(browser) {
		case "chrome":System.setProperty("webdriver.chrome.driver","driver\\"+browser+"driver"+".exe");
		driver = new ChromeDriver();
		break;
		case "firefox":System.setProperty("webdriver.gecko.driver","driver\\"+browser+".exe");
		driver = new FirefoxDriver();
		break;
		case "ie":System.setProperty("webdriver.ie.driver","driver\\"+browser+".exe");
		driver = new InternetExplorerDriver();
		break;
		default:System.out.println("Wrong browser "+browser);
		}		
		driver.manage().window().maximize();
		LOG.traceExit("browserSetup(browser)");
	}

	public void pdfReader(String filePath) throws InvalidPasswordException, IOException {
		LOG.traceEntry("pdfReader(filePath)");
		try (PDDocument document = PDDocument
				.load(new File(filePath))) {
			document.getClass();
			if (!document.isEncrypted()) {	
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);
				String lines[] = pdfFileInText.split("\\r?\\n");
				for (String line : lines) {
					System.out.println(line);
				}
			}
		}
		LOG.traceExit("pdfReader(filePath)");
	}
}
