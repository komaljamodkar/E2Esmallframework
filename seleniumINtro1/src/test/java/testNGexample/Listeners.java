package testNGexample;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface implements TestNG listeners
public class Listeners implements ITestListener{

	@Override		
    public void onFinish(ITestContext arg0) {					
       System.out.println("Test finished.."+arg0.getName());		
        		
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
    	 System.out.println("Test Start.."+arg0.getName());			
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
    	System.out.println("Test SuccessPercentage.."+arg0.getName());		
    }		

    @Override		
    public void onTestFailure(ITestResult arg0) {					
    	System.out.println("Test failed.."+arg0.getName());			
    	//capture screenshot
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult arg0) {					
    	System.out.println("Test Skipped.."+arg0.getName());	
        		
    }		

    @Override		
    public void onTestStart(ITestResult arg0) {					
    	System.out.println("Test Started.."+arg0.getName());					
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        	System.out.println("Test Success.."+arg0.getName());	
    }
}

//types of listeners
//IAnnotationTransformer ,
//IAnnotationTransformer2 ,
//IConfigurable ,
//IConfigurationListener ,
//IExecutionListener,
//IHookable ,
//IInvokedMethodListener ,
//IInvokedMethodListener2 ,
//IMethodInterceptor ,
//IReporter,
//ISuiteListener,
//ITestListener .

//ITestListener has following methods
//
//OnStart- OnStart method is called when any Test starts.
//onTestSuccess- onTestSuccess method is called on the success of any Test.
//onTestFailure- onTestFailure method is called on the failure of any Test.
//onTestSkipped- onTestSkipped method is called on skipped of any Test.
//onTestFailedButWithinSuccessPercentage- method is called each time Test fails but is within success percentage.
//onFinish- onFinish method is called after all Tests are executed.