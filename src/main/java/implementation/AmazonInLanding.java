package implementation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utitlity.CucumberHooks;
import utitlity.Utilities;

public class AmazonInLanding {
	private WebDriver driver;
	private Utilities utility;
	public AmazonInLanding(CucumberHooks hooks, Utilities utility) {
		this.driver = hooks.driver;
		this.utility = utility;
	}
	
	public void enterUrl(String url) {
		try{
			driver.get(url);
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to load "+url);
		}
	}
	
	public void clickOnDropdownBesidesSearchBox() {
		try {
			driver.findElement(By.xpath(utility
					.getProperty(getClass()
					.getSimpleName(), "searchCategoriesOptionsDropdown")))
					.click();
		} catch (FileNotFoundException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (IOException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to click on the dropdown beside search box");
		}
	}
	
	public void dropdownOptionsCount(int count){
		int size = 0;
		try {
			size = driver.findElements(By.xpath(utility
						.getProperty(getClass()
						.getSimpleName(), "searchCategoriesOptionsDropdown")))
						.size();
		} catch (FileNotFoundException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (IOException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (Exception e) {
			Assert.assertTrue(size==count, "No of option on webpage: "+size+
											"No of options to be present: "+count);
		}
	}
	
	public void userSelectsAnyValueFromDropdown() {
		/*try {
			Select sc = new Select(driver
							.findElement(By
							.xpath(utility
							.getProperty(getClass()
							.getSimpleName(), "searchCategoriesOptionsList"))));
			sc.selectByValue("search-alias=appliances");			
		} catch (IOException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to click on the option");
		}*/
	}
	
	public void optionIsDisplayedOnTheDropdown() {
		String text = null;
		try {
			text = driver.findElement(By.xpath(utility
					.getProperty(getClass()
					.getSimpleName(), "searchCategoriesSelectedOption")))
					.getText();
		} catch (IOException e) {
			Assert.assertTrue(false, e.getMessage());
		} catch (Exception e) {
			Assert.assertTrue(text.equals("Select"), "Value in the dropdown is "+
							text+" whereas it should be Appliances");
		}
	}
		
}
