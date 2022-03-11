package pkg1;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;


// selenium-java , seleium-devtools version must be same and browser and brwoser driver version
public class MobileEmulator {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		//in sel 4 chromeDriver class inherited from Chromium class so explicitly used ChromeDriver
		ChromeDriver driver =new ChromeDriver();
		//create the object for chrome dev tools with getDeTools() methods
		try {
			DevTools devtool=driver.getDevTools();
			
			devtool.createSession();			
			devtool.send(Emulation.setDeviceMetricsOverride(400, 900, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("abcd@gmail.com");
			driver.findElement(By.id("password")).sendKeys("abcd@gmail.com");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

}
