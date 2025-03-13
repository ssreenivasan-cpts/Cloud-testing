/**
 * 
 */
package clo;

import org.testng.annotations.Test;

import com.google.errorprone.annotations.Var;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.BankAppPO;
import pageObjects.BillingSetupPO;
import pageObjects.FRM1040PO;
import pageObjects.FRM1099_MISCPO;
import pageObjects.FRM8867PO;
import pageObjects.FRM8879PO;
import pageObjects.FRMSCHK1_1065PO;
import pageObjects.FRMSCH_CPO;
import pageObjects.FRMSCH_EPO;
import pageObjects.FRMSCH_FPO;
import pageObjects.FRMW2PO;
import pageObjects.InterviewModePO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import pageObjects.addaforminaReturnPO;
import resources.Base;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.bson.Document;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//@Listeners(Listener.class)
/**
 * @author ssreenivasan
 */
public class AddaNewReturn extends Base {

	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());
	// public Actions action = new Actions(driver);

	public void generateSSN(String env) throws IOException, InterruptedException {
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		sheet = getCellData();
		
		// *********** creates SSN************
		int aSSNnum = 0;
		int bSSNnum = 0, cSSNnum = 0;
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

	}
	 
	public void changeto23(String env,String year) throws InterruptedException, IOException
	{
		
		
		  Reporter.log("opened a preparer"); Reporter.log("<br>");
		  test.log(LogStatus.INFO, "opened a preparer"); AddaReturnpgPO ap = new
		  AddaReturnpgPO(driver); ap.clkCloseNewRtrnbtn().click(); 
		  switchYear(year);
		  OverviewpgPO op = new OverviewpgPO(driver);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Thread.sleep(1000); op.clickdashboardBtn().click(); openaPreparer(env, 334);
		 
	}

	public void addDOB() throws InterruptedException {

		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.getdob().click();
		//Thread.sleep(1000);
		ap.getdob().sendKeys("05051987");
		Thread.sleep(500);
		ap.getremotesignConsent_tp().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//ap.getremotesignConsent_tp().sendKeys("Y");
		ap.clickinfoandstatusbtn().click();
		ap.clicksigned8879().sendKeys("X"); /// TY2021
		

	}

	public void addCDS(String env, String year, String firstname, String filingstatus)
			throws IOException, InterruptedException {

		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickClientdatabtn()));
		Thread.sleep(2000); // changed for FF
		// WebDriverWait Wait2 = new WebDriverWait(driver,20);
		// Wait2.until(ExpectedConditions.elementToBeClickable(ap.clickClientdatabtn()));
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
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		Thread.sleep(500); // changed for FF
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
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.getlastname().click();
		Thread.sleep(500);
		ap.getlastname().sendKeys("Return");//new DataFormatter().formatCellValue(sheet.getRow(5).getCell(1))
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		ap.getoccup().click();
		Thread.sleep(500);
		ap.getoccup().sendKeys("Manager");//String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(6).getCell(1)))
		Thread.sleep(500);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		// ap.getcellph2().clear();
		ap.getcellph().sendKeys("6103088236"); //String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(7).getCell(1)))
		Thread.sleep(500);
		ap.getcellph2().sendKeys("6103088236");
		ap.gettextmsg().sendKeys("X");
		ap.gettextmsg().sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.clkagreeForTextmsg().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

		Thread.sleep(500);
		AltplusC("cellphcarrier", ap.getcellphcarrier());
		Thread.sleep(500);
		ap.getemailid().sendKeys("ssreenivasan@crosslinktax.com");
		ap.getfilingstatus().sendKeys(filingstatus);
		Thread.sleep(1000);
		Actions act2 = new Actions(driver);
		act2.build().perform();
		act2.sendKeys(ap.getdob(), "05051998");
		if (filingstatus.equals("2")) {
			// Thread.sleep(500);
			ap.getspousessn().click();
			ap.getspousessn().clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ap.getspousessn().sendKeys("4561239876");
			ap.getspousedob().sendKeys("05051989");
			ap.getspousefirstname().sendKeys("spousename");
			ap.getspouselastname().sendKeys("return");
			// AltplusC("spouseoccup",ap.getspouseoccup());
			ap.getspouseoccup().sendKeys("return");
			// ap.getspouseoccup().sendKeys("homemaker");
			ap.getspousehomeph().clear();
			ap.getspousehomeph().sendKeys("2092258965");
			ap.getspouseemail().sendKeys("saran2@mailinator.com");

		}
		// (new DataFormatter().formatCellValue(sheet.getRow(8).getCell(1)));
		ap.getusaddress().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(9).getCell(1)));
		Thread.sleep(1000);
		AltplusC("zipcode", ap.getzip());
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,250);");
		int year_int = Integer.parseInt(year); // convert year string to Int
		if (ap.getenrollProtection().isDisplayed()) {
			ap.getenrollProtection().sendKeys("N");
		}
		/*
		 * if(year_int != 2019) { ap.gethealthinsA().sendKeys("x"); // not in 2019 /not
		 * in 2020 also }
		 */
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("scroll(0,250);");
		if (filingstatus.equalsIgnoreCase("2")) {
			Thread.sleep(1000);
			//ap.getenrollProtection().sendKeys("TAB");
			//ap.getenrollProtection().sendKeys("TAB");
			//ap.getenrollProtection().click();
			ap.getkid1firstname().click();
			ap.getkid1firstname().sendKeys("joe");
			ap.getkid1lastname().sendKeys("return");
			ap.getkid1DOB().sendKeys("04042015");
			ap.getkid1ssn().sendKeys("6262626261");
			// AltplusC("child",ap.getkid1relationship());
			ap.getkid1relationship().sendKeys("SON");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ap.getkid1noofmonths().sendKeys("12");
			ap.getkid1dependentcode().sendKeys("N");
		//	TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//ap.getremotesignConsent_tp().sendKeys("y");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			ap.getremotesignConsen_sp().sendKeys("y");
			
		}
		else {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		  int attempts = 0; while(attempts<2) { try {
		  ap.getremotesignConsent_tp().sendKeys("Y"); //boolean result= true; break;
		  
		  } catch(Exception e) { //ap.getremotesignConsent().sendKeys("Y");
		  
		  } attempts++; }
		}
		 
		/*
		 * if(filingstatus.equalsIgnoreCase("1"))
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * ap.getremotesignConsent().sendKeys("Y");
		 */
		/*
		 * ap.clickinfoandstatusbtn().click(); ap.clicksigned8879().sendKeys("X");
		 */ // in addDOB()
		
		Thread.sleep(1000);
		/*
		 * Actions act3 = new Actions(driver); act3.build().perform();
		 * act3.sendKeys(ap.getdob(),"05051985");
		 */
		//tb.clkbtnSaveTaxReturn().click();
	}

	public void addW2(String env, String status) throws IOException, InterruptedException {

		Reporter.log("addW2");
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(500);
		ap.clickaddaform().click();
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		Thread.sleep(500);
		Actions action = new Actions(driver);
		if(status.equals("1"))
		{
			fm.clkfrmw2().click();
			
			action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		}
		
		else if (status.equalsIgnoreCase("2")) {
			fm.clkfrmw2_TP().click();
			action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		}
		// fm.clkAddbtnAddanewform().click();
		// Actions action = new Actions(driver);
		logger.info("FRM W2 ADDED");
		test.log(LogStatus.INFO, "w2 form added");
		FRMW2PO w2 = new FRMW2PO(driver);
		w2.getwages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
		w2.getwages().sendKeys(Keys.TAB);
	    //w2.getdbleentryWages().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(13).getCell(1)));
	   // w2.clkokindblentryWages().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		w2.getFedtax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		w2.getFedtax().sendKeys(Keys.TAB);
	  //  w2.getdbleentryFedTax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		//w2.clkokindblentryFedTax().click();
		Thread.sleep(1000);
		w2.getein().sendKeys(String.valueOf(new DataFormatter().formatCellValue(sheet.getRow(15).getCell(1))));
		w2.getEmployername().clear();
		// Wait.until(ExpectedConditions.textToBePresentInElement(w2.getEmployername(),
		// "")); // changed from thread.sleep
		Thread.sleep(1000);
		//AltplusC("EmpName", w2.getEmployername());
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
	}

	public void frm8879(String env, String refundtype) throws IOException, InterruptedException {
		Reporter.log("frm8879");
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		ap.clickaddaform().click();
		Thread.sleep(1000);
		fm.clksearchAForm().sendKeys("8879");// added recently
		fm.clkfrm8879().click();
		Actions action = new Actions(driver);
		action.doubleClick(fm.clkAddbtnAddanewform()).perform();
		// fm.clkAddbtnAddanewform().click();
		logger.info("8879 form added");
		test.log(LogStatus.INFO, "8879 form added");
		FRM8879PO f879 = new FRM8879PO(driver);
		String mwh = driver.getWindowHandle();// mwh - main window handle
		f879.getRefndtype().sendKeys(refundtype);
		// sendKeys(new DataFormatter().formatCellValue(sheet.getRow(21).getCell(1)));
		f879.getRefndtype().sendKeys(Keys.TAB);
		// Wait.until(ExpectedConditions.elementToBeClickable(f879.clickokbtninRefundType()));//
		// changed from thread.sleep
		Thread.sleep(500);
		Boolean factor = null;
		int refundtype_int = Integer.parseInt(refundtype);
		System.out.println(refundtype_int);
		if (refundtype_int == 1)
			factor = true;
		else if (refundtype_int == 5)
			factor = false;
		while (factor) {
			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("window.scrollBy(0,350");
			 */
			// f879.clickokbtninRefundType().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			Thread.sleep(1000);
			f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
			f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
			f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			break;
		}
		while (!factor) {
			Set s = driver.getWindowHandles(); // how many windows open
			System.out.println("s: " + s);
			String parent = driver.getWindowHandle();
			System.out.println(parent);
			Iterator ite = s.iterator();
			// WebElement alert=driver.findElement(By.id("alert-dialog-title"));
			// alert.click();

			/*
			 * while(ite.hasNext()) { String child_window=(String) ite.next();
			 * if(!parent.equals(child_window)) { driver.switchTo().window(child_window);
			 * System.out.println(driver.switchTo().window(child_window).getTitle());
			 * JavascriptExecutor js = (JavascriptExecutor)driver;
			 * js.executeScript("window.scrollBy(0,350"); } break; }
			 */

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
			System.out.println("inside while(!factor");
			// f879.clickokbtninRefundType().click();
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			Thread.sleep(1000);
			f879.gettaxpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(30).getCell(1)));
			f879.getEROpin().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(22).getCell(1)));
			f879.getpreptype().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(29).getCell(1)));
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			break;
			/*
			 * if disclosure JavascriptExecutor jse = (JavascriptExecutor) driver;
			 * jse.executeScript("scroll(0,250);");
			 * f879.clickokbtninDisclosureReminder().click();
			 */

		}
	    f879.clickdirectDeposit_Nobtn().sendKeys("X");
	    TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
	    
	}

	public void verifyareturn(String env) throws IOException, InterruptedException {
		try {
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "in Verify a return");
			Reporter.log("verifyareturn-5");
			tb.clkbtnSaveTaxReturn().click();
			tb.clkverifyReturnbtn().click();
			Thread.sleep(1000);
			try {
				if (tb.clkOKinVerifysuccessbtn().isDisplayed()) {
					System.out.println("Verify success");
					/*
					 * String path = TakeScreenshot(); String imagePath =
					 * test.addScreenCapture(path); test.log(LogStatus.PASS, "Took screen shot",
					 * imagePath);
					 */
					File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(screenshotFile, new File("./reports/verifyerror.png"));
					String path = "verifyerror.png";
					// String imagePath = test.addScreenCapture(path);
					logger.info("screen shot taken");
					test.log(LogStatus.PASS, "Took screen shot", test.addScreenCapture(path));

				}
			} catch (Exception e) {
				System.out.println("Verified with errors");
			}
			if (tb.clkOKinVerifysuccessbtn().isDisplayed()) {
				tb.clkOKinVerifysuccessbtn().click();

				tb.clkbtnArrowOptions().click();
				tb.clkbtnSaveTaxReturn().click();
			} else
				tb.clkcloseinverify().click();
			tb.clkbtnArrowOptions().click();
			tb.clkbtnSaveTaxReturn().click(); // change after stale elm exception
			// Thread.sleep(1000);
			/*
			 * Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveTaxReturn()))
			 * ; tb.clkbtnSaveTaxReturn().click();
			 * 
			 * tb.clkbtnArrowOptions().click();
			 * //driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
			 * Thread.sleep(1000); tb.clkbtnsaveinarrow().click();
			 */
			// driver.findElement(By.xpath("//li[@id='menuOptions9']")).click(); /// save a
			// return btn
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		} catch (Exception e) {
			logger.error("Error in Addareturn testcase" + e);
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors screenshots\\error10.png"));
		}

	}

	public void addAssets() throws InterruptedException {
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clicktabDepreciation().click();
		Thread.sleep(2000);
		ap.clickbtnAddAsset().click();
		addaforminaReturnPO af = new addaforminaReturnPO(driver);
		/*
		 * Actions action = new Actions(driver);
		 * action.doubleClick(af.clkcartruck()).perform();
		 */
		af.clkcartruck().click();
		af.clkAddbtnAddanewform().click();

		ap.clickaddAssetDesc().clear();
		ap.clickaddAssetDesc().sendKeys("PORCHE");
		Thread.sleep(500);
		ap.clickaddAssetDate().clear();
		ap.clickaddAssetDate().sendKeys("01012019");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ap.clickgasPoweredAuto().click();
		ap.clickaddbtninAddAsset().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.getoriginalCost()));
		ap.getoriginalCost().sendKeys("25000");
		ap.getvehiclePersUse_Y().sendKeys("X");
		ap.getvehiclemorethan5_Y().sendKeys("X");
		ap.getisAnotherVehicle_Y().sendKeys("X");
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclemorethan5_Y(),
		// "X"));
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclePersUse_Y(),
		// "X"));
		ap.getownthisVehicle_y().sendKeys("X");
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getownthisVehicle_y(),
		// "X"));
		ap.getforceActExpense_N().sendKeys("X");
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getvehiclePersUse_Y(),
		// "X"));
		ap.getforceStndMileage_N().sendKeys("X");
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Thread.sleep(1000);
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getforceStndMileage_N(),
		// "X"));
		// ap.getACRSinprevYear_N().sendKeys("X");
		Thread.sleep(500);
		ap.clickbtnClose().click();
		test.log(LogStatus.INFO, "Asset Added");
		ap.clickcarTruckVehAlloc().click();
	}

	@Parameters({ "env", "year" })
	// @BeforeTest
	@BeforeMethod
	public void login(String env, String year) throws IOException, InterruptedException {
		driver = invokeBrowser(env);
		LogincloPO lp = new LogincloPO(driver);
		// test = report.startTest("add a return");
		if (env.equalsIgnoreCase("qa")) {
			driver.get(prop.getProperty("url"));
			// ("https://qa.crosslinkonline.com/#");
			String mwh = driver.getWindowHandle();
			lp.getusername().clear();
			Thread.sleep(500);
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			lp.clickLogin().click();
			// changepasspopup
			Thread.sleep(1000);
			Set s = driver.getWindowHandles();
			Iterator ite = s.iterator();
			System.out.println(s);
			System.out.println(mwh);
			while (ite.hasNext()) {
				String popupHandle = ite.next().toString();
				System.out.println(popupHandle);
				if (!popupHandle.contains(mwh)) {
					driver.switchTo().window(popupHandle);
					lp.clickpwdexpireCancelbtn().click();
					logger.info("Username and Password success");
					Reporter.log("reporter working");
					Thread.sleep(1000);
					driver.switchTo().window(mwh);
				}

				Thread.sleep(1000);
				lp.clicksecLogin().click();
				// lp.clickmarkaspublic().click();
				lp.clickconfirmationkey().sendKeys("abcde");
			}
		}

		/*
		 * else if (env.equalsIgnoreCase("dev")) {
		 * driver.get("https://dev.crosslinkonline.com/#");
		 * lp.getusername().sendKeys(prop.getProperty("username"));
		 * lp.getPassword().sendKeys(prop.getProperty("devssbpassword"));
		 * lp.clickLogin().click(); logger.info("Username and Password success");
		 * //...Wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
		 * Thread.sleep(1000); lp.clicksecLogin().click();
		 * lp.clickmarkaspublic().click(); }
		 */ else if (env.equalsIgnoreCase("prod")) {
			driver.get("https://crosslinkonline.com/");
			lp.getusername().clear();
			lp.getusername().sendKeys("1700011");
			lp.getPassword().sendKeys("P@ssword6");
			// (prop.getProperty("prodpassword"));
			lp.clickrememberPassword().click();
			lp.clickLogin().click();
			logger.info("Username and Password success");
			// Wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
			Thread.sleep(1000);
			lp.clicksecLogin().click();
			Thread.sleep(500);
			// lp.clickmarkaspublic().click();
			// lp.getdeviceLabel().sendKeys("testing Pc");// or testing Pc1
			WebElement confirmkey = driver.findElement(By.id("txtConfirmKey"));
			// By.xpath("//*[@id=\"mfaEnterCodeContainer\"]/div/div/div[2]/form/div[2]/div/input"));

			String otpKeyStr = prop.getProperty("1700011_secretkey");
			// "7XZ43POG3SJY54TD";
			Totp totp = new Totp(otpKeyStr);
			String twoFcode = totp.now();
			confirmkey.sendKeys(twoFcode);
			// lp.clickthrdcontbtn().click();
			// lp.clickcontbtnIRS().click();
			// lp.clickcanceltour().click();
			logger.info("In OverView Page");
		} else if (env.equalsIgnoreCase("prod1")) {
			driver.get("https://crosslinkonline.com/");
			lp.getusername().clear();
			lp.getusername().sendKeys("NAHMIC");
			lp.getPassword().sendKeys("P@ssword8");
			lp.clickrememberPassword().click();
			lp.clickLogin().click();
			logger.info("Username and Password success");
			Thread.sleep(1000);
			lp.clicksecLogin().click();
			Thread.sleep(500);
			// lp.clickmarkaspublic().click();
			WebElement confirmkey = driver.findElement(By.id("txtConfirmKey"));
			String otpKeyStr = prop.getProperty("NAHMIC_secretkey");
			Totp totp = new Totp(otpKeyStr);
			String twoFcode = totp.now();
			confirmkey.sendKeys(twoFcode);
			// lp.clickthrdcontbtn().click();
			// lp.clickcontbtnIRS().click();
			// lp.clickcanceltour().click();
			logger.info("In OverView Page");

		}
		logger.info("URL open-Success");
		lp.clickthrdcontbtn().click();
		// lp.clickcontbtnIRS().click();
		// lp.clickcanceltour().click();
		// logger.info("In OverView Page");

	}

	public void switchYear(String year) throws IOException, InterruptedException {

		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				// WebDriverWait(driver, 20);
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		//ap.clickswitchselectyeardropdown().click();
		//Select se = new Select(driver.findElement(By.xpath("//Select[@name = 'season']")));
				//By.xpath("//option[@value = '2024'))")));
		//se.selectByVisibleText("2021 Tax year");
		//ap.clickswitchoptionyear2020().click();
		// Thread.sleep(2000);
		
			
			 // ap.clickswtichoptionyear2023().click(); 
				/*
				 * switch (Integer.valueOf(year)) {
				 * 
				 * case 2017: ap.clickswitchoptionyear2017().click();
				 * logger.info("switched to the year 2017"); test.log(LogStatus.INFO,
				 * "switched to the year 2017"); break; case 2018:
				 * ap.clickswitchoptionyear2018().click();
				 * logger.info("switched to the year 2018"); test.log(LogStatus.INFO,
				 * "switched to the year 2018"); break; case 2019:
				 * ap.clickswitchoptionyear2019().click();
				 * logger.info("switched to the year 2019"); test.log(LogStatus.INFO,
				 * "switched to the year 2019"); break; case 2020:
				 * ap.clickswitchoptionyear2020().click();
				 * logger.info("switched to the year 2020"); test.log(LogStatus.INFO,
				 * "switched to the year 2020"); break; case 2021:
				 * ap.clickswitchoptionyear2021().click();
				 * logger.info("switched to the year 2020"); test.log(LogStatus.INFO,
				 * "switched to the year 2021"); break; case 2022:
				 * ap.clickswitchoptionyear2022().click();
				 * logger.info("switched to the year 2020"); test.log(LogStatus.INFO,
				 * "switched to the year 2022"); break; case 2023:
				 * ap.clickswtichoptionyear2023().click();
				 * logger.info("switched to the year 2020"); test.log(LogStatus.INFO,
				 * "switched to the year 2023"); break; }
				 * 
				 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.clickswitchbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Parameters("env")
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(String env) throws InterruptedException {
		logger.info("in tear down");
		if (driver != null) {
			//driver.close();
			driver.quit();
		}
	}

	/*
	 * @Parameters("env")
	 * 
	 * @AfterMethod(alwaysRun = true) public void teardown(String env) throws
	 * InterruptedException { logger.info("in tear down"); if(driver != null ) {
	 * //driver.close(); // driver.quit(); }
	 * 
	 * // report.endTest(test); report.flush();
	 * 
	 * } }
	 */

	// @Test(priority = 3, dependsOnMethods = "addareturn")
	public void scheduleC(String year) throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE C");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().click();
			// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			af.clksearchAForm().sendKeys("sch c");
			Actions action = new Actions(driver);
			action.doubleClick(af.clkfrmschC()).perform();
			// af.clkfrmschC().click();
			// af.clkAddbtnAddanewform().click();
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			// TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			FRMSCH_CPO schc = new FRMSCH_CPO(driver);
			logger.info("ADDED FORM SCH-C");
			test.log(LogStatus.INFO, "ADDED FORM SCH-C");
			schc.getA().clear();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			schc.getA().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(500);
			schc.getA().sendKeys("cafe");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//System.out.println(schc.getA().getLocation());
			AltplusC("schc_bizcode", schc.getB());
			schc.getE_Bizaddress().sendKeys("12 z st");
			AltplusC("zipcode", schc.getE_Zip());
			schc.getF_Cash().sendKeys("X");
			schc.getI_No().sendKeys("X");
			if (year != "2017") {
				schc.getQualbizIndicator().sendKeys("Q");
			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
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
	public void scheduleE(String year) throws InterruptedException, IOException {
		try {
			System.out.println("SCHEDULE E");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			Thread.sleep(1000);
			ap.clickaddaform().click();
			addaforminaReturnPO af = new addaforminaReturnPO(driver);
			af.clksearchAForm().sendKeys("sch e");
			af.clkfrmschE().click();
			af.clkAddbtnAddanewform().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			FRMSCH_EPO sche = new FRMSCH_EPO(driver);
			sche.getpayments_Question().sendKeys("X");
			sche.getA_streetaddr().sendKeys("87 bolsom ct");
			logger.info("ADDED FORM SCH-E");
			test.log(LogStatus.INFO, "ADDED FORM SCH-E");
			AltplusC("zipcode", sche.getA_zip());
			// sche.getA_zip().sendKeys("95330");
			AltplusC("proptype", sche.getA_proptype());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			sche.getA_numofdays().click();
			sche.getA_numofdays().sendKeys("365");
			if (year != "2017") {
				sche.getA_QBI().sendKeys("N");
			}
			// sche.getMortInterest().sendKeys("15000");
			sche.getRepairs().sendKeys("15000");
			TaxreturnBarPO tb = new TaxreturnBarPO(driver);
			tb.clkbtnSaveTaxReturn().click();
			logger.info("FRM SCH-E SUCCESS");
		}

		catch (Exception e) {
			System.out.println("ERror " + e);

			/*
			 * logger.error("Error in SCH E " + e); test.log(LogStatus.ERROR,
			 * "Error in SCH E"); File screenshotFile = ((TakesScreenshot)
			 * driver).getScreenshotAs(OutputType.FILE);
			 */
			// FileUtils.copyFile(screenshotFile, new File("C:\\CLO-Errors
			// screenshots\\errorInSCH-E.png"));
		}

	}

	// @Test(priority = 5, dependsOnMethods = { "addareturn", "scheduleC",
	// "scheduleE" })
	public void frm1099_MISC() throws InterruptedException, IOException {
		try {
			System.out.println("1099MISC");
			AddaReturnpgPO ap = new AddaReturnpgPO(driver);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			// Thread.sleep(1000);
			// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaddaform()));//
			// changed from thread.sleep
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
			// tb.clkbtnSaveAndClose().click();
			Thread.sleep(1000);
			logger.info("1099MISC SUCCESS");
		} catch (Exception e) {
			// logger.error("Error in SCH 1099-MISC " + e);
			/*
			 * test.log(LogStatus.ERROR, "Error in SCH 1099-MISC"); File screenshotFile =
			 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 * FileUtils.copyFile(screenshotFile, new
			 * File("C:\\CLO-Errors screenshots\\errorIn1099MISC.png"));
			 */
		}

	}

	// @Test(priority = 6 )//,dependsOnMethods = { "addareturn", "scheduleC",
	// "scheduleE", "frm1099_MISC" }
	public void printTaxReturn() throws InterruptedException, IOException {
		System.out.println("PRINT FINAL TAX RETURN");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		tb.clkprintbtn().click();
		logger.info("clicked print button");
		test.log(LogStatus.INFO, "PRINT FINAL TAX RETURN");
		// Wait.until(ExpectedConditions.elementToBeClickable(tb.clkfinalTaxReturnbtn()));
		// // changed from thread.sleep
		Thread.sleep(500);
		tb.clkfinalTaxReturnbtn().click();
		// logger.info("clicked final tax return button");
		// Wait.until(ExpectedConditions.elementToBeClickable(tb.clkprintInVerifybtn()));
		// // changed from thread.sleep
		Assert.assertTrue(isElementPresent(tb.clkprintInVerifybtn()), "Print button disabled"); // changed from
																								// thread.sleep
		tb.clkprintInVerifybtn().click();
		Thread.sleep(1000);
		tb.clkprintBankDocsbtn().click();
		Thread.sleep(1000);
		String mwh = driver.getWindowHandle();
		Set s = driver.getWindowHandles();
		System.out.println(s);
		System.out.println(s);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		tb.clkclosebtninPDFdoc().click();
		// Iterator ite=s.iterator();
		// while(ite.hasNext())
		/*
		 * for(String handle: driver.getWindowHandles()) { String popupHandle =
		 * ite.next().toString(); //if(!popupHandle.contains(mwh)) //{
		 * //driver.switchTo().window(popupHandle); driver.switchTo().window(handle);
		 * TakeScreenshot(); //driver.switchTo().window(mwh); //} }
		 */
		// driver.switchTo()
		/*
		 * for(String handle: driver.getWindowHandles()) { Thread.sleep(1000);
		 * driver.switchTo().window(handle); }
		 */
		// TakeScreenshot();
		Screenshot sc = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(sc.getImage(), "PNG", new File(System.getProperty("user.dir") + "\\reports\\" + "new.png"));
		tb.clkbtnSaveTaxReturn().click();
		// logger.info("save and closing the tax return");
		test.log(LogStatus.INFO, "save and closing the tax return");

		/*
		 * } catch (Exception e) { logger.error("Error in PRINT TAX RETURN " + e);
		 * test.log(LogStatus.ERROR, "Error in PRINT TAX RETURN"); File screenshotFile =
		 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(screenshotFile, new
		 * File("C:\\CLO-Errors screenshots\\errorInPrintTaxRtrn.png")); }
		 */

	}

	public void addSchF(String env) throws InterruptedException, IOException {

		System.out.println("SCHF");
		FRMSCH_FPO schf = new FRMSCH_FPO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clickaddaform().click();
		addaforminaReturnPO af = new addaforminaReturnPO(driver);
		af.clksearchAForm().sendKeys("sch f");
		af.clkfrmSchF().click();
		af.clkAddbtnAddanewform().click();
		schf.getactivity_A().clear();
		schf.getactivity_A().sendKeys("farming");
		AltplusC("activitycode", schf.getactivitycode_B());
		schf.getcash_C().sendKeys("X");
		schf.getE_yes().sendKeys("X");
		schf.getF_No().sendKeys("X");
		schf.getQBIindicator().sendKeys("N");
		schf.getpart1_1a().sendKeys("2000");
		schf.getpart1_1b().sendKeys("1000");
		schf.getpart11_28().sendKeys("1000");

	}

	public void frm1040() throws InterruptedException {
		FRM1040PO obj1 = new FRM1040PO(driver);
		Thread.sleep(1000);
		// Wait.until(ExpectedConditions.elementToBeClickable(obj1.clkFrm1040btn()));
		Boolean bool = true;
		while (bool) {
			try {

				obj1.clkFrm1040btn().click();
				bool = false;
			} catch (Exception e) {
				Thread.sleep(1000);
				obj1.clkFrm1040btn().click();
				bool = true;
			}
		}
		Thread.sleep(1000);
		obj1.getvirtualcurrency_No().sendKeys("X");
		// obj1.clkarrownear1040btn().click();
		// obj1.clkrecoveryrebatesheettbn().click();
		/* Not in 2024
		 * obj1.clkbox30infrom1040().click(); obj1.clkthreedotsnearbox30().click();
		 * Thread.sleep(500); obj1.clkworksheetbtnin3dots().click(); JavascriptExecutor
		 * jse = (JavascriptExecutor) driver;
		 * jse.executeScript("window.scrollBy(0,250)");
		 * obj1.clknostimuluspaymntcheckbx1().sendKeys("X");
		 */
		// obj1.clknostimuluspaymntcheckbx2().sendKeys("X");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();

	}

	public void sendTextmsg() throws InterruptedException {
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSendTxtMsg().click();
		Thread.sleep(1000);
		WebElement dummy = driver.findElement(By.id("txtTextLinkCellNumber"));
		dummy.click();
		tb.gettxtmsgcontent().click();
		tb.gettxtmsgcontent().sendKeys("AUTOMATION TEXT MSG");
		tb.clkSendbtninTextmsg().click();
		tb.clkOkinTextmsgSuccessbtn().click();
	}

	@Parameters({ "env", "year" })
	//@Test(groups= {"training"})
	final void trainingModeReturn(String env, String year) throws IOException, InterruptedException {
		// test= report.startTest("TRAINING MODE RETURN");
		test.log(LogStatus.INFO, "STARTING ~ TRAINING MODE RETURN");
		System.out.println("training mode ");
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		Thread.sleep(2000);
		openaPreparer(env, 334);
		changeto23(env,year);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Wait.until(ExpectedConditions.(ar.clkCloseNewRtrnbtn());
		Thread.sleep(1000);
		ar.clkCloseNewRtrnbtn().click();
		ap.clickaccountsdropdown().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
		Thread.sleep(2000);
		ap.clicktoggletrainingmodelink().click();
		OverviewpgPO op = new OverviewpgPO(driver);
		op.clickoffices().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("scrollTo(0,4500);");
		Thread.sleep(1000);
		op.clickviewbtnfor334().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		op.clickpreparertab().click();
		Thread.sleep(1000);
		op.clickviewprepbtn().click();
		op.clickTaxreturns().click();
		Thread.sleep(1000);
		op.clickNewTaxreturnsbtn().click();
		generateSSN(env);
		addCDS(env, year, "trainingmode", "1");
		addDOB();
		addW2(env, "single");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(1000);
		// tb.clkbtnSaveTaxReturn().click();
		tb.clkbtnArrowOptions().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		//---------------COPYTILIVE--------------------------------------
		ap.clickcopytolivelink().click();
		// String promptmsg = ap.clickcopiedsuccessfullyPromptmsg().getText();
		// Assert.assertEquals(promptmsg,"Tax return copied to live Database");
		// sendTextmsg();
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		tb.clkbtnSaveAndClose().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		Thread.sleep(500);
		ap.clickaccountsdropdown().click();
		ap.clicktoggletrainingmodelink().click();
	
	}

	@Parameters({ "env", "year" })
   // @Test
	final void refundCalcReturn(String env, String year) throws IOException, InterruptedException {
		// test= report.startTest("REFUND CALC RETURN");
		test.log(LogStatus.INFO, "STARTING ~ REFUND CALCULATOR RETURN");
		OverviewpgPO op = new OverviewpgPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(op.clickoverview()));
		Thread.sleep(500);
		// op.clickoverview().click();
		// switchYear(year);
		op.clickdashboardBtn().click();
		Thread.sleep(1000);
		openaPreparer(env, 334);
		//changeto23(env,year);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		// ap.clkcancelNewRtrnbtn().click();
		ap.clkCloseNewRtrnbtn().click();
		ap.clickrefundCalcSideBarbtn().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clicksingleCheckbox()));
		Thread.sleep(1000);
		ap.clicksingleCheckbox().click();
		int year_Int = Integer.parseInt(year);
		if (year_Int == 2020)
			ap.clickaboutheFamilyNextbtn19().click();
		else
			ap.clickaboutheFamilyNextbtn().click();
		Thread.sleep(500);
		ap.getsingleTextbox().sendKeys("X");
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.getsingleTextbox(),"X"));
		if (year_Int == 2020)
			ap.clickFilingstatusNextbtn19().click();
		else
			ap.clickFilingstatusNextbtn().click();
		Thread.sleep(1000);
		ap.gettaxpayersDOB().sendKeys("05051980");
		Thread.sleep(2000);
		ap.clicktaxPayerinfoNextbtn().click();
		Thread.sleep(2000);
		// Wait.until(ExpectedConditions.textToBePresentInElement(ap.gettaxpayersDOB(),"05051980"));
		ap.clickw2WagesCheckbox().click();
		Thread.sleep(1000);
		// Wait.until(ExpectedConditions.el(ap.gettaxpayersWages()));
		ap.gettaxpayersWages().sendKeys("20000");
		ap.gettaxpayersFedWith().sendKeys("1500");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		// Wait.until(ExpectedConditions(ap.clickincomeNextbtn()));
		Thread.sleep(500);
		if (year_Int == 2021) {
			ap.clickincomeNextbtn().click();
			// Thread.sleep(500);
			ap.clickadjustmentsNextbtn().click();
			// Thread.sleep(500);
			ap.clickcreditsNextbtn().click();
		} else {
			ap.clickincomeNextbtn().click();
			ap.clickadjustmentsNextbtn().click();
			ap.clickcreditsNextbtn().click();
		}
		ap.clickcreateReturnbtn().click();
		generateSSN(env);
		Thread.sleep(2000);
		// Wait.until(ExpectedConditions.stalenessOf(ap.gettaxpayersDOB()));
		// int year_int = Integer.parseInt(year);
		addCDS(env, year, "refundcalc", "1");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
		// report.endTest(test);
		// OverviewpgPO op = new OverviewpgPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(op.clickdashboardBtn()));
		// Thread.sleep(500);
		op.clickdashboardBtn().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(op.clickoverview()));
		// op.clickoverview().click();
		Thread.sleep(1000);

	}

	@Parameters({ "env", "year" })
	@Test
	final void addaReturn(String env, String year) throws IOException, InterruptedException {

		// test= report.startTest("ADD A NEW RETURN");
		test.log(LogStatus.INFO, "STARTING ADD A RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		openaPreparer(env, 334);
		//changeto23(env,year);
		//switchYear(year);
	    Reporter.log("opened a preparer"); Reporter.log("<br>");
	    test.log(LogStatus.INFO, "opened a preparer"); 
		generateSSN(env);
		addCDS(env, year, "allforms", "1");
		addDOB();
		addW2(env, "1");
		frm8879(env, "1");
		scheduleC(year);
		test.log(LogStatus.INFO, "sch-C success");
		scheduleE(year);
		test.log(LogStatus.INFO, "sch-E success"); 
		frm1099_MISC();
		test.log(LogStatus.INFO, "FRM1099MISC success");
		frm1040();
		verifyareturn(env);
		test.log(LogStatus.INFO, "RETURN VERIFIED");
		printTaxReturn();
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		//send text
		
		 tb.clkbtnArrowOptions().click(); Thread.sleep(500);
		  tb.clkbtnSendTxtMsg().click(); Thread.sleep(1000); 
		  WebElement dummy= driver.findElement(By.id("txtTextLinkCellNumber"));
		  dummy.click();
		  tb.gettxtmsgcontent().click();
		  tb.gettxtmsgcontent().sendKeys("AUTOMATION TEXT MSG");
		  tb.clkSendbtninTextmsg().click(); tb.clkOkinTextmsgSuccessbtn().click();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		  Thread.sleep(1000);
		
		tb.clksignatureBtn().click();
		Thread.sleep(500);
		tb.clksignBtn().click();
		Thread.sleep(500);
		tb.clksignbtninReturnErrors().click();
		Thread.sleep(500);
		// Wait.until(ExpectedConditions.elementToBeClickable(tb.clksendBtninCaptureSignature()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		tb.clksendBtninCaptureSignature().click();
		Thread.sleep(500);
		tb.clkcancelBtn().click();
		Thread.sleep(500);
		tb.clksignatureBtn().click();
		Thread.sleep(500);
		tb.clksignBtn().click();
		Thread.sleep(500);
		tb.clksignbtninReturnErrors().click();
		
		  Thread.sleep(500); tb.clksignoptionDropdown().click(); 
		  Select signoption =  new Select(tb.clksignMethodDropdown());
		  signoption.selectByValue("Remote Signature"); Thread.sleep(1000);
		  tb.clkEmailRadioBtn().click();
		 // Next btn shows only if there is spouse to sign // tb.clkNextBtn.click();
		  tb.clksendBtninCaptureSignature().click();
		// tb.clkokbtninRemoteSignRequest().click();
		// tb.clkcancelBtn().click();
		//Thread.sleep(500);
		//tb.clkcancelbtninremotesignerror().click();---------------season 24 working on it
		// transmit
		Thread.sleep(1000);
		tb.clktransmitReturnbtn().click();
		Thread.sleep(500);
		tb.clkOKinVerifysuccessbtn().click();
		Thread.sleep(500);
		tb.clkNextBtn().click();
		Thread.sleep(500);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("./reports/transmitreturn.png"));
		String path1 = "transmitreturn.png";
		
	}

	@Parameters({ "env", "year" })
   // @Test
	final void interviewModeReturn(String env, String year) throws InterruptedException, IOException {
		// test= report.startTest("INTERVIEW MODE RETURN");
		test.log(LogStatus.INFO, "STARTING ~ INTERVIEW MODE RETURN");
		// switchYear(year);
		openaPreparer(env, 334);
		//changeto23(env,year);
		generateSSN(env);
		InterviewModePO im = new InterviewModePO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		Thread.sleep(500);
		Boolean bool = true;
		while (bool) {
			try {
				ap.clickClientdatabtn().click();
				bool = false;
			} catch (Exception e) {
				// ap.clickClientdatabtn().click();
				bool = true;
			}
		}
		Thread.sleep(500);
		WebElement fsalert = driver.findElement(By.id("btnRequireFLST"));
		while (fsalert.isDisplayed()) {
			fsalert.click();
			break;
		}
		// ap.getcellph().click();
		Thread.sleep(500);
		ap.getfilingstatus().click();
		ap.getfilingstatus().sendKeys("1");
		Thread.sleep(500);
		ap.getfirstname().click();
		Thread.sleep(1000);
		Boolean bool1 = true;

		im.clickinterviewicon().click();
		Thread.sleep(500);
		WebElement confirminterviewfrms = driver.findElement(By.id("btnConfirmDialog"));
		confirminterviewfrms.click();
		Thread.sleep(1000);
		im.clickinterviewicon().click();
		/* im.clickinterviewicon().sendKeys(Keys.TAB); */
		// Wait.until(ExpectedConditions.elementToBeClickable(im.clickintvmarriedicon()));
		Thread.sleep(2000);
		im.clickintvmarriedicon().click();
		im.clickintvhadjobicon().click();
		im.clickintvhadchldicon().click();
		im.clickintviconpgNextbtn().click();
		// ---------
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		// Wait.until(ExpectedConditions.elementToBeClickable(im.clickintvMFJbox()));
		Actions act = new Actions(driver);
		act.click(im.clickintvMFJbox()).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		im.clickintvMFJbox().sendKeys("x");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(2000);
		// tb.clkbtnSaveTaxReturn().click();
		// Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int year_int = Integer.parseInt(year);
		if (year_int == 2018)// for Ty2018
		{
			im.clickintvFSpgNextbtn().click();
		} else if (year_int == 2019)// TY2019
		{
			im.clickintvFSpgNextbtn_19().click();
		} else {
			im.clickintvFSpgNextbtn_19().click();
		}
		im.getintvTPfirstname().sendKeys("INTRVWMODE");
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		im.getintvTPlastname().sendKeys("RETURN");
		// im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.getintvTPdob().clear();
		Thread.sleep(500);
		im.getintvTPdob().sendKeys("04041978");
		im.getintvTPoccupation().sendKeys("Manager");
		im.getintvTPhomeph().sendKeys("6103055825");
		im.getintvSPfirstname().sendKeys("Spouse");
		im.getintvSPlastname().sendKeys("RETURN");
		im.getintvSPdob().sendKeys("05121982");
		im.getintvSPoccupation().sendKeys("HomeMaker");
		tb.clkbtnSaveTaxReturn().click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		im.clickintvperinfopgNextbtn20().click(); // }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		im.getintvusaddress().sendKeys("12 leo st");
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		im.getintvzip().click();
		Thread.sleep(500);
		AltplusC("zipcode", im.getintvzip());
		im.getlivedinUS().sendKeys("x");
		im.clickaddinfopgNextbtn().click();
		if (year_int == 2020)
			im.clickintvadditionalperinfopgNextbtn().click();
		else
			im.clickintvadditionalinfopgNextbtn().click();

		im.clickintvyesdepstoclaim().sendKeys("X");

		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		Thread.sleep(500);
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.clickintvyeshomeorsupport().sendKeys("X");
		im.clickintvyeshomeorsupport().sendKeys(Keys.TAB);
		tb.clkbtnSaveTaxReturn().click();
		// take screenshot
		String pathnew = TakeScreenshot();
		System.out.println(pathnew);
		test.log(LogStatus.PASS, test.addScreenCapture(pathnew));
		Thread.sleep(500);
		im.clickintvdepspgNextbtn().click();
		// INCOME
		im.clickintvaddTPW2frmbtn().click();
		FRMW2PO w2 = new FRMW2PO(driver);
		w2.getwages().sendKeys("25000");
		w2.getwages().sendKeys(Keys.TAB);
		// w2.getdbleentryWages().sendKeys("25000");
		//w2.clkokindblentryWages().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		w2.getFedtax().sendKeys(new DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		w2.getFedtax().sendKeys(Keys.TAB);
		// w2.getdbleentryFedTax().sendKeys(new
		//// DataFormatter().formatCellValue(sheet.getRow(14).getCell(1)));
		// w2.clkokindblentryFedTax().click();
		Thread.sleep(1000);
		im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		im.clickintvW2frmNextbtn19().click();
		Thread.sleep(500);
		im.clickintvtypofincNextbtn().click();
		im.clickintvadjustmentspgNextbtn().click();
		im.clickintvcreditspgNextbtn().click();
		// im.getintvnostimulusreceived1().sendKeys("X");
		// im.getintvnostimulusreceived2().sendKeys("X");
		// im.clicknextbtnRebaterecovsheet().click();

		if (year_int == 2018) {
			im.clickintvhealthemployer().click();
		} else {
			im.clickintmarketplcoverage_No().sendKeys("X"); // 2019,2020
		}
		Thread.sleep(500);
		im.clickintvhealthpgNextbtn().click();
		Thread.sleep(500);
		im.clickintvmiscpgNextbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		im.clickintvotherMiscInterview2ndNextbtn().click();
		 im.clickintvEicchecklistNextbtn().click();//not in 2022
		 im.clickintvPaidprepduediligneceNextbtn().click();//not in 2022
		im.clickintvstateretpgNextbtn().click();
		/*
		 * im.getintvRTfinprod().sendKeys("N");
		 * im.getintvRTfinprod().sendKeys(Keys.TAB); String path1= TakeScreenshot();
		 * System.out.println(path1); test.log(LogStatus.INFO,
		 * test.addScreenCapture(path1));
		 */ // Not in 2020
		// report.endTest(test);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("scroll(0,500);");
		im.clickintvresultsNextbtn20().click();
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
	}
	
	
	@Parameters({ "env", "year" })
	//@Test
	public final void changerefundtypeReturn334(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING BANK APP RETURN 000334");
		// switchYear("2020");
		openaPreparer(env, 334);
		changeto23(env,year);
		generateSSN(env);
		addCDS(env, year, "changerefundtype", "1");
		addDOB();
		addW2(env, "single");
		frm1040();
		frm8879(env, "5");
		BankAppPO ba = new BankAppPO(driver);
		ba.clkbankAppbtninFederal().click();
		ba.getbnkSignVerification().sendKeys("Y");
		ba.getmorethanoneRT().sendKeys("N");
		ba.getTPcitizenstatus().sendKeys("C");
		// ba.gettpIDType().sendKeys("drivers license"); //---CHANGE TO ALT+c
		AltplusC("idtype", ba.gettpIDType());
		ba.gettpIDNumber().sendKeys("9876542");
		ba.gettpIDdateissued().sendKeys("08082018");
		ba.gettpIDstate().sendKeys("CA");
		ba.gettpIDexpdate().sendKeys("08082028");
		ba.getIDexamined().sendKeys("Y");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		Thread.sleep(1000);
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		ar.clickfileOptionsbtn().click();
		ar.getremoveAdvancements().sendKeys("x");
		//change refund type from 5 to 1
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		fm.clkfrm8879infederalsidebar().click();
		FRM8879PO f879 = new FRM8879PO(driver);
		f879.getRefndtype().clear();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		f879.clickremoveBankApp_Yesbtn().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		f879.getRefndtype().click();
		Thread.sleep(500);
		f879.getRefndtype().sendKeys("1");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		tb.clkbtnSaveTaxReturn().click();
		Thread.sleep(500);
		f879.getRefndtype().clear();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		f879.getRefndtype().sendKeys("5");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		tb.clkbtnSaveTaxReturn().click();
		
		//f879.getRefndtype().sendKeys(Keys.TAB);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		
	}

	@Parameters({ "env", "year" })
	//@Test
	public final void bankAppReturn334(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING BANK APP RETURN 000334");
		// switchYear("2020");
		openaPreparer(env, 334);
		changeto23(env,year);
		generateSSN(env);
		addCDS(env, year, "bankapp", "1");
		addDOB();
		addW2(env, "single");
		frm1040();
		frm8879(env, "5");
		BankAppPO ba = new BankAppPO(driver);
		ba.clkbankAppbtninFederal().click();
		ba.getbnkSignVerification().sendKeys("Y");
		ba.getmorethanoneRT().sendKeys("N");
		ba.getTPcitizenstatus().sendKeys("C");
		// ba.gettpIDType().sendKeys("drivers license"); //---CHANGE TO ALT+c
		AltplusC("idtype", ba.gettpIDType());
		ba.gettpIDNumber().sendKeys("9876542");
		ba.gettpIDdateissued().sendKeys("08082018");
		ba.gettpIDstate().sendKeys("CA");
		ba.gettpIDexpdate().sendKeys("08082028");
		ba.getIDexamined().sendKeys("Y");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		Thread.sleep(1000);
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		ar.clickfileOptionsbtn().click();
		ar.getremoveAdvancements().sendKeys("x");
		// to switch to pdf doc
		// String winHandleBefore = driver.getWindowHandle();
		tb.clkprintbtn().click();
		Thread.sleep(500);
		tb.clkbankDocsbtn().click();
		tb.clkprintBankDocsbtn().click();
		// Wait.until(ExpectedConditions.visibilityOfElementLocated(tb.clkclosebtninPDFdoc()));
		// (tb.clkclosebtninPDFdoc()));
		/*
		 * for(String winHandle : driver.getWindowHandles()){
		 * driver.switchTo().window(winHandle).close(); }
		 */
		Thread.sleep(500);
		tb.clkclosebtninPDFdoc().click();
		// driver.close();
		// driver.switchTo().window(winHandleBefore);
		tb.clkbtnSaveTaxReturn().click();
		verifyareturn(env);

	}
	@Parameters({"env","year"})
	//@Test
	public final void interviewmodewithstateLA(String env,String year) throws IOException, InterruptedException
	{
		test.log(LogStatus.INFO, "STARTING ~ INTERVIEW MODE RETURN");
		// switchYear(year);
		openaPreparer(env, 334);
		generateSSN(env);
		InterviewModePO im = new InterviewModePO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		Thread.sleep(500);
		Boolean bool = true;
		while (bool) {
			try {
				ap.clickClientdatabtn().click();
				bool = false;
			} catch (Exception e) {
				// ap.clickClientdatabtn().click();
				bool = true;
			}
		}
		Thread.sleep(500);
		WebElement fsalert = driver.findElement(By.id("btnRequireFLST"));
		while (fsalert.isDisplayed()) {
			fsalert.click();
			break;
		}
		// ap.getcellph().click();
		Thread.sleep(500);
		ap.getfilingstatus().click();
		ap.getfilingstatus().sendKeys("1");
		Thread.sleep(500);
		ap.getfirstname().click();
		Thread.sleep(1000);
		im.clickinterviewicon().click();
		Thread.sleep(500);
		WebElement confirminterviewfrms = driver.findElement(By.id("btnConfirmDialog"));
		confirminterviewfrms.click();
		Thread.sleep(1000);
		im.clickinterviewicon().click();
		Thread.sleep(2000);
		im.clickintvsingleicon().click();
		im.clickintvhadjobicon().click();
		im.clickintviconpgNextbtn().click();
		
		// ---------
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		// Wait.until(ExpectedConditions.elementToBeClickable(im.clickintvMFJbox()));
		Actions act = new Actions(driver);
		act.click(im.clickintvSinglebox()).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	
		im.clickintvSinglebox().sendKeys("x");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(2000);
		// tb.clkbtnSaveTaxReturn().click();
		// Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		int year_int = Integer.parseInt(year);
		if (year_int == 2018)// for Ty2018
		{
			im.clickintvFSpgNextbtn().click();
		} else if (year_int == 2019)// TY2019
		{
			im.clickintvFSpgNextbtn_19().click();
		} else {
			im.clickintvFSpgNextbtn_19().click();
		}
		im.getintvTPfirstname().sendKeys("LAstate");
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		im.getintvTPlastname().sendKeys("Interview");
		// im.clickintvyesdepstoclaim().sendKeys(Keys.TAB);
		im.getintvTPdob().clear();
		Thread.sleep(500);
		im.getintvTPdob().sendKeys("04041978");
		im.getintvTPoccupation().sendKeys("Manager");
		im.getintvTPhomeph().sendKeys("6103055825");
		im.getintvTPIDnumber().sendKeys("544544333");
		im.getintvTPIDstate().sendKeys("CA");
		im.getintvTPIDdateissued().sendKeys("04132020");
		im.getintvTPIDdateexpired().sendKeys("03052030");
		im.getintvTPIDtype().sendKeys("X");
		im.getintvTPremotesignconsent().sendKeys("N");
		im.getintvremotesignchargesconsent().sendKeys("N");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		im.clickintvadditionalperinfopgNextbtn().click();
		//address
		im.getintvusaddress().sendKeys("12 main st");
		im.getintvcity().sendKeys("batan rouge");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		im.getintvstate().click();
		Thread.sleep(500);
		im.getintvstate().sendKeys("LA");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		im.getintvzip().sendKeys("70801");
		im.getlivedinUS().sendKeys("X");
		im.getintvTPhomeinUS().sendKeys("X");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		im.clickaddinfopgNextbtn().click();
		im.clickintvadditionalperinfopgNextbtn_State().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		Thread.sleep(1000);
		im.clickintvaddTPW2frmbtn_State().click();
		addW2(env,year);
		im.getintvw2_15_state().sendKeys("LA");
		im.getintvw2_16_statewages().sendKeys("39000");
		im.getintvw2_15_empid().sendKeys("343444342323");
		im.getintvw2_17_statetax().sendKeys("600");
		im.clickintvW2frmNextbtn19().click();
		im.clickintvtypofincNextbtn().click();
		im.clickintvadjustmentspgNextbtn().click();
		im.clickintvcreditspgNextbtn().click();
		//marketplace
		im.clickintmarketplcoverage_No().sendKeys("X");
		im.clickintvhealthpgNextbtn().click();
		im.clickintvtaxcreditcalcpgNextbtn().click();
		im.clickintvmiscpgNextbtn().click();
		im.clickintvotherMiscInterview2ndNextbtn().click();
		im.clickintvstateretpgNextbtn().click();
		
	}

	@Parameters({ "env", "year" })
	// @Test
	final void bankAppReturnfor333(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING BANK APP RETURN for 000333");
		openaPreparer(env, 333);
		generateSSN(env);
		addCDS(env, year, "bankapptwo", "1");
		addW2(env, "single");
		frm8879(env, "5");
		BankAppPO ba = new BankAppPO(driver);
		// ba.clkbankAppbtninFederal().click();
		// ba.getBankIDCode().sendKeys("R0BCDEFG");
		ba.getbnkSignVerification().sendKeys("Y");
		ba.getmorethanoneRT().sendKeys("N");
		AltplusC("idtype", ba.gettpIDType());
		// generate 7 digit drivers license ID
		Random rand = new Random();
		int tpIDnum = rand.nextInt(9000000) + 1000000;
		String tpIDnum_str = Integer.toString(tpIDnum);
		ba.gettpIDNumber().sendKeys(tpIDnum_str);
		ba.gettpIDdateissued().sendKeys("08082018");
		ba.gettpIDstate().sendKeys("CA");
		ba.gettpIDexpdate().sendKeys("08082028");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		// AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		// ar.clickfileOptionsbtn().click();
		// ar.getremoveAdvancements().sendKeys("x");
		// to switch to pdf doc
		// String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(500);
		tb.clkprintbtn().click();
		Thread.sleep(500);
		tb.clkbankDocsbtn().click();
		Thread.sleep(500);
		tb.clkprintBankDocsbtn().click();
		// Wait.until(ExpectedConditions.visibilityOfElementLocated(tb.clkclosebtninPDFdoc()));
		// (tb.clkclosebtninPDFdoc()));
		/*
		 * for(String winHandle : driver.getWindowHandles()){
		 * driver.switchTo().window(winHandle); } Thread.sleep(5000);
		 */
		// tb.clkclosebtninPDFdoc().click();
		// driver.close();
		// driver.switchTo().window(winHandleBefore);
		verifyareturn(env);

	}

	@Parameters({ "env", "year" })
	//@Test
	final void addschCAssetonly(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING ~ schCAssetOnly RETURN");
		// switchYear(year);
		openaPreparer(env, 334);
		changeto23(env,year);
		generateSSN(env);
		addCDS(env, year, "schCAsset", "1");
		addDOB();
		addAssets();
		addW2(env, "1");
		frm8879(env, "1");
		scheduleC(year);
		test.log(LogStatus.INFO, "sch-C success");
		frm1040();
		verifyareturn(env);
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
	}

	@Parameters({ "env", "year" })
   //@Test
	final void schFreturn(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING ~ schFOnly RETURN");
		// switchYear(year);
		openaPreparer(env, 334);
		changeto23(env,year);
		generateSSN(env);
		addCDS(env, year, "schF", "1");
		addDOB();
		addW2(env, "1");
		frm8879(env, "1");
		frm1040();
		addSchF(env);
		test.log(LogStatus.INFO, "sch-F success");
		verifyareturn(env);
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveAndClose()));
		Thread.sleep(1000);
		tb.clkcopytotraining().click();
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
	}

	public void frm8867(String env) throws InterruptedException {
		// AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		addaforminaReturnPO fm = new addaforminaReturnPO(driver);
		// ap.clickaddaform().click();
		Thread.sleep(1000);
		/*
		 * fm.clksearchAForm().sendKeys("FRM 8867"); fm.clkfrm8867().click();
		 * fm.clkAddbtnAddanewform().click(); fm.clkfrm8867().click();
		 * fm.clkAddbtnAddanewform().click();
		 */
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();
		Thread.sleep(1000);
		fm.clkfrm8867().click();
		FRM8867PO f867 = new FRM8867PO(driver);
		f867.getyes_1().sendKeys("X");
		f867.getyes_2().sendKeys("X");
		f867.getyes_3().sendKeys("X");
		f867.getNo_4().sendKeys("X");
		f867.getyes_5().sendKeys("X");
		f867.getyes_6().sendKeys("X");
		f867.getyes_7().sendKeys("X");
		f867.getyes_10().sendKeys("X");
		Thread.sleep(1000);
		f867.getyes_11().sendKeys("X");
		f867.getyes_12().sendKeys("X");
		f867.getyes_15().sendKeys("X");
		f867.getline5_A_d().sendKeys("X");
		// TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnSaveTaxReturn().click();

	}

	@Parameters({ "env", "year" })
	//@Test
	final void MarriedwithKidsreturn(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING ~ MarriedwithKids RETURN");
		// switchYear(year);
		openaPreparer(env, 334);
		//changeto23(env,year);
		generateSSN(env);
		addCDS(env, year, "MwKids", "2");
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.getdob().click();
		//Thread.sleep(1000);
		ap.getdob().sendKeys("05051987");
		Thread.sleep(500);
		ap.getremotesignConsent().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.clickinfoandstatusbtn().click();
		ap.clicksigned8879().sendKeys("X");
	//	addDOB();
		addW2(env, "2");
		frm8879(env, "1");
		frm8867(env);
		frm1040();
		test.log(LogStatus.INFO, "Mwkids success");
		verifyareturn(env);
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		Thread.sleep(500);
		tb.clkbtnArrowOptions().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(tb.clkbtnSaveAndClose()));
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();

	}

	@Parameters({ "env", "year" })
   // @Test
	final void ReturnPayjunction(String env, String year) throws IOException, InterruptedException {

		test.log(LogStatus.INFO, "STARTING Payjunction RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		// switchYear(year);
		openaPreparer(env, 334);
		changeto23(env,year);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		generateSSN(env);
		addCDS(env, year, "payjunction", "1");
		addDOB();
		// addW2(env,"single");
		// frm8879(env,"1");
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkpaymentsbtn().click();
		tb.getreceivedFrom().sendKeys("Test Person");
		tb.getamount().sendKeys("1.123");
		tb.getrefNumb().sendKeys("12345");
		tb.clksavebtn().click();
		// verifyareturn(env);
		tb.clkbtnArrowOptions().click();
		Thread.sleep(500);
		tb.clkbtnSaveAndClose().click();
	}

	@Parameters({ "env", "year" })
	//@Test
	final void BillinginSetup(String env, String year) throws IOException, InterruptedException {

		test.log(LogStatus.INFO, "STARTING ~ BILLING IN SETUP");
		// switchYear(year);
		openaPreparer(env, 334);
		// close the ssn box
		changeto23(env,year);
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		// ar.clkcancelNewRtrnbtn().click();
		ar.clkCloseNewRtrnbtn().click();// click cancel in ssn box
		AccountSettingsPO as = new AccountSettingsPO(driver);
		// as.clickaccountsdropdown().click();
		as.clickaccountsettingsbtn().click();
		BillingSetupPO bs = new BillingSetupPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		bs.clickbillingLink().click();
		bs.clickaddformbtn().click();
		bs.getRetSch4peritem().sendKeys("50");
		bs.clickaddbtninselectform().click();
		// worksheet
		Thread.sleep(1000);
		bs.clickaddworksheetbtn().click();
		Thread.sleep(1000);
		bs.getret1040peritem().sendKeys("45");
		bs.clickaddbtninWorksheet().click();
		// Linesheetbilling
		Thread.sleep(1000);
		bs.clickaddlineitemsbtn().click();
		bs.getret1040perlineitem().sendKeys("55");
		bs.clickaddbtninlineitem().click();
		// discounts
		// Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,500);");
		bs.clickdisaddrowbtn().click();
		bs.getdiscountcode().sendKeys("Automation charge");
		bs.getdisamount().sendKeys("100");
		// custom charge
		// Thread.sleep(1000);
		bs.clickcustomaddrowbtn().click();
		bs.getchargedesc().sendKeys("Automation custom");
		bs.getcustomamount().sendKeys("25");
		bs.clicksavebillingbtn().click();
		Thread.sleep(1000);

	}

	public void schk11065(String env, String year) throws InterruptedException {
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		Thread.sleep(1000);
		ap.clickaddaform().click();
		addaforminaReturnPO af = new addaforminaReturnPO(driver);
		af.clksearchAForm().sendKeys("k");
		af.clkfrmSchk11065().click();
		af.clkAddbtnAddanewform().click();
		FRMSCHK1_1065PO schk = new FRMSCHK1_1065PO(driver);
		schk.getpatnershipEIN_A().click();
		Thread.sleep(500);
		schk.getpatnershipEIN_A().sendKeys("132123123");
		Thread.sleep(500);
		schk.getpatnershipName_B().clear();
		schk.getpatnershipName_B().sendKeys("PATNERSHIP123");
		Thread.sleep(500);
		schk.getpatnershipAddress().sendKeys("12 k st");
		Thread.sleep(500);
		schk.getpatnershipZipcode().click();
		AltplusC("sck_zip", schk.getpatnershipZipcode());
		schk.getirsCenter_C().sendKeys("ogden");
		schk.getresidentStatecode().sendKeys("CA");
		schk.getmaterialParticipation_Yes().sendKeys("X");
		schk.getactiveParticipatein2019_No().sendKeys("X");
		schk.getDomesticPatner_H1().sendKeys("X");
		schk.getprofitBeggining().clear();
		schk.getprofitBeggining().sendKeys("50.00");
		schk.getprofitEnding().clear();
		schk.getprofitEnding().sendKeys("50.00");
		schk.getlossBeggining().clear();
		schk.getlossBeggining().sendKeys("50.00");
		schk.getlossEnding().clear();
		schk.getlossEnding().sendKeys("50.00");
		schk.getcapitalBeggining().clear();
		schk.getcapitalBeggining().sendKeys("50.00");
		schk.getcapitalEnding().clear();
		schk.getcapitalEnding().sendKeys("50.00");
		schk.getnonrecourseBeggining_K().sendKeys("9650");
		schk.getbegginingCapitalAccnt_L().sendKeys("2700");
		schk.getcurrentyrNetIncome().sendKeys("500");
		schk.getwithdrawals().sendKeys("600");
		schk.getendingCapitalAccnt().sendKeys("1600");
		schk.getM_No().sendKeys("X");
		schk.getpart3_1().sendKeys("500");
		schk.getpart3_10().sendKeys("250");
		schk.getpart3_16A().sendKeys("A");
		schk.getpart3_countryAbbreviation().sendKeys("VARIOUS");
		schk.getpart3_16B().sendKeys("B");
		schk.getpart3_16B_Amount().sendKeys("1370");
		schk.getpart3_16F().sendKeys("F");
		schk.getpart3_16F_Amount().sendKeys("200");
		schk.getpart3_16G().sendKeys("G");
		schk.getpart3_16G_Amount().sendKeys("100");
		schk.getpart3_19A().sendKeys("A");
		schk.getpart3_19_Amount().sendKeys("300");

	}

	@Parameters({ "env", "year" })
   // @Test
	final void Return_addk11065(String env, String year) throws IOException, InterruptedException {

		test.log(LogStatus.INFO, "STARTING SCHK1065 RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		// switchYear(year);
		openaPreparer(env, 334);
		//changeto23(env,year);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		generateSSN(env);
		addCDS(env, year, "SCHK", "1");
		addDOB();
		addW2(env, "1");
		frm8879(env, "1");
		schk11065(env, year);
		frm1040();
		verifyareturn(env);

	}

	@Parameters({ "env", "year" })
	//@Test
	final void PRODaddaReturn(String env, String year) throws IOException, InterruptedException {

		// test= report.startTest("ADD A NEW RETURN");
		test.log(LogStatus.INFO, "STARTING ADD A RETURN IN PROD");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		openaPreparer(env, 334);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		generateSSN(env);
		addCDS(env, year, "Automation", "1");
		addW2(env, "single");
		frm8879(env, "1");
		printTaxReturn();
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnArrowOptions().click();
		tb.clkbtnSaveAndClose().click();

	}

	@Parameters({ "env", "year" })
	//@Test
	final void payjunction2(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING Payjunction RETURN");
		Reporter.log("STARTING Payjuntion2");
		Reporter.log("<br>");
		// switchYear(year);
		openaPreparer(env, 334);
		changeto23(env,year);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		OverviewpgPO op = new OverviewpgPO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.clkCloseNewRtrnbtn().click();
		Actions act1 = new Actions(driver);
		// act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act1.moveToElement(op.clickopenfirsttaxretrn()).moveToElement(op.clickfirstthreedotsbtn()).click().build()
				.perform();
		Thread.sleep(500);
		act1.moveToElement(op.clickcapturePayment()).click().build().perform();
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.getreceivedFrom().sendKeys("Test Person");
		tb.getamount().sendKeys("1.01");
		tb.getrefNumb().sendKeys("12345");
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		double loadTime = (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
		System.out.print(loadTime + " seconds");
		Thread.sleep(500);
		tb.clksavebtn().click();
	}

	@Parameters({ "env", "year" })
	//@Test
	final void QuickWizardReturn(String env, String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING Payjunction RETURN");
		Reporter.log("STARTING Quick Wizard Return");
		Reporter.log("<br>");
		// switchYear("2021");
		openaPreparer(env, 334);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		// OverviewpgPO op = new OverviewpgPO(driver);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		sheet = getCellData();
		// *********** creates SSN*************
		int aSSNnum = 0;
		int bSSNnum = 0, cSSNnum = 0;
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
		ap.clkaddquickwizardreturnbtn().click();
		ap.clickwiztaxpayerInfotab().click();
		// WebElement foo = new WebDriverWait(driver, Duration.ofSeconds(3))
		// .until(ap.clickwizfilingStatusintaxpayerinfo());
		Thread.sleep(5000);
		WebDriverWait Wait2 = new  WebDriverWait(driver, Duration.ofSeconds(20));
		Wait2.until(ExpectedConditions.elementToBeClickable(ap.clickwizfirstNameintaxpayerinfo()));
		// ap.clickwiztaxpayerInfotab().sendKeys("KEYS.TAB");

		// ap.clickwizfilingStatusintaxpayerinfo().click();
		ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.DOWN);
		// ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.DOWN);
		// ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.ENTER);
		ap.clickwizfilingstatusSingle().click();
		// ap.clickwizfilingstatusMarriedfiledjoint().click();
		ap.clickwizbirhtDateintaxpayerinfo().click();
		ap.clickwizbirhtDateintaxpayerinfo().sendKeys("05051980");
		ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizfilingStatusintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizbirhtDateintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizbirhtDateintaxpayerinfo().sendKeys(Keys.DOWN);
		ap.clickwizbirhtDateintaxpayerinfo().sendKeys(Keys.DOWN);
		ap.clickwizbirhtDateintaxpayerinfo().sendKeys(Keys.DOWN);

		ap.clickwizbirhtDateintaxpayerinfo().sendKeys(Keys.RETURN);
		ap.clickwizfirstNameintaxpayerinfo().sendKeys("WIZARD");
		ap.clickwizlastNameintaxpayerinfo().sendKeys("RETURN");
		ap.clickwizlastNameintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizlastNameintaxpayerinfo().sendKeys(Keys.TAB);
		ap.clickwizlastNameintaxpayerinfo().sendKeys(Keys.TAB);
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		// tb.clksavebtn().click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// System.out.println(document.body.scrollHeight);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 3000)");
		ap.clickwizcontactInfotab().click();
		// ap.clickwizsuffix().click();
		ap.clickwizaddressinContactInfo().sendKeys("12 main st");
		tb.clkbtnSaveTaxReturn().click();
		ap.clickwizincometab().click();
		ap.clickwizwagesinIncome().sendKeys("25000");
		ap.clickwizwithholdinginIncome().sendKeys("3500");
		ap.clickwizresultstab().click();
		// new Actions(driver).moveByOffset(1536, 840).click().perform();
		Actions actions = new Actions(driver); // ActionChains(driver);
		actions.moveByOffset(1470, 624).click().build().perform();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 3000)");
		// actions.moveByOffset(1470,412).click().build().perform();
		// Actions actions1 = new Actions(driver);
		// actions1.moveByOffset(1470,412).click().build().perform();
		// ap.clickwizresultspgContainer().sendKeys(Keys.PAGE_DOWN);
		// this.scrollIntoView(false);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();",ap.clickwizcompleteguidedestimatorbtn());
		// ap.clickwizcompleteguidedestimatorbtn().click();
		// tb.clksavebtn().click();

	}

	@Parameters({ "env", "year" })
	// @Test(groups = {"prod"})
	final void NahmicSetup(String env, String year) throws InterruptedException, IOException {
		test.log(LogStatus.INFO, "STARTING Payjunction RETURN");
		Reporter.log("STARTING Setup in NAHMIC");
		Reporter.log("<br>");
		AccountSettingsPO as = new AccountSettingsPO(driver);
		Thread.sleep(1000);
		// as.clickaccountsdropdown().click();
		// as.clikarrowforaccntsettings().click();
		// Thread.sleep(1000);
		as.clickaccountsettingsbtn().click();
		Thread.sleep(1000);
		as.clikmnglicensingbtn().click();
		Thread.sleep(1000);
		as.clikassignbtn4().click();
		// as.clikassignLicencetobtn().click();
		// as.clikselect18004option().click();
		Select dropoptions = new Select(as.clikassignLicencetobtn());
		dropoptions.selectByValue("1217");
		Thread.sleep(1000);
		as.cliksavebtninAssignLicense().click();
		// Remove licence
		Thread.sleep(1000);
		as.clikremoveLicence().click();// remove 180004
		Thread.sleep(1000);
		as.clikrmvbtninUnassignLicence().click();

		// ancilaryprod
		Thread.sleep(500);
		as.clikancillaryproducts().click();
		Thread.sleep(1000);
		as.clikmanagebtn().click();
		as.clikeditaddonfee().clear();
		as.clikeditaddonfee().sendKeys("10");
		as.cliksaveinancillaryproduct().click();
		// cobranding
		Thread.sleep(1000);
		/*
		 * as.clikcobrandingbtn().click(); Thread.sleep(500);
		 * as.cliktechsupportnumber().clear();
		 * as.cliktechsupportnumber().sendKeys("8002002000"); Thread.sleep(500);
		 * as.cliksavetechsupportnumbr().click();
		 */
		// create a new login
		Thread.sleep(1000);
		as.clikloginbtn().click();
		Thread.sleep(1000);
		as.clikcreateaNewLogin().click();
		as.clikusername().sendKeys("prodauto");
		as.clikdisplayname().sendKeys("prodauto");
		as.clikemailid().sendKeys("mnahhas@crosslinktax.com");
		as.clikconfirmemailid().sendKeys("mnahhas@crosslinktax.com");
		Select drpoption = new Select(as.clikaccessLevel());
		drpoption.selectByVisibleText("Preparer/Login");
		as.cliksavebtninNewLogin().click();

	}
	@Parameters({ "env", "year" })
	//@Test
	public void reloadBilling(String env,String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "STARTING ADD A RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		// switchYear(year);
		openaPreparer(env, 334);
		changeto23(env,year);
		Reporter.log("opened a preparer");
		Reporter.log("<br>");
		test.log(LogStatus.INFO, "opened a preparer");
		//open Settings change 50 to 55 for 1040
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		ar.clkCloseNewRtrnbtn().click();// click cancel in ssn box
		AccountSettingsPO as = new AccountSettingsPO(driver);
		as.clickaccountsettingsbtn().click();
		BillingSetupPO bs = new BillingSetupPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(1000);
		bs.clickbillingLink().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		String randomnumber = "0";
		randomnumber = String.valueOf(((int)(Math.random()*11)+20));
		System.out.println(randomnumber);
		Thread.sleep(1000);
		//bs.clickformbillingperitem().clear();
		Thread.sleep(1000);
		bs.clickformbillingperitem().sendKeys("31");
		Thread.sleep(1000);
		bs.clicksavebillingbtn().click();
		bs.clickbillingsetupclosebtn().click();//close setup 
		//open billing in 1st tax return
		OverviewpgPO op = new OverviewpgPO(driver);
		op.clickTaxreturns().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		op.clickfirstTaxRtrnOpenbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		op.clickinvoicebillinggobtn().click();
		String billingcharge = ar.clickitemizedbillingcharges().getAttribute("value");
		System.out.println("billing charge before" + billingcharge);
		TaxreturnBarPO tb = new TaxreturnBarPO(driver);
		tb.clkbtnArrowOptions().click();
		tb.clkbtnreloadbilling().click();
		System.out.println(ar.clickitemizedbillingcharges().getAttribute("value"));
		
		

	}
	@Parameters({ "env", "year" })
	//@Test
	public void selfPreparerreturn(String env,String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "SELF PREPARER RETURN");
		Reporter.log("STARTING ADDARETURN");
		Reporter.log("<br>");
		openaPreparer(env, 334);
		//changeto23(env,year);
		//switchYear(year);
	    Reporter.log("opened a preparer"); Reporter.log("<br>");
	    test.log(LogStatus.INFO, "opened a preparer"); 
		generateSSN(env);
		addCDS(env, year, "SELFPREPARER", "1");
		addDOB();
		addW2(env, "single");
		frm8879(env, "1");
		FRM8879PO f879 = new FRM8879PO(driver);
		f879.getpreptype().clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		f879.getpreptype().sendKeys("S");
	
		
	}
	
	@Parameters({ "env", "year" })
	//@Test
	public void docArchive(String env,String year) throws IOException, InterruptedException {
		test.log(LogStatus.INFO, "DOC ARCHIVE");
		Reporter.log("DOC ARCHIVE");
		Reporter.log("<br>");
		openaPreparer(env, 334);
		//changeto23(env,year);
		//switchYear(year);
	    Reporter.log("opened a preparer"); Reporter.log("<br>");
	    test.log(LogStatus.INFO, "opened a preparer"); 
		generateSSN(env);
		addCDS(env, year, "docarch", "1");
		addDOB();
		docarchive();
	

}

	private void docarchive() throws InterruptedException {
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clickdocArchivebtn().click();
		ap.clickarchivedDocbtn().click();
		ap.clickaddNewDocbtn().click();
	    if(ap.clickBrowsebtn().isDisplayed())
	    	if(ap.clickscanbtn().isDisplayed())
	    		ap.clickdocDesctextbox().sendKeys("test docs");
		//select idType = new select(driver.findElement(By ))//No id for the type
	    if(ap.clickaddbtninadddoc().isDisplayed())
	    	System.out.println("Add button present");
	    ap.clickcancelbtninAddDocs().click();
	  //req documents
	    ap.clickrequestedDocsbtn().click();
	    ap.clickReqDocbtninside().click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Thread.sleep(1000);
	    ap.clickselectanEmaildropdown().click();
	    ap.clickselectaEmail_tp().click();
	    
	}
}
