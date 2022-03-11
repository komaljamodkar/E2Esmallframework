package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//in junit trigger testcases with @Runwith

@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@WebTest",
		features="src/test/java/features",
		glue="stepDefinitions")
		
public class TestRunner {

}
