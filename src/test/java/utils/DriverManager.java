package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPage;

public class DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config = new ConfigReader();

    protected HomePage homepage;
    protected LoginPage loginpage;

    @BeforeClass
    public void setup() {
        config = new ConfigReader();
        driver = DriverFactory.getDriver(config.getBrowser()); // launches Chrome
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl()); // https://automationexercise.com/
    }

    @BeforeMethod
    public void instantiatePages() {
        homepage = new HomePage(driver, wait);
        loginpage = new LoginPage(driver, wait);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
