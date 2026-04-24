package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By orderBtn = By.xpath("//a[text()='Place Order']");
    By name = By.name("name_on_card");
    By cardNo = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payBtn = By.id("submit");
    By successMsg = By.xpath("//p[contains(text(),'Congratulations')]");

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(orderBtn)).click();
    }

    public void enterPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Test User");
        driver.findElement(cardNo).sendKeys("1234567890");
        driver.findElement(cvc).sendKeys("123");
        driver.findElement(expiryMonth).sendKeys("12");
        driver.findElement(expiryYear).sendKeys("2028");
        WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe")));
        new Actions(driver).scrollToElement(subscribe).perform();
        driver.findElement(payBtn).click();
    }

    public boolean isOrderPlaced() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
    }
}