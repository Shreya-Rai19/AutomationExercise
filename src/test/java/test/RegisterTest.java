package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CredentialUtil;
import utils.DriverManager;

public class RegisterTest extends DriverManager {
	
	@Test
	public void registerTest() {
		homepage.clickLoginOrSignup();
		signuploginpage.enterUsername(CredentialUtil.username);
		signuploginpage.enterEmail(CredentialUtil.email);
		signuploginpage.clickSignUp();
		signuploginpage.clickTitle("male");
		signuploginpage.enterName("admin");
		signuploginpage.enterPassword(CredentialUtil.password);
		signuploginpage.enterDob("1", "January", "2000");
		signuploginpage.enterFirstName("Admin");
		signuploginpage.enterLastName("User");
		signuploginpage.enterAddress("123 Main Road");
		signuploginpage.enterState("Karnataka");
		signuploginpage.enterCity("Bangalore");
		signuploginpage.enterZipcode("123456");
		signuploginpage.enterMobileNo("1234567890");
		signuploginpage.clickCreateAccountButton();
		Assert.assertTrue(signuploginpage.getAccountCreatedMessage().toLowerCase().contains("account created"));
		signuploginpage.clickContinue();
		homepage.clickLogout();
	}

}
