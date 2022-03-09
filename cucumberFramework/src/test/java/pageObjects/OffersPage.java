package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.GenericUtils;

public class OffersPage {
	public WebDriver driver;

	GenericUtils gn=new GenericUtils(driver);

	public OffersPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement search;
	
	@FindBy(css="tr td:nth-child(1)")
	private WebElement productName;

	
	public void searchItem(String name){
		gn.sendkeys(search, name);
	}
	
	public void getSearchText()
	{
		gn.gettext(search);
	}
	
	public String getProductName()
	{
		return gn.gettext(productName);
	}
	
	
	
}
