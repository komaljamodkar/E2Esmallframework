package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CoreUtils {

	WebDriver driver;
	public CoreUtils(WebDriver driver) {
		this.driver=driver;
	}

	public WebDriverWait getWait(int val) {
		WebDriverWait wait=new WebDriverWait(driver,val);
		return wait;
	}

	public void explicitWait(WebElement element) {
		getWait(30).until(ExpectedConditions.visibilityOf(element));
	}

	public void sendkeys(WebElement element,String value) {
		explicitWait(element);
		element.sendKeys(value);
	}

	public void buttonClick(WebElement element) {
		element.click();
	}
}
