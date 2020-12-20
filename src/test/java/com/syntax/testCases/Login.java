package com.syntax.testCases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.utilities.CommonMethods;
import com.syntax.utilities.ConfigsReader;

public class Login extends CommonMethods {
	
	@Test (priority=1, groups= {"smoke"})
	public  static void login() {
		
		
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
		
		String actual=dashboard.welcome.getText();
		System.out.println(actual);
		String expected="Welcome Admin";
		
		
		// if you use hardAssert and have priority second test will run
	//	Assert.assertEquals(actual, expected, "Text did not match");
		
		
		
		SoftAssert asrt=new SoftAssert();
		asrt.assertEquals(actual, expected, "Text did not match");
		
		// if you want to run just in this class you need to comment out test.info ----> when the test fails it will not appears in report
		test.info("entering valid credentials"); // we use this in order to see it in our report on the right side
		
		asrt.assertAll(); // it must be at the end of the codes
		
		
		
		
	}
	
	
	@Test (priority=2)
	public static void loginInvalidUserName() {
		
		
		
		sendText(login.username, "paty");
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
		
		String actual=login.invalidCredentials.getText();
		String expected="Invalid credentials";
		
		SoftAssert asrt=new SoftAssert();
		asrt.assertEquals(actual, expected, "Text did not match");
		
		test.info("entering invalid userName");
		asrt.assertAll();
		
		wait(5);
	}
	
	@Test (priority=3)
	public void loginInvalidPassword() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "abcd123");
		jsClick(login.loginBtn);
		
		String expected= "Invalid credentials";
		String actual= login.invalidCredentials.getText();
		SoftAssert asrt=new SoftAssert();
		asrt.assertEquals(actual, expected,"Text did not match");
		test.info("entering invalid password");
		asrt.assertAll();
		
		
		wait(5);
		
	}
	
	
}
