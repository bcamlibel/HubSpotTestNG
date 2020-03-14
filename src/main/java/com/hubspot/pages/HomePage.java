package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By header=By.xpath("//i18n-string[contains(text(),'Marketing Dashboard')]");
	By accountName=By.xpath("//span[text()='Kisga llc']");
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contatcChildTab = By.id("nav-secondary-contacts");
	
	
		// constructor 
	public HomePage (WebDriver driver){
		this.driver=driver;	
		elementUtil=new ElementUtil(driver);
		
	}
	
		public String getHomePageTitle(){
			return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
			
			//return driver.getTitle();
		}
	
	public String getHomePageHeader(){
		return elementUtil.doGetText(header);
		
		//return driver.findElement(header).getText();
		
	}
	
	public String verifyLoggedInAccountName(){
		
		
		return elementUtil.doGetText(accountName);
		//return driver.findElement(accountName).getText();
	}
	
	//helper method
			private void clickOnContacts(){
				elementUtil.doClick(contactMainTab);
				elementUtil.doClick(contatcChildTab);
			}
			public ContactsPage gotoContactsPage(){
				clickOnContacts();
				return new ContactsPage(driver);
			}		
	
}
