package pkg1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;

public class CDPcmdTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//executeCDP command accepts 2 arguments -method , param
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			
			Map params=new HashMap<>();
			params.put("width", 500);
	        params.put("height", 1000);
	        params.put("deviceScaleFactor", 50);
	        params.put("mobile", true);
	        
	        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
	        
			//devtool.send(Emulation.setDeviceMetricsOverride(400, 900, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));
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
