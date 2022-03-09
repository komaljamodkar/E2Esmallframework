package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.Baseclass;
import pageObjects.RegisterPageObject;
import utility.CoreUtils;

public class RegisterTestCase01 extends Baseclass {

	public static Logger log =LogManager.getLogger(RegisterTestCase01.class.getName());
	//local declaration
	WebDriver driver;
	
	@BeforeTest
	public void start() throws IOException{
		driver=intializeDriver();
		log.info("driver is initialized..");
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to Register page");
	}
	
	@Test()
	public void basePageNavigation() throws IOException {
		RegisterPageObject rp=new RegisterPageObject(driver);
		CoreUtils coreutil=new CoreUtils(driver);
		coreutil.buttonClick(rp.getname());
		log.info("verified page sucessfully..");
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
