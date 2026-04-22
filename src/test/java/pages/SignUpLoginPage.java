package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public SignUpLoginPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	By usernameField = By.xpath("//input[@type='text']");
	By emailField = By.xpath("//input[@data-qa='signup-email']");
	By signupButton = By.xpath("//button[@data-qa='signup-button']");
	By title = By.className("radio-inline");
	By nameField = By.id("name");
	By passwordField = By.id("password");
	By dobDay = By.id("days");
	By dobMonth = By.id("months");
	By dobYear = By.id("years");
	By firstNameField = By.id("first_name");
	By lastNameField = By.id("last_name");
	By addressField = By.id("address1");
	By stateField = By.id("state");
	By cityField = By.id("city");
	By zipcodeField = By.id("zipcode");
	By mobilenoField = By.id("mobile_number");
	By createAccountButton = By.cssSelector(".btn.btn-default");
	By accountCreatedMessage = By.tagName("b");
	By continueButton = By.xpath("//a[@data-qa='continue-button']");
	
	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
	}
	
	public void enterEmail(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(password);
	}
	
	public void clickSignUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signupButton)).click();
	}
	
	public void clickTitle(String gender) {
		List<WebElement> titles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(title));
		if(gender.equalsIgnoreCase("male"))
			titles.get(0).click();
		else
			titles.get(1).click();
	}
	
	public void enterName(String name) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	}
	
	public void enterDob(String day,String month,String year) {
		Select selectDay = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(dobDay)));
		Select selectMonth = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(dobMonth)));
		Select selectYear = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(dobYear)));
		
		selectDay.selectByVisibleText(day);
		selectMonth.selectByVisibleText(month);
		selectYear.selectByVisibleText(year);
	}
	
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);		
	}
	
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);		
	}
	
	public void enterAddress(String address) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);
	}
	
	public void enterState(String state) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);		
	}
	
	public void enterCity(String city) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);		
	}
	
	public void enterZipcode(String zipcode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeField)).sendKeys(zipcode);		
	}
	
	public void enterMobileNo(String mobileno) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobilenoField)).sendKeys(mobileno);		
	}
	
	public void clickCreateAccountButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountButton)).click();
	}
	
	public String getAccountCreatedMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage)).getText();
	}
	
	public void clickContinue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
	}
}
