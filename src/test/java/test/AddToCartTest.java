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
		
		cart.goToCart();
	       
	     int count = cart.getItemCount();
	     System.out.println("Item Count: "+count);

	     cart.removeTwoItems();


	     int after = cart.getItemCount();
	     System.out.println("After Remove: " + after);
	     
	     homepage.clickLogout();
	}

}
