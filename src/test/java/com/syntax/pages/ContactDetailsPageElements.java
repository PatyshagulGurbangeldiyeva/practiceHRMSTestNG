package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utilities.CommonMethods;

public class ContactDetailsPageElements extends CommonMethods {
	
	@FindBy (xpath="//ul[@id='sidenav']")
	public List <WebElement> lists;
	
	@FindBy (xpath="//form[@id='frmEmpContactDetails']//li")
	public List <WebElement> contacDet;
	
	
	
	
	public ContactDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectList(String input) {
		for (WebElement list: lists ) {
			String str= list.getText();
			if (str.equalsIgnoreCase(input)) {
				list.click();
				break;
			}

			
		}
	}
	
	
		
	}


