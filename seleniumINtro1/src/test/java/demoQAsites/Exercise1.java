package demoQAsites;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise1 {

	public static void main(String[] args) {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		JavascriptExecutor js =(JavascriptExecutor)driver;
		//driver.get("https://jqueryui.com/droppable/");
		driver.get("https://demoqa.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


		List<WebElement> count=driver.findElements(By.xpath("//ul[@id='verticalListContainer']//li"));
		System.out.println(count.size());
		js.executeScript("javascript:window.scrollBy(0,100)"); 
		for(int i=0;i<count.size();i++) { 
			count.get(i).click();
			System.out.println(count.get(i).getText()); }


		try {
			driver.findElement(By.id("demo-tab-grid")).click();
			Thread.sleep(2000);
			List<WebElement> gridcount=driver.findElements(By.xpath("//div[@id='demo-tabpane-grid']//li[contains(@class,'list-group-item')]"));
			for(int i=0;i<gridcount.size();i++) {
				gridcount.get(i).click();
				System.out.println(gridcount.get(i).getText());

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());		}

		driver.close();

	}

}
