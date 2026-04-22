package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverManager;

public class SearchTest extends DriverManager {

    @Test
    public void searchTwoProductsTest() {
       
        searchPage.clickProductsLink();
        searchPage.enterSearchText("T-Shirt");
        searchPage.clickSearchButtonAndScroll();
        Assert.assertTrue(searchPage.isProductDisplayed("T-Shirt"), "T-Shirt not found!");

        
        searchPage.clickProductsLink();
        searchPage.enterSearchText("Jeans");
        searchPage.clickSearchButtonAndScroll();
        Assert.assertTrue(searchPage.isProductDisplayed("Jeans"), "Jeans not found!");
    }
}
