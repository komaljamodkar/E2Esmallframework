package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericUtils;

public class LandingPage {
	public WebDriver driver;

	GenericUtils gn=new GenericUtils(driver);
	public LandingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement search;

	@FindBy(css ="h4.product-name")
	WebElement productName;

	@FindBy(linkText ="Top Deals" )
	WebElement topDeals ;

	@FindBy(css ="a.increment")
	WebElement increment;

	@FindBy(css =".product-action button")
	WebElement addToCart;

	//5-6

	public void searchItem(String name){
		gn.sendkeys(search, name);
	}

	public void getSearchText(){
		gn.gettext(search);
	}

	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0){
			gn.buttonClick(increment);
			i--;
		}

	}

	public void addToCart()
	{
		gn.buttonClick(addToCart);
	}

	public String getProductName()
	{
		return gn.gettext(productName);
	}

	public void selectTopDealsPage()
	{
		gn.buttonClick(topDeals);
	}

	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}



}
