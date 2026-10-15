package com.ecommerce.tests;

import org.testng.annotations.Test;
import com.ecommerce.utilities.ConfigReader;

public class ConfigReaderTest {

    @Test
    public void verifyConfigProperties() {

        System.out.println("Application URL: " + ConfigReader.getProperty("baseUrl"));
        System.out.println("Browser: " + ConfigReader.getProperty("browser"));
        System.out.println("Implicit Wait: " + ConfigReader.getProperty("implicitWait"));
        System.out.println("Explicit Wait: " + ConfigReader.getProperty("explicitWait"));
        
    }
    
}