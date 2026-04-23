Feature: Add Review for Product
  As a user
  I want to submit a review for a product
  So that other customers can see my feedback

  Background:
    Given I am on the product details page for product id "Mens Tshirt"

  Scenario: Submit a valid review
    When I enter "John Doe" in the name field
    And I enter "john@example.com" in the email field
    And I enter "Great quality tshirt, very comfortable!" in the review field
    And I click on "Submit"
    Then I should see a success message "Thank you for your review."

  Scenario: Submit a review with missing name
    When I leave the name field empty
    And I enter "john@example.com" in the email field
    And I enter "Nice fabric and fit." in the review field
    And I click on "Submit"
    Then I should see no message

  Scenario: Submit a review with missing email
    When I enter "John Doe" in the name field
    And I leave the email field empty
    And I enter "Good value for money." in the review field
    And I click on "Submit"
    Then I should see no message

