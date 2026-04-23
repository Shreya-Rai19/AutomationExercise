package steps;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.*;
import utils.Hooks;

public class RegisterCheckoutSteps {

    LoginPage loginpage;
    AddToCartPage addcart;
    CartPage cart;
    CheckOutPage checkout;
    PaymentPage payment;
    SuccessPage success;

    @Given("user is on Home Page")
    public void user_is_on_home_page() {
        Hooks.driver.get("https://automationexercise.com/");
    }

    @When("user logins with valid credential")
    public void user_logins_with_valid_credential() {

        loginpage = new LoginPage(Hooks.driver, Hooks.wait);

        loginpage.clickSignupLogin();
        loginpage.enterEmail();
        loginpage.enterPassword();
        loginpage.clickLoginButton();

        Assert.assertTrue(loginpage.isLoginSuccessful());
    }

    @When("user adds product to the cart")
    public void user_adds_product_to_the_cart() {

        addcart = new AddToCartPage(Hooks.driver, Hooks.wait);

        addcart.categoryWomen();
        addcart.categoryChild();
        addcart.categoryPolo();
    }

    @When("user navigates to cart")
    public void user_navigates_to_cart() {

        cart = new CartPage(Hooks.driver, Hooks.wait);

        cart.goToCart();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {

        checkout = new CheckOutPage(Hooks.driver, Hooks.wait);

        checkout.clickCheckOut();

        Assert.assertTrue(checkout.isAddressDisplayed());
    }

   
    @When("user places the order")
    public void user_places_the_order() {

        payment = new PaymentPage(Hooks.driver, Hooks.wait);

        payment.clickPlaceOrder();   
    }

    @When("user enters the payment details")
    public void user_enters_the_payment_details() {

        payment.enterPayment();     
    }

    @Then("order should be successfull")
    public void order_should_be_successfull() {

        Assert.assertTrue(payment.isOrderPlaced());

        success = new SuccessPage(Hooks.driver, Hooks.wait);
        success.clickContinue();    
    }
}