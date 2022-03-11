package testNGexample;

import org.testng.annotations.Test;

public class Sample2 {
	@Test(groups = {"smoke"})
	public void fun1() {
		System.out.println("Sample2 class -testmethod 1 class 2");
	}
}
