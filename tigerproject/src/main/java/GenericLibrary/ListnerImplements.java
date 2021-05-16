package GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import TestScript.BaseTest;

public class ListnerImplements extends BaseTest  implements ITestListener {
	
	public void onFinish(ITestContext arg0) {					
		Reporter.log("onFinish",true);			

	}		


	public void onStart(ITestContext arg0) {					
		Reporter.log("onStart",true);					

	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
		Reporter.log("onTestFailedButWithinSuccessPercentage",true);				

	}		


	public void onTestFailure(ITestResult result) {					
		ScreenShotUtils sc=new ScreenShotUtils();
		sc.getScreenShotOfPage(driver,result);

	}		


	public void onTestSkipped(ITestResult arg0) {					
		Reporter.log("onTestSkipped",true);			

	}		


	public void onTestStart(ITestResult arg0) {					
		Reporter.log("onTestStart",true);					

	}		


	public void onTestSuccess(ITestResult arg0) {					
		Reporter.log("onTestSuccess",true);				

	}		
}
