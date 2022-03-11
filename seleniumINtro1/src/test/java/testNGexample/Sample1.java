package testNGexample;

import org.testng.annotations.Test;

public class Sample1 {

	@Test
	public void fun1() {
		System.out.println("testmethod 1 fun 1");
	}
	
	@Test(groups = {"smoke"})
	public void fun2() {
		System.out.println("testmethod 2 fun 2");
	}
	
	@Test(groups = {"smoke"})
	public void fun3() {
		System.out.println("testmethod 2 fun 3");
	}
	
	
}
