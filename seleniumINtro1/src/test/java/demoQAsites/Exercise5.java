package demoQAsites;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise5 {
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();

		String option = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/../.. //label[2]")).getText().trim();

		System.out.println(option);
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));

		Select s = new Select(dropDown);
		s.selectByVisibleText(option);

		driver.findElement(By.id("name")).sendKeys(option);

		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		if(alertText.contains(option)){
			System.out.println("pass");

		}
		else {
			System.out.println("fail");
		}
		driver.quit();

	}


}




