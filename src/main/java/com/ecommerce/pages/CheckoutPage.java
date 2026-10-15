package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	private WebDriver driver;
	
	@FindBy(id = "first-name")
	private WebElement firstNameField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeField;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(id = "cancel")
	private WebElement cancelButton;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void enterFirstName(String firstName) {
		
		firstNameField.sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		
		lastNameField.sendKeys(lastName);
		
	}
	
	public void enterPostalCode(String postalCode) {
		
		postalCodeField.sendKeys(postalCode);
		
	}
	
	public void clickContinue() {
		
		continueButton.click();
		
	}
	
	public void clickCancel() {
		
		cancelButton.click();
		
	}
	
	public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
		
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);
		
	}

}