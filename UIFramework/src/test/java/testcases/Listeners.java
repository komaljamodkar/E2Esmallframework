package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.Baseclass;
import utility.ExtentReporterNG;

//testNG version > 7 not give error to implement interface methods
//
public class Listeners extends Baseclass implements ITestListener {

	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	//to run test in threadsafe  (in || el already allocated to test 1 test 2 overrried test may show failed)
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal();
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// set test object in ThreadLocal pool
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// capturescreenshot
		//pass driver object
		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String methodName=result.getMethod().getMethodName();		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

		} catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
//attach failure screenshot to report
		try {
			extentTest.get().addScreenCaptureFromPath(screenshotMethod(methodName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP,"Test is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
