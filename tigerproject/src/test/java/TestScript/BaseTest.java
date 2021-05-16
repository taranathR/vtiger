package TestScript;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import GenericLibrary.ExcelLib;
import POMrepository.HomePage;
import POMrepository.InvoicePage;
import POMrepository.LoginPage;
public class BaseTest {
	public static WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	InvoicePage invoicepage;
	ExcelLib lib=new ExcelLib();
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void openApplication(@Optional("ChromeDriver")String browserName) throws Exception{
		//pre-condition : Launching the browser
		if(browserName.equalsIgnoreCase("ChromeDriver")){
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FirefoxDriver")){
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
		}
		Reporter.log("chrome browser is launching successfully",true);
		driver.manage().window().maximize();
		Reporter.log("chrome browser is maximized successfully",true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//===========================================================================================================================
		//step 1: navigate to CRM application
		
		String url = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 0, 0);
		driver.get(url);
		String expectedLoginTitle = "vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedLoginTitle)){
			Reporter.log("Login page is displayed successfully",true);
		}else{
			Reporter.log("Login page is not displayed",true);
		}
	}
	@BeforeMethod(alwaysRun=true)
	public void loginToApplication() throws Exception{
		
		//===========================================================================================================================
		//step 1: Login to the application
		String username = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 1, 0);
		String password = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 2, 0);
		System.out.println(username);
		System.out.println(password);
		loginpage=new LoginPage(driver);
		loginpage.login(username,password);
		String expectedHomeTitle="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(expectedHomeTitle)){
			Reporter.log("Home page is displayed successfully",true);
		}else{
			Reporter.log("Home page is not displayed",true);
		}

	}
	
	//===========================================================================================================================
	//step 6:Click on logout

	@AfterMethod(alwaysRun=true)
	public void logOutFromApplication(){
		homepage=new HomePage(driver);
		homepage.logOut();
		if(loginpage.getLoginButton().isDisplayed()){
			Reporter.log("user is logged out successfully",true);
		}else{
			Reporter.log("user is not logged out",true);
		}
	}
	@AfterClass(alwaysRun=true)
	public void closeTheApplication(){
		Reporter.log("Applications is getting closed............",true);
		driver.quit();
		
	}
}
