package GenericLibrary;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenShotUtils {
	public void getScreenShotOfPage(WebDriver driver,ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./ErrorShot/"+result.getMethod().getMethodName()+".png");
		tempFile.renameTo(destFile);
		
	}
}
