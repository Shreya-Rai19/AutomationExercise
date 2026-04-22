package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverManager;

public class LoginTest extends DriverManager {

    @Test
    public void validLoginTest() {
        
        loginpage.clickSignupLogin();

        
        loginpage.enterEmail();
        loginpage.enterPassword();
        loginpage.clickLoginButton();

        
        Assert.assertTrue(loginpage.isLoginSuccessful(), "Login Failed");
    }
}
