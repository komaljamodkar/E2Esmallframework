package dataprovider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Testcase02 {
	
	public static WebDriver driver;
	String filePath ="C:\\developmentAveto\\workspace\\seleniumINtro1\\src\\test\\java\\dataprovider\\excelData\\TestData1.xlsx";
	String sheetName = "Sheet2";
	
	@BeforeTest
	public void beforetestcase1() {
		System.out.println("Before test one");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		driver.get("https://www.makemytrip.com/");
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  }
	
	@Test(priority = 0)
	public void selectOption() throws Exception{
		WebElement flight=driver.findElement(By.xpath("//li[@class='menu_Flights']"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", flight);
		
		String way="OneWay";
		
	}
	
	@Test(dataProvider = "Form")
	public static void testcase3(String fromCity,String toCity)throws Exception {
		Thread.sleep(3000);
		System.out.println(fromCity+"  "+toCity);
		Actions action= new Actions(driver);
		
		Thread.sleep(2000);
		//fromcity
		WebElement fromElement=driver.findElement(By.xpath("//label[@for='fromCity']"));
		fromElement.click();
		//action.click(fromElement).build().perform();
		action.sendKeys(fromCity).pause(3).keyDown(Keys.ENTER).build().perform();
		
		
		
		/*
		 * //Selection of From City WebElement button
		 * =driver.findElement(By.xpath("//label[@for='fromCity']"));
		 * 
		 * js.executeScript("arguments[0].click();", button);
		 */
		
		WebElement city=driver.findElement(By.xpath("//input[@aria-controls='react-autowhatever-1']"));
		
	      city.sendKeys("Huzur Sahib Nanded");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	//To provide data from excel sheet
	  @DataProvider(name = "Form")
		public String[][] getValidData() throws Exception {
			
			return Excelutil.excelRead(filePath, sheetName);
		}


}
