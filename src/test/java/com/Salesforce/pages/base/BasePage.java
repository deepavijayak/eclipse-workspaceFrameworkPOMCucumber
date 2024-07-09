package com.Salesforce.pages.base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Salesforce.utilities.ExtentReportsUtility;
import com.google.common.io.Files;
import com.Salesforce.utilities.ExtentReportsUtility;
public class BasePage {
	protected WebDriver driver;
	Logger mylog = LogManager.getLogger(BasePage.class);
	private WebDriverWait wait=null;
//	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			mylog.info("data is entered in " + objectName + " textbox");
	//		extentReport.logTestInfo("username data is entered in " + objectName + " textbox");
			
		} else {
			mylog.error(objectName + " element is not displayed");
		}
	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			mylog.info(objectName + "button is clicked");
	//		extentReport.logTestInfo(objectName + "button is clicked");
			
		} else {
			mylog.error(objectName+" element is not enabled");
			
		}
	}
	public void checkboxElement(WebElement ele, String objectName) {
	if (!ele.isSelected()) {
		ele.click();
	    System.out.println("Checkbox is now selected.");
	} else {
		mylog.error(objectName+" element is not enabled");
	}
	}
	public String getTextFromElement(WebElement ele, String objectName) {
		String data=null;
		if(ele.isDisplayed()) {
		data = ele.getText();
		mylog.info("text is extracted from "+objectName);
		}
		else {
			mylog.error(objectName+" not dispalyed");
		}
		return data;
	}
//	public void waitForVisibility(WebElement ele,Duration timeInSec,String ObjectName) {
//		System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec");
//		wait=new WebDriverWait(driver,timeInSec);
//		wait.until(ExpectedConditions.visibilityOf(ele));
//	}
	public void waitForVisibility(WebElement ele,long timeInSec,String ObjectName) {
		mylog.info(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec");
		
	}
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
			try	 {
				Files.copy(src, destination);
				mylog.info("Captured the Screen");
			}catch(IOException e) {
			e.printStackTrace();	
			mylog.info("Went wrong when capturing screen");
		 
			}
	}
	

}
