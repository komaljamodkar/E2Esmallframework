package gridPkg;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Seleniumgrid {

	WebDriver driver;

	@Test
	public void login() throws MalformedURLException {

		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		//caps.setBrowserName("Chrome");
		//caps.setPlatform("windows 10");
	//	caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.43.74:4444"),caps);
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium grid");
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
