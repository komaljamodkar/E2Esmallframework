package seleniumINtro1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollTableValuescount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		  Thread.sleep(2000);
		  // js.executeScript("document.querySelector('.react-datepicker__time-list').scrollTop=5000");
			//table/list ids above row
		  
		  js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//css selector -.tableFixHead td:nth-child(4)
		List<WebElement> ls=driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum=0;
		for(int i=0;i<ls.size();i++) {
			System.out.println(ls.get(i).getText());
			sum+=Integer.parseInt(ls.get(i).getText());
		}
		System.out.println("sum :"+sum);
		
		String sumText=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int sumtxt=Integer.valueOf(sumText);
		Assert.assertEquals(sum,sumtxt);
		
		driver.close();
	}

}
