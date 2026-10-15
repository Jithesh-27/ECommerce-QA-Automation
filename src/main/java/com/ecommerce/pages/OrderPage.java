package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    private WebDriver driver;

    @FindBy(className = "complete-header")
    private WebElement orderCompleteHeader;

    @FindBy(className = "complete-text")
    private WebElement orderCompleteMessage;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public OrderPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        
    }

    public String getOrderCompleteHeader() {
    	
        return orderCompleteHeader.getText();
        
    }

    public String getOrderCompleteMessage() {
    	
        return orderCompleteMessage.getText();
        
    }

    public void clickBackToProducts() {
    	
        backToProductsButton.click();
        
    }
    
}