Feature: Verify subscription in cart page

  Scenario: Verify user can subscribe successfully from cart page
   Given the customer is in Cart page of Automation Exercise
   When the customer fills the email address
   And press the arrow
   Then the success message should be visible to the customer
