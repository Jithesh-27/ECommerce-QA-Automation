package com.ecommerce.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
    	
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
        test.get().pass("Test passed");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
        test.get().fail(result.getThrowable());
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	
        test.get().skip("Test skipped");
        
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
    	
        extent.flush();
        
    }
    
}