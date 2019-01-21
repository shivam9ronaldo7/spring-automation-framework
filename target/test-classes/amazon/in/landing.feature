#Author: shivam9ronaldo7@gmail.com

@amazonin
Feature: To check landing page functionality

  @test1
  Scenario: Check 39 options are available in categories dropdown besides search box in sorting order
    Given I enter url "https://www.amazon.in"
    When I click on dropdown besides search box
    Then dropdown is opened
    And it contains 39 options
    And options are present in sorting order
    When user selects any value from dropdown
    Then that option is displayed on the dropdown
