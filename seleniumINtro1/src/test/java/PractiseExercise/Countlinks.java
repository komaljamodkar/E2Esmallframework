package PractiseExercise;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Countlinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		int count=driver.findElements(By.tagName("a")).size();
		System.out.println("count :"+count);
		
		js.executeScript("window.scrollBy(0,1000)");
		//links from footer part
		WebElement footerdriver=driver.findElement(By.xpath("//div[contains(@class,'navLeftFooter')]"));
		int footerCount=footerdriver.findElements(By.tagName("a")).size();
		System.out.println("footer link Count :"+footerCount);
		
		// links only from 1st column
		
		WebElement firstColumnDriver=driver.findElement(By.xpath("//div[contains(@class,'navFooterLinkCol')][1]"));
		int footerfirstColumn=firstColumnDriver.findElements(By.tagName("a")).size();
		System.out.println("footerfirstColumn :"+footerfirstColumn);
		//check these links are working
		
		for(int i=0;i<footerfirstColumn;i++) {
			//open all links in windows tab
			//keyChord() use to press multiple keys simultenously
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(3000);
		}
			Set<String> windowCount=driver.getWindowHandles();
			Iterator<String> it=windowCount.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				String title=driver.getTitle();
				System.out.println("title :"+title);
			}
		
		
		
		driver.quit();
	}

}
