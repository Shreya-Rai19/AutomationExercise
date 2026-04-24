package utils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import pages.*;
 
public class Hooks extends DriverManager{
    public static WebDriver driver;
    public static WebDriverWait wait;
    // Page objects accessible to steps  
    public static LoginPage loginpage;
    public static HomePage homepage;
    public static AddToCartPage addcart;
    public static SignUpLoginPage signuploginpage;
    public static InvalidLoginPage invalidPage;
    public static SearchPage searchPage;
    public static CartPage cart;
    public static CartSubscriptionPage cartSubscription;
    public static RegisterWhileCheckoutPage check;

    public static CheckOutPage checkout;
    public static PaymentPage payment;
    public static SuccessPage success;
    public static MenTshirtPage mentshirtpage;
    public static ContactUsPage contactUsPage;
           

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
        // instantiate pages
        contactUsPage = new ContactUsPage(driver,wait);
        loginpage = new LoginPage(driver, wait);
        homepage = new HomePage(driver, wait);
        addcart = new AddToCartPage(driver, wait);
        signuploginpage = new SignUpLoginPage(driver, wait);
        invalidPage = new InvalidLoginPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        cart = new CartPage(driver, wait);
        cartSubscription= new CartSubscriptionPage(driver,wait);
        mentshirtpage = new MenTshirtPage(driver,wait);
        check = new RegisterWhileCheckoutPage(driver,wait);
        
    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
