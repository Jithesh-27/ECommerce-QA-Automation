Feature: Order functionality

  @smoke @regression @order
  Scenario: Complete checkout and verify order confirmation
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed
    When the user adds the first product to the cart
    And the user opens the cart page
    And the user clicks the checkout button
    Then the checkout information page should be displayed
    When the user enters valid checkout information
    And the user clicks the continue button
    Then the checkout overview page should be displayed
    When the user clicks the finish button
    Then the order confirmation page should be displayed
