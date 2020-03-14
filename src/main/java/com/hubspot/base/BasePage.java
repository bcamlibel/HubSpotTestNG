package com.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public static String flash;
	
  public WebDriver initialize_driver(Properties prop){
	 String browser= prop.getProperty("browser");
	 String headless=prop.getProperty("headless");
	 flash=prop.getProperty("elementflash");
	 
	 if (browser.equalsIgnoreCase("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "/Users/billcamlibel/Documents/DRIVERS/chromedriver");
		if (headless.equalsIgnoreCase("yes")) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless");
			driver=new ChromeDriver(co);
		}
		else{
			driver=new ChromeDriver();
		}
	 }
		
	else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headless.equalsIgnoreCase("yes")) {
				FirefoxOptions fo= new FirefoxOptions();
				fo.addArguments("--headless");
				driver=new FirefoxDriver(fo);
				
			}
			else{
				driver=new FirefoxDriver();
		}
	}
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("url"));
	 return driver;
}

  public Properties initialize_properties(){
		
		 prop = new Properties();
		 
		 try{
		 FileInputStream ip = new FileInputStream("/Users/billcamlibel/Documents/workspace/BilalHubSpotTestNG/"
		 		+ "src/main/java/config/hubspot/config/config.properties");
		    prop.load(ip);
		 }catch (FileNotFoundException e) {
			e.printStackTrace();
		 } catch (IOException e) {
			e.printStackTrace();
		 }
			
		 return prop;
	   }
	   
		/**
		 * quit
		 */
		public void quitBrowser(){
			try{
			driver.quit();
			}catch(Exception e){
				System.out.println("Some exception occured while quitting the browser");
			}
		}
		
		/**
		 * close
		 */
		public void closeBrowser(){
			try{
			driver.close();
			}catch(Exception e){
				System.out.println("some exception occured while closing the browser");
			}
		}	

	


}
