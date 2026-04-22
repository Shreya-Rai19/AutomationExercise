package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.AddToCartPage;
import pages.HomePage;
import pages.InvalidLoginPage;
import pages.LoginPage;
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
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
