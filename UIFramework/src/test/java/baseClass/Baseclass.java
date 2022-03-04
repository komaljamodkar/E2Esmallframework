package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

//add testNG library
public class Baseclass {
	public Properties prop;
	public WebDriver driver=null;
		
	public WebDriver intializeDriver() throws IOException {
		prop=new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\env.properties");
		
		prop.load(fis);

		String browser=prop.getProperty("browser");
		
		System.out.println(browser);
			switch(browser) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
			    driver =new ChromeDriver();

				break;
			case "FIREFOX":
				System.setProperty("webdriver.chrome.driver",".\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				break;
			case "EDGE":
				System.setProperty("webdriver.chrome.driver",".\\drivers\\msedgedriver.exe");
				driver=new EdgeDriver();
				break;
			default :
				System.out.println("Invalid browser name");
			
			}
			return driver;	
	}
	
	
	//add apache commans.io dependency
	public String screenshotMethod(String testCaseMethod,WebDriver driver) {
		String filePath=System.getProperty("user.dir")+"\\reports\\"+testCaseMethod+".png";
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(filePath);
			FileUtils.copyFile(src, dest);
			//FileHandler.copy(src, dest);
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

}
