package seleniumINtro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChekckBoxop {

	public static void main(String[] args) {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * ".\\drivers\\chromedriver.exe"); WebDriver driver =new ChromeDriver();
		 */		
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		boolean val=false;
		
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
		val=driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected();
		Assert.assertTrue(val);

		driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
		val=driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected();
		Assert.assertFalse(val);
		
		int count=driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("count :"+count);
		driver.close();

		
		/*
		 * List<WebElement> checkboxes
		 * =driver.findElements(By.xpath("//input[@type='checkbox']"));
		 * 
		 * System.out.println(checkboxes.size());
		 */
		
		/*
		 * driver.get("http://spicejet.com"); //URL in the browser
		 * 
		 * Assert.assertFalse(driver.findElement(By.cssSelector(
		 * "input[id*='SeniorCitizenDiscount']")).isSelected());
		 * 
		 * //Assert.assertFalse(true);System.out.println(driver.findElement(By.
		 * cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		 * 
		 * driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).
		 * click();
		 * 
		 * System.out.println(driver.findElement(By.cssSelector(
		 * "input[id*='SeniorCitizenDiscount']")).isSelected());
		 * 
		 * Assert.assertTrue(driver.findElement(By.cssSelector(
		 * "input[id*='SeniorCitizenDiscount']")).isSelected());
		 */}
}
