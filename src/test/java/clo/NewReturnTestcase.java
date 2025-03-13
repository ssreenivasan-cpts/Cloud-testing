/**
 * 
 */
package clo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.FRMW2PO;
import pageObjects.InterviewModePO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class NewReturnTestcase extends AddaNewReturn{
	
	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());
	
	@Parameters({"env","year"})
	@Test(groups= {"training"})
	public void trainingModeReturn1(String env,String year) throws IOException, InterruptedException {
		//test= report.startTest("TRAINING MODE RETURN");
		test.log(LogStatus.INFO, "STARTING ~ TRAINING MODE RETURN");
		System.out.println("training mode ");
		//switchYear(year);
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(5000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		OverviewpgPO op= new OverviewpgPO(driver);
		op.clickoverview().click();
		Thread.sleep(2000);
		ap.clickaccountsdropdown().click();		
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
		ap.clicktoggletrainingmodelink().click();
		//logger.info("Switched to training mode");
		Thread.sleep(1000);
		openaPreparer(env,334);
		generateSSN(env);
		addCDS(env,year,"trainingmode1","1");
		addW2(env,"single");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(1000);
		// tb.clkbtnSaveTaxReturn().click();
		tb.clkbtnArrowOptions().click();
		Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveAndClose()));
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
		ap.clicktoggletrainingmodelink().click();
		//logger.info("Training Mode off");
	//	OverviewpgPO op = new OverviewpgPO(driver);
		op.clickoverview().click();
	}

	@Parameters({"env","year"})
	//@Parameters("env")
	//@Test
	public void refundCalcReturn1(String env,String year) throws IOException, InterruptedException {
		//test= report.startTest("REFUND CALC RETURN");
		test.log(LogStatus.INFO, "STARTING ~ REFUND CALCULATOR RETURN");
		OverviewpgPO op = new OverviewpgPO(driver);
		//Wait.until(ExpectedConditions.elementToBeClickable(op.clickoverview()));
		Thread.sleep(5000);
		//op.clickoverview().click();
		switchYear(year);
		Thread.sleep(1000);
		openaPreparer(env,334);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		Thread.sleep(1000);
		ap.clickrefundCalcSideBarbtn().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clicksingleCheckbox()));
		ap.clicksingleCheckbox().click();
		ap.clickaboutheFamilyNextbtn19().click();
		Thread.sleep(500);
		ap.getsingleTextbox().sendKeys("X");
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getsingleTextbox(),"X"));
		ap.clickFilingstatusNextbtn19().click();
		ap.clicktaxPayerinfoNextbtn().click();
		ap.gettaxpayersDOB().sendKeys("05051980");
		Thread.sleep(2000);
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.gettaxpayersDOB(),"05051980"));
		ap.clickw2WagesCheckbox().click();
		//Thread.sleep(1000);
		//Wait.until(ExpectedConditions.el(ap.gettaxpayersWages()));
		ap.gettaxpayersWages().sendKeys("20000");
		ap.gettaxpayersFedWith().sendKeys("1500");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Wait.until(ExpectedConditions(ap.clickincomeNextbtn()));
		Thread.sleep(500);
		ap.clickincomeNextbtn().click();
		ap.clickadjustmentsNextbtn().click();
		ap.clickcreditsNextbtn().click();
		ap.clickcreateReturnbtn().click();
		generateSSN(env);
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.stalenessOf(ap.gettaxpayersDOB()));
		addCDS(env,year,"complexrefndcalc","1");
		//---
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
		//report.endTest(test);
		//OverviewpgPO op = new OverviewpgPO(driver);
		Wait.until(ExpectedConditions.elementToBeClickable(op.clickdashboardBtn()));
		//Thread.sleep(500);
		op.clickdashboardBtn().click();
		Wait.until(ExpectedConditions.elementToBeClickable(op.clickoverview()));
		op.clickoverview().click();
		Thread.sleep(1000);
		
	}


	/*@Parameters({"env","year"})
	//@Test
	public void addaReturn(String env,String year) throws IOException, InterruptedException {
		
		//test= report.startTest("ADD A NEW RETURN");
		test.log(LogStatus.INFO, "STARTING ADD A RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		switchYear(year);
		openaPreparer(env,334);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		generateSSN(env);
		addCDS(env,year);
		addAssets();
		addW2(env);
		frm8879(env,"1");
		scheduleC(year);
		test.log(LogStatus.INFO, "sch-C success");
		scheduleE(year);
		test.log(LogStatus.INFO, "sch-E success");
		frm1099_MISC();
		test.log(LogStatus.INFO, "FRM1099MISC success");
	    verifyareturn(env);
		test.log(LogStatus.INFO, "RETURN VERIFIED");
		//printTaxReturn();
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
		//webelement closebtn = driver.findElement(arg0)
	//tb.clkcl
		Thread.sleep(500);
		OverviewpgPO op = new OverviewpgPO(driver);
		op.clickoverview().click();
		Thread.sleep(1000);
	//	report.endTest(test);
		report.flush();
	}*/
	
	@Parameters("env")
	//@Test
	public void interviewModeReturn(String env) throws InterruptedException, IOException
	{
		//test= report.startTest("INTERVIEW MODE RETURN");
		test.log(LogStatus.INFO, "STARTING ~ INTERVIEW MODE RETURN");
		switchYear("2018");
		openaPreparer(env,334);
		generateSSN(env);
		InterviewModePO im = new InterviewModePO(driver);
		Thread.sleep(2000);//........change later
		im.clickinterviewicon().click();
		Thread.sleep(2000);//
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		im.clickinterviewicon().sendKeys(Keys.TAB);
		//Wait.until(ExpectedConditions.elementToBeClickable(im.clickintvmarriedicon()));
		Thread.sleep(2000);
		im.clickintvmarriedicon().click();
		im.clickintvhadjobicon().click();
		im.clickintvhadchldicon().click();
		im.clickintviconpgNextbtn().click();
		//---------
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Wait.until(ExpectedConditions.elementToBeClickable(im.clickintvMFJbox()));
		im.clickintvMFJbox().sendKeys("x");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		//.....
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		im.clickintvFSpgNextbtn().click();
		//
		im.getintvTPfirstname().sendKeys("INTRVWMODE");
		//....Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		im.getintvTPlastname().sendKeys("RETURN");
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.getintvTPdob().sendKeys("04041978");
		im.getintvTPoccupation().sendKeys("Manager");
		im.getintvTPhomeph().sendKeys("6103055825");
		im.getintvSPfirstname().sendKeys("Spouse");
		im.getintvSPlastname().sendKeys("RETURN");
		im.getintvSPdob().sendKeys("05121982");
		im.getintvSPoccupation().sendKeys("HomeMaker");
		tb.clkbtnSaveTaxReturn().click();
		im.clickintvperinfopgNextbtn18().click();//for 2018
		//
		im.getintvusaddress().sendKeys("12 leo st");
		//....Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		im.getintvzip().click();
		AltplusC("zipcode", im.getintvzip());
		im.getlivedinUS().sendKeys("x");
		im.clickaddinfopgNextbtn().click();
		im.clickintvadditionalinfopgNextbtn().click();
		im.clickintvyesdepstoclaim().sendKeys("X");
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.clickintvyeshomeorsupport().sendKeys("X");
		im.clickintvyeshomeorsupport().sendKeys(Keys.TAB);
		tb.clkbtnSaveTaxReturn().click();
		//take screenshot
		String path = TakeScreenshot();
		System.out.println(path);
		test.log(LogStatus.PASS,test.addScreenCapture(path));
		im.clickintvdepspgNextbtn().click();
		//
		im.clickintvaddTPW2frmbtn().click();
		FRMW2PO w2=new FRMW2PO(driver);
		w2.getwages().sendKeys("25000");
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		w2.getFedtax().sendKeys("1000");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		im.clickintvW2frmNextbtn19().click();
		im.clickintvtypofincNextbtn().click();
		im.clickintvadjustmentspgNextbtn().click();
		im.clickintvcreditspgNextbtn().click();
		im.clickintvhealthemployer().click();
		im.clickintvhealthpgNextbtn().click();
		im.clickintvmiscpgNextbtn().click();
		im.clickintvstateretpgNextbtn().click();
		im.getintvRTfinprod().sendKeys("N");
		im.getintvRTfinprod().sendKeys(Keys.TAB);
		String path1= TakeScreenshot();
		System.out.println(path1);
		test.log(LogStatus.INFO, test.addScreenCapture(path1));
		//report.endTest(test);
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
	    }

}
