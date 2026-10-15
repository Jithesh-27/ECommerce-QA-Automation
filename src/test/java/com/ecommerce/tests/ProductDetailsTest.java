package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductDetailsPage;

public class ProductDetailsTest extends BaseTest {
	
	@Test
	public void verifyProductDetails() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		driver.findElement(org.openqa.selenium.By.id("item_4_title_link")).click();
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		
		Assert.assertEquals(productDetailsPage.getProductName(), "Sauce Labs Backpack", "Product name is incorrect");
		Assert.assertTrue(!productDetailsPage.getProductDescription().isEmpty(), "Product description is empty");
		Assert.assertTrue(!productDetailsPage.getProductPrice().isEmpty(), "Product price is empty");
		productDetailsPage.clickBackToProduction();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Did not return to the Products page.");
	
	}

}