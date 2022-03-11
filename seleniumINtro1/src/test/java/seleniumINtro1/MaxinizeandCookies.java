package seleniumINtro1;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MaxinizeandCookies {

	//delete cookie and verify session logout and see login screen
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteCookieNamed("hfdf");
		driver.manage().deleteAllCookies();//session logout if it opened
		driver.get("https://www.amazon.in/");
		driver.manage().getCookies();
		
		Set<Cookie> c=driver.manage().getCookies();
		
		for(Cookie c1: c) {
		System.out.println(c1.toString());
		}
		driver.manage().deleteAllCookies();//session logout if it opened
		
		driver.manage().window().fullscreen();
		driver.manage().window().minimize();
		driver.manage().window().maximize();


	}

}
