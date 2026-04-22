package test;

import org.testng.annotations.Test;

import utils.DriverManager;

public class RegisterTest extends DriverManager {
	
	@Test
	public void registerTest() {
		homepage.clickLoginOrSignup();
	}

}
