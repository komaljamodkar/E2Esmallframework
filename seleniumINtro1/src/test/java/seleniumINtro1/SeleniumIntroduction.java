package seleniumINtro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {
	//webdriver its an interface
	public static void main(String[] args) {
		//invoking a browser
		//Chrome firefix ... browser class extends methods from webdriver interface ex: close get
		//Webdriver methods+ class methods , class methods no accesible in another browser class so
		//Webdriver methods+class  personal methods -driver object can access both
		//set key value pair
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		WebDriver driver1=new ChromeDriver();
		// driver will knowledge have the methods only have which Webdriver implementation of Chromedriver 
		
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver2=new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgeodriver.exe");
		WebDriver driver3=new ChromeDriver();
		driver.get("https://google.com/");
		System.out.println(driver.getPageSource());
		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());


		driver.close();
	}

}
