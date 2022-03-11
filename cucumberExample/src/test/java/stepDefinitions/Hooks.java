package stepDefinitions;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	
	@Before("@MobileTest")
	public void beforevaldiation()
	{
		System.out.println("Before Mobile  hook");
	}
	
	@After("@MobileTest")
	public void Aftervaldiation()
	{
		System.out.println("  After Mobile before hook");
	}
		
		@Before("@WebTest")
		public void beforeWebvaldiation()
		{
			System.out.println("Before Web  hook");
		}
		
		@After("@WebTest")
		public void AfterWebvaldiation()
		{
			System.out.println("  After Web before hook");
		}
		
		@AfterStep
		public void Addscreesnhot(Scenario scenario) throws IOException {
			WebDriver driver=null;
			if(scenario.isFailed()) {
				//add screenshot method here need to convert into Byte format
				//screenshot
				File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
				scenario.attach(fileContent, "image/png", "image");

			}
		}
		
	}

