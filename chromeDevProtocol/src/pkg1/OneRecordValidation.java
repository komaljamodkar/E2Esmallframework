package pkg1;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.fetch.Fetch;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;

//validate with only record with API
//in GET api search with only one id

public class OneRecordValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//executeCDP command accepts 2 arguments -method , param
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			//maxtotalBuffersize,maxresouseBuffersize
			devtool.send(Fetch.enable(Optional.empty(), Optional.empty()));
			devtool.addListener(Fetch.requestPaused(), request->{
				
				if(request.getRequest().getUrl().contains("shetty")) {
					
					String mockurl=request.getRequest().getUrl().replace("=Shetty", "=BadGuy");
					System.out.println(mockurl);
					//continue Request can modify update the value in URL
					devtool.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockurl),Optional.of(request.getRequest().getMethod()),Optional.empty(),Optional.empty(), Optional.empty()));
				}
				
				else {
					devtool.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()),Optional.empty(),Optional.empty(), Optional.empty()));
				}
				
			});
			
			
			
			driver.get("https://google.com/");
			
			driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			
			//gettext of one record message
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();

	}

}
