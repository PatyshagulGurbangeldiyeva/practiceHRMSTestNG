package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.testBase.BaseClass;
import com.syntax.utilities.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	
	@FindBy (id="welcome")
	public WebElement welcome;
	
	
	@FindBy (xpath="//div[@id='branding']/a[1]/img")
	public WebElement logo;
	
	
	// by using this locater you can handle all the dashBoard menu on dashbopard page: admin, pim...
	@FindBy (xpath="//div[@class='menu']/ul/li")
	public List <WebElement> dashMenu;
	
	
	@FindBy (xpath="//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;
	
	@FindBy (id="menu_pim_Configuration")
	public WebElement configuration;
	
	@FindBy (id="menu_pim_viewEmployeeList")
	public WebElement empList;
	
	@FindBy (id="menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy (id="menu_core_viewDefinedPredefinedReports")
	public WebElement reports;
	
	
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	/**
	 * This method will navigate to Configuration under the PIM
	 */
	public void navigateToConfiguration() {
		jsClick(PIM);
		jsClick(configuration);
	}
	
	
	/**
	 * This method will navigate to empList under the PIM
	 */
	public void navigateToEmpList() {
		jsClick(PIM);
		jsClick(empList);
	}

	/**
	 * This method will navigate to addEmp under the PIM
	 */
	public void navigateToAddEmp() {
		jsClick(PIM);
		jsClick(addEmp);
	}
	
	
	/**
	 * This method will navigate to reports under the PIM
	 */
	public void navigateToReports() {
		jsClick(PIM);
		jsClick(reports);
	}
}
