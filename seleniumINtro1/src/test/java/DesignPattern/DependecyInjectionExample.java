package DesignPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// picocontainer dependency need to add
// create a one class declare variable which want to share across all step definition
//pass the a instance of class in all step def constuctor
//call with that instace
//ex: create a StepContext class and ddeclare variable which want to use in setep def
public class DependecyInjectionExample {
	StepContext stepcontext;
	
	//constructor initialize
	public DependecyInjectionExample(StepContext stepcontext) {
		this.stepcontext=stepcontext;
	}
	
	
	@Test
	public void start() {
		stepcontext.driver=new ChromeDriver();
		stepcontext.name="abcd";
	}

	public static void main(String[] args) {
		
	}

}
