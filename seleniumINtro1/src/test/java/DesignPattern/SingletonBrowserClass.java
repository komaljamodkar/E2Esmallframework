package DesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//DBMS, logging, keep track of same driver instace thoughtout the execution
public class SingletonBrowserClass {
	
	// instance of singleton class
		private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;
	    private WebDriver driver;

	    // Constructor
	    private SingletonBrowserClass(){
	    	//which steps needs in all class
	    	System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
			driver= new ChromeDriver();
	    }

	    // TO create instance of class
	    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
	        if(instanceOfSingletonBrowserClass==null){
	        	instanceOfSingletonBrowserClass = new SingletonBrowserClass();
	        }
	        return instanceOfSingletonBrowserClass;
	    }
	    
	    // To get driver
	    public WebDriver getDriver()
	    {
	    	return driver;
	    }

	public static void main(String[] args) {
		
	//in another class create a instance object
//		SingletonBrowserClass sbc1= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
//		WebDriver driver1 = sbc1.getDriver();
//		
//		
//		SingletonBrowserClass sbc2= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
//		WebDriver driver2 = sbc2.getDriver();
//		driver2.get("https://www.google.com");
		
		
	}

}
