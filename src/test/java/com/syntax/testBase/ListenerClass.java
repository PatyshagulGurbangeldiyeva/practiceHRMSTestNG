package com.syntax.testBase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.syntax.utilities.CommonMethods;



public class ListenerClass implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {//this listener executes based on <test> from xml file
		System.out.println("Functionality Testing Start");
		

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing Finished");
	}

	@Override
	public void onTestStart(ITestResult result) {//this listener executes when @Test method starts
		System.out.println("Test Started " + result.getName());
		BaseClass.test=BaseClass.report.createTest(result.getName()); // it takes name of the method, and we can see it on the left side of hrms report
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed " + result.getName());
		BaseClass.test.pass("Test Case pass "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed " + result.getName());
		BaseClass.test.fail("Test Case Failed "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/"+result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
