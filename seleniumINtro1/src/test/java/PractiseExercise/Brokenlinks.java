package PractiseExercise;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks {

	//get all urls
	// status code >=400 can check broken urls
	//soft Assert concept at lst add Assert.assertAll();
	public static void main(String[] args) {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		String url="";
		HttpsURLConnection huc=null;
		int responseCode=200;
		//create a object of Soft Assert class
		SoftAssert a=new SoftAssert();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		List<WebElement>link=driver.findElements(By.tagName("a"));
		System.out.println("count :"+link.size());
		Iterator<WebElement>it=link.iterator();

		while(it.hasNext()) {
			url=it.next().getAttribute("href");
			if(url.isEmpty()||url==null) {
				System.out.println("url is null :"+url);
			}
			if(!(url.startsWith("https://www.amazon.in/"))) {
				try {
					huc=(HttpsURLConnection)(new URL(url).openConnection());
					huc.setRequestMethod("HEAD");
					huc.connect();
					responseCode=huc.getResponseCode();
						a.assertTrue(responseCode<400,responseCode+" with broken URL :"+url+" text :"+it.next().getText());
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		//to log all asert
		a.assertAll();
	}

}



//broken URL

//Step 1 - IS to get all urls tied up to the links using Selenium

//  Java methods will call URL's and gets you the status code

//if status code >400 then that url is not working-> link which tied to url is broken

//a[href*="soapui"]'

//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//
//SoftAssert a =new SoftAssert();
//
//for(WebElement link : links){
//
// String url= link.getAttribute("href");
//
// HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
//
// conn.setRequestMethod("HEAD");
//
// conn.connect();
//
// int respCode = conn.getResponseCode();
//
// System.out.println(respCode);
//
// a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
//
//}
//
//a.assertAll();
//
//
//}

