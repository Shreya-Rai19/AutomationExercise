package steps;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.*;
import utils.Hooks;

public class RegisterCheckoutSteps {


    @Given("user is on Home Page")
    public void user_is_on_home_page() {
    	Hooks.homepage.clickLogout();
        Hooks.homepage.clickLoginOrSignup();
    }

    @When("user logins with valid credential")
    public void user_logins_with_valid_credential() {
        Hooks.loginpage.enterEmail();
        Hooks.loginpage.enterPassword();
        Hooks.loginpage.clickLoginButton();
        Assert.assertTrue(Hooks.loginpage.isLoginSuccessful());
    }

    @When("user adds product to the cart")
    public void user_adds_product_to_the_cart() {

    	Hooks.addcart = new AddToCartPage(Hooks.driver, Hooks.wait);

    	Hooks.addcart.categoryWomen();
    	Hooks.addcart.categoryChild();
    	Hooks.addcart.categoryPolo();
    }

    @When("user navigates to cart")
    public void user_navigates_to_cart() {

    	Hooks.cart = new CartPage(Hooks.driver, Hooks.wait);

    	Hooks.cart.goToCart();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {

    	Hooks.checkout = new CheckOutPage(Hooks.driver, Hooks.wait);

    	Hooks.checkout.clickCheckOut();

        Assert.assertTrue(Hooks.checkout.isAddressDisplayed());
    }

   
    @When("user places the order")
    public void user_places_the_order() {

    	Hooks.payment = new PaymentPage(Hooks.driver, Hooks.wait);

    	Hooks.payment.clickPlaceOrder();   
    }

    @When("user enters the payment details")
    public void user_enters_the_payment_details() {

    	Hooks.payment.enterPayment();     
    }

    @Then("order should be successfull")
    public void order_should_be_successfull() {

        Assert.assertTrue(Hooks.payment.isOrderPlaced());

        Hooks.success = new SuccessPage(Hooks.driver, Hooks.wait);
        Hooks.success.clickContinue();    
    }
}