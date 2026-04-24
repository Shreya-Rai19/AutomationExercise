package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartSubscriptionPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartSubscriptionPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	By cart=By.xpath("//a[@href=\"/view_cart\"]");
	By email=By.xpath("//input[@id='susbscribe_email']");
	By cartArrow=By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
	public void cartPage()
	{
		driver.findElement(cart).click();
	}
	public void enterEmail()
	{	
		driver.findElement(email).click();
		driver.findElement(email).sendKeys("abc@gmail.com");
		
	}
	public void clickArrow()
	{
		driver.findElement(cartArrow).click();
	}
	public void successMessage()
	{
		WebElement message=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
	    Assert.assertTrue(message.isDisplayed());

	}

}
