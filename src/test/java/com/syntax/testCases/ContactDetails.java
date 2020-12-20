package com.syntax.testCases;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import com.syntax.utilities.CommonMethods;

public class ContactDetails extends CommonMethods{
	
	@Test
	public static void addContactDetails() {
		
		Login.login();
		
		dashboard.navigateToEmpList();
		
		sendText(empList.idSearch, "8997");
		
		jsClick(empList.searchBtn);
		
		empList.searchEmp("8997"); // if you will run this code in this pg
								  // go to login steps and comment out testInfo
									// then here TestNg will run, or you need to run it via xml/pomxml
		
		
		
		SoftAssert asrt= new SoftAssert();
		
		String actual= persDet.empFullName.getText();
		String expected="z x c";
		
		asrt.assertEquals(actual, expected, "The name is not matching");
		
		test.info("searching emp by id and adding contact details");
		asrt.assertAll();
		
		
	}
	
	

}
