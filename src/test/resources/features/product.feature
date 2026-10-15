Feature: Products functionality

@smoke @regression
Scenario: Verify products page is displayed after login
Given the user is on the SauceDemo login page
When the user enters a valid username and password
And the user clicks the login button
Then the products page should be displayed

  @regression
  Scenario: Verify products page title
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed
    And the products page title should be "Swag Labs"