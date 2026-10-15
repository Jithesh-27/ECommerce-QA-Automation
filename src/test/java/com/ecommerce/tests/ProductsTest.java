package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.ProductsPage;

public class ProductsTest extends BaseTest {
	
	@Test
	public void verifyProductsPage() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertEquals(productsPage.getPageTitle(), "Products", "Products page title is incorrect.");
		Assert.assertEquals(productsPage.getProductCount(), 6, "The products count is inncorrect.");
		
	}

}