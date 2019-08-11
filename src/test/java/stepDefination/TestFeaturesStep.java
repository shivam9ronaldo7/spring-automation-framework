package stepDefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import cucumber.api.java8.En;

public class TestFeaturesStep implements En {
	private static final Logger LOG = LogManager.getLogger();
	public TestFeaturesStep() {
		ThreadContext.put("logFileName", Thread.currentThread().getName());
		Given("I want to write a step with precondition", () -> {
			LOG.trace("I want to write a step with precondition");
		});

		Given("some other precondition", () -> {
			LOG.trace("some other precondition");
		});

		When("I complete action", () -> {
			LOG.trace("I complete action");
		});

		When("some other action", () -> {
			LOG.trace("some other action");
		});

		When("yet another action", () -> {
			LOG.trace("yet another action");
		});

		Then("I validate the outcomes", () -> {
			LOG.trace("I validate the outcomes");
		});

		Then("check more outcomes", () -> {
			LOG.trace("check more outcomes");
		});

		Given("I want to write a step with name{int}", (Integer int1) -> {
			LOG.trace("I want to write a step with name{int}");
		});

		When("I check for the {int} in step", (Integer int1) -> {
			LOG.trace("I check for the {int} in step");
		});

		Then("I verify the success in step", () -> {
			LOG.trace("I verify the success in step");
		});

		Then("I verify the Fail in step", () -> {
			LOG.trace("I verify the Fail in step");
		});
	}	
}
