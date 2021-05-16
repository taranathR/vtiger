package Examples;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestScript.BaseTest;

public class Sample4 extends BaseTest{
	@Test
	public void demo(){
		Reporter.log("method is getting executed...",true);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/","login page is not displayed");
		System.out.println(driver.getTitle());
		
	}
	@Test
	public void disp(){
		Reporter.log("next method is getting executed...",true);
	}

}
