package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void verifySuccessfulLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(actualURL.contains("inventory.html"), "Login failed: Product page was not displayed.");
		
	}

}
