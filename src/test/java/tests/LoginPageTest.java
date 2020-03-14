package tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;


@Listeners(com.hubspot.listeners.TestAllureListener.class)
public class LoginPageTest {

	Logger log = Logger.getLogger("LoginPageTest");
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	
	
	@BeforeMethod
	public void setUp(){
	basePage=new BasePage();
	prop=basePage.initialize_properties();
	driver=basePage.initialize_driver(prop);
	loginPage= new LoginPage(driver);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
	System.out.println("some problems before method");
		e.printStackTrace();
	}
		
	}
	
	
	@Test(priority=2,enabled=true, description="Login test correct username and password")
	public void loginTest1(){
		log.info("test 1 is starting");
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		log.info("test 1 is ending");
	}
	
	@Test(priority=3,enabled=true, description="Login test correct username and incorrect password")
	public void loginTest2(){
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("incorrectpass"));
		
	}
	@Test(priority=4,enabled=true, description="Login test incorrect username and correct password")
	public void loginTest3(){
		loginPage.doLogin(prop.getProperty("incorrectuser"),prop.getProperty("password"));
		
	}
	
	
	
	
	@Test(priority=1,enabled=true, description="Hubspot login get title")
	public void getTitle(){
	String title=loginPage.getLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"title is correct");
	
	
	}
	
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
		
		
		
	}
		
	
	
}
