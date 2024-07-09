package com.Salesforce.pages.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Salesforce.pages.base.BasePage;

public class SalesForceHomePage extends BasePage {
	@FindBy(id="userNavLabel") WebElement usermenudropdownele;
	@FindBy(xpath ="//a[@title='Logout']") WebElement logoutele;
		public SalesForceHomePage(WebDriver driver) {
			super(driver);
	}
		
//	@FindBy(xpath ="//*[@id=\"userNavLabel\"]") WebElement HomepageUsername;
//	@FindBy(xpath ="//a[@title='Logout']") WebElement logout;

	public void getPageTitle()	{
	String HomepageTitle = driver.getTitle();// Verifying home page title
	System.out.println(HomepageTitle);
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
