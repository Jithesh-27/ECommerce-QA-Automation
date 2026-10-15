package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	private WebDriver driver;
	
	@FindBy(className = "cart_item")
	private List<WebElement> cartItems;
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> productNames;
	
	@FindBy(className = "inventory_item_price")
	private List<WebElement> productPrices;
	
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	
	@FindBy(className = "shopping_cart_link")	
	private WebElement shoppingCartLink;
	
	@FindBy(id = "continue-shopping")
	private WebElement continueShoppingButton;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public int getCartItemCount() {
		
		return cartItems.size();
		
	}
	
	public List<String> getProductNames() {
		
		return productNames.stream().map(WebElement::getText).toList();
		
	}
	
	public List<String> getProductPrices() {
		
		return productPrices.stream().map(WebElement::getText).toList();
		
	}
	
	public void clickCheckout() {
		
		checkoutButton.click();
		
	}
	
	public void openShoppingCart() {
		
		shoppingCartLink.click();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
	}
	
	public void clickContinueShopping() {
		
		continueShoppingButton.click();
		
	}

}