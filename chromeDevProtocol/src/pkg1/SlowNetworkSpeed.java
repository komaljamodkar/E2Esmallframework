package pkg1;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.fetch.Fetch;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.ConnectionType;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

//reduce n/w speed
//disconnect n/w
// connection type 2g 3g

public class SlowNetworkSpeed {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\developmentAveto\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			//maxtotalBuffersize,maxresouseBuffersize
			//working with any network domain related command 1st enable network command
			devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			//1st param internet connection
			devtool.send(Network.emulateNetworkConditions(false, 3000, 20000, 30000, Optional.of(ConnectionType.CELLULAR4G)));
				//check network speed
			long starttime=System.currentTimeMillis();

			driver.get("https://google.com/");
			driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
			
			driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			String titile=driver.findElement(By.cssSelector(".our-story-card-title")).getText();
			System.out.println(titile);
//			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//			
//			driver.findElements(By.cssSelector("//button[routerlink*='library']")).get(0).click();
//			
			long endtime=System.currentTimeMillis();
			System.out.println(endtime-starttime);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//driver.close();

	}

}
