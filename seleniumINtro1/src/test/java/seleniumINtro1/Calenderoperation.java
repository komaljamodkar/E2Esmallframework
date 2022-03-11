package seleniumINtro1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderoperation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("incognito");
		option.addArguments("--disable-notification");
		option.addArguments("disable-popup-blocking");
		option.addArguments("disable-infobars");
		driver=new ChromeDriver(option);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.id("travel_date")).click();
		
		//select month using while loop 
		
		WebElement ele=driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		
		while(!(ele.getText().contains("April"))) {
			driver.findElement(By.className("next")).click();
		}
		
		//another way
		/*
		 * ele.click(); List<WebElement>
		 * monthcount=driver.findElements(By.cssSelector(".month")); for(int
		 * i=0;i<monthcount.size();i++) { if(monthcount.get(i).getText().equals("23")){
		 * monthcount.get(i).click(); break; } }
		 */
		
		//iterrate list webelement to select day
		List<WebElement> daycount=driver.findElements(By.cssSelector(".day"));
		
		int count=daycount.size();
		for(int i=0;i<count;i++) {
			if(daycount.get(i).getText().equals("23")){
				daycount.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("travel_date")).getText());
	driver.close();	

	}

}
