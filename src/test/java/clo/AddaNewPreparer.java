/**
 * 
 */
package clo;

import java.io.IOException;
import java.time.Duration;

import com.applitools.eyes.*;
//import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.CompletesetupPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.PreparerinCompleteSetupPO;
import resources.Base;

/**
 * @author ssreenivasan office level
 *
 */
public class AddaNewPreparer extends Base {

	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());
	public static WebDriverWait wait;
	// Initialize the Runner for your test.
	// EyesRunner runner = new ClassicRunner();

	// Initialize the eyes SDK
	// Eyes eyes = new Eyes();

	// Change the APPLITOOLS_API_KEY API key with yours

	@Parameters({ "env", "year" })
	// @Test(priority=1)
	public void newPreparer(String env, String year) throws InterruptedException, IOException {

		OverviewpgPO op = new OverviewpgPO(driver);
		 switchYear(year);
		//changeto23(env,year);
		op.clickpreparertab().click();
		Reporter.log("STARTING ADD A PREPARER");
		Thread.sleep(500);
		// wait = new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.elementToBeClickable(op.clickCreateNewPrep()));
		op.clickCreateNewPrep().click();
		// eyes.checkWindow("check1");
		logger.info("Clicked New preparer button");
		Thread.sleep(1000);
		PreparerinCompleteSetupPO pc = new PreparerinCompleteSetupPO(driver);
		pc.clkAddNewbtn().click();
		logger.info("Entering New Preparers Info");
		test.log(LogStatus.INFO, "ADDING A PREPARER ");
		int shortcutID = 0;
		shortcutID = (int) ((Math.random() * 700) + 100);
		pc.getPrepID().sendKeys(String.valueOf(shortcutID));
		pc.getPrepName().sendKeys("Auto prep");
		pc.getPrepSSN().sendKeys("123456789");
		pc.getPrepPTIN().sendKeys("01111111");
		pc.getPrepType().click();
		pc.getPrepTypeOption().click();
		pc.getPrepEmail().sendKeys("ssreenivasan@crosslinktax.com");
		pc.getFirmName().sendKeys("The Firm");
		pc.getFirmAddress().sendKeys("12 main st");
		pc.getCity().sendKeys("tracy");
		pc.getState().sendKeys("CA");
		pc.getZip().sendKeys("95337");
		pc.clickAddNewPrep().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "SUCCESS : ADDING A PREPARER ");
		/*
		 * if(pc.getErrortoNewPrep().isDisplayed()) { logger.error("Alert shows: " +
		 * pc.getErrortoNewPrep().getText()); logger.fatal("Error Desc : " +
		 * pc.getErrorDesc().getText()); pc.clickDonebtninError().click(); } else {
		 * logger.info("no error"); }
		 */
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


	@Parameters({ "env", "year" })
	public void addaduplicatePreparer(String env, String year) throws IOException, InterruptedException {
		
		Reporter.log("STARTING ADD A DUPLICATE PREPARER");
		test.log(LogStatus.INFO, "ADDING A DUPLICATE PREPARER ");
		// Wait.until(ExpectedConditions.elementToBeClickable(op.clickCreateNewPrep()));
		// op.clickCreateNewPrep().click();
		logger.info("Clicked New preparer button");
		Thread.sleep(1000);
		PreparerinCompleteSetupPO pc = new PreparerinCompleteSetupPO(driver);
		pc.clkAddNewbtn().click();
		logger.info("Entering New Preparers Info");
		pc.getPrepID().sendKeys("64");
		pc.getPrepName().sendKeys("Duplicate Auto prep");
		pc.getPrepSSN().sendKeys("123456789");
		pc.getPrepPTIN().sendKeys("01111111");
		pc.getPrepType().click();
		pc.getPrepTypeOption().click();
		pc.getPrepEmail().sendKeys("ssreenivasan@crosslinktax.com");
		pc.getFirmName().sendKeys("The Firm");
		pc.getFirmAddress().sendKeys("12 main st");
		pc.getCity().sendKeys("tracy");
		pc.getState().sendKeys("CA");
		pc.getZip().sendKeys("95337");
		pc.clickAddNewPrep().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// logger.error("Alert shows: " + pc.getErrortoNewPrep().getText());
		// logger.fatal("Error Desc : " + pc.getErrorDesc().getText());
		test.log(LogStatus.WARNING, "EXPECTED DUPLICATE SHORTCUT ID ERROR ");
		// Wait.until(ExpectedConditions.elementToBeClickable(pc.clickDonebtninError()));//.....12/5/19
		Thread.sleep(1000);
		// pc.clickDonebtninError().click();
		pc.clickConfirminDeletePrep().click();
		// Wait.until(ExpectedConditions.elementToBeClickable(pc.clickCancelbtninCreateanewprep()));//.....12/5/19
		Thread.sleep(500);
		pc.clickCancelbtninCreateanewprep().click();
	}

	@Parameters({ "env", "year" })
	// @Test(priority=2)
	public void deleteaPreparer() {
		try {
			logger.info("Delete prep");
			Reporter.log("Deleting a Preparer");
			test.log(LogStatus.INFO, "DELETE A PREPARER");
			PreparerinCompleteSetupPO pc = new PreparerinCompleteSetupPO(driver);
			// Wait.until(ExpectedConditions.elementToBeClickable(pc.clickDelete_btnexecuteaction3()));
			pc.clickDelete_btnexecuteaction3().click();
			logger.info("Preparer Deleted");
			Wait.until(ExpectedConditions.elementToBeClickable(pc.clickConfirminDeletePrep()));
			pc.clickConfirminDeletePrep().click();
			// Wait.until(ExpectedConditions.elementToBeClickable(pc.clickClosebtn()));
			Thread.sleep(1000);
			pc.clickClosebtn().click();
			test.log(LogStatus.INFO, "PREPARER DELETED");
			logger.info("Closing the setup.Going to Overview page");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Error " + e);
		}
	}

	@Parameters("env")
	@BeforeClass
	public void login(String env) throws IOException, InterruptedException {

		driver = invokeBrowser(env);
		// eyes.setApiKey("cXqzsoup6aiVEq5dvOm4L8exce57prO199s0DfXajpB8110");
		// eyes.open(driver, "Demo App", "Smoke Test");
		driver.get(prop.getProperty("url"));
		// eyes.checkWindow("hello");
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys("000334");// prop.getProperty("preparerlogin")
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));
		// eyes.checkWindow("loginpage");
		// yes.checkwin
		Thread.sleep(1000);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		test.log(LogStatus.INFO, "LOGGING IN AS PREPARER ");
		// WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(1000);
		// Wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		// lp.clickmarkaspublic().click();
		lp.clickconfirmationkey().sendKeys("abcde");
		logger.info("Clicked markaspublic");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		logger.info("In OverView Page");
	}

	public void switchYear(String year) throws IOException, InterruptedException {

		AccountSettingsPO ap = new AccountSettingsPO(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Thread.sleep(1000);
		// Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));//.......12/5/2019
		ap.clickswitchselectyeardropdown().click();
		/*
		 * switch (Integer.valueOf(year)) { case 2017:
		 * ap.clickswitchoptionyear2017().click();
		 * logger.info("switched to the year 2017"); test.log(LogStatus.INFO,
		 * "SWITCH TO YEAR : 2017"); break; case 2018:
		 * ap.clickswitchoptionyear2018().click();
		 * logger.info("switched to the year 2018"); test.log(LogStatus.INFO,
		 * "SWITCH TO YEAR : 2018"); break; }
		 */
		//Thread.sleep(1000);
		ap.clickswitchbtn().click();
	}

	@AfterClass
	public void teardown() {
		// report.flush();
		// driver.close();
		// End the test.
		// eyes.setLogHandler(new StdoutLogHandler(true));
		// eyes.closeAsync();
		// TestResultsSummary allTestResults = runner.getAllTestResults();
		// System.out.println(allTestResults);

		// Close the browser.
		driver.quit();

		// If the test was aborted before eyes.close was called, ends the test as aborted.
		// eyes.abortIfNotClosed();
	}

	@Parameters({ "env", "year" })
	@Test(priority = 1)
	public void adddeleteaprep(String env, String year) throws InterruptedException, IOException {
		// test = report.startTest("ADD A PREPARER");
		newPreparer(env, year);
		//addaduplicatePreparer(env, year);
		// deleteaPreparer();
		// report.endTest(test1);
	}

}
