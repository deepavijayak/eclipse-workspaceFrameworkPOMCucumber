package com.Salesforce.pages.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Salesforce.pages.base.BasePage;

public class ForgotPassword extends BasePage{

	@FindBy(id="userNavLabel") WebElement usermenudropdownele;
	@FindBy(xpath ="//a[@title='Logout']") WebElement logoutele;
	@FindBy(xpath ="//input[@name='un']") WebElement Forgotpwdusername_ele;	
	@FindBy(id="continue") WebElement continue_ele;
	@FindBy(id="header") WebElement Checkemail_ele;
	
	@FindBy(xpath ="/html/body/div[1]/div/div/div[2]/div/div/p[1]") WebElement forgotpwdmsg;
	@FindBy(xpath ="//*[@id=\"forgotPassForm\"]/a") WebElement returntologinbut_ele;
	
	   public ForgotPassword(WebDriver driver) {
				super(driver);
		}
			
		public void getforgotpwdPageTitle()	{
		String forgotpwdpageTitle = driver.getTitle();// Verifying home page title
		System.out.println(forgotpwdpageTitle);
		}
		
		public void enterFPUserName(String data) {
			enterText(Forgotpwdusername_ele, data, "username field");
		}
		
		public WebDriver Continuebutton() {
			clickElement(continue_ele, "continue");
			return driver;
		}
		
		public String getTextFromcheckEmailText() {
			waitForVisibility(Checkemail_ele, 30,"Check your email");
			String data= getTextFromElement(Checkemail_ele, "check Email page");
			System.out.println("text extracted from check email page="+data);
			return data;
		}
	
		//verify the message An email associated with the <username> account is sent.
		public String extractconfirmTextmsg() {
			String actualMsg = forgotpwdmsg.getAttribute("innerHTML");
			System.out.println(actualMsg);
			String expmsg="We’ve sent you an email with a link to finish resetting your password.";
			Assert.assertEquals(actualMsg, expmsg);
	 		System.out.println("Confirmation message verified");
			return expmsg;
		}
		public WebDriver Returntologinbutton() {
			clickElement(returntologinbut_ele, "return to login button");
			return driver;
		}
		public void getforgotpwdemailpageTitle()	{
			String forgotpwdemailTitle = driver.getTitle();// Verifying home page title
			System.out.println(forgotpwdemailTitle);
			}
		
		public WebDriver userMenuDropdown() {
			clickElement(usermenudropdownele, "Usermenu");
			return driver;
		}
		
		public WebDriver logoutMenuOption() {
			clickElement(logoutele, "Usermenulogoutoption");
			return driver;
		}	

	}



