package com.syntax.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.testBase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * This method is used in order to get date and time of the scrennshot
	 * 
	 * @return TimeOfSchreenShot
	 */
	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}

	/**
	 * This method takes ScreenShot
	 * 
	 * @param filename
	 * @return destinationOfFile
	 */
	public static String takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";
		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		return destinationFile;
	}

	/**
	 * This method clear and sendKeys to textBox
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This method chacke is there is a text and then selects the element
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectDDValue(WebElement element, String text) {

		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();

			for (WebElement option : options) {
				if (option.getText().equals(text)) {
					select.selectByVisibleText(text);
					break;
				}

			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This methods selects value by index
	 * @param element
	 * @param index
	 */
	public static void selectDDValueIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will return WebDriverWait
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}
	
	
	/**
	 * This method will wait till the element is clickable
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * This method will wait till element will visible
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will return js
	 * @return
	 */
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * This method will click after waiting
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	
	/**
	 * This method will click with js
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	

	/**
	 * This method will scroll the Element
	 * @param element
	 */

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	
	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will wait the seconds that you are declaring
	 * @param second
	 */
	
	public static void wait (int second) {
		try {
			Thread.sleep(second*1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

    /**
     * Methods that accept alerts and catches exception if alert is not present
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    /**
     * Methods that dismiss alerts and catches exception if alert is not present
     */
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
    /**
     * Methods that gets text of alert and catches exception if alert is not present
     * 
     * @return String alert text
     */
    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
        return alertText;
    }

}
