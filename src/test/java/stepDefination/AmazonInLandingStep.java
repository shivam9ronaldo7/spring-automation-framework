package stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import implementation.AmazonInLanding;

public class AmazonInLandingStep {
	
	private AmazonInLanding azLand;
	public AmazonInLandingStep(AmazonInLanding azLand) {
		this.azLand = azLand;
	}
	
	@Given("^I enter url \"([^\"]*)\"$")
	public void i_enter_url(String url) throws Throwable {
		//azLand.enterUrl(url);
	}
	
	@When("^I click on dropdown besides search box$")
	public void i_click_on_dropdown_besides_search_box() throws Throwable {
		//azLand.clickOnDropdownBesidesSearchBox();
		//Assert.assertFalse(true);
	}

	@Then("^dropdown is opened$")
	public void dropdown_is_opened() throws Throwable {
	}

	@Then("^it contains (\\d+) options$")
	public void it_contains_options(int size) throws Throwable {
		//azLand.dropdownOptionsCount(size);
	}

	@Then("^options are present in sorting order$")
	public void options_are_present_in_sorting_order() throws Throwable {
		//throw new Exception();
	}

	@When("^user selects any value from dropdown$")
	public void user_selects_any_value_from_dropdown() throws Throwable {
		//azLand.userSelectsAnyValueFromDropdown();
	}

	@Then("^that option is displayed on the dropdown$")
	public void that_option_is_displayed_on_the_dropdown() throws Throwable {
		//azLand.optionIsDisplayedOnTheDropdown();
	}

}
