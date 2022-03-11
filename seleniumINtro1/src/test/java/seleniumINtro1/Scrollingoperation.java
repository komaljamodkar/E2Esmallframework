package seleniumINtro1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//on console
//window.scrollBy(0,250)

//casting driver with JS
public class Scrollingoperation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//jquery
		  //document.getElementBy ID/ ClassName,Xpath ,TagName
		  //copy console script
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,550)");
		  //in javascript document.querySelector(class/id)
		  //scrollTop=5000 scroll text to bottom inside the table
		  js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		  //scroll to left
		  js.executeScript("document.querySelector('.tableFixHead').scrollLeft=5000");
		  
		  //scroll to ele
		  WebElement element=driver.findElement(By.xpath("//*[text()='Checkbox Example']"));
		  js.executeScript("arguments[0].scrollIntoView();", element);
		  
		  //scroll to bottam of page
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(3000);
		  //scroll top of page
		  js.executeScript("window.scrollBy(0,-1000)");

		  Thread.sleep(3000);
		  driver.findElement(By.id("name")).click();
		  js.executeScript("document.getElementById('name').value='abcd'");
		  Thread.sleep(3000);
		  String text=(String) js.executeScript("document.getElementById('name').value");
		  System.out.println(text);
		  //scroll up : pass 2nd param -ve
		  Thread.sleep(4000);
		  js.executeScript("window.scrollBy(0,-250)");
		  
		  //scroll to right
		  js.executeScript("scrollTo(document.body.scrollHeight,0)");
		 
		  driver.quit();
	}

}
