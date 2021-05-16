package GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRestryImplementation implements IRetryAnalyzer{
	private int count=0;
	private int rertyCount=3;
	public boolean retry(ITestResult result) {
		if(rertyCount>=count){
			count++;
			return true;
		}
		return false;
	}

}
