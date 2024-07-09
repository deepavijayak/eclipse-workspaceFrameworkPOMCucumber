package com.Salesforce.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Salesforce.base.BaseSFTest;
import com.Salesforce.pages.login.ForgotPassword;
//import com.Salesforce.base.BaseSFfunctionality;
import com.Salesforce.pages.login.LoginPage;
import com.Salesforce.pages.login.SalesForceHomePage;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
import org.testng.annotations.Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Salesforce.utilities.TestListenerUtility.class)
public class SfdcAutomation extends BaseSFTest{
	
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	@Test
	public void Sdfcloginpositive() throws InterruptedException{ //TC-1
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamedata);
		loginpage.enterPassword(passworddata);
		driver=loginpage.clickLoginButton();
		Thread.sleep(2000);
		SalesForceHomePage homepage=new SalesForceHomePage(driver);
		homepage.getPageTitle();
//		mylog.info("Title verified");
//		driver=homepage.clickusermenudropdown();
	}
	
	@Test
	public void Sfdcinvalidlogin() throws InterruptedException {//TC-2
		// initalizing the chrome browser interface
		 // calling the launchbrowser reusable class
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//String actualMsg = driver.findElement(By.id("error")).getAttribute("innerHTML");
		String experror="Please enter your password.";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamedata);
		loginpage.enterPassword(" ");
		driver=loginpage.clickLoginButton();
		loginpage.extractTextErrormsg();
	}
	@Test
	public void Sfdcrememberme() throws InterruptedException {
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernamedata);
		loginpage.enterPassword(passworddata);
		driver=loginpage.checkRememberMe();
		driver=loginpage.clickLoginButton();
		Thread.sleep(2000);
		SalesForceHomePage homepage=new SalesForceHomePage(driver);
		//homepage.getPageTitle();
		driver=loginpage.userMenuDropdown();
		System.out.println("Usermenu dropdown clicked");
		driver=homepage.logoutMenuOption();
		System.out.println("Logout dropdown clicked");
		Thread.sleep(2000);
		loginpage.getloginPageTitle();
		loginpage.remembermeusernameverify();
	}
	@Test
	public void Sfdcforgotpwd() throws InterruptedException {
		
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickForgotPwd();
		ForgotPassword forgotpwdpage=new ForgotPassword(driver);
		forgotpwdpage.getforgotpwdPageTitle();
		forgotpwdpage.enterFPUserName(usernamedata);
		forgotpwdpage.Continuebutton();
		Thread.sleep(8000);
	//	forgotpwdpage.getforgotpwdemailpageTitle();
	//	String resetpwdemailtitle = driver.getTitle();
	//	System.out.println(resetpwdemailtitle);
		String expecteddata = "Check Your Email"; 
		String actualText=forgotpwdpage.getTextFromcheckEmailText();
		Assert.assertEquals(actualText, expecteddata);
		forgotpwdpage.extractconfirmTextmsg();		
		forgotpwdpage.Returntologinbutton();
	}
	@Test
	public void SfdcInvalidUsernamePwd() {
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("123");
		loginpage.enterPassword("22131");
		loginpage.clickLoginButton();
		loginpage.extractTextInvalidErrormsg();
	}
		
}	

	


