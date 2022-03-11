package pkg1;

import java.util.List;
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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

//javascript error example added items in cart
//calculation javascript function error capture

public class JavaScriptlogerror {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\developmentAveto\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		
		// with selenium use Listeners on TestFailure
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).getText();
		
		driver.findElement(By.linkText("Cart")).click();
		
		driver.findElement(By.id("")).clear();
		driver.findElement(By.id("")).sendKeys("2");
		//returntype is LogEntry for browser log
		//Brwoser/client /driver
		LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
		//get logentry object
		List<LogEntry>logs=entry.getAll(); //return alllogs in list
		for(LogEntry e:logs) {
			System.out.println(e.getMessage());// else return to log file
		}
		
	}

}
