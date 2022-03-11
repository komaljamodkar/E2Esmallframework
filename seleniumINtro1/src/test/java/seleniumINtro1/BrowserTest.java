package seleniumINtro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//webDriverManager automates browser setup in selenium code
//bydefault it downloads the latest version of browser binary and also binary for appropriate platform
//have to add dependency for WebDriverManager in case belongs to Maven
//supports browser as chrome,firefox,ie edge,opera
//if needs specific version platform version , proxy details
public class BrowserTest {

	public static void main(String[] args) {
		try {
			//need to set property and absolute path
			//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			//ChromeDriver driver=new ChromeDriver();
			
			WebDriver driver=launchBrowser(BrowserName.CHROME);
			//WebDriver driver=launchBrowser(BrowserName.FIREFOX);
			//WebDriver driver=launchBrowser(BrowserName.EDGE);

			driver.get("https://google.com/");
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//enum, is constant variable access by enumname.value
	enum BrowserName{
		CHROME,FIREFOX,EDGE
		}

	private static WebDriver launchBrowser(BrowserName browser) {
		WebDriver driver=null;
		switch(browser) {
		case CHROME:
			
			/*
			 * WebDriverManager.chromedriver() .version("83.0.0") .arch32()
			 * .proxy("proxyhostname:80") .proxyUser("username") .proxyPass("password")
			 * .setup();
			 */
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("Invalid browser name");
		
		}
		return driver;	
	}
}
