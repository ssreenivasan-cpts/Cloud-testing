/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 *changed ids
 */
public class FRMW2PO {
	
	public WebDriver driver;
	public FRMW2PO(WebDriver driver) {
		this.driver=driver;
	}
	
	By wages = By.id("012000");
	By dbleentryWages = By.id("dblindTextField");
	By okindblentryWages = By.xpath("//span[contains(text(),'Ok')]");
	By cancelindblentryWages =By.xpath("//span[contains(text(),'Cancel')]");
	By Fedtax = By.id("013000");
	By okindblentryFedTax = By.xpath("//span[contains(text(),'Ok')]");
	By cancelindblentryFedTax =By.xpath("//span[contains(text(),'Cancel')]");
	By ein = By.id("004000");
	By Employername = By.id("005000");
	By Empaddrs = By.id("006000");
	By Empcity = By.id("007000");
	By Empstate = By.id("007300");
	By Empzip = By.id("007500");
	
	
	public WebElement getwages()
	{
		return driver.findElement(wages);
	}
	public WebElement getdbleentryWages()
	{
		return driver.findElement(dbleentryWages);
	}
	public WebElement clkokindblentryWages()
	{
		return driver.findElement(okindblentryWages);
	}
	public WebElement clkcancelindblentryWages()
	{
		return driver.findElement(cancelindblentryWages);
	}
	public WebElement getFedtax()
	{
		return driver.findElement(Fedtax);
	}
	public WebElement getdbleentryFedTax()
	{
		return driver.findElement(dbleentryWages);
	}
	public WebElement clkokindblentryFedTax()
	{
		return driver.findElement(okindblentryFedTax);
	}
	public WebElement clkcancelindblentryFedTax()
	{
		return driver.findElement(cancelindblentryFedTax);
	}
	public WebElement getein()
	{
		return driver.findElement(ein);
	}
	public WebElement getEmployername()
	{
		return driver.findElement(Employername);
	}
	public WebElement getEmpaddrs()
	{
		return driver.findElement(Empaddrs);
	}
	public WebElement getEmpcity()
	{
		return driver.findElement(Empcity);
	}
	public WebElement getEmpstate()
	{
		return driver.findElement(Empstate);
	}
	public WebElement getEmpzip()
	{
		return driver.findElement(Empzip);
	}
	
	
}
