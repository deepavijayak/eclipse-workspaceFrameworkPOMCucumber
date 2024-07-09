package com.Salesforce.stepdefs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Salesforce.pages.login.SalesForceHomePage;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
import com.Salesforce.pages.login.ForgotPassword;
import com.Salesforce.pages.login.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StepDefSalesforce {
	WebDriver driver;
	protected static Logger mylog=LogManager.getLogger(StepDefSalesforce.class);
	LoginPage loginpg;
	SalesForceHomePage home;
	ForgotPassword forgotpwdpage;
	Alert alert;
	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//mylog.info("chrome browser instance chrome created.");
			mylog.info("chrome browser instance chrome created.");
		//	extentReport.logTestInfo("chrome browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			
			//mylog.log(Level.INFO,"window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			mylog.info("firefox browser instance chrome created.");
		//	extentReport.logTestInfo("firefox browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			mylog.info("edge browser instance chrome created.");
			driver.manage().window().maximize();
			mylog.info("window is maximized");
			break;

			case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			mylog.error("Unsupported browser: " + browserName);
		}
	}
	public void goToUrl(String url) {
   	    driver.get(url);
   	    mylog.info(url + "is entered");
   	 //Thread.sleep(5000);
	}
	public void closeBrowser() {
		driver.close();
		mylog.info("browser instance closed");
		driver=null;
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	
	@After
	public void tearDown() {
		closeBrowser();
	}
	

	@Given("the url {string}")
	public void the_url(String url) throws InterruptedException {
		goToUrl(url);
	    
	}

	@When("i land in {string}")
	public void i_land_in(String pageName) {
		if (pageName.equalsIgnoreCase("loginpage")) {
			loginpg=new LoginPage(driver);
		}else if(pageName.equalsIgnoreCase("HomePage")) {
			home=new SalesForceHomePage(driver);
		}else if (pageName.equalsIgnoreCase("ForgotPasswordPage")) {
			forgotpwdpage=new ForgotPassword(driver);
		}
		
	}

	@When("i enter Username as {string}")
	public void i_enter_username_as(String Username) throws InterruptedException {
		Thread.sleep(2000);		
//		WebElement username_ele=driver.findElement(By.id("username"));
//		username_ele.sendKeys(Username);
		loginpg.enterUserName(Username);
	}

	@When("i enter Password as {string}")
	public void i_enter_password_as(String Password) {
//		WebElement password_ele=driver.findElement(By.id("password"));
//		password_ele.sendKeys(Password);  
		loginpg.enterPassword(Password);
	}

	@When("i click on the {string} button")
	public void i_click_on_the_button(String button) {
		if (button.equalsIgnoreCase("Login")) {
			loginpg.clickLoginButton();
		}else if(button.equalsIgnoreCase("Continue")) {
			forgotpwdpage.Continuebutton();
		}
		
//		WebElement loginButton= driver.findElement(By.id("Login"));
//		loginButton.click();
	//	driver=loginpg.clickLoginButton();
	    
	}

	@Then("i should see the home page")
	public void i_should_see_the_home_page() throws InterruptedException {
//		String HomepageTitle = driver.getTitle();// Verifying home page title
//		System.out.println(HomepageTitle);
		loginpg.getloginPageTitle();

	}

	@Then("i should see the error message {string}")
	public void i_should_see_the_error_message(String string) {
//		WebElement errormsgInvalidlogin= driver.findElement(By.id("error"));
//		String actualMsg = errormsgInvalidlogin.getAttribute("innerHTML");
//		System.out.println(actualMsg);
//		String experror="Please enter your password.";
//		Assert.assertEquals(actualMsg, experror);
//		System.out.println("Error message verified");
//		//return getText(errormsgInvalidlogin);
//		return;
		loginpg.extractTextErrormsg();
	}

	@When("i click on the {string} checkbox")
	public void i_click_on_the_checkbox(String string) throws InterruptedException {
		driver=loginpg.checkRememberMe();
//		driver=loginpg.clickLoginButton();
		Thread.sleep(2000);
		
	}
	@Then("i click on the {string} Usermenubutton")
	public void i_click_on_the_Usermenubutton(String Usermenu) throws InterruptedException {
		Thread.sleep(2000);
		driver=loginpg.userMenuDropdown();
	//	System.out.println("Usermenu dropdown clicked");
	}

	@Then("i click on the {string} option from usermenu")
	public void i_click_on_the_option_from_usermenu(String string) {
		driver=home.logoutMenuOption();
		//System.out.println("Logout dropdown clicked");
	}

//	@Then("i should see the Login page")
//	public void i_should_see_the_Login_page(String string) {
//		loginpg.getloginPageTitle();
//	//	loginpg.remembermeusernameverify();
//	}
	@When("i click on the {string} link")
	public void i_click_on_the_link(String string) {
		loginpg.clickForgotPwd();
	}
//	@When("i land in {string} page.")
//	public void i_land_in_page(String string) {
//	    
//	}


	@Then("i should see the Forgot Password page.")
	public void i_should_see_the_forgot_password_page() {
	
		forgotpwdpage.getforgotpwdPageTitle();
	}

	@Then("i enter the username as {string}")
	public void i_enter_the_username_as(String string) {
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		forgotpwdpage.enterFPUserName(usernamedata);
	}
	

	@Then("i should see the {string} text")
	public void i_should_see_the_text(String string) {
		String expecteddata = "Check Your Email"; 
		String actualText=forgotpwdpage.getTextFromcheckEmailText();
		Assert.assertEquals(actualText, expecteddata);
		forgotpwdpage.extractconfirmTextmsg();	
	}
	
	@Then("i should see the error message \"Please check your username and password. If you still can't log in, contact your Salesforce administrator.”")
	public void i_should_see_the_error_message_please_check_your_username_and_password_if_you_still_can_t_log_in_contact_your_salesforce_administrator() {
		loginpg.extractTextInvalidErrormsg();
	}


}
