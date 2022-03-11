package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import pageObjects.LandingPage;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		// result = testCondition ? value1 : value2
		//run in cmd prompt  mvn test -Dbrowser=chrome
		String browser = browser_maven!=null ? browser_maven : browser_properties;



		if(driver == null)
		{
			if(browser.contains("chrome")){
				System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
				ChromeOptions option=new ChromeOptions();
				if(browser.contains("headless")) {
					option.addArguments("headless");
				}
				driver =new ChromeDriver(option);
			}
			if(browser.contains("firefox")){
				System.setProperty("webdriver.gecko.driver",".//drivers//geckodriver.exe");
				FirefoxOptions option=new FirefoxOptions();
				if(browser.contains("headless")) {
					option.addArguments("headless");
				}
				driver=new FirefoxDriver(option);
			}

			if(browser.contains("edge")){
				System.setProperty("webdriver.edge.driver",".//drivers//msedgedriver.exe");
				EdgeOptions option=new EdgeOptions();
				if(browser.contains("headless")) {
					option.addArguments("headless");
				}
				driver = new EdgeDriver(option);	
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}

		return driver;

	}



}

