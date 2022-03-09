package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericUtils;

public class CheckoutPage {
	public WebDriver driver;

	GenericUtils gn=new GenericUtils(driver);

	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[alt='Cart']")
	WebElement cartBag;

	@FindBy(css=".promoBtn")
	WebElement promoBtn;

	@FindBy(xpath ="//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement checkOutButton;

	@FindBy(xpath ="//button[contains(text(),'Place Order')]")
	WebElement placeOrder;

	
	public void CheckoutItems(){
		gn.buttonClick(cartBag);
		gn.buttonClick(checkOutButton);
	}

	public Boolean VerifyPromoBtn()
	{
		return promoBtn.isDisplayed();
	}

	public Boolean VerifyPlaceOrder()
	{
		return placeOrder.isDisplayed();
	}




}
