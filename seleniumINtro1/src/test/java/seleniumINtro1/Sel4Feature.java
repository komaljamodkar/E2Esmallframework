package seleniumINtro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
public class Sel4Feature {

	public static void main(String[] args) {
		
		//relative locators using selenium4
//		above()
//		below()
//		toRightOf()
//		toLeftOf()
//		with
		
		//driver.findElement((with(By.tagName("input").above(webElement))
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/9521/identity/sign_up/with_email");
		WebElement password = driver.findElement(By.id("password"));
		String text=driver.findElement(with(By.tagName("label")).above(password)).getText();
		System.out.println(text);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");



		WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));



		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();



		WebElement rdb = driver.findElement(By.id("inlineRadio1"));



		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		driver.close();
	}

}
