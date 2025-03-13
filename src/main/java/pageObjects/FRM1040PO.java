/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 * changd ids
 */
public class FRM1040PO {
	
	public WebDriver driver;
	public FRM1040PO(WebDriver driver) {
		this.driver=driver;
	}
	
	By frm1040btn = By.xpath("//p[contains(text(),'RET 1040 - FEDERAL RETURN')]");
	
			//By.id("itemIconUS0101");
			//By.xpath("//div[@id='US0101']");
	By preptype = By.id("SELF00");
	By virtualcurrency_No = By.id("041700"); //new in 2020
	//arrow symbol near 1040frm btn
	By arrownear1040btn = By.id("moreIconUS0101");
	By recoveryrebatesheettbn = By.id("sidebarUS0101pgm11");
	By nostimuluspaymntcheckbx1 = By.id("m15000");
	By nostimuluspaymntcheckbx2 = By.id("m20000");
	By box30infrom1040 = By.id("154000"); 
	By threedotsnearbox30 = By.xpath("//span/img[@src='/images/icons/menu-vertical-filled.png']");
	By worksheetbtnin3dots = By.xpath("//li[contains(text(),'Worksheet')]");
	By receiveareward_No = By.id("041700");
	
	public WebElement clkFrm1040btn()
	{
		return driver.findElement(frm1040btn);
	}
	public WebElement getPreptype()
	{
		return driver.findElement(preptype);
	}
	public WebElement getvirtualcurrency_No()
	{
		return driver.findElement(virtualcurrency_No);
	}
	public WebElement clkarrownear1040btn()
	{
		return driver.findElement(arrownear1040btn);
	}
	public WebElement clkrecoveryrebatesheettbn()
	{
		return driver.findElement(recoveryrebatesheettbn);
	}
	public WebElement clknostimuluspaymntcheckbx1()
	{
		return driver.findElement(nostimuluspaymntcheckbx1);
	}
	public WebElement clknostimuluspaymntcheckbx2()
	{
		return driver.findElement(nostimuluspaymntcheckbx2);
	}
	public WebElement clkbox30infrom1040()
	{
		return driver.findElement(box30infrom1040);
	}
	public WebElement clkthreedotsnearbox30()
	{
		return driver.findElement(threedotsnearbox30);
	}
	public WebElement clkworksheetbtnin3dots()
	{
		return driver.findElement(worksheetbtnin3dots);
	}

	public WebElement clkreceiveareward_No()
	{
		return driver.findElement(receiveareward_No);
	}
}
