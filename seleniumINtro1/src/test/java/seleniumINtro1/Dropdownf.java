package seleniumINtro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dropdownf {

	public static void main(String[] args) throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		WebDriver driver =new ChromeDriver();

		driver.get("http://spicejet.com"); 
		
		/*Select dropdown=new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Adult']")));

		dropdown.selectByIndex(4);

		dropdown.selectByVisibleText("9 Adults");

		dropdown.selectByValue("8");*/
		driver.findElement(By.id("divpaxinfo")).click();

		   Thread.sleep(2000L);

		   /*int i=1;

		while(i<5)

		{

		driver.findElement(By.id("hrefIncAdt")).click();//4 times

		i++;

		}*/

		   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int i=1;i<5;i++)

		{

		driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		

			/*System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");

			WebDriver driver =new ChromeDriver();

			driver.get("http://spicejet.com"); *///URL in the browser

			//  //a[@value='MAA']  - Xpath for chennai

			//  //a[@value='BLR']

			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

			driver.findElement(By.xpath("//a[@value='BLR']")).click();

			Thread.sleep(2000);

			//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

			

	}

}
