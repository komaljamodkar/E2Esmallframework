package seleniumINtro1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdowngetAllvalues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.codechef.com/ide?itm_medium=navmenu&itm_campaign=ide");

		WebElement ele=driver.findElement(By.xpath("//div[@class='language_selector']//select"));
		ele.click();
		Select select=new Select(ele);
		List<WebElement> ele1=select.getOptions();
		int n= ele1.size();
		for(int i=0;i<n;i++) {
		System.out.println(ele1.get(i).getText());
		}
		driver.quit();
	}

}
