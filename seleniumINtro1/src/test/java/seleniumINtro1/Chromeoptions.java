package seleniumINtro1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
//https://chromedriver.chromium.org/capabilities

public class Chromeoptions {

	public static void main(String[] args) {
		WebDriver driver;
		
		//Desired capability
				//Desired capabilities=
				//general chrome profile
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.acceptInsecureCerts();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				//ch.acceptInsecureCerts();
				cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		ChromeOptions options=new ChromeOptions();
		options.setHeadless(false);
		options.setAcceptInsecureCerts(true);
		
		//capability and options merge
		options.merge(cap);
		
		FirefoxOptions options1=new FirefoxOptions();
		options1.setAcceptInsecureCerts(false);
		
		EdgeOptions options2=new EdgeOptions();
		options1.setAcceptInsecureCerts(false);
		
	//add exeyension or plugun need to run when can see on normal browser
		options.addEncodedExtensions("file path ");
	//set proxy
		Proxy proxy=new Proxy();//selenium.org pkg
		proxy.setHttpProxy("ipaddress: hostname 4444");
		options.setCapability("proxy", proxy);
		
	//block all pop up window as location 
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
	//download to specific folder
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());
		
//		//Capability Name	Description
//		ACCEPT_SSL_CERTS	This property tells the browser to accept SSL Certificates by default
//		PLATFORM_NAME	This property is used to set the operating system platform used to access the web site
//		BROWSER_NAME	This property is used to set the browser name for a web driver instance
//		VERSION	This property to used to set the browser version
		
		//Below are the list of available and most commonly used arguments for ChromeOptions class

//start-maximized: Opens Chrome in maximize mode
//incognito: Opens Chrome in incognito mode
//headless: Opens Chrome in headless mode
//disable-extensions: Disables existing extensions on Chrome browser
//disable-popup-blocking: Disables pop-ups displayed on Chrome browser
//make-default-browser: Makes Chrome default browser
//version: Prints chrome browser version
//disable-infobars: Prevents Chrome from displaying the notification ‘Chrome is being controlled by automated software

	}

}
