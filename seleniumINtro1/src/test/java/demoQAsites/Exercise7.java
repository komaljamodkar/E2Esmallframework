package demoQAsites;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise7 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");

		List<WebElement>options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		for(int i=0;i<options.size();i++){
			if(options.get(i).getText().equalsIgnoreCase("India")){
				options.get(i).click();
			}		
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
			driver.close();

		}

	}}

