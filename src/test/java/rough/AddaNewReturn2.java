/**
 * 
 */
package rough;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.FRM1099_MISCPO;
import pageObjects.FRM8879PO;
import pageObjects.FRMSCH_CPO;
import pageObjects.FRMSCH_EPO;
import pageObjects.FRMW2PO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import pageObjects.addaforminaReturnPO;
import resources.Base;

@Listeners
/**
 * @author ssreenivasan OverviewpgPO op AddaReturnpgCDSPO ap TaxreturnBarPO tb
 *         addaforminaReturnPO af
 */
public class AddaNewReturn2 extends Base {

	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());

	@Parameters({"env"})
	@Test(priority = 1, groups= {"functionalTest"})
	public void addareturn(String env) throws IOException, InterruptedException {
		
		try {
			
			System.out.println("in Test " + env);
			OverviewpgPO op = new OverviewpgPO(driver);
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickoffices()));
			Thread.sleep(1000);
			if(env.equalsIgnoreCase("prod"))
			{
				op.clickprodPreparertab();
			}
			else
			{
			op.clickoffices().click();
			}
			//op.clickoffices().sendKeys(Keys.RETURN);
			logger.info("Clicked Offices");
			test.log(LogStatus.INFO, "Clicked Offices");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (env.equalsIgnoreCase("qa")) {
				op.clickviewbtnfor334().click();
			}
			else if(env.equalsIgnoreCase("dev")) {
				op.clickdevViewbtn().click();
			}
			else if(env.equalsIgnoreCase("prod"))
			{
				op.clickprodViewbtn().click();
			}
			logger.info("Opening a Office");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			op.clickpreparersbtn().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (env.equalsIgnoreCase("qa")) {
				op.clickviewprepbtn().click();
			} else if(env.equalsIgnoreCase("dev")) {
				op.clickdevViewprepbtn().click();
			}
			else if(env.equalsIgnoreCase("prod"))
			{
				op.clickprodViewprepbtn().click();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			op.clickTaxreturns().click();
			Assert.assertTrue(isElementPresent(op.clickNewTaxreturnsbtn()), "Add New Tax Return disabled");
			op.clickNewTaxreturnsbtn().click();
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			sheet = getCellData();
			// String.valueOf(sheet.getRow(0).getCell(1).getNumericCellValue());
			// *********** creates SSN*************
			int aSSNnum = 0;
			int bSSNnum = 0,cSSNnum =0;
			aSSNnum = (int) ((Math.random() * 700) + 100);
			bSSNnum = (int) ((Math.random() * 9000) + 1000);
			cSSNnum = (int) ((Math.random() * 90) + 10);
			if (aSSNnum < 011) {
				aSSNnum = (int) ((Math.random() * 700) + 100);
			}
			if (env.equalsIgnoreCase("qa") || (env.equalsIgnoreCase("dev"))) {
				ap.getssn().sendKeys(String.valueOf(aSSNnum) + String.valueOf(cSSNnum) + String.valueOf(bSSNnum));
				ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum) + String.valueOf(cSSNnum) + String.valueOf(bSSNnum));
			} else if (env.equalsIgnoreCase("prod")) {
				ap.getssn().sendKeys(String.valueOf(aSSNnum) + "11" + String.valueOf(bSSNnum));
				ap.getconfirmssn().sendKeys(String.valueOf(aSSNnum) + "11" + String.valueOf(bSSNnum));
			}
			// ************************************
			ap.clkaddbtn().click();
			test.log(LogStatus.INFO, "Entered SSN");
			logger.info("SSN taken");
			logger.info("New Taxreturn Opened");
			// ap.clickgeneralbtn().click();
			ap.clickClientdatabtn().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ap.getdob().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(3).getCell(1)));
			test.log(LogStatus.INFO, "Entering CDS info");
			ap.getfirstname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(4).getCell(1)));
			//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getfirstname(), "JENKINS"));
			Thread.sleep(500);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ap.getlastname().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1)));
			Thread.sleep(500);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ap.getoccup().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(6).getCell(1))));
			Thread.sleep(500);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ap.getcellph().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(7).getCell(1))));
			Thread.sleep(500);
			ap.getemailid().sendKeys("qa1@petzent.com");
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ap.getfilingstatus().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(8).getCell(1)));
			ap.getusaddress().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(9).getCell(1)));
			AltplusC("zipcode", ap.getzip());
			ap.getenrollProtection().sendKeys("N");
			ap.gethealthinsA().sendKeys("x");
			ap.clickaddaform().click();
			addaforminaReturnPO fm = new addaforminaReturnPO(driver);
			fm.clkfrmw2().click();
			fm.clkAddbtnAddanewform().click();
			logger.info("Added w2 form");
			test.log(LogStatus.INFO, "w2 form added");
			FRMW2PO w2 = new FRMW2PO(driver);
			w2.getwages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
			w2.getFedtax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
			w2.getein().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(15).getCell(1))));
			w2.getEmployername().clear();
			Wait.until(ExpectedConditions.textToBePresentInElement(w2.getEmployername(), ""));  // changed from thread.sleep
			AltplusC("EmpName", w2.getEmployername());
			ap.clickaddaform().click();
			fm.clkfrm8879().click();
			fm.clkAddbtnAddanewform().click();
			logger.info("8879 form added");
			test.log(LogStatus.INFO, "8879 form added");
			FRM8879PO f879 = new FRM8879PO(driver);
			f879.getRefndtype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(21).getCell(1)));
			f879.getRefndtype().sendKeys(Keys.TAB);
			Wait.until(ExpectedConditions.elementToBeClickable(f879.clickokbtninRefundType()));
			f879.clickokbtninRefundType().click();
			f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
			f879.getPTIN().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(23).getCell(1)));
			// f879.getprepname().sendKeys(new
			// DataFormatter().formatCellValue(sheet.getRow(24).getCell(1)));
			// f879.getprepaddress().sendKeys(new
			// DataFormatter().formatCellValue(sheet.getRow(25).getCell(1)));
			// f879.getprepcity().sendKeys(new
			// DataFormatter().formatCellValue(sheet.getRow(26).getCell(1)));
			// f879.getprepstate().sendKeys(new
			// DataFormatter().formatCellValue(sheet.getRow(27).getCell(1)));
			// f879.getprepzip().sendKeys(new
			// DataFormatter().formatCellValue(sheet.getRow(28).getCell(1)));
			f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
			f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			//Wait.until(ExpectedConditions.elementToBeClickable(tb.clkverifyReturnbtn()));
			Thread.sleep(1000);
			tb.clkverifyReturnbtn().click();
			try {
				if (tb.clkOKinVerifysuccessbtn().isDisplayed()) {

					System.out.println("Verify success");
					tb.clkOKinVerifysuccessbtn().click();
				}
			} catch (Exception e) {
				System.out.println("Verified with errors");
				
			}
			String path = TakeScreenshot();
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.PASS, "Took screen shot", imagePath);
			logger.info("screen shot taken");
			Thread.sleep(1000);
			tb.clkbtnSaveTaxReturn().click();
			/*tb.clkbtnArrowOptions().click();
			//driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
			Thread.sleep(1000);
			tb.clkbtnsaveinarrow().click();*/
			//driver.findElement(By.xpath("//li[@id='menuOptions9']")).click(); /// save a return btn
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Error in Addareturn testcase" + e);
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error1.png"));
			
		}

	}

	@Parameters("env")
	@BeforeTest
	public void login(String env) throws IOException, InterruptedException {
		System.out.println(env);
		driver = invokeBrowser(env);
		LogincloPO lp = new LogincloPO(driver);
		if (env.equalsIgnoreCase("qa")) {
			driver.get("https://qa.crosslinkonline.com/#");
			lp.getusername().clear();
			Thread.sleep(500);
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			lp.clickmarkaspublic().click();
		} else if (env.equalsIgnoreCase("dev")) {
			driver.get("https://dev.crosslinkonline.com/#");
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("devssbpassword"));
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			lp.clickmarkaspublic().click();
		} else if (env.equalsIgnoreCase("prod")) {
			driver.get("https://crosslinkonline.com/#");
			lp.getusername().clear();
			lp.getusername().sendKeys(prop.getProperty("produsername"));
			lp.getPassword().sendKeys(prop.getProperty("prodpassword"));
			lp.clickrememberPassword().click();
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			Thread.sleep(2000);
			lp.clickmarkaspublic().click();
			/*//lp.getdeviceLabel().sendKeys("testing Pc");// or testing Pc1
			Runtime.getRuntime().exec("C:\\Users\\ssreenivasan\\Desktop\\autoitscript\\googleauthenticator.exe");
			Thread.sleep(2000);
			lp.getverificationCode().click();
			lp.getverificationCode().sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(2000);*/
			WebElement confirmkey =driver.findElement(By.id("txtConfirmKey"));
			//By.xpath("//*[@id=\"mfaEnterCodeContainer\"]/div/div/div[2]/form/div[2]/div/input"));
			String otpKeyStr = "7XZ43POG3SJY54TD";
			Totp totp = new Totp(otpKeyStr);
			String twoFcode = totp.now();
			confirmkey.sendKeys(twoFcode);
			lp.clickthrdcontbtn().click();
			//lp.clickcontbtnIRS().click();
			//lp.clickcanceltour().click();
			logger.info("In OverView Page");
		}
		logger.info("URL open-Success");
		lp.clickthrdcontbtn().click();
	//	lp.clickcontbtnIRS().click();
		//lp.clickcanceltour().click();
		logger.info("In OverView Page");

	}

	@Parameters("env")
	@AfterClass(alwaysRun = true)
	public void teardown(String env) throws InterruptedException {
		logger.info("in tear down");
		//driver.close();
		/*report.endTest(test);
		report.flush();*/
		/* } */
	}
	

	//@Test(priority = 3, dependsOnMethods = "addareturn")
	public void scheduleC() throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE C");

			// ap-AddaReturnpgCDSPO
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch c");
			af.clkfrmschC().click();
			af.clkAddbtnAddanewform().click();
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			FRMSCH_CPO schc = new FRMSCH_CPO(driver);
			logger.info("ADDED FORM SCH-C");
			test.log(LogStatus.INFO, "ADDED FORM SCH-C");
			schc.getA().sendKeys("paintings");
			System.out.println(schc.getA().getLocation());
			AltplusC("schc_bizcode", schc.getB());
			schc.getE_Bizaddress().sendKeys("12 z st");
			AltplusC("zipcode", schc.getE_Zip());
			schc.getF_Cash().sendKeys("X");
			schc.getI_No().sendKeys("X");
			schc.getQualbizIndicator().sendKeys("Q");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,250);");
			schc.getgrossSales().sendKeys("2000");
			schc.getutilities().sendKeys("2000");
			logger.info("SCH-C SUCCESS");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();

		} catch (Exception e) {
			logger.error("Error in SCH C " + e);
			test.log(LogStatus.ERROR, "Error in SCH C");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error2.png"));
		}
		
	}

   // @Test(priority = 4, dependsOnMethods = { "addareturn", "scheduleC" })
	public void scheduleE() throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE E");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch e");
			af.clkfrmschE().click();
			af.clkAddbtnAddanewform().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			FRMSCH_EPO sche = new FRMSCH_EPO(driver);
			sche.getA_streetaddr().sendKeys("87 bolsom ct");
			logger.info("ADDED FORM SCH-E");
			test.log(LogStatus.INFO, "ADDED FORM SCH-E");
			AltplusC("zipcode", sche.getA_zip());
			AltplusC("proptype", sche.getA_proptype());
			sche.getA_numofdays().sendKeys("365");
			sche.getA_QBI().sendKeys("Q");
			sche.getMortInterest().sendKeys("15000");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			logger.info("FRM SCH-E SUCCESS");
		} catch (Exception e) {
			logger.error("Error in SCH E " + e);
			test.log(LogStatus.ERROR, "Error in SCH E");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInSCH-E.png"));
		}

	}

//	@Test(priority = 5, dependsOnMethods = { "addareturn", "scheduleC", "scheduleE" })
	public void frm1099_MISC() throws InterruptedException, IOException {
		try {
			System.out.println("1099MISC");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaddaform()));
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("1099-MIS");
			af.clkfrm1099MISC().click();
			af.clkAddbtnAddanewform().click();
			FRM1099_MISCPO obj1 = new FRM1099_MISCPO(driver);
			AltplusC("payersEIN", obj1.getpayersEIN());
			logger.info("ADDED FORM 1099-MISC");
			test.log(LogStatus.INFO, "ADDED FORM 1099-MISC");
			obj1.getrents().sendKeys("15000");
			AltplusC("linkto", obj1.getlinksTo());
			 TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			 tb.clkbtnSaveTaxReturn().click();
		//    tb.clkbtnSaveAndClose().click();
			Thread.sleep(1000);
			logger.info("1099MISC SUCCESS");
		} catch (Exception e) {
			logger.error("Error in SCH 1099-MISC " + e);
			test.log(LogStatus.ERROR, "Error in SCH 1099-MISC");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorIn1099MISC.png"));
		}

	}

	@Test(priority = 6 )//,dependsOnMethods = { "addareturn", "scheduleC", "scheduleE", "frm1099_MISC" }
	public void printTaxReturn() throws InterruptedException, IOException {
		try {
			System.out.println("PRINT FINAL TAX RETURN");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			Thread.sleep(1000);
			tb.clkprintbtn().click();
			logger.info("clicked print button");
			test.log(LogStatus.INFO, "PRINT FINAL TAX RETURN");
			Wait.until(ExpectedConditions.elementToBeClickable(tb.clkfinalTaxReturnbtn()));
			tb.clkfinalTaxReturnbtn().click();
			logger.info("clicked final tax return button");
			Wait.until(ExpectedConditions.elementToBeClickable(tb.clkprintInVerifybtn()));
			//TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			//tb.clkverifyReturnbtn().click();
			Assert.assertTrue(isElementPresent(tb.clkprintInVerifybtn()), "Print button disabled");
			tb.clkprintInVerifybtn().click();
			logger.info("clicked print button in verify");
			Wait.until(ExpectedConditions.elementToBeClickable(tb.clkremoteSignbtn()));
			tb.clkremoteSignbtn().click();
			logger.info("clicked remote signature button");
			tb.clksaveRtrnInRemotesign().click();
			driver.navigate().refresh();
			//Wait.until(ExpectedConditions.elementToBeClickable(tb.clkpaidPrepEmail_checkbx()));
			driver.navigate().refresh();
			//tb.clkpaidPrepEmail_checkbx().click();
		//	tb.clktaxPayerEmail_checkbx().click();
			//tb.clkcancelbtn_inoffcsignature().click();
			logger.info("PRINT SUCCESS");
			test.log(LogStatus.INFO, "PRINT SUCCESS");
		/*	logger.info("saved and checked Email checkbox");
			tb.clkOKbtn_inoffcsignature().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if (tb.getremotesignComplete().getText().equalsIgnoreCase("Remote Signature Request Complete")) {
				System.out.println(tb.getremotesignComplete().getText());
				logger.info("PRINT SUCCESS");
				test.log(LogStatus.INFO, "PRINT SUCCESS");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tb.clkOKbtnInRemoteSignComplete().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(1000);
*/			// !!! change this to the last form!!!!!!!!!!!!
			tb.clkbtnArrowOptions().click();
			Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveAndClose()));
			tb.clkbtnSaveAndClose().click();
			logger.info("save and closing the tax return");
			test.log(LogStatus.INFO, "save and closing the tax return");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Error in PRINT TAX RETURN " + e);
			test.log(LogStatus.ERROR, "Error in PRINT TAX RETURN");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\errorInPrintTaxRtrn.png"));
		}

	}
	//@Test(groups= {"training"})
	public void trainingModeReturn() throws IOException, InterruptedException
	{
	System.out.println("training mode ");
	AccountSettingsPO ap = new AccountSettingsPO(driver);
	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
	ap.clickaccountsdropdown().click();
	Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
	ap.clicktoggletrainingmodelink().click();
	logger.info("Switched to training mode");
	Thread.sleep(1000);
	addareturn("qa");
	TaxreturnBarPO tb = new TaxreturnBarPO(driver);
	Thread.sleep(1000);
	//tb.clkbtnSaveTaxReturn().click();
	tb.clkbtnArrowOptions().click();
	Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveAndClose()));
	tb.clkbtnSaveAndClose().click();
	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
	ap.clickaccountsdropdown().click();
	Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
	ap.clicktoggletrainingmodelink().click();
	logger.info("Training Mode off");
	OverviewpgPO op = new OverviewpgPO(driver);
	op.clickoverview().click();
	
	}
	
	public void refundCalcReturn() throws InterruptedException
	{
		//openaPreparer("qa");
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clickrefundCalcSideBarbtn().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clicksingleCheckbox()));
		ap.clicksingleCheckbox().click();
		ap.clickaboutheFamilyNextbtn19().click();
		Thread.sleep(500);
		ap.getsingleTextbox().sendKeys("X");
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.getsingleTextbox(),"X"));
		ap.clickFilingstatusNextbtn19().click();
		ap.clicktaxPayerinfoNextbtn().click();
		ap.gettaxpayersDOB().sendKeys("05051980");
		//Wait.until(ExpectedConditions.textToBePresentInElement(ap.gettaxpayersDOB(),"05051980"));
		ap.clickw2WagesCheckbox().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.gettaxpayersWages()));
		ap.gettaxpayersWages().sendKeys("20000");
		ap.gettaxpayersFedWith().sendKeys("1500");
		ap.clickincomeNextbtn().click();
		ap.clickadjustmentsNextbtn().click();
		ap.clickcreditsNextbtn().click();
		ap.clickcreateReturnbtn().click();
		//addCDS(env);
	}
	
}


