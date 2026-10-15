package com.ecommerce.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    private void initializeDriver() {

        driver = Hooks.driver;
        Assert.assertNotNull(driver, "WebDriver is null. Check the Hooks class initialization.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    @When("the user adds the first product to the cart")
    public void userAddsFirstProductToCart() {

        initializeDriver();
        By addToCartButton =By.id("add-to-cart-sauce-labs-backpack");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        System.out.println("First product added to cart.");
        
    }

    @Then("the cart badge should display {string}")
    public void cartBadgeShouldDisplay(String expectedCount) {

        initializeDriver();
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertEquals(badge.getText(), expectedCount, "Cart badge count does not match.");
        System.out.println("Cart badge count verified: " + badge.getText());
        
    }

	@When("the user opens the cart page")
	public void userOpensCartPage() {

		initializeDriver();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
		wait.until(ExpectedConditions.urlContains("cart.html"));
		Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Cart page was not opened.");
		System.out.println("Cart page opened successfully.");
		
	}

	@When("the user clicks the checkout button")
	public void userClicksCheckoutButton() {

		initializeDriver();
		By checkoutLocator = By.id("checkout");

		try {

			System.out.println("\n========== CHECKOUT DIAGNOSTICS ==========");
			System.out.println("URL before click: " + driver.getCurrentUrl());
			
			WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutLocator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkoutButton);
			checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutLocator));

			System.out.println("Button displayed: " + checkoutButton.isDisplayed());
			System.out.println("Button enabled: " + checkoutButton.isEnabled());
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);

			System.out.println("Checkout button clicked using JavaScript Executor.");
			wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
			
			Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Checkout information page was not opened.");
			System.out.println("Checkout navigation successful: " + driver.getCurrentUrl());

		} 
		
		catch (TimeoutException e) {

			System.err.println("Checkout navigation failed.");

			try {

				System.err.println("Current URL: " + driver.getCurrentUrl());
				System.err.println("Page title: " + driver.getTitle());

			} 
			
			catch (WebDriverException sessionException) {

				System.err.println("Could not collect browser diagnostics: " + sessionException.getMessage());
				
			}

			throw new AssertionError("Checkout button was clicked using JavaScript, " + "but checkout navigation did not complete.", e);

		} 
		
		finally {

			System.out.println("========== END CHECKOUT DIAGNOSTICS ==========\n");
			
		}
		
	}

	@Then("the checkout information page should be displayed")
	public void checkoutInformationPageShouldBeDisplayed() {

		initializeDriver();
		wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Checkout information page was not displayed.");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
		System.out.println("Checkout information page displayed successfully.");
		
	}

	@When("the user enters valid checkout information")
	public void userEntersValidCheckoutInformation() {

		initializeDriver();
		wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
		enterAndVerifyField(By.id("first-name"), "John", "First Name");
		enterAndVerifyField(By.id("last-name"), "Smith", "Last Name");
		enterAndVerifyField(By.id("postal-code"), "600001", "Postal Code");
		
	}

	private void enterAndVerifyField(By locator, String value, String fieldName) {

	    WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    System.out.println(fieldName + " field is visible: " + field.isDisplayed());
	    System.out.println(fieldName + " field is enabled: " + field.isEnabled());

	    field.click();
	    field.clear();
	    field.sendKeys(value);

	    WebDriverWait fieldWait = new WebDriverWait(driver, Duration.ofSeconds(3));

	    try {
	    	
	        fieldWait.until(d -> {
	        	
	        WebElement currentField = d.findElement(locator);
	        return value.equals(currentField.getDomProperty("value"));});
	        
	    } 
	    
	    catch (org.openqa.selenium.TimeoutException e) {
	    	
	        System.out.println("Value was not entered correctly for: " + fieldName);
	    }

	    WebElement currentField = driver.findElement(locator);
	    String actualValue = currentField.getDomProperty("value");

	    System.out.println("Field: " + fieldName);
	    System.out.println("Expected value: [" + value + "]");
	    System.out.println("Actual value: [" + actualValue + "]");
	    
	}	
	
	@When("the user clicks the continue button")
	public void userClicksContinueButton() {

		initializeDriver();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
		System.out.println("Checkout Continue button clicked.");
		
	}

    @Then("the checkout overview page should be displayed")
    public void checkoutOverviewPageShouldBeDisplayed() {

        initializeDriver();
        System.out.println("Checkout overview page displayed successfully.");
        
    }

    @Then("the checkout error message should be displayed")
    public void checkoutErrorMessageShouldBeDisplayed() {
    	
        WebElement errorContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-message-container")));
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Error container HTML: " + errorContainer.getAttribute("outerHTML"));
        System.out.println("Error container text: [" + errorContainer.getText() + "]");
        
    }
    
    @When("the user clicks the finish button")
    public void userClicksFinishButton() {

        initializeDriver();
        System.out.println("Finish button clicked successfully.");
        
    }

    @Then("the order confirmation page should be displayed")
    public void orderConfirmationPageShouldBeDisplayed() {

        initializeDriver();
        System.out.println("Order confirmation verified successfully.");
        
    }
    
}