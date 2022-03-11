package pkg1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v97.emulation.Emulation;
import org.openqa.selenium.devtools.v97.network.Network;
import org.openqa.selenium.devtools.v97.network.model.Request;
import org.openqa.selenium.devtools.v97.network.model.Response;


//setGeoLocationOverride
//get log, lat 40 3

public class NetworkActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		//executeCDP command accepts 2 arguments -method , param
		try {
			DevTools devtool=driver.getDevTools();
			devtool.createSession();
			//maxtotalBuffersize,maxresouseBuffersize
			devtool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			
			devtool.addListener(Network.requestWillBeSent(), request->{
				Request req=request.getRequest();
				System.out.println(req.getUrl());
			});
			
			//event get fireed
			devtool.addListener(Network.responseReceived(), response->{
				Response res=response.getResponse();
				System.out.println(res.getUrl());
				System.out.println(res.getStatus());
				if(res.getStatus().toString().startsWith("4")) {
					System.out.println(res.getUrl()+" is failed with "+res.getStatus());
				}
				System.out.println(res.getStatusText());
			});
			driver.get("https://google.com/");
			
			driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.close();
	}

}
