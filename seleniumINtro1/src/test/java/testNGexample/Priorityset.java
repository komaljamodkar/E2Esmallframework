package testNGexample;

import org.testng.annotations.Test;

public class Priorityset {

	@Test
	public void webLogin() {
		System.out.println("Priority set class-testcase with WebLogin");
	}
	
	@Test
	public void mobileLogin() {
		System.out.println("priority set- testcase with mobileLogin");
	}
	
	@Test
	public void apiLogin() {
		System.out.println("priority set-testcase with apiLogin");
	}
}
