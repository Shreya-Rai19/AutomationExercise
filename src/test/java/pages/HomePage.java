package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	public void clickLoginOrSignup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginOrSignup)).click();
	}
	
	public void clickLogout() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logout)).click();
	}
}
