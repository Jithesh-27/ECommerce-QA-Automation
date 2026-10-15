package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	private WebDriver driver;
	
	@FindBy(className = "inventory_item_name")
	private List<WebElement> productList;
	
	@FindBy(className = "title")
	private WebElement pageTitle;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartLink;
	
	public ProductsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public int getProductCount() {
		
		return productList.size();
		
	}
	
	public String getPageTitle() {
		
		return pageTitle.getText();
		
	}
	
	public void openShoppingCart() {
		
		shoppingCartLink.click();
		
	}

}