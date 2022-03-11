package testNGexample;

import org.testng.annotations.Test;

//TestNG plugin download-help->eclipse marketplace->TestNG then 
// add in project right clickt ->build path-> add librray-> TestNG

// in POM.XML file add TestNG jar 7.2.0
public class Sample {

	@Test(groups = {"smoke"},dependsOnMethods = {"fun2"})
	public void fun1() {
		System.out.println("Sample class- testmethod 1");
	}
	
	@Test
	public void fun2() {
		System.out.println("Sample class-testmethod 2");
	}
	
	//skip the test case not exeute
	@Test(enabled=false)
	public void fun3() {
		System.out.println("skipped test case");
	}
	
	//set script time only for this test
	@Test(timeOut = 10000)
	public void fun4() {
		System.out.println("timeout test case");
	}
	
	//repeat testcase 3 times
	@Test(invocationCount = 3)
	public void fun5() {
		System.out.println("invocation test case");
	}
	
	//repeat testcase 3 times with timeout
		@Test(invocationCount = 10,invocationTimeOut = 1000,skipFailedInvocations = true)
		public void fun6() {
			System.out.println("invocation test case with timeout 1 sec");
		}



	
}
