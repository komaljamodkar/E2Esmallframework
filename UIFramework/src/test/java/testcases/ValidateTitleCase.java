package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageObjects.HomePageObject;
import utility.CoreUtils;

public class ValidateTitleCase extends Baseclass{
	private static Logger log =LogManager.getLogger(ValidateTitleCase.class.getName());
//local driver intialize if execute in parallel create a local copy and execute
	WebDriver driver;

	@BeforeTest
	public void start() throws IOException{
		driver=intializeDriver();
		log.info("driver is initialized..");
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to Register page");
	}
	
	@Test
	public void validateTitle()  {
		HomePageObject hp=new HomePageObject(driver);
		CoreUtils coreutil=new CoreUtils(driver);
		
		
		Assert.assertEquals(driver.getTitle()," ");
		log.info("verified page sucessfully..");
		
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
