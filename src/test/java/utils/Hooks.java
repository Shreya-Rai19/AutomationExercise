package utils;
 
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
 
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
    public static CheckOutPage checkout;
    public static PaymentPage payment;
    public static SuccessPage success;
 
    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        checkout=new CheckOutPage(driver,wait);
        payment=new PaymentPage(driver,wait);
        success=new SuccessPage(driver,wait);
    }
 
    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}