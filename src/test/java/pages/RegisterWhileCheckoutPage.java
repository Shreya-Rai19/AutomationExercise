package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterWhileCheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterWhileCheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // HOME PAGE
    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[@alt='Website for automation practice']")
        ));
    }

    // ADD PRODUCT
    public void addProductToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[contains(text(),'Add to cart')])[1]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);

        // Handle modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='modal-content']")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Continue Shopping')]")
        )).click();
    }

    // CART
    public void clickCart() {
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Cart')]")
        ));
        cartBtn.click();

        wait.until(ExpectedConditions.urlContains("view_cart"));
    }

    public void verifyCartPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[contains(text(),'Shopping Cart')]")
        ));
    }

    // CHECKOUT
    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Proceed To Checkout')]")
        )).click();
    }

    public void clickRegisterLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//u[contains(text(),'Register / Login')]")
        )).click();
    }

    // SIGNUP
    public void signup() {
        String email = "test" + System.currentTimeMillis() + "@mail.com";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")))
                .sendKeys("TestUser");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa='signup-email']")
        )).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Signup')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")))
                .sendKeys("123456");

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("days"))))
                .selectByValue("1");

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("months"))))
                .selectByValue("1");

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years"))))
                .selectByValue("2000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")))
                .sendKeys("Test");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")))
                .sendKeys("User");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1")))
                .sendKeys("Street 1");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state")))
                .sendKeys("State");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")))
                .sendKeys("City");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zipcode")))
                .sendKeys("600001");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_number")))
                .sendKeys("9999999999");

        // Scroll
        WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe")));
        new Actions(driver).scrollToElement(subscribe).perform();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Create Account')]")
        )).click();
    }

    public void verifyAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[contains(text(),'Account Created!')]")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Continue')]")
        )).click();
    }

    public void verifyLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Logged in as')]")
        ));
    }

    public void clickCartAgain() {
        clickCart();
    }

    public void proceedToCheckoutAgain() {
        clickProceedToCheckout();
    }

    public void verifyAddressAndOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Address Details')]")
        ));
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("message")))
                .sendKeys("Test Order");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Place Order')]")
        )).click();
    }

    // PAYMENT
    public void enterPaymentDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card")))
                .sendKeys("Test User");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("card_number")))
                .sendKeys("4111111111111111");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cvc")))
                .sendKeys("123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_month")))
                .sendKeys("12");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_year")))
                .sendKeys("2030");
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
    }

    public void verifyOrderSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
        		By.xpath("//p[contains(text(),'Congratulations')]")
        ));
    }
}