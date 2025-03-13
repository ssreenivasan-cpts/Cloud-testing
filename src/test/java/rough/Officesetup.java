/**
 * 
 */
package rough;

import org.testng.annotations.Test;

import pageObjects.CompletesetupPO;
import pageObjects.OverviewpgPO;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class Officesetup extends Base {

	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
	
	/*Officesetup(WebDriver driver)
	{
		this.driver=driver;
		
	}*/
	
	@Test
	public void completeSetup() throws IOException, InterruptedException
	{
		System.out.println("officesetup");
		LoginClo lc=new LoginClo();
		driver = lc.openHomePage();
		OverviewpgPO op = new OverviewpgPO(driver);
		op.clickProfiletitlebar().click();
		op.clickSetupofficebtn().click();
		CompletesetupPO cs = new CompletesetupPO(driver);
		cs.clkOfficebtn().click();
		Thread.sleep(1000);
		cs.getfirmName().clear();
		cs.getfirmName().sendKeys("333 Republic office");
		cs.getfirmAddress().clear();
		Thread.sleep(1000);
		cs.getfirmAddress().sendKeys("333 EFIN1 dr");
		cs.getfirmCity().clear();
		Thread.sleep(1000);
		cs.getfirmCity().sendKeys("manteca");
		cs.getfirmZip().clear();
		Thread.sleep(1000);
		cs.getfirmZip().sendKeys("95350");
		cs.getfirmph().clear();
		cs.getfirmph().sendKeys("209) 835-2720");
		cs.clkrtrnoverridecheckbox().click();
		cs.clkrtrnoverridecheckbox().click();
		cs.clkSavenNextOffice().click();
		logger.info("Office information saved");
		cs.clkERObtn().click();
		//cs.getEROName().clear();
		//cs.getEROName().sendKeys("333 Republic office");
		cs.getEROaddress().clear();
		cs.getEROaddress().sendKeys("333 EFIN dr");
		cs.getEROcity().clear();
		cs.getEROcity().sendKeys("Manteca");//modesto
		cs.getEROzip().clear();
		cs.getEROzip().sendKeys("95350");
		cs.getEROph().clear();
		cs.getEROph().sendKeys("(209) 835-0000");//(209) 835-2720
		cs.clkEROSavenNext().click();
		logger.info("ERO information saved");
		//add a form in billing
		cs.clkBillingRowBtn().click();
		cs.clkBillingAddFormbtn().click();
		Thread.sleep(1000);
		cs.getW2Peritem().sendKeys("150");
		cs.clkAddBtninAddBillingFrm().click();
		//add a worksheet in billing
		cs.clkAddworksheetinBilling().click();
		Thread.sleep(1000);
		cs.getPerIteminworksheet().sendKeys("75");
		cs.clkAddWorksheetBtn().click();
		cs.clkAddLinesheetBtn().click();
		Thread.sleep(1000);
		cs.getPerIteminLinesheet().sendKeys("20");
		cs.clkAddLinesheetBtn().click();
		cs.clkbillingSavebtn().click();
		//Efiling	
		cs.clkEfilingbtn().click();
		cs.clkCheckBox1().click();
		cs.clkCheckBox2().click();
		cs.clkCheckBox3().click();
		cs.clkCheckBox4().click();	
		cs.clkSaveEfilingbtn().click();
		logger.info("Efiling Changes saved");
		cs.clkPrintingbtn().click();
		cs.clkPcheckBox1().click();
		cs.clkPcheckBox2().click();
		cs.clkPcheckBox3().click();
		cs.clkPcheckBox4().click();
		cs.clkPcheckBox5().click();
		cs.clkPcheckBox6().click();
		cs.clkPcheckBox7().click();
		cs.clkPcheckBox8().click();
		cs.clkPcheckBox9().click();
		cs.clkPcheckBox10().click();
		cs.clkprintingSavebtn().click();
		logger.info("Printing Changes saved");
		cs.clkOfficebtn().click();
		System.out.println(cs.getfirmName().getAttribute("Value"));
		
		
		
	}
}
