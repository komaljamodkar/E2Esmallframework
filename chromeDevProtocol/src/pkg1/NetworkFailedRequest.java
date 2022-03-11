package pkg1;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.fetch.Fetch;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

//validate with only record with API
//in GET api search with only one id

public class NetworkFailedRequest {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\developmentAveto\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//executeCDP command accepts 2 arguments -method , param
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			//maxtotalBuffersize,maxresouseBuffersize
			devtool.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
			devtool.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
			
			long starttime=System.currentTimeMillis();
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			
			driver.findElement(By.linkText("Browse Products")).click();
			driver.findElement(By.linkText("Selenium")).click();
			driver.findElement(By.cssSelector(".add-to-cart")).getText();
			String text=driver.findElement(By.cssSelector("p")).getText();
			System.out.println(text);
			//no images will show images are blocked
			//gettext of one record message
			long endtime=System.currentTimeMillis();
			System.out.println(endtime-starttime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//driver.close();

	}

}
