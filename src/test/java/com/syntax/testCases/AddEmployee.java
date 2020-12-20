package com.syntax.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.utilities.CommonMethods;
import com.syntax.utilities.ConfigsReader;

public class AddEmployee extends CommonMethods {
	
	@Test (priority=1)
	
	public void addEmployeeWihtPic() throws InterruptedException {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
		
		dashboard.navigateToAddEmp();
		
		sendText(addEmp.fName, "z");
		sendText(addEmp.mName, "x");
		sendText(addEmp.lName, "c");
	 
		
		addEmp.photoUp.sendKeys("/Users/vepagurbangeldiyev/Documents/scree.png");
		
		wait(5);
		addEmp.checkBox.click();
		
		sendText(addEmp.userName, "zdvvdz" );
		sendText(addEmp.userPassword, "Joseph123_Leo-1316" );
		sendText(addEmp.confPassword, "Joseph123_Leo-1316" );
		
		
		wait(5);
		
		selectDDValue(addEmp.status, "Disabled");
		
		if (addEmp.saveBtn.isEnabled()) {
			jsClick(addEmp.saveBtn);
			System.out.println("button is clickble");
		}else {
			System.out.println("button is not clickble");
		}
		
		wait(5);	
		
		
		SoftAssert asrt=new SoftAssert();
		
		String actual=persDet.empFullName.getText();
		System.out.println(actual);
		String expected= "z x c";
		AssertJUnit.assertEquals(actual, expected);
		
		if (persDet.empPic.isDisplayed()) {
			System.out.println("Picture is displayed");
		}else {
			System.out.println("Picture is not displayed");
		}
		wait(5);
		test.info("adding employee"); // if you will run this code via eclipse testng u need to comment out it 
									//but when you will rin via xml delete the comment
		asrt.assertAll();
		
		
		wait(5);
		
		
		
		
		
		
	}
	

}
