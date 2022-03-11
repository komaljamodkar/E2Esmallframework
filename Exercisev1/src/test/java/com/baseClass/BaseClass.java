package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	WebDriver driver=null;
	//enum, is constant variable access by enumname.value
		enum BrowserName{
			CHROME,FIREFOX,EDGE
			}
		
		
		@BeforeSuite
		public void setUP() {
			launchBrowser(BrowserName.CHROME);
			
		}
	
	public static WebDriver launchBrowser(BrowserName browser) {
		WebDriver driver=null;
		switch(browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			/*
			 * WebDriverManager.chromedriver() .version("83.0.0") .arch32()
			 * .proxy("proxyhostname:80") .proxyUser("username") .proxyPass("password")
			 * .setup();
			 */
			/*
			 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
			 */
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("Invalid browser name");
		
		}
		return driver;	
	}

}
