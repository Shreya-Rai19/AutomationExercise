Feature:Checkout with registered user

Scenario:Login and proceed to checkout
	Given user is on Home Page
	When user logins with valid credential
	And user adds product to the cart
	And user navigates to cart
	And user proceeds to checkout
	And user places the order
	And user enters the payment details
	Then order should be successfull
