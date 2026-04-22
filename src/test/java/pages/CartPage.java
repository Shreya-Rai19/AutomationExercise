package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    private By cartBtn = By.xpath("//a[@href='/view_cart']");
    private By deleteButtons = By.className("cart_quantity_delete");
    private By cartRows = By.xpath("//tbody/tr");

  
    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartRows));
        return this;
    }

    // Remove 2 items
    public CartPage removeTwoItems() {

        for (int i = 0; i < 2; i++) {

            List<WebElement> items = driver.findElements(deleteButtons);

            if (items.isEmpty()) {
                break;
            }

            int sizeBefore = items.size();

            items.get(0).click();

          
            wait.until(d -> d.findElements(deleteButtons).size() < sizeBefore);
        }

        return this;
    }

   
    public int getItemCount() {
        return driver.findElements(deleteButtons).size();
    }
}