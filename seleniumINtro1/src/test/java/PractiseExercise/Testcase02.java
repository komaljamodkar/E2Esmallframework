package PractiseExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase02 {
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver;

	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	driver.get("https://rahulshettyacademy.com/angularpractice/");

	driver.manage().window().maximize();

	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abcd");

	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd@gmail.com");

	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("12345678");

	boolean ch1=driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected();


	driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();

	System.out.println(ch1);

	System.out.println(driver.findElements(By.xpath("//input[@id='exampleCheck1']")).size());

	WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));

	Select select = new Select(dropdown1);

	select.selectByVisibleText("Female");

	driver.findElement(By.cssSelector("[name='bday']")).sendKeys("02-24-2022");

	driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();

	boolean ch2=driver.findElement(By.xpath("//input[@id='inlineRadio3']")).isEnabled();

	if(ch2==false){

	System.out.println("Entrepreneur is disabled as Expected");

	}

	else{

	System.out.println("Entrepreneur is Enabled and its wrong");

	}

	System.out.println(ch2);

	driver.findElement(By.xpath("//input[@type='submit']")).click();

	Thread.sleep(3000);
	System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText());
	driver. close();
	
	System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");



//	WebDriver driver=new ChromeDriver();
//
//
//
//
//
//	driver.get("https://rahulshettyacademy.com/angularpractice/");
//
//	driver.findElement(By.name("name")).sendKeys("rahul");
//
//	driver.findElement(By.name("email")).sendKeys("hello@abc.com");
//
//	driver.findElement(By.id("exampleInputPassword1")).sendKeys("123456");
//
//	driver.findElement(By.id("exampleCheck1")).click();
//
//	WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
//
//	Select abc = new Select(dropdown);
//
//	abc.selectByVisibleText("Female");
//
//	driver.findElement(By.id("inlineRadio1")).click();
//
//	driver.findElement(By.name("bday")).sendKeys("02/02/1992");
//
//	driver.findElement(By.cssSelector(".btn-success")).click();
//
//	System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
//
//
//
//	}
//






	

//	Your submission
//	KJ
//	Komal Jamodkar
//	Posted A few seconds ago
//	Complete the Assignment and Post the code here
//
//	public static void main(String[] args) throws InterruptedException {
//
//	WebDriver driver;
//
//
//
//	WebDriverManager.chromedriver().setup();
//
//	driver=new ChromeDriver();
//
//	driver.get("https://rahulshettyacademy.com/angularpractice/");
//
//
//
//	driver.manage().window().maximize();
//
//
//
//	driver.findElement(By.xpath("//input[@name='name']")).sendKeys("abcd");
//
//
//
//	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abcd@gmail.com");
//
//
//
//	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("12345678");
//
//
//
//	boolean ch1=driver.findElement(By.xpath("//input[@id='exampleCheck1']")).isSelected();
//
//
//
//
//
//	driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
//
//
//
//	System.out.println(ch1);
//
//
//
//	System.out.println(driver.findElements(By.xpath("//input[@id='exampleCheck1']")).size());
//
//
//
//	WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
//
//
//
//	Select select = new Select(dropdown1);
//
//
//
//	select.selectByVisibleText("Female");
//
//
//
//	driver.findElement(By.cssSelector("[name='bday']")).sendKeys("02-24-2022");
//
//
//
//	driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
//
//
//
//	boolean ch2=driver.findElement(By.xpath("//input[@id='inlineRadio3']")).isEnabled();
//
//
//
//	if(ch2==false){
//
//
//
//	System.out.println("Entrepreneur is disabled as Expected");
//
//
//
//	}
//
//
//
//	else{
//
//
//
//	System.out.println("Entrepreneur is Enabled and its wrong");
//
//
//
//	}
//
//
//
//	System.out.println(ch2);
//
//
//
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//
//
//	Thread.sleep(3000);
//
//	System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText());
//
//	driver. close();
//
//	}


}

}
