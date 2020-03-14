package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.ElementUtil;

import com.hubspot.util.Constants;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	
	// non-page factory
	// Locators
	
	By emailId=By.id("username");
	By password= By.id("password");
	By loginBtn=By.id("loginBtn");
	
	
	
	// constructor 
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	
	// page action 
	
	public String getLoginPageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
		//return driver.getTitle();
	}
	
	
	// bu home page niye burada var nedeni? bir sonraki home page gitmek icin mi?
	
	public HomePage doLogin(String username, String pwd){
	
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		
		
		
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		
		return new HomePage(driver);
		
	}
	
	
	
	
}
