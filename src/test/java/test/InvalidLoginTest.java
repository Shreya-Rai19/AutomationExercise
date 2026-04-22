package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DriverManager;

public class InvalidLoginTest extends DriverManager {

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
            {"wronguser@example.com", "wrongpassword"},
            {"validuser@example.com", "wrongpassword"},
            {"wronguser@example.com", "ValidPassword123"},
            {"", "somepassword"},
            {"user@example.com", ""},
            {"", ""}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String email, String password) {
        invalidPage.goToLoginPage();
        invalidPage.login(email, password);

        if (email.isEmpty() || password.isEmpty()) {

            Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        } 
        else {

            String error = invalidPage.getErrorMessage();

            Assert.assertEquals(error,
                    "Your email or password is incorrect!");
        }
    }
}