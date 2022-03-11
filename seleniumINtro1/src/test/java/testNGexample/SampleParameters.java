package testNGexample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleParameters {

	@Test
	@Parameters({"URL"})
	public void fun1(String url) {
		System.out.println("Paramater method value -"+url);
		
	}
	
}
