package steps;

import io.cucumber.java.en.*;
import utils.Hooks;

public class RegisterWhileCheckoutStep {

    // FIXED: required constructor
    public RegisterWhileCheckoutStep() {}

    @Given("I launch the browser and navigate to the home page")
    public void launchBrowser() {}

    @Then("I verify that home page is visible successfully")
    public void verifyHomePage() {
        Hooks.checkout.verifyHomePage();
    }

    @When("I add products to cart")
    public void addProductsToCart() {
        Hooks.checkout.addProductToCart();
    }

    @And("I click on Cart button")
    public void clickCartButton() {
        Hooks.checkout.clickCart();
    }

    @Then("I verify that cart page is displayed")
    public void verifyCartPage() {
        Hooks.checkout.verifyCartPageDisplayed();
    }

    @When("I click Proceed To Checkout")
    public void proceedToCheckout() {
        Hooks.checkout.clickProceedToCheckout();
    }

    @And("I click Register or Login button")
    public void clickRegisterLogin() {
        Hooks.checkout.clickRegisterLogin();
    }

    @And("I fill all details in Signup and create account")
    public void fillSignupDetails() {
        Hooks.checkout.signup();
    }

    @Then("I verify {string} and click Continue button")
    public void verifyAccountCreated(String msg) {
        Hooks.checkout.verifyAccountCreated();
    }

    @And("I verify Logged in as username at top")
    public void verifyLoggedIn() {
        Hooks.checkout.verifyLoggedIn();
    }

    @When("I click Cart button")
    public void clickCartAgain() {
        Hooks.checkout.clickCartAgain();
    }

    @And("I click Proceed To Checkout button")
    public void proceedAgain() {
        Hooks.checkout.proceedToCheckoutAgain();
    }

    @Then("I verify Address Details and Review Your Order")
    public void verifyAddress() {
        Hooks.checkout.verifyAddressAndOrder();
    }

    @When("I enter description and click Place Order")
    public void placeOrder() {
        Hooks.checkout.placeOrder();
    }

    @And("I enter payment details")
    public void payment() {
        Hooks.checkout.enterPaymentDetails();
    }

    @And("I click Pay and Confirm Order button")
    public void confirm() {
        Hooks.checkout.confirmOrder();
    }

    @Then("I verify success message")
    public void success() {
        Hooks.checkout.verifyOrderSuccess();
    }
}