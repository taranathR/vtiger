package POMrepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import GenericLibrary.ExcelLib;


public class LoginPage {
	WebDriver driver;
	ExcelLib lib=new ExcelLib();
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(name="user_name")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	@FindBy(name="user_password")
	private WebElement password;

	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void login(String username,String password) throws Exception{
		getUsername().sendKeys(username);
		getPassword().sendKeys(password,Keys.ENTER);
		//getLoginButton().click();
	}
}