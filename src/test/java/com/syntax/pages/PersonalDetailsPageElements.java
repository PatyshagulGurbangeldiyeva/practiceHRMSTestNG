package com.syntax.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.testBase.BaseClass;
import com.syntax.utilities.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods{
	
	
	@FindBy (id="empPic")
	public WebElement empPic;
	
	@FindBy (xpath="//div[@id='profile-pic']//h1")
	public WebElement empFullName;
	
	
	
	public PersonalDetailsPageElements(){
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	

}
