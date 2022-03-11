package pkg1;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

//add desired capability

//https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
//https://wiki.saucelabs.com/display/DOCS/Getting+Started+with+Selenium+for+Automated+Website+Testing


//account-> user setting -> view access key

public class SauselabsTest {

	public static final String USERNAME = "oauth-jamodkar.swati-d6dbc";

	  public static final String ACCESS_KEY = "c9709e12-1483-456d-8487-e71ee3e68886";

	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";



	public static void main(String[] args) throws MalformedURLException {

	// TODO Auto-generated method stub



	DesiredCapabilities caps =new DesiredCapabilities();

	caps.setCapability("platform", "Windows 7");

	caps.setCapability("version", "51.0");

	WebDriver driver=new RemoteWebDriver(new URL(URL), caps);

	driver.get("http://google.com");

	System.out.println(driver.getTitle());

	}


}
