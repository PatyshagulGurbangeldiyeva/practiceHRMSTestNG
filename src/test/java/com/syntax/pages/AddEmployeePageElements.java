package com.syntax.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.testBase.BaseClass;
import com.syntax.utilities.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {
	
	
	@FindBy (id="firstName")
	public WebElement fName;
	
	@FindBy (id="middleName")
	public WebElement mName;
	
	@FindBy (id="lastName")
	public WebElement lName;
	
	@FindBy (id="employeeId")
	public WebElement empId;
	
	@FindBy (id="photofile")
	public WebElement photoUp;
	
	@FindBy (id="chkLogin")
	public WebElement checkBox;
	
	@FindBy (id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy (id="re_password")
	public WebElement confPassword;
	
	@FindBy (id="status")
	public WebElement status;
	
	@FindBy (id="btnSave")
	public WebElement saveBtn;
	
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	

}
