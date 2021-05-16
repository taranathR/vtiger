package Examples;

import org.testng.Reporter;
import org.testng.annotations.Test;
import TestScript.BaseTest;

public class Sample2 extends BaseTest{

	@Test
	public void demo()
	{

		Reporter.log("second method",true);
	}

}
