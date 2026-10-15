package com.ecommerce.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	private WebDriver driver;
	private LoginPage loginPage;

	@Given("the user is on the SauceDemo login page")
	public void userIsOnLoginPage() {

		driver = Hooks.driver;
		loginPage = new LoginPage(driver);

		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "User is not on the SauceDemo login page");

	}

	@When("the user enters a valid username and password")
	public void userEntersCredentials() {

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");

	}

	@When("the user clicks the login button")
	public void userClicksLoginButton() {

		loginPage.clickLoginButton();

	}

	@Then("the products page should be displayed")
	public void productsPageShouldBeDisplayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("inventory.html"));
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Products page was not displayed");

	}

	@Then("the products page title should be {string}")
	public void verifyProductsPageTitle(String expectedTitle) {

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Products page title does not match");

	}

	@When("the user logs out")
	public void userLogsOut() {
		
		WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
		menuButton.click();

		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logoutButton.click();
		System.out.println("User logged out successfully.");
		
	}

	@Then("the login page should be displayed")
	public void loginPageShouldBeDisplayed() {

	    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.or(ExpectedConditions.urlContains("saucedemo.com"),ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))));
	    System.out.println("URL after logout: " + Hooks.driver.getCurrentUrl());
	    System.out.println("Page title after logout: " + Hooks.driver.getTitle());
	    
	}
	
}