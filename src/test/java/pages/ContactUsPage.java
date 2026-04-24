package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	private WebDriver driver;
    private WebDriverWait wait;
    
    public ContactUsPage(WebDriver driver,WebDriverWait wait) {
    	this.driver = driver;
        this.wait = wait;
    }
    
    private By contactUs = By.xpath("//a[@href='/contact_us']");
    private By nameField = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    private By emailField = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    private By subjectField = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    private By messageField = By.xpath("//*[@id=\"message\"]");
    private By submitButton = By.xpath("submit");
    private By successMessage = By.cssSelector(".status"); // Adjust if needed

    
    public void goToContactUsPage() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs)).click();
    }

    public void enterName(String name) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterEmail(String email) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterSubject(String subject) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(subjectField)).sendKeys(subject);
    }

    public void enterMessage(String message) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(messageField)).sendKeys(message);
    }

    public void clickSubmit() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
