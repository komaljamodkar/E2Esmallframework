package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import coreUtils.Coreutils;
import pageobject.PageFactoryclass;
import pageobject.PageObjectfile;
import testcase.TestCase01;

public class BaseClass {
	WebDriver driver=null;
	
	@Test
	public void inlializeDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();

		TestCase01 tc=new TestCase01(driver);
		PageObjectfile pf=new PageObjectfile(driver);
		PageFactoryclass pc=new PageFactoryclass(driver);

		Coreutils coreutil=new Coreutils(driver);
		

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		tc.getLogin();
		tc.TearDown();
	}
	

}
