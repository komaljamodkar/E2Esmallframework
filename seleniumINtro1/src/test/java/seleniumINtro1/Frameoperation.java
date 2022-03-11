package seleniumINtro1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frameoperation {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  WebElement ele=driver.findElement(By.className("demo-frame"));
		  driver.switchTo().frame(ele);//id, class,name,webelement
		  
		  WebElement source=driver.findElement(By.id("draggable")); WebElement
		  target=driver.findElement(By.id("droppable")); Actions action=new
		  Actions(driver); action.dragAndDrop(source, target).build().perform();
		  
		  driver.switchTo().defaultContent();
		  driver.switchTo().parentFrame();
		  driver.close();
	}

}
