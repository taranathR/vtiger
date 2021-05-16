package Examples;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import TestScript.BaseTest;

public class Sample3 extends BaseTest{
	@Test
	public void demo(){
		Reporter.log("method is getting executed...",true);
		Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/","login page is not displayed");
		System.out.println(driver.getTitle());
		
	}
	@Test
	public void disp(){
		Reporter.log("next method is getting executed...",true);
	}
}
