package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Hooks;

public class ContactUsSteps {
    WebDriver driver;
    

    @Given("I am on the Contact Us page")
    public void i_am_on_the_contact_us_page() {
    	Hooks.contactUsPage.goToContactUsPage();
        
    }

    @When("I enter {string} in the subject field")
    public void i_enter_in_the_subject_field(String subject) {
    	Hooks.contactUsPage.enterSubject(subject);
    }

    @When("I enter {string} in the message field")
    public void i_enter_in_the_message_field(String message) {
    	Hooks.contactUsPage.enterMessage(message);
    }

    @When("I click the Submit button")
    public void i_click_the_submit_button() {
    	Hooks.contactUsPage.clickSubmit();
    }

    @Then("I should see a success message confirming my feedback was sent")
    public void i_should_see_a_success_message_confirming_my_feedback_was_sent() {
        Assert.assertTrue(Hooks.contactUsPage.isSuccessMessageDisplayed(),"Success message not displayed!");
        driver.quit();
    }
}
