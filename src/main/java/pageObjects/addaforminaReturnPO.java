/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 * changed ids except 1
 */
public class addaforminaReturnPO {
	
	public WebDriver driver;
	public addaforminaReturnPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By searchAForm = By.id("txtFilterDefaultAddFormModal");
	
	By continuebtnAddanewform = By.id("btnSubflagContinueAddFormModal");
	By AddbtnAddanewform = By.id("btnAdd");
			//.xpath("//button/span[text()='Add']");
	//---Federal
	By frmw2 = By.xpath("//td[contains(text(),'Wage and Tax Statement')]");	//By.id("US02row0"); Wage and Tax Statement
	By frmw2_TP = By.xpath("//tr[@id='US02']");
	By frm8879 = By.xpath("//tbody/tr/th[contains(text(),'FRM 8879')]");//By.id("US99row0"); formUS9901
	By frmschE = By.id("US13");	
	By frm1099MISC = By.id("USG6"); 
	By frmschC =By.xpath("//tr[@id='US09']");//By.id("US09row0"); 
			//By.id("btnAddFormAddFormModal");
	By frmSchF = By.id("US14");
	By frmSchk11065 = By.id("USK2");
	By cancelbtnAddanewform = By.id("btnCancelAddFormModal");
	//----Depreciation
	By cartruck = By.xpath("//*[contains(text(),'Vehicle Allocation')]");
			//("//td[contains(text(),'Vehicle Allocation'[1]]");
	//By frm8867 = By.id("USEJ");
	By frm8867=By.xpath("//*[@id='formUSEJ01']");
	By frm8879infederalsidebar = By.id("formUS9901"); //added form in side bar federal
	
	public WebElement clksearchAForm()
	{
		return driver.findElement(searchAForm);
	}
	public WebElement clkfrmw2()
	{
		return driver.findElement(frmw2);
	}
	
	public WebElement clkfrmw2_TP()
	{
		return driver.findElement(frmw2_TP);
	}
	public WebElement clkfrm8879()
	{
		return driver.findElement(frm8879);
	}
	public WebElement clkcontinuebtnAddanewform()
	{
		return driver.findElement(continuebtnAddanewform);
	}
	public WebElement clkAddbtnAddanewform()
	{
		return driver.findElement(AddbtnAddanewform);
	}
	public WebElement clkcancelbtnAddanewform()
	{
		return driver.findElement(cancelbtnAddanewform);
	}
	//------------------sche
	public WebElement clkfrmschE()
	{
		return driver.findElement(frmschE);
	}
	public WebElement clkfrm1099MISC()
	{
		return driver.findElement(frm1099MISC);
	}
	public WebElement clkfrmschC()
	{
		return driver.findElement(frmschC);
	}
	public WebElement clkfrmSchF()
	{
		return driver.findElement(frmSchF);
	}
	public WebElement clkfrmSchk11065()
	{
		return driver.findElement(frmSchk11065);
	}
	public WebElement clkfrm8867()
	{
		return driver.findElement(frm8867);
	}
	//-----------Assets
	public WebElement clkcartruck()
	{
		return driver.findElement(cartruck);
	}
	public WebElement clkfrm8879infederalsidebar()
	{
		return driver.findElement(frm8879infederalsidebar);
	}
	
	
}
