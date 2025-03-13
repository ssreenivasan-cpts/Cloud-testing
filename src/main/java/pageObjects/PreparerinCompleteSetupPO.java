/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 *
 */
public class PreparerinCompleteSetupPO {
	
	public WebDriver driver;
	public PreparerinCompleteSetupPO(WebDriver driver) {
		this.driver=driver;
	}
	By AddNewbtn = By.id("btnAddNewPreparerSetup");
	By PrepID = By.id("txtNpPreparerIDNewPreparer");
	By ThirdPartyPIN = By.id("txtNpThirdPartyPINNewPreparer");
	By PrepName = By.id("txtPreparerNameNewPreparer");
	By PrepSSN = By.id("txtPreparerSSNNewPreparer");
	By PrepPTIN = By.id("txtPreparerPTINNewPreparer");
	By PrepType = By.id("ddlPreparerTypeNewPreparerSelect");
	By PrepTypeOption = By.xpath("//option[@value='CERTIFIED PUBLIC ACCOUNTANT']");
	By PrepEmail = By.id("txtPreparerEmailNewPreparer");
	By PrepConfEmail = By.id("txtConfirmEmailNewPreparer");
	By Prepcellph = By.id("nfPreparerCellPhoneNewPreparer");
	By PrepcellCarrier = By.id("ddlCellphoneCarrierNewPreparer");
	By prepcellCarrierOption = By.xpath("//option[@value='CELLULAR ONE']");
	By FirmName = By.id("txtPreparerFNameNewPreparer");
	By EIN = By.id("txtEINNewPreparer");
	By FirmAddress = By.id("txtFirmAddressNewPreparer");
	By City = By.id("txtCityNewPreparer");
	By State = By.id("ddlStateNewPreparer-npState");
	By Zip = By.id("txtZipNewPreparer");
	By Officeph = By.id("txtOfficePhoneNewPreparer");
	By EFINID = By.id("txtEFINNewPreparer");
	By AddNewPrep = By.id("btnAddNewPreperarer");
	By ErrortoNewPrep = By.id("confirm-delete-title");
	By ErrorDesc = By.id("confirm-delete-desc");
	By DonebtninError = By.id("btnHideSettingsError");//ok button in Error
	By Delete_btnexecuteaction3 =By.xpath("//button[@id='btnExecuteDelete6']");
	By ConfirminDeletePrep = By.id("btnConfirmDialog");
	By CancelbtninCreateanewprep = By.id("btnCancelNewPreparer");
	By Closebtn = By.id("btnSaveAndCloseSettingsProfile");
	
	public WebElement clkAddNewbtn()
	{
		return driver.findElement(AddNewbtn);
	}
	public WebElement getPrepID()
	{
		return driver.findElement(PrepID);
	}
	public WebElement getThirdPartyPIN()
	{
		return driver.findElement(ThirdPartyPIN);
	}
	public WebElement getPrepName()
	{
		return driver.findElement(PrepName);
	}
	public WebElement getPrepSSN()
	{
		return driver.findElement(PrepSSN);
	}
	public WebElement getPrepPTIN()
	{
		return driver.findElement(PrepPTIN);
	}
	public WebElement getPrepType()
	{
		return driver.findElement(PrepType);
	}
	public WebElement getPrepTypeOption()
	{
		return driver.findElement(PrepTypeOption);
	}
	public WebElement getPrepEmail()
	{
		return driver.findElement(PrepEmail);
	}
	public WebElement getPrepConfEmail()
	{
		return driver.findElement(PrepConfEmail);
	}
	public WebElement getPrepcellph()
	{
		return driver.findElement(Prepcellph);
	}
	public WebElement getPrepcellCarrier()
	{
		return driver.findElement(PrepcellCarrier);
	}
	public WebElement getprepcellCarrierOption()
	{
		return driver.findElement(prepcellCarrierOption);
	}
	public WebElement getFirmName()
	{
		return driver.findElement(FirmName);
	}
	public WebElement getEIN()
	{
		return driver.findElement(EIN);
	}
	public WebElement getFirmAddress()
	{
		return driver.findElement(FirmAddress);
	}
	public WebElement getCity()
	{
		return driver.findElement(City);
	}
	public WebElement getState()
	{
		return driver.findElement(State);
	}
	public WebElement getZip()
	{
		return driver.findElement(Zip);
	}
	public WebElement getOfficeph()
	{
		return driver.findElement(Officeph);
	}
	public WebElement getEFINID()
	{
		return driver.findElement(EFINID);
	}
	public WebElement clickAddNewPrep()
	{
		return driver.findElement(AddNewPrep);
	}
	public WebElement getErrortoNewPrep()
	{
		return driver.findElement(ErrortoNewPrep);
	}
	public WebElement clickDonebtninError()
	{
		return driver.findElement(DonebtninError);
	}
	public WebElement getErrorDesc()
	{
		return driver.findElement(ErrorDesc);
	}
	public WebElement clickDelete_btnexecuteaction3()
	{
		return driver.findElement(Delete_btnexecuteaction3);
	}
	public WebElement clickClosebtn()
	{
		return driver.findElement(Closebtn);
	}
	public WebElement clickCancelbtninCreateanewprep()
	{
		return driver.findElement(CancelbtninCreateanewprep);
	}
	public WebElement clickConfirminDeletePrep()
	{
		return driver.findElement(ConfirminDeletePrep);
	}
}
