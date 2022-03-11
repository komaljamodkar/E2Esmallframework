package threadconcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Parallelbrowserexecution extends Thread {
	enum BrowserName{
		CHROME,FIREFOX,EDGE
	}

	private WebDriver driver;
	private String Url;
	private String browsertype;

	public Parallelbrowserexecution(String name,String browsertype) {
		super(name);
		this.browsertype=browsertype;

	}

	@Override
	public void run(){
		System.out.println("Thread-stared"+Thread.currentThread().getName());
		String threadname=Thread.currentThread().getName();
		System.out.println(threadname);
		try {
			Thread.sleep(1000);
			setUp(this.browsertype);
			testGooglesearch();

		} catch (InterruptedException e) {
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			tearDown();
		}
		System.out.println("Thread-end"+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		Thread t1=new Parallelbrowserexecution("Thread Chrome","CHROME");
		Thread t2=new Parallelbrowserexecution("Thread FIREFOX","FIREFOX");
		Thread t3=new Parallelbrowserexecution("Thread EDGE","EDGE");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Thread has started..");
	}

	// test scripts

	public void testGooglesearch() throws Exception {

		
	}

	// tear down function to close browser

	public void tearDown() {

		driver.close();

		driver.quit();
		

	}

	private static void setUp(String browser) {
		WebDriver driver=null;
		switch(browser) {
		case "CHROME":

			/*
			 * WebDriverManager.chromedriver() .version("83.0.0") .arch32()
			 * .proxy("proxyhostname:80") .proxyUser("username") .proxyPass("password")
			 * .setup();
			 */
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("Invalid browser name");

		}

		String Url = "https://www.google.com/";

		driver.get(Url);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//input[@title='Search']"));
		ele.sendKeys("parallel execution in testng");
		ele.sendKeys(Keys.ENTER);
	}

}
