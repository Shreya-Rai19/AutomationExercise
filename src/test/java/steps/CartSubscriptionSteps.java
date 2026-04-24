package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

public class CartSubscriptionSteps {
	@Given("the customer is in Cart page of Automation Exercise")
	public void the_customer_is_in_cart_page_of_automation_exercise() {
		Hooks.cartSubscription.cartPage();
	    
	}

	@When("the customer fills the email address")
	public void the_customer_fills_the_email_address() {
	    Hooks.cartSubscription.enterEmail();
	}

	@When("press the arrow")
	public void press_the_arrow() {
		Hooks.cartSubscription.clickArrow();
	   
	}

	@Then("the success message should be visible to the customer")
	public void the_success_message_should_be_visible_to_the_customer() {
		Hooks.cartSubscription.successMessage();
	   
	}

}
