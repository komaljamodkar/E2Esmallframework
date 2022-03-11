package seleniumINtro1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionsoperations {

	public static void main(String[] args) {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement ele=driver.findElement(By.id("twotabsearchtextbox"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).click().pause(2).keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().pause(6).sendKeys(Keys.BACK_SPACE).sendKeys("ABCDED").build().perform();
		WebElement ele1=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		action.moveToElement(ele1).contextClick();
		driver.close();
	}

}
