package testNGexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideroperation {

	@Test(dataProvider = "getData")
	public void dataproviderFun1(String userName,String password) {
		System.out.println("Paramater method value -");
		System.out.println(userName+"   "+password);
	}

	@BeforeMethod
	public void bmethod1() {
		System.out.println("before method 1");
	}
	
	@BeforeMethod
	public void bmethod2() {
		System.out.println("before method 2");
	}
	
	@BeforeMethod
	public void bmethod3() {
		System.out.println("before method 3");
	}

	@DataProvider
	public Object[][] getData() {
		//create object of Object class
		Object [][] data=new Object[3][2]; //3 row 2 col
		//1st set
		data[0][0]="firstUserName";
		data[0][1]="firstPassword";

		//2nd set
		data[1][0]="secondUserName";
		data[1][1]="secondPassword";

		//3nd set
		data[2][0]="thirdUserName";
		data[2][1]="thirdPassword";
		
		return data;
	}
}
