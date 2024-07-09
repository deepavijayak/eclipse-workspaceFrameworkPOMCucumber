package com.Salesforce.base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
import com.google.common.io.Files;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Salesforce.utilities.TestListenerUtility.class)
public class BaseSFTest {
	Logger mylog = LogManager.getLogger(BaseSFTest.class);
	protected WebDriver driver = null;
	@BeforeMethod
	@Parameters("browserName")

	public void setUpBeforeMethod(@Optional("chrome") String BrowserName1) throws InterruptedException {
//		mylog.info("*********************setUpBeforeMethod**************************");
		mylog.info("****************setUpBeforeMethod*******************");
		launchBrowser(BrowserName1);
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		mylog.info("****************tearDownAfterTestMethod*******************");
	}
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser instance chrome created.");
			driver.manage().window().maximize();
			System.out.println("window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser instance chrome created.");
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser instance chrome created.");
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			System.out.println("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");
		
	}

	
	public void closeBrowser() {
		driver.close();
		System.out.println("browser instance closed");
		//driver=null;
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


	


