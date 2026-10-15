Feature: Logout functionality

  @smoke @regression @logout
  Scenario: Logout successfully from SauceDemo
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed
    When the user logs out
    Then the login page should be displayed