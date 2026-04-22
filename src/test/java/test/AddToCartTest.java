package test;

import org.testng.annotations.Test;

import utils.DriverManager;

public class AddToCartTest extends DriverManager{
	@Test
	public void addTest()
	{
		addcart.categoryWomen();
		addcart.categoryChild();
		addcart.categoryPolo();
	}

}
