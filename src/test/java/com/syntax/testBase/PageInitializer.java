package com.syntax.testBase;

import com.syntax.pages.AddEmployeePageElements;
import com.syntax.pages.DashboardPageElements;
import com.syntax.pages.EmployeeListPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass{
	
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements persDet;
	public static EmployeeListPageElements empList;
	
public static void initialize() {
		
		login=new LoginPageElements();
		dashboard=new DashboardPageElements();
		addEmp=new AddEmployeePageElements();
		persDet=new PersonalDetailsPageElements();
		empList=new EmployeeListPageElements();
	}

}
