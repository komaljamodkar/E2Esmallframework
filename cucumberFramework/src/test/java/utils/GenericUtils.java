package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	
	public WebDriverWait getWait(int val) {
		WebDriverWait wait=new WebDriverWait(driver,val);
		return wait;
	}

	public void explicitWait(WebElement element) {
		getWait(3).until(ExpectedConditions.visibilityOf(element));
	}

	public void sendkeys(WebElement element,String value) {
		//explicitWait(element);
		element.sendKeys(value);
	}

	public void buttonClick(WebElement element) {
		element.click();
	}
	
	public String gettext(WebElement element) {
		return element.getText();
	}	
}
