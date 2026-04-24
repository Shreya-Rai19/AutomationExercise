package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.InvalidLoginPage;
import pages.LoginPage;
import pages.MenTshirtPage;
import pages.SearchPage;
import pages.SignUpLoginPage;

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
    public static MenTshirtPage mentshirtpage;

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
        

        // instantiate pages
        loginpage = new LoginPage(driver, wait);
        homepage = new HomePage(driver, wait);
        addcart = new AddToCartPage(driver, wait);
        signuploginpage = new SignUpLoginPage(driver, wait);
        invalidPage = new InvalidLoginPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        cart = new CartPage(driver, wait);
        mentshirtpage = new MenTshirtPage(driver,wait);
        
    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
