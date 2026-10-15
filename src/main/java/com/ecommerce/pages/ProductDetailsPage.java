package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	private WebDriver driver;
	
	@FindBy(className = "inventory_details_name")
	private WebElement productName;
	
	@FindBy(className = "inventory_details_desc")
	private WebElement productDescription;
	
	@FindBy(className = "inventory_details_price")
	private WebElement productPrice;
	
	@FindBy(id = "back-to-products")
	private WebElement backToProductsButton;
	
	public ProductDetailsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public String getProductName() {
		
		return productName.getText();
		
	}
	
	public String getProductDescription() {
		
		return productDescription.getText();
		
	}
	
	public String getProductPrice() {
		
		return productPrice.getText();
		
	}
	
	public void clickBackToProduction() {
		
		backToProductsButton.click();
		
	}

}
