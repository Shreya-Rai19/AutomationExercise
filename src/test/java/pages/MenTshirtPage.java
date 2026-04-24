package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Hooks;

public class MenTshirtPage {
	WebDriver driver;
	WebDriverWait wait;
	
	By nameField = By.id("name");
	By emailField = By.id("email");
	By reviewField = By.id("review");
	By submitButton = By.id("button-review");
	By successMessage = By.id("review-section");
	
	public MenTshirtPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void enterName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
	}
	
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	}
	
	public void enterReview(String review) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(reviewField)).sendKeys(review);
	}
	
	public void clickSubmitButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
	}
	
	public String getSuccessMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	}
	
	public boolean isSuccessMessageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
	}
}
