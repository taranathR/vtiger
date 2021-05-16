package Examples;

import org.testng.Reporter;
import org.testng.annotations.Test;
import TestScript.BaseTest;

public class Sample1 extends BaseTest{

	@Test
	public void demo2()
	{

		Reporter.log("demo method",true);
	}

}
