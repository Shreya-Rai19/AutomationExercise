Feature: Contact Us Form

  Scenario: Submit contact form successfully
    Given I am on the Contact Us page
    When I enter "John Doe" in the name field
    And I enter "john.doe@example.com" in the email field
    And I enter "Order Inquiry" in the subject field
    And I enter "I would like to know the status of my order." in the message field
    And I click the Submit button
    Then I should see a success message confirming my feedback was sent
