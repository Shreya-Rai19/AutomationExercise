package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public AddToCartPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	By products=By.xpath("//a[@href='/products']");
	By women=By.xpath("//a[@href='#Women']");
	By dress=By.xpath("//a[@href=\"/category_products/1\"]");
	By brownDress=By.xpath("//a[@href=\"/product_details/38\"]");
	By addDress=By.xpath("//button[@class='btn btn-default cart']");
	By continueShopping=By.xpath("//button[text()='Continue Shopping']");
	
	By babyHug=By.xpath("//a[@href='/brand_products/Babyhug']");
	By printedTop=By.xpath("//a[@href='/product_details/11']");
	By addTop=By.xpath("//button[@class='btn btn-default cart']");
	
	By polo=By.xpath("//a[@href='/brand_products/Polo']");
	By shirt=By.xpath("//a[@href='/product_details/29']");
	By addShirt=By.xpath("//button[@class='btn btn-default cart']");
	
	public void categoryWomen()
	{
		driver.findElement(products).click();
		driver.findElement(women).click();
		driver.findElement(dress).click();
		driver.findElement(brownDress).click();
		driver.findElement(addDress).click();
		driver.findElement(continueShopping).click();
	}
	public void categoryChild()
	{
		driver.findElement(babyHug).click();
		driver.findElement(printedTop).click();
		driver.findElement(addTop).click();
		driver.findElement(continueShopping).click();
	}
	public void categoryPolo()
	{
		driver.findElement(polo).click();
		driver.findElement(shirt).click();
		driver.findElement(addShirt).click();
		driver.findElement(continueShopping).click();
	}


}
