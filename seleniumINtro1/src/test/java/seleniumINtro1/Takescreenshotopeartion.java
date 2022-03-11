package seleniumINtro1;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Takescreenshotopeartion {
//required a jar apache commans.io
	public static void main(String[] args) {
		WebDriver driver=null;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		//timeout is an interface having 3 abstract methods , manage()returns a options interface
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		js.executeScript("window.scrollBy(0,250)");
		Date dt=new Date();
		long time=dt.getTime();
		Timestamp ts=new Timestamp(time);
		String fileName=ts.toString();
		String filePath="C:\\developmentAveto\\workspace\\seleniumINtro1\\screenshots\\"+fileName+".png";
		System.out.println(filePath);
		screenshotMethod(driver,filePath);
driver.close();
	}
	
	public static void screenshotMethod(WebDriver driver,String filePath) {
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(filePath);
			FileUtils.copyFile(src, dest);
			//FileHandler.copy(src, dest);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
