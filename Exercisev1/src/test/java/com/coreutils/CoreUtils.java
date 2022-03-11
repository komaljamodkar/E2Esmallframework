package com.coreutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stepDef.TestCase;

public class CoreUtils{
	WebDriver driver=null;
	
	 
	  public WebDriverWait getWait(int time) {
		  WebDriverWait wait=new WebDriverWait(driver,time);
		  return wait;
	  }
	  
	  public void explicitWait(WebElement element) {
		  getWait(30).until(ExpectedConditions.visibilityOf(element));
	  }
	
	public void dragAndDrop(WebElement source,WebElement target) {
		explicitWait(source);
		Actions action=new Actions(driver); 
		  action.dragAndDrop(source, target).build().perform();
	}
}
