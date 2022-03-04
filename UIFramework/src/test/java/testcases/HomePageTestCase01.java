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
import pageObjects.ForgotpassPageObject;
import pageObjects.HomePageObject;
import utility.CoreUtils;

public class HomePageTestCase01 extends Baseclass{
	private static Logger log =LogManager.getLogger(HomePageTestCase01.class.getName());
//local driver intialize if execute in parallel create a local copy and execute
	WebDriver driver;

	@BeforeTest
	public void start() throws IOException{
		driver=intializeDriver();
		log.info("driver is initialized..");
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to Register page");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String user,String pass) throws InterruptedException  {
		HomePageObject hp=new HomePageObject(driver);
		CoreUtils coreutil=new CoreUtils(driver);

		coreutil.sendkeys(hp.getusername(),user);

		coreutil.sendkeys(hp.getPassword(),pass);

		coreutil.buttonClick(hp.getLogin());
		
		
		Assert.assertEquals(driver.getTitle(),"Login | Salesforce");
		log.info("verified page sucessfully..");
		// import Forgotpasspageobject no need to create a another object apss driver
		ForgotpassPageObject fp=hp.forgotpassMethod();
		coreutil.sendkeys(fp.getMail(),user);
		coreutil.buttonClick(fp.getButton());

		
		
	}

	@DataProvider
	public Object[][] getData() {
		Object [][] data=new Object[1][2];
		data[0][0]="abcd";
		data[0][1]="1234";
		return data;

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
