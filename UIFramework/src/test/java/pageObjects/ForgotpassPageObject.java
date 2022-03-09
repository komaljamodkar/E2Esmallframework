package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotpassPageObject {
	
	WebDriver driver;
	public ForgotpassPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}

	@FindBy(id="un")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement sendMe;
	
	public WebElement getMail() {
		return email;
	}
	
	
	public WebElement getButton() {
		return sendMe;
	}
}
