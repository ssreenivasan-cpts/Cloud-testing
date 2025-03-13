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
public class FRMSCH_EPO {

	public WebDriver driver;
	public FRMSCH_EPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By payments_Question = By.id("000700");
	By A_streetaddr = By.id("837200");
	By A_zip = By.id("837800");
	By A_proptype = By.id("002500");
	By A_numofdays = By.id("004300");
	By A_QBI = By.id("880000");
	By MortInterest = By.id("035000");//id changed in 2019.not using
	By Repairs = By.id("042000");
	
	public WebElement getpayments_Question()
	{
		return driver.findElement(payments_Question);
	}
	public WebElement getA_streetaddr()
	{
		return driver.findElement(A_streetaddr);
	}
	public WebElement getA_zip()
	{
		return driver.findElement(A_zip);
	}
	public WebElement getA_proptype()
	{
		return driver.findElement(A_proptype);
	}
	public WebElement getA_numofdays()
	{
		return driver.findElement(A_numofdays);
	}
	public WebElement getA_QBI()
	{
		return driver.findElement(A_QBI);
	}
	public WebElement getMortInterest()
	{
		return driver.findElement(MortInterest);
	}
	public WebElement getRepairs()
	{
		return driver.findElement(Repairs);
	}
	
	
	
}
