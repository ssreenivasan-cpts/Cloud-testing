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
public class BankAppPO {
	
	public WebDriver driver;
	public BankAppPO(WebDriver driver) {
		this.driver=driver;
	}
	By bankAppbtninFederal = By.id("formUSBA01");
	By fedRefundType = By.id("USRF00");
	By TPDOB = By.id("PDOB00");
	By spouseDOB = By.id("SDBB00");
	By bnkSignVerification = By.id("ESIG00");
	By morethanoneRT = By.id("SRAC00");
	By TPcitizenstatus = By.id("CITT00");//only in 334
	By spouseCitizenStatus = By.id("CITS00");
	By tpIDType = By.id("IDT100");
	By tpIDNumber = By.id("IDN100");
	By tpIDdateissued = By.id("IDI100");
	By tpIDstate = By.id("IDP100");
	By tpIDexpdate= By.id("IDE100");
	By spIDType = By.id("IDT300");
	By spIDNumber = By.id("IDN300");
	By spIDdateissued = By.id("IDI100");
	By spIDstate = By.id("IDP100");
	By spIDexpdate= By.id("IDE100");
	By IDexamined = By.id("450000");
	By BankIDCode = By.id("BAID00");
	
	
	public WebElement clkbankAppbtninFederal()
	{
		return driver.findElement(bankAppbtninFederal);
	}
	public WebElement getfedRefundType()
	{
		return driver.findElement(fedRefundType);
	}
	public WebElement getTPDOB()
	{
		return driver.findElement(TPDOB);
	}
	public WebElement getspouseDOB()
	{
		return driver.findElement(spouseDOB);
	}
	public WebElement getbnkSignVerification()
	{
		return driver.findElement(bnkSignVerification);
	}
	public WebElement getmorethanoneRT()
	{
		return driver.findElement(morethanoneRT);
	}
	public WebElement getTPcitizenstatus()
	{
		return driver.findElement(TPcitizenstatus);
	}
	public WebElement getspouseCitizenStatus()
	{
		return driver.findElement(spouseCitizenStatus);
	}
	public WebElement gettpIDType()
	{
		return driver.findElement(tpIDType);
	}
	public WebElement gettpIDNumber()
	{
		return driver.findElement(tpIDNumber);
	}
	public WebElement gettpIDdateissued()
	{
		return driver.findElement(tpIDdateissued);
	}
	public WebElement gettpIDstate()
	{
		return driver.findElement(tpIDstate);
	}
	public WebElement gettpIDexpdate()
	{
		return driver.findElement(tpIDexpdate);
	}
	public WebElement getspIDType()
	{
		return driver.findElement(spIDType);
	}
	public WebElement getspIDNumber()
	{
		return driver.findElement(spIDNumber);
	}
	public WebElement getspIDdateissued()
	{
		return driver.findElement(spIDdateissued);
	}
	public WebElement getspIDstate()
	{
		return driver.findElement(spIDstate);
	}
	public WebElement getspIDexpdate()
	{
		return driver.findElement(spIDexpdate);
	}
	public WebElement getIDexamined()
	{
		return driver.findElement(IDexamined);
	}
	public WebElement getBankIDCode()
	{
		return driver.findElement(BankIDCode);
	}
}
