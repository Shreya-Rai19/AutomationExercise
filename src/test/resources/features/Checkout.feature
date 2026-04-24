Feature: Place Order while Registering during Checkout

Scenario: Successful order placement with registration during checkout
    Given I launch the browser and navigate to the home page
    Then I verify that home page is visible successfully
    When I add products to cart
    And I click on Cart button
    Then I verify that cart page is displayed
    When I click Proceed To Checkout
    And I click Register or Login button
    And I fill all details in Signup and create account
    Then I verify "ACCOUNT CREATED!" and click Continue button
    And I verify Logged in as username at top
    When I click Cart button
    And I click Proceed To Checkout button
    Then I verify Address Details and Review Your Order
    When I enter description and click Place Order
    And I enter payment details
    And I click Pay and Confirm Order button
    Then I verify success message