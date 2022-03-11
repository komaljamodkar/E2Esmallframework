package demoQAsites;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise3 {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());

		driver.quit();

	}


}




