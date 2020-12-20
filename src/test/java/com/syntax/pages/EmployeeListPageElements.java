package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utilities.CommonMethods;

public class EmployeeListPageElements extends CommonMethods{
	
	
	@FindBy (id="empsearch_id")
	public WebElement idSearch;
	
	@FindBy (id="empsearch_employee_status")
	public WebElement empStatus;
	
	@FindBy (id="empsearch_termination")
	public WebElement include;
	
	@FindBy (id="empsearch_supervisor_name")
	public WebElement supervisor;
	
	@FindBy (id="empsearch_job_title")
	public WebElement jobTitle;
	
	@FindBy (id="empsearch_sub_unit")
	public WebElement subUnit;
	
	@FindBy (id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy (xpath="//table[@id='resultTable']/tbody/tr/td[2]")
	public List <WebElement> empIds;
	
	@FindBy (xpath="//ul[@class='paging top']/li[9]/a")
	public WebElement nextButton;
		
	
	public EmployeeListPageElements(){
		PageFactory.initElements(driver, this);
	}
	
public void searchEmp(String idExpected) {
		
		
		for (WebElement empId:empIds) {
			String empID=empId.getText();
			
			if (empID.equalsIgnoreCase(idExpected)) {
				empId.click();
				break;
			}else {
				jsClick(nextButton);
			}
		}
	}

}
