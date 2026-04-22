package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.SignUpLoginPage;


public class DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader config = new ConfigReader();
    
    protected HomePage homepage;
    protected SignUpLoginPage signuploginpage;
    
    @BeforeClass
    public void setup() {
        config = new ConfigReader();
        driver = DriverFactory.getDriver(config.getBrowser());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(config.getBaseUrl());
    }

    @BeforeMethod
    public void instantiatePages() {
    	homepage = new HomePage(driver,wait);
    	signuploginpage = new SignUpLoginPage(driver,wait);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
