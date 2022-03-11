package demoQAsites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragndropOperation {

	public static void main(String[] args) {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  
		  WebElement source=driver.findElement(By.id("draggable")); 
		  WebElement target=driver.findElement(By.id("droppable")); 
		  Actions action=new Actions(driver); 
		  action.dragAndDrop(source, target).build().perform();
		  driver.close();
	}

}
