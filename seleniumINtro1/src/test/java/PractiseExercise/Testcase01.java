package PractiseExercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase01 {
	
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
	@Test
	public static void testcase3() {
		System.out.println("test three");
	}
	@Test
	public static void testcase4() {
		System.out.println("test four");
	}
	
	@Ignore
	public static void testcase5() {
		System.out.println("test two");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
