package demoQAsites;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		driver.get("https://demoqa.com/date-picker");
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  
		  js.executeScript("window.scrollBy(0,250)");

		  
		  driver.findElement(By.id("dateAndTimePickerInput")).click();

		//select month using while loop 
			
			WebElement ele=driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown')]"));
			
			while(!(ele.getText().contains("April"))) {
				driver.findElement(By.xpath("//div[@class='react-datepicker__triangle']//following::button[text()='Next Month']")).click();
			}

		  List<WebElement> daycount=driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day') and @role='option']"));
			
			int count=daycount.size();
			for(int i=0;i<count;i++) {
				if(daycount.get(i).getText().equals("23")){
					daycount.get(i).click();
					break;
				}
			}
			 Thread.sleep(2000);
			js.executeScript("document.querySelector('.react-datepicker__time-list').scrollTop=700");
			Thread.sleep(2000);
			List<WebElement> timecount=driver.findElements(By.xpath ("//li[contains(@class,'time-list-item')]"));
			
			int count1=timecount.size();
			for(int i=0;i<count1;i++) {
				//Thread.sleep(2000);
				if(timecount.get(i).getText().trim().equals("06:30")){
					Thread.sleep(2000);
					timecount.get(i).click();
					break;
				}
			}
			Thread.sleep(2000);
			String text1=(String) js.executeScript("document.getElementById('dateAndTimePickerInput').value");
		 System.out.println(text1);
		  		  
driver.close();
	}

}
