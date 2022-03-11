package dataprovider;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase01 {
	
	String filePath ="C:\\developmentAveto\\workspace\\seleniumINtro1\\src\\test\\java\\dataprovider\\excelData\\TestData1.xlsx";
	String sheetName = "Sheet1";
	
	@BeforeTest
	public void beforetestcase1() {
		System.out.println("Before test one");
	}
	
	@Test(enabled=false)
	public static void testcase1() {
		System.out.println("test one");
	}

	@Test(priority=1, groups="grp1")
	@Parameters("name")
	public static void testcase2(String name) {
		System.out.println("test two");
		System.out.println("name :"+name);
	}
	@Test(dataProvider = "Form")
	public static void testcase3(String username,String password) {
		System.out.println("test three");
		System.out.println(username+"   "+password);
	}
	@Test
	public static void testcase4() {
		System.out.println("test four");
	}
	
	@Ignore
	public static void testcase5() {
		System.out.println("test two");
	}
	
	//To provide data from excel sheet
	  @DataProvider(name = "Form")
		public String[][] getValidData() throws Exception {
			
			return Excelutil.excelRead(filePath, sheetName);
		}

}
