package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

public class AddReviewSteps{

	
	@Given("I am on the product details page for product id {string}")
	public void i_am_on_the_product_details_page_for_product_id(String string) {
		Hooks.homepage.clickViewProductTshirt();
	}

	@When("I enter {string} in the name field")
	public void i_enter_in_the_name_field(String name) {
		Hooks.mentshirtpage.enterName(name);
	}

	@When("I enter {string} in the email field")
	public void i_enter_in_the_email_field(String email) {
		Hooks.mentshirtpage.enterEmail(email);
	}

	@When("I enter {string} in the review field")
	public void i_enter_in_the_review_field(String review) {
		Hooks.mentshirtpage.enterReview(review);
	}

	@When("I click on {string}")
	public void i_click_on(String string) {
		Hooks.mentshirtpage.clickSubmitButton();
	}

	@Then("I should see a success message {string}")
	public void i_should_see_a_success_message(String string) {
	    Assert.assertTrue(Hooks.mentshirtpage.getSuccessMessage().toLowerCase().contains("thank you for your review"));
	}

	@When("I leave the name field empty")
	public void i_leave_the_name_field_empty() {
		Hooks.mentshirtpage.enterEmail("admin@gmail.com");
		Hooks.mentshirtpage.enterReview("Very good product");
		Hooks.mentshirtpage.clickSubmitButton();
	}

	@Then("I should see no message")
	public void i_should_see_no_message() {
		Assert.assertThrows(TimeoutException.class, () -> {
            // This will throw TimeoutException if element not found in 2 seconds
			Hooks.mentshirtpage.getSuccessMessage();
        });
	}

	@When("I leave the email field empty")
	public void i_leave_the_email_field_empty() {
		Hooks.mentshirtpage.enterName("admin");
		Hooks.mentshirtpage.enterReview("Very good product");
		Hooks.mentshirtpage.clickSubmitButton();
	}

}
