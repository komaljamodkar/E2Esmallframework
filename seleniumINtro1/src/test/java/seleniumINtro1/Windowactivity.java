package seleniumINtro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowactivity {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
//driver.get () and navigate().to("") : difference get() having inbuid sync wait (wait until all components get loaded)
	//	navigate().To() :it directly move to another page, wait can handle by implicit explicit
		driver.get("http://google.com");

		driver.navigate().to("https://rahulshettyacademy.com");

		driver.navigate().back();

		driver.navigate().forward();
		driver.navigate().refresh();
		}


}
