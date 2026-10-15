package com.ecommerce.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.pages.OrderPage;

public class OrderTest extends BaseTest {

	@Test
	public void verifyOrderCompletion() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

		CartPage cartPage = new CartPage(driver);
		cartPage.openShoppingCart();
		cartPage.clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.enterCheckoutInformation("John", "Smith", "600001");
		checkoutPage.clickContinue();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), "Checkout Overview page was not displayed.");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();

		OrderPage orderPage = new OrderPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
		Assert.assertEquals(orderPage.getOrderCompleteHeader(), "Thank you for your order!");

		Assert.assertTrue(orderPage.getOrderCompleteMessage().contains("dispatched"), "Order confirmation message was incorrect.");
		orderPage.clickBackToProducts();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Products page was not displayed.");
		
	}

}