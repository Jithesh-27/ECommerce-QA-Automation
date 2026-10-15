package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.LoginPage;

public class CartTest extends BaseTest {
	
	@Test
	public void verifyAddProductToCart() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		System.out.println("Cart badge: " +driver.findElement(By.className("shopping_cart_badge")).getText());
		driver.findElement(By.className("shopping_cart_link")).click();
		System.out.println("Cart page source contains cart_item: " + driver.getPageSource().contains("cart_item"));
		System.out.println("Cart page source contains Backpack: " +driver.getPageSource().contains("Sauce Labs Backpack"));
		
		System.out.println("Current URL: " +driver.getCurrentUrl());
		System.out.println("Cart item elements: " +driver.findElements(By.className("cart-item")).size());
		
		CartPage cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart should contain one product.");
		Assert.assertTrue(cartPage.getProductNames().contains("Sauce Labs Backpack"), "Sauce Labs Backpack was not found in the cart.");
		Assert.assertEquals(cartPage.getProductPrices().size(), 1, "Cart should display one product price.");
		
	}

}