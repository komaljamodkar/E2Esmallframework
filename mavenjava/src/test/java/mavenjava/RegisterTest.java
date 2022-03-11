package mavenjava;

import org.testng.annotations.Test;

public class RegisterTest {

	@Test
	public void demo() {
		System.out.println("register-Testcase 1...");
	}
	
	@Test(enabled=false)
	public void demo1() {
		System.out.println("register-Testcase 2...");
	}

	@Test
	public void demo2() {
		System.out.println("register-Testcase 3...");
	}

}
