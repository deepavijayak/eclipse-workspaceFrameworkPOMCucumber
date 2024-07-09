package com.Salesforce.pages.login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Salesforce.pages.base.BasePage;
public class LoginPage extends BasePage{
	// page factory where it will keep all the elements ready
		@FindBy(id="username") WebElement username_ele;
		@FindBy(id="password") WebElement password_ele;
		@FindBy(id="Login") WebElement login_butele;
		@FindBy(id="rememberUn") WebElement rememberMeCheckboxele;
		@FindBy(id="userNavLabel") WebElement usermenudropdownele;
		@FindBy(id="forgot_password_link") WebElement forgotPwdlinkele;
		@FindBy(id="error") WebElement errormsgInvalidlogin;
		@FindBy(id="idcard-identity") WebElement identifyidentityele;

		public void getloginPageTitle()	{
			String LoginpageTitle = driver.getTitle();// Verifying home page title
			System.out.println(LoginpageTitle);
		}
		public void remembermeusernameverify()	{
			if(identifyidentityele.isDisplayed()){
				System.out.println("Username is showing for remember me testcase passed" + identifyidentityele );
			}else {
				System.out.println("Username is not showing");
				}
		}
		
		public LoginPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void enterUserName(String data) {
			enterText(username_ele, data, "username field");
		}
		
		public void enterPassword(String data) {
			enterText(password_ele, data, "password field");
		}
		
		public WebDriver clickLoginButton() {
			clickElement(login_butele,"login button");
			return driver;
			
		}
		
		public String getTitleOfThePage() {
			//waitUntilPageLoads();
			return getTitleOfThePage();
		}
		public void login(String username,String password) {
			enterUserName(username);
			enterPassword(password);
			clickLoginButton();
		}
		
		public String extractTextErrormsg1() {
			
			return getText(errormsgInvalidlogin);
	   }
		public String extractTextErrormsg() {
			String actualMsg = errormsgInvalidlogin.getAttribute("innerHTML");
			System.out.println(actualMsg);
			String experror="Please enter your password.";
			Assert.assertEquals(actualMsg, experror);
			System.out.println("Error message verified");
			//return getText(errormsgInvalidlogin);
			return experror;
		}
		public String extractTextInvalidErrormsg() {
			String actualerrorMsg = errormsgInvalidlogin.getAttribute("innerHTML");
			System.out.println(actualerrorMsg);
			String experrorMsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
			Assert.assertEquals(actualerrorMsg, experrorMsg);
			System.out.println("Error message verified");
			//return getText(errormsgInvalidlogin);
			return experrorMsg;
		}
		private String getText(WebElement errormsgInvalidlogin2) {
			// TODO Auto-generated method stub
			return null;
		}
	
		public WebDriver checkRememberMe() {
			checkboxElement(rememberMeCheckboxele,"Remember Me");
			return driver;
		}
		public WebDriver userMenuDropdown() {
			clickElement(usermenudropdownele, "Usermenu");
			return driver;
		}
		public WebDriver clickForgotPwd() {
			clickElement(forgotPwdlinkele,"Forgot Password");
			return driver;
		}
	/*	public Alert switchToErrorAlert() {
			return switchToAlert();
		}
		public String extractTextFromAlert(Alert a) {
			return getAlertText(a,"LOginError Alert");
		}
		public void acceptErrorAlert(Alert a) {
			AcceptAlert(a);
		}
		public void rejectErrorAlert(Alert a) {
			dismisAlert(a);
		}*/
		
	

}
