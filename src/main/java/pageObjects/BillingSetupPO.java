package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingSetupPO {
	public WebDriver driver;
	public BillingSetupPO(WebDriver driver) {
		this.driver=driver;
		}
 By billingLink = By.id("miClickableRowBilling");//Billing link in left menu
 By selectstatedpdwn = By.id("selectedState");// Select state drop down
 By addbtnmodal = By.id("btnUpdateBillingState");// add button in add form billing modal
 By cancelbtnmodal = By.id("btnToggleAddListCancel");// Cancel button in add form billing modal
 By previousbtn = By.id("btnPreviousGenBillingSetup");//previous button at the bottom
 By cancelbtn = By.id("btnCancelGenBillingSetup");//Cancel btn at the bottom
 By savebillingbtn = By.id("btnSaveBillingSetup");//Save btn at the bottom
 By saveandnextbtn = By.id("btnNextBillingSetup");// save&next btn at the bottom 
 //-----------------------------Form Billing-------------------------------------------------------------------------
 By addformbtn = By.id("btnAddForm+");// AddForm+ button
 //By formbaseqty = By.id("bqty-15338");// BaseQTY text box
 //By formbaseprice = By.id("bprice-15338");// Base Price text box 
 //By formperitem = By.id("bpriceperrow0");// Per item text box bpriceper-18335
 By RetSch4peritem = By.id("bpriceper-31239"); //per item for sch3 //new
 By addbtninselectform = By.id("btnUpdateBillingState"); //add in form by billing //new
 By formbillingperitem = By.xpath("//*[@id='txtFormPerItem0']"); //for reload billing txtFormPerItem0
 By itemizedchargeinareturn = By.id("BB0100"); //after reload billing, check here to confirm
  //------------------------------Worksheet Billing------------------------------------------------------------------
 By addworksheetbtn = By.id("btnAddWorksheet+");// Add Worksheet+ bbutton
 By ret1040peritem = By.id("bpriceper-33542"); //ret1040in worksheet //new
 By addbtninWorksheet = By.id("btnUpdateBillingState"); //addinworksheet //new
 By wrkshtbaseqty = By.id("txtFormBaseQty2");// baseQTY txt box in worksheet modal
 By wrkshtbaseprice = By.id("txtFormBasePrice2");// base price in worksheet
 By wrkshtperitem = By.id("bpriceper-17461");//per item in worksheet
 //-------------------------------Line Item Billing------------------------------------------------------- 
 By addlineitemsbtn = By.id("btnAddLineItems+");//add lineitems+ btn
 By ret1040perlineitem = By.id("bpriceper-32417"); //lineitems 1040 //new
 By addbtninlineitem = By.id("btnUpdateBillingState"); //add in linebtn //new
 By lineitemsbaseqty = By.id("bqty-16389");// base qty 
 By lineitemsbaseprice = By.id("bprice-16389");//base price
 By lineitemsperitem = By.id("bpriceper-16389");//per item
 //----------------------------------Discounts----------------------------------------------------------------
 By disaddrowbtn = By.id("btnAddRowBillingDiscounts");// Add row+ btn in discounts  
 By discountcode = By.id("txtDiscountCode0");// discount code text box
 By disamount = By.id("txtDiscountAmt0");//amount in discounts
 //---------------------------------Custom Charges----------------------------------------------------
 By customaddrowbtn = By.id("btnAddRowCustomChanges");// add row+ btn in custom charges
 By chargedesc = By.id("txtChargeDesc0");// charge description txt box
 By customamount = By.id("txtChargeAmt0");//Amount in custom Charges
 //---------------------------------Close-------------------------------------------------------------
 By billingsetupclosebtn = By.id("btnSaveAndCloseSettingsProfile");//close button in billingsetup
 //------------------------------ Billing--------------------------------------------------------------------------
 public WebElement clickbillingLink()
	{
		return driver.findElement(billingLink);
	}
 public WebElement clickselectstatedpdwn()
	{
		return driver.findElement(selectstatedpdwn);
	}
 public WebElement clickaddbtnmodal()
	{
		return driver.findElement(addbtnmodal);
	}
public WebElement clickcancelbtnmodal()
	{
		return driver.findElement(cancelbtnmodal);
	}
public WebElement clickpreviousbtn()
	{
	return driver.findElement(previousbtn);
	}
public WebElement clickcancelbtn()
	{
	return driver.findElement(cancelbtn);
	}
public WebElement clicksavebillingbtn()
	{
	return driver.findElement(savebillingbtn);
	}
public WebElement clicksaveandnextbtn()
	{
	return driver.findElement(saveandnextbtn);
	}
//----------------------------------Form Billing----------------------------------------
 public WebElement clickaddformbtn()
	{
		return driver.findElement(addformbtn);
	}
 
 	public WebElement getRetSch4peritem()
	{
		return driver.findElement(RetSch4peritem);
	}
 	public WebElement clickaddbtninselectform()
	{
		return driver.findElement(addbtninselectform);
	}
 	
 	public WebElement clickformbillingperitem()
	{
		return driver.findElement(formbillingperitem);
	}
 	
 	public WebElement clickitemizedchargeinareturn()
	{
		return driver.findElement(itemizedchargeinareturn);
	}
 /*public WebElement clickformbaseqty()
	{
		return driver.findElement(formbaseqty);
	}
 public WebElement clickformbaseprice()
	{
		return driver.findElement(formbaseprice);
	}
 public WebElement clickformperitem()
	{
		return driver.findElement(formperitem);
	}*/
 //---------------------------------Worksheet billing-------------------------------------------------
 public WebElement clickaddworksheetbtn()
	{
		return driver.findElement(addworksheetbtn);
	}
 public WebElement clickwrkshtbaseqty()
	{
		return driver.findElement(wrkshtbaseqty);
	}
 public WebElement clickwrkshtbaseprice()
	{
		return driver.findElement(wrkshtbaseprice);
	}
 public WebElement clickwrkshtperitem()
	{
		return driver.findElement(wrkshtperitem);
	} 
 public WebElement getret1040peritem()
	{
		return driver.findElement(ret1040peritem);
	}
 public WebElement clickaddbtninWorksheet()
	{
		return driver.findElement(addbtninWorksheet);
	}
 //-------------------------------Line Items Billing------------------------------------------------------------------------
 public WebElement clickaddlineitemsbtn()
	{
		return driver.findElement(addlineitemsbtn);
	}
 public WebElement clicklineitemsbaseqty()
	{
		return driver.findElement(lineitemsbaseqty);
	}
 public WebElement clicklineitemsbaseprice()
	{
		return driver.findElement(lineitemsbaseprice);
	}
 public WebElement clicklineitemsperitem()
	{
		return driver.findElement(lineitemsperitem);
	} 
 public WebElement getret1040perlineitem()
	{
		return driver.findElement(ret1040perlineitem);
	}
 public WebElement clickaddbtninlineitem()
	{
		return driver.findElement(addbtninlineitem);
	}
 //----------------------------------Discounts---------------------------------------------------------------------
 public WebElement clickdisaddrowbtn()
	{
		return driver.findElement(disaddrowbtn);
	}
 public WebElement getdiscountcode()
	{
		return driver.findElement(discountcode);
	}
 public WebElement getdisamount()
	{
		return driver.findElement(disamount);
	}
 //-----------------------------------Custom Charges---------------------------------------------------------
 public WebElement clickcustomaddrowbtn()
	{
		return driver.findElement(customaddrowbtn);
	}
 public WebElement getchargedesc()
	{
		return driver.findElement(chargedesc);
	}
 public WebElement getcustomamount()
	{
		return driver.findElement(customamount);
	}
 
 public WebElement clickbillingsetupclosebtn()
	{
		return driver.findElement(billingsetupclosebtn);
	}
}




