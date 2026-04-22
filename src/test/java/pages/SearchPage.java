package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    By productsLink = By.xpath("//a[@href='/products']");
    By searchBox = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchedProducts = By.xpath("//div[@class='features_items']");

    // Actions
    public void clickProductsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(productsLink)).click();
    }

    public void enterSearchText(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }

    public void clickSearchButtonAndScroll() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        // Scroll to product results after search
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", 
            wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProducts)));
    }

    public boolean isProductDisplayed(String productName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProducts))
                   .getText().toLowerCase().contains(productName.toLowerCase());
    }
}
