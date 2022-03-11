package seleniumINtro1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDropoperation {

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
		
		String textTo = target.getText();
		if(textTo.equals("Dropped!")) {
		System.out.println("PASS: File is dropped to target as expected");
		}else {
		System.out.println("FAIL: File couldn't be dropped to target as expected");
		}
		driver.navigate().refresh();
		
		WebElement source1=driver.findElement(By.id("draggable")); 
		WebElement target1=driver.findElement(By.id("droppable"));
			//Building a drag and drop action
			Action dragndrop=action.clickAndHold(source1).moveToElement(target1).release(target1).build();
			dragndrop.perform();
	
		driver.close();
	}
	

}
