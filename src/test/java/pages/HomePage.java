package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	By loginOrSignup = By.xpath("//a[@href='/login']");
	By logout = By.xpath("//a[@href='/logout']");
	By viewProductTshirt = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[2]/ul/li/a");
	By fourthProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[5]/div/div[2]/ul/li/a");
	
	
	public void clickLoginOrSignup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginOrSignup)).click();
	}
	
	public void clickLogout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
	}
	
	public void clickViewProductTshirt() {
		Actions action = new Actions(driver);
		action.scrollToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(fourthProduct))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewProductTshirt)).click();
	}
}
