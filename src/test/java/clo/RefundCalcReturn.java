/**
 * 
 */
package clo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AddaReturnpgPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;


/**
 * @author ssreenivasan
 *
 */
public class RefundCalcReturn extends AddaNewReturn{
	
	/**
	 * @param env
	 * @param year
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Parameters({"env","year"})
	//@Test
	public void complexRefundcalcReturn(String env,String year) throws InterruptedException, IOException
	{
	OverviewpgPO op = new OverviewpgPO(driver);
	//Wait.until(ExpectedConditions.elementToBeClickable(op.clickoverview()));
	Thread.sleep(500);
	//op.clickoverview().click();
	op.clickdashboardBtn().click();
	//switchYear(year);
	Thread.sleep(1000);
	openaPreparer(env,334);
	AddaReturnpgPO ap = new AddaReturnpgPO(driver);
	ap.clkCloseNewRtrnbtn().click();
	ap.clickrefundCalcSideBarbtn().click();
	//Wait.until(ExpectedConditions.elementToBeClickable(ap.clicksingleCheckbox()));
	ap.clickmarriedCheckbox().click();
	ap.clickhadChildrenCheckbox().click();
	ap.clickaboutheFamilyNextbtn19().click();
	ap.clickMFJcheckbox().sendKeys("X");
	ap.clickFilingstatusNextbtn19().click();
	ap.gettaxpayersDOB().sendKeys("05051980");
	ap.getspouseDOB().sendKeys("06061985");
	//ap.next
	Thread.sleep(500);
	//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	//ap.clicktaxPayerinfoNextbtn().click();
	ap.clicktaxPayerinfoNextbtn().click();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	ap.getchildrenUnder17().sendKeys("1");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	ap.clickchildrenandotherNextBtn_complex().click();//new
	ap.clickw2WagesCheckbox().click();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	ap.gettaxpayersWages().sendKeys("25000");
	ap.gettaxpayersFedWith().sendKeys("5000");
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	//ap.getspouseswages().sendKeys("20000");
	//ap.getspouseFedWith().sendKeys("1000");
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	ap.clickIRApension().click();
	ap.getTPdistriNotSubtoPen().sendKeys("1500");
	ap.getTPwithholding().sendKeys("500");
	ap.getspouseDistriNotSubtoPen().sendKeys("1000");
	ap.getspousewithholding().sendKeys("500");
	ap.clicksocialSecurity().click();
	ap.getsocialsecIncome().sendKeys("1500");
	ap.clickincomeNextbtn().click();
	//charity
	ap.clickcharity().click();
	ap.getgiftstoCharity().sendKeys("505");
	ap.clickmedicalCosts().click();
	ap.getmedicalExpenses().sendKeys("25000");
	ap.clickstudentLoan().click();
	ap.getstudentLoanExpenses().sendKeys("15000");
	ap.clickadjustmentsNextbtn().click();
	//daycare
	ap.clickdaycarepaid().click();
	ap.getdayCarePaid().sendKeys("4000");
	ap.getnumofChildren().sendKeys("1");
	ap.clickcreditsNextbtn().click();
	ap.clickcreateReturnbtn().click();
	generateSSN(env);
	addCDS(env,"2022","Complex","1");
	
	
	}
	
	public void addCDS(String env, String year, String firstname, String filingstatus)
			throws IOException, InterruptedException {

		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickClientdatabtn()));
		Thread.sleep(2000); // changed for FF
		Boolean bool = true;
		while (bool) {
			try {
				ap.clickClientdatabtn().click();
				bool = false;
			} catch (Exception e) {
				bool = true;
			}
		}
		// WebDriverWait Wait3 = new WebDriverWait(driver,20);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(500); // changed for FF
		// Wait3.until(ExpectedConditions.elementToBeClickable(ap.getdob()));
		 if (firstname != "refundcalc") {
				WebElement fsalert = driver.findElement(By.id("btnRequireFLST"));
				while (fsalert.isDisplayed()) {
					fsalert.click();
					break;
				}
		 }
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Entering CDS info");
		ap.getfirstname().sendKeys(firstname);
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ap.getoccup().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(6).getCell(1))));
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ap.getcellph2().clear();
		ap.getcellph().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(7).getCell(1))));
		//Thread.sleep(500);
		ap.getemailid().sendKeys("ssreenivasan@crosslinktax.com");
		ap.getfilingstatus().sendKeys(filingstatus);
		Thread.sleep(2000);
		Actions act2 = new Actions(driver);
		act2.build().perform();
		act2.sendKeys(ap.getdob(), "05051985");
		ap.getusaddress().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(9).getCell(1)));
		Thread.sleep(1000);
		AltplusC("zipcode", ap.getzip());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,250);");
		if (ap.getenrollProtection().isDisplayed()) {
			ap.getenrollProtection().sendKeys("N");
		}	
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0,250);");
		ap.getremotesignConsent().sendKeys("Y");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(2000);
		tb.clkbtnSaveTaxReturn().click();
	}

}
