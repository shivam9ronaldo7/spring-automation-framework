package utitlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Utilities {
	public WebDriver driver = null;
	//private ExtentHtmlReport er;
		
	//Method to return value of the key from property file
	public String getProperty(String fileName,String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\main\\resources\\"+fileName+".properties"));
		return prop.getProperty(key);		
	}	
	
	@Before
	public void beforeHook(Scenario scenario) {
		browserSetup("firefox");
		//er.createBDDScenario(scenario.getName());
	}
	
	@After
	public void afterHook() {
		driver.quit();
	}
	
	public void browserSetup(String browser) {
		switch(browser) {
		case "chrome":System.setProperty("webdriver.chrome.driver","driver\\"+browser+".exe");
		driver = new ChromeDriver();
		break;
		case "firefox":System.setProperty("webdriver.geko.driver","driver\\"+browser+".exe");
		driver = new FirefoxDriver();
		break;
		case "ie":System.setProperty("webdriver.ie.driver","driver\\"+browser+".exe");
		driver = new InternetExplorerDriver();
		break;
		default:System.out.println("Wrong browser "+browser);
		}		
		driver.manage().window().maximize();
	}
	
}
