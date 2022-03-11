package testNGexample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotationsoperation {
	
	@BeforeSuite
	public void suite1() {
		//set up global variable , api keys,environment
		System.out.println("suite level execute");
	}

	@BeforeTest
	public void before(){
		//before test url delete old cookies
		System.out.println("before Test execute");

	}
	
	@BeforeMethod
	public void method1level() {
		System.out.println("=================");
		System.out.println("method level execute --before each method");
		
	}
	
	@AfterMethod
	public void method2level() {
		
		System.out.println("method level execute --After each method");
		System.out.println("=================");
	}
	
	@BeforeClass
	public void class1() {
		System.out.println("before class exection.....");
	}
	
	@AfterClass
	public void class12() {
		System.out.println("after class exection.....");
	}
	
	@Test
	public void demo() {
		System.out.println("Annotation class-test level 1 ..demo 1");
	}
	
	@Test
	public void fun3() {
		System.out.println("Annotation class-testmethod 2 fun 3");
	}
	
	
	
	@Test(groups = {"smoke"})
	public void demo1() {
		System.out.println("Annotation class-test level 2 ..demo2 ");
	}
	
	@AfterTest
	public void tearDown() {
		//delete cookies
		System.out.println("After Test execute");
	}
	
	@AfterSuite
	public void suite2() {
		System.out.println("After suite level execute");
	}
}
