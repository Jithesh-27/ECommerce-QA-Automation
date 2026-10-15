package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.utilities.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waitUtils = new WaitUtils(driver);
        
    }

    public void enterUsername(String username) {
    	
        usernameField.sendKeys(username);
        
    }

    public void enterPassword(String password) {
    	
        passwordField.sendKeys(password);
        
    }

    public void clickLoginButton() {
    	
        loginButton.click();
        
    }

    public void login(String username, String password) {
    	
        enterUsername(username);
        enterPassword(password);
        waitUtils.waitForElementToBeClickable(loginButton).click();
        
    }
    
}