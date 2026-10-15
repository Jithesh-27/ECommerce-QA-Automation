package com.ecommerce.runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.ecommerce.utilities.TestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(TestListener.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "com.ecommerce.stepdefinitions",
	    plugin = {"pretty"},
	    monochrome = true,
	    tags = "@regression"
	    
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
    	
        return super.scenarios();
        
    }
    
}