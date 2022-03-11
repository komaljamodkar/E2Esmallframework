package pkg1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;

//setGeoLocationOverride
//get log, lat 40 3

public class Geolocation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//executeCDP command accepts 2 arguments -method , param
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			
			Map coordinates=new HashMap<>();
			coordinates.put("latitude", 40);
			coordinates.put("longitude", 53);
			coordinates.put("accuracy", 1);
			
	        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
	        
		//	devtool.send(Emulation.setGeolocationOverride(null, null, null));
			driver.get("https://google.com/");
			driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
			
			driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			String titile=driver.findElement(By.cssSelector(".our-story-card-title")).getText();
			System.out.println(titile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

}
