package TestScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(GenericLibrary.ListnerImplements.class)

public class DemoForLister extends BaseTest{
	@Test
	public void disp(){
		Reporter.log("TEST CASE IS RUNNING..........",true);
		//Assert.fail();
	}
}
