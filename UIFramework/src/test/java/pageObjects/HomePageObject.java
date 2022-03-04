package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;

	@FindBy(id="Login")
	WebElement login;

	
	public WebElement getusername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

//create a object of another pageobject class and call by current pageobject
	// can remove redunduncy in step def
	public ForgotpassPageObject forgotpassMethod() throws InterruptedException {
		driver.findElement(By.id("forgot_password_link")).click();
		Thread.sleep(3000);
		return new ForgotpassPageObject(driver);
	}
}
