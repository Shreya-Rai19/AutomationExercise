package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

  
    private static final String EMAIL = "swa123@gmail.com";
    private static final String PASSWORD = "1234567";

  
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    By signupLoginLink = By.xpath("//a[@href='/login']"); // "Signup / Login" link on homepage
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");

    // Actions
    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
    }

    public void enterEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(EMAIL);
    }

    public void enterPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPassword)).sendKeys(PASSWORD);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAs)).isDisplayed();
    }
}
