package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.InvalidLoginPage;
import pages.LoginPage;
import pages.RegisterWhileCheckoutPage;
import pages.SearchPage;
import pages.SignUpLoginPage;

public class DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config = new ConfigReader();

    protected LoginPage loginpage;
    protected HomePage homepage;
    protected AddToCartPage addcart;
    protected SignUpLoginPage signuploginpage;
    protected InvalidLoginPage invalidPage;
    protected SearchPage searchPage;
    protected CartPage cart;
    protected RegisterWhileCheckoutPage checkout;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver(config.getBrowser()); // launches Chrome
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl()); // https://automationexercise.com/
    }

    @BeforeMethod
    public void instantiatePages() {
        loginpage = new LoginPage(driver, wait);
        homepage = new HomePage(driver, wait);
        addcart = new AddToCartPage(driver, wait);
        signuploginpage = new SignUpLoginPage(driver, wait);
        invalidPage = new InvalidLoginPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        cart = new CartPage(driver, wait);
        checkout=new RegisterWhileCheckoutPage(driver, wait);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
