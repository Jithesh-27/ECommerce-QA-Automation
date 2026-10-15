Feature: Checkout functionality

  @smoke @regression @checkout
  Scenario: Verify checkout information page is displayed
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed
    When the user adds the first product to the cart
    And the user opens the cart page
    And the user clicks the checkout button
    Then the checkout information page should be displayed

  @regression @checkout
  Scenario: Enter valid checkout information
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

  @regression @checkout
  Scenario: Continue checkout without entering information
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And the user clicks the login button
    Then the products page should be displayed
    When the user adds the first product to the cart
    And the user opens the cart page
    And the user clicks the checkout button
    Then the checkout information page should be displayed
    When the user clicks the continue button
    Then the checkout error message should be displayed
