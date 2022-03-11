package com.stepDef;

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

import com.baseClass.BaseClass;
import com.coreutils.CoreUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase extends BaseClass{
	WebDriver driver=null;
	CoreUtils  coreutil=new CoreUtils();
	
	@BeforeTest
	public void setUp() {
		super.setUP();

		driver.get("https://demoqa.com/droppable/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
		  
		  try {
				
			  WebElement source=driver.findElement(By.id("draggable")); 
			  WebElement target=driver.findElement(By.id("droppable")); 
			  Thread.sleep(3000);
			  Actions action=new Actions(driver); 
			  action.dragAndDrop(source, target).build().perform();
			//coreutil.dragAndDrop(source, target);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	@Test
	public void testcase01() throws InterruptedException{
		
	}
	
	@AfterTest
	public void tearDown() {
		  driver.close();
	}
	

}
