package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//trigger testcases with AbstractTestNgCucucmber class
@CucumberOptions(
		tags="@WebTest or @tag2",
		features="src/test/java/features",
		glue="stepDefinitions",
		monochrome = true,
		dryRun =true,
		plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}) // need to give explicitly in report can see the steps 
public class TestngRunner extends AbstractTestNGCucumberTests {

	//run cucumber testcases in parallel
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

