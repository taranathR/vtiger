package TestScript;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sampe {
	@DataProvider(name="d",parallel=true)
	public String[][] value(){
		String [][] arr={{"hi","heloo"},{"java","selenium"}};
		return arr;
	}
	
	@Test(dataProviderClass=sampe.class,dataProvider="d")
	public void sam(String[] a){
		for(String s:a){
		Reporter.log(s,true);
		}
	}
}
