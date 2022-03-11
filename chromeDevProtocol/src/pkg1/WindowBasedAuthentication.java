package pkg1;

import java.util.Optional;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;

//browser based pop up handle
//with URI class
//can use autoIt but jenkins headless mode not work
// so Selenium 4 feature will help to resolve this issue

public class WindowBasedAuthentication {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\developmentAveto\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		
		try {
			//get host
			//predicate same as filter
			//UserNameAndPassword is a class
			Predicate<URI> uriPredicate=uri->uri.getHost().contains("httpbin.org");//to filterout
			
			((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("username", "password"));
			
			driver.get("http://httpbin.org/basic/foo/bar");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//driver.close();

	}

}
