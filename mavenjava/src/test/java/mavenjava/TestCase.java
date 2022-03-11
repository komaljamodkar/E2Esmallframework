package mavenjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase{
	
	@Test
	public void testcase01() throws InterruptedException{
		System.out.println("test case 1 ");
	}
	
	@AfterTest
	public void tearDown() {
		  
		System.out.println("exit.. ");
	}
	

}
