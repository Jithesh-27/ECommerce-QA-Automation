Feature: Login Functionality 
  @smoke @login @regression
  Scenario: Login with valid credentials
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed