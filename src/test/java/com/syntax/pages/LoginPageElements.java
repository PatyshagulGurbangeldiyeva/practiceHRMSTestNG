package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.testBase.BaseClass;

public class LoginPageElements {
	
	
	
	@FindBy(id="txtUsername")
	public WebElement username;
		
	@FindBy(id="txtPassword")
	public WebElement password;	
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy (id="spanMessage")
	public WebElement invalidCredentials;
	
	@FindBy (id="spanMessage")
	public WebElement emptyCredentials;
	
	
	public LoginPageElements(){	
	PageFactory.initElements(BaseClass.driver, this);
	}

}
