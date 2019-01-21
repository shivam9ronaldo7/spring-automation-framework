package utitlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {

	public WebDriver driver = null;
	
	@Before
	public void beforeHook() {
		browserSetup("firefox");
	}
	
	@After
	public void afterHook(Scenario scenario) {
		driver.quit();
		System.out.println(scenario.getStatus());
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
