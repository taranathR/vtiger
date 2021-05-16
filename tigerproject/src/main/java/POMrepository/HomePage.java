package POMrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public  HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	//Actions action=new Actions(driver);
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement More;
	
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/user')]")
	private WebElement profileIcon;
	
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/main')]")
	private WebElement settingsIcon;
	
	@FindBy(name="Invoice")
	private WebElement invoice;

	@FindBy(partialLinkText="Sign Out")
	private WebElement signOutIcon;
	
	
	public WebElement getSignOutIcon() {
		return signOutIcon;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getMore() {
		return More;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSettingsIcon() {
		return settingsIcon;
	}
	
	public void logOut(){
		Actions action=new Actions(driver);
	action.moveToElement(getProfileIcon()).perform();
	getSignOutIcon().click();
	}
	
}
