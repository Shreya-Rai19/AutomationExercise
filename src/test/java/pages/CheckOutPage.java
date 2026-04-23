package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {

	 WebDriver driver;
	    WebDriverWait wait;

	    public CheckOutPage(WebDriver driver,WebDriverWait wait) {
			this.driver = driver;
			this.wait = wait;
		}
	    
	    By checkoutBtn=By.linkText("Proceed To Checkout");
	    By address=By.xpath("//h2[text()='Address Details']");
	    
	    public void clickCheckOut() {
	    	wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
	    }
	    
	    public boolean isAddressDisplayed() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(address)).isDisplayed();
	    	
	    }
}
