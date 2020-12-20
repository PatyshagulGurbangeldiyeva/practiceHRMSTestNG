package com.syntax.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.syntax.utilities.ConfigsReader;
import com.syntax.utilities.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@BeforeTest (alwaysRun=true)
	public void generatereport() {
		ConfigsReader.readProperty(Constants.CONFIGURATION_FILEPATH);
		
		htmlReport=new ExtentHtmlReporter (Constants.REPORT_FILEPATH);
		htmlReport.config().setDocumentTitle(ConfigsReader.getProperty("reportTitle"));
		htmlReport.config().setReportName(ConfigsReader.getProperty("reportName"));
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
	}
	
	@AfterTest(alwaysRun = true)
	public void writeReport() {
		System.out.println("writing report");
		report.flush();
	}
	
	
	@BeforeMethod (alwaysRun=true)
	public WebDriver setUp() {
		
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		
		
		// first we need to initialize prop variable then we can get the property
		ConfigsReader.readProperty(Constants.CONFIGURATION_FILEPATH);
		
		
		String headless=ConfigsReader.getProperty("headless");
		
		
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cOptions=new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				driver=new ChromeDriver(cOptions);
			}else {
				driver=new ChromeDriver();
			}
			break;
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}
				// driver.manage().window().fullscreen();
				
				driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
				
				
				
				driver.get(ConfigsReader.getProperty("url"));
				// initialize all page objects as part of setup
				PageInitializer.initialize();

				
		
	
		return driver;
	}
	
	@AfterMethod (alwaysRun=true) // to make this method to run after every @Test method
	public static void tearDown() {
		if (driver !=null) {
			driver.quit();
		}
	}	
	
}


