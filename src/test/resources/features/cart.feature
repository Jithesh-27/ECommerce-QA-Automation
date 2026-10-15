Feature: Cart functionality

@smoke @cart
Scenario: Add a product to the cart
Given the user is on the SauceDemo login page
When the user enters a valid username and password
And the user clicks the login button
Then the products page should be displayed
When the user adds the first product to the cart
Then the cart badge should display "1"