package TestScript;

import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POMrepository.HomePage;
import POMrepository.InvoicePage;

public class TestNGClass4 extends BaseTest{
	@Test(groups="second")
	public void TC_9() throws Exception{
		Actions action=new Actions(driver);
		homepage=new HomePage(driver);
		Set<String> allWid;
		//===========================================================================================================================
		//step 3:Go to "More" DropDown menu & click on "Invoice" sub menu
		action.moveToElement(homepage.getMore()).perform();
		homepage.getInvoice().click();
		String excpectedInvoiceTitle = "Administrator - Invoice - vtiger CRM 5 - Commercial Open Source CRM";
		if(driver.getTitle().equals(excpectedInvoiceTitle)){
			Reporter.log("Invoice page is displayed successfully",true);
		}else{
			Reporter.log("Invoice page is not displayed",true);
		}


		//===========================================================================================================================
		//step 4:click on lookup image of "Create Invoice" Page

		invoicepage=new InvoicePage(driver);
		invoicepage.getCreateNewInvoiceButton().click();
		if(invoicepage.getSubTitleOfInvoice().isDisplayed()){
			Reporter.log("creating New Invoice page is displayed successfully",true);
		}else{
			Reporter.log("creating New Invoice page is not displayed",true);
		}


		//===========================================================================================================================
		//step 5: Create Invoice By Following Info:Enter Subject,Billing Address,Shipping Address & click on "Look-UP" image beside the "Organisation" field


		String subjectValue = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 3, 0);
		invoicepage.getSubjectTextField().sendKeys(subjectValue);
		String billingAddress = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 4, 0);
		invoicepage.getBillingAddressTextField().sendKeys(billingAddress);
		String shippingAddress = lib.getStringcellvalue("./Resources/data.xlsx", "Sheet1", 5, 0);
		invoicepage.getShippingAddressTextField().sendKeys(shippingAddress);
		invoicepage.getOrganizationButton().click();
		String parentWid = driver.getWindowHandle();
		allWid = driver.getWindowHandles();
		allWid.remove(parentWid);
		for(String s:allWid){
			driver.switchTo().window(s);
		}
		if(invoicepage.getOrganizationSubTitle().isDisplayed()){
			Reporter.log("Oganisation page  is displayed with list of Organisation name in new-Browser-Window successfully",true);
		}else{
			Reporter.log("Oganisation page  is not displayed in new-Browser-Window",true);
		}
		driver.close();
		driver.switchTo().window(parentWid);


		//===========================================================================================================================
		//step 6: Click on "Look-UP"image beside the item name and select the "product" 

		invoicepage.getIteamNameButton().click();
		allWid = driver.getWindowHandles();
		allWid.remove(parentWid);
		for(String s:allWid){
			driver.switchTo().window(s);
		}
		if(invoicepage.getProductsSubTitle().isDisplayed()){
			Reporter.log("Products page  is displayed in new-Browser-Window successfully",true);
		}else{
			Reporter.log("Products page  is not displayed in new-Browser-Window",true);
		}
		driver.close();
		driver.switchTo().window(parentWid);

		
	}
}
