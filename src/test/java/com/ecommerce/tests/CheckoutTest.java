package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;

public class CheckoutTest extends BaseTest {
	
	@Test
	public void verifyCheckoutInformation() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.openShoppingCart();
		System.out.println("URL before Checkout: " + driver.getCurrentUrl());
		System.out.println("Cart item count: " + cartPage.getCartItemCount());
		
		cartPage.clickCheckout();
		
		System.out.println("Current URL after Checkout: " +driver.getCurrentUrl());
		System.out.println("Page title: " + driver.getTitle());
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.enterCheckoutInformation("John", "Smith", "600001");
		checkoutPage.clickContinue();
		System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page text: " + driver.findElement(By.tagName("body")).getText());
		
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), "Checkout Overview page was not displayed.");
		
	}

}