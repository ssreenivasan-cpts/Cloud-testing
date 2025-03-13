/**
 * 
 */
package clo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.AccountSettingsPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class LoginPage extends Base {
	Logger logger = LogManager.getLogger(getClass());

	public WebDriver driver;
	
	private void switchYear(String year) throws IOException, InterruptedException {
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();  
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		switch(Integer.valueOf(year))
		{
		case 2017:
			ap.clickswitchoptionyear2017().click();
			logger.info("switched to the year 2017");
			test.log(LogStatus.INFO,"switched to the year 2017");
			break;
		case 2018:
			ap.clickswitchoptionyear2018().click();
			logger.info("switched to the year 2018");
			//test.log(LogStatus.INFO,"switched to the year 2018");
			break;
		case 2019:
			ap.clickswitchoptionyear2019().click();
			logger.info("switched to the year 2018");
			//test.log(LogStatus.INFO,"switched to the year 2018");
			break;
		}
		Thread.sleep(1000);
		ap.clickswitchbtn().click();
		//Thread.sleep(1000);
	}

	@Parameters("env")
	// @Test(priority = 1)
	public void loginNegative(String env) throws IOException, InterruptedException {
		try {
			driver = invokeBrowser(env);
			driver.get("https://qa.crosslinkonline.com/#");
			LogincloPO lp = new LogincloPO(driver);
			logger.info("STARTED : LOGIN NEGATIVE");
			lp.getusername().sendKeys("000334");
			lp.getPassword().sendKeys("password");
			Thread.sleep(500);
			lp.clickLogin().click();
			WebElement invalidPassword = driver.findElement(By.xpath("//div[text() = 'Incorrect password']"));
			System.out.println(invalidPassword.getText());
			if (invalidPassword.getText().contains("Incorrect password")) {
				// System.out.println("Login Negative testcase passed" );
				logger.info("PASSED : LOGIN NEGATIVE");
				// logger.info("--------------------------------");
				logger.info("Login Negative testcase passed");
				// System.out.println("Login Negative testcase passed" );
				logger.info("PASSED : LOGIN NEGATIVE");
				// logger.info("--------------------------------");
				logger.info("Login Negative testcase passed");
				test.log(LogStatus.INFO, "Login Negative testcase passed");
			} else {
				logger.info("Login Negative testcase failed");
				test.log(LogStatus.INFO, "Login Negative testcase failed");
		}
			driver.close();
		}
		catch (Exception e) {
			logger.error("Error in Login Negative" + e);
		test.log(LogStatus.ERROR, "Error in Login Negative");
		}

		driver.quit();
	}

	@Parameters("env")
	// @Test(priority = 2)
	public void forgotPassword(String env) throws IOException, InterruptedException {
		try {
			driver = invokeBrowser(env);
			driver.get("https://qa.crosslinkonline.com/#");
			LogincloPO lp = new LogincloPO(driver);
			logger.info("STARTED : FORGOT PASSWORD");
			Thread.sleep(500);
			// lp.getusername().sendKeys(prop.getProperty("username"));
			lp.clickforgotpassword().click();
			Thread.sleep(500);
			lp.clickfpusername().click();
			lp.clickfpusername().sendKeys("nidhi");
			lp.clicksendcodebtn().click();
			Thread.sleep(500);
			WebElement emailsentdialog = driver.findElement(By.id("confirm-delete-title"));
			System.out.println(emailsentdialog.getText());
			logger.info(emailsentdialog.getText());
			assertTrue(emailsentdialog.getText().contains("EMAIL SENT"));
			logger.info("SUCCESS : FORGOT PASSWORD");
			test.log(LogStatus.INFO, "forgot password passed");
			WebElement donebtn = driver.findElement(By.id("btnHideEmailSentModal"));
			donebtn.click();
		} catch (Exception e) {
			logger.error("Error in Forgot Password" + e);
			test.log(LogStatus.ERROR, "Error in Forgot Password");
		}
		driver.quit();
	}

	@Parameters("env")
	// @Test(priority = 3)
	public void loginPositive(String env) throws IOException, InterruptedException {
		//try {
			driver = invokeBrowser(env);
			driver.get(prop.getProperty("url"));
			LogincloPO lp = new LogincloPO(driver);
			logger.info("STARTED :LOGIN POSITIVE");
			OverviewpgPO op = new OverviewpgPO(driver);
			lp.getusername().sendKeys("000334");
			lp.getPassword().sendKeys(prop.getProperty("preparerpass"));
			//lp.getPassword().sendKeys("P@ssword26");
			Thread.sleep(500);
			lp.clickLogin().click();
			Thread.sleep(1000);
			lp.clicksecLogin().click();
			//lp.clickmarkaspublic().click();
			lp.clickconfirmationkey().sendKeys("abcde");
			lp.clickthrdcontbtn().click();
			op.clickdashboardBtn().click();
// 			assertTrue(op.clickoverview().getText().contains("Overview"));
			logger.info("Login Positive testcase passed");
			logger.info("SUCCESS : LOGIN POSITIVE");
			logger.info("Login Positive testcase passed");
			test.log(LogStatus.INFO, "Login Positive testcase passed");
			Thread.sleep(500);
		/*} catch (Exception e) {
			logger.error("Error in Login Positive" + e);
			test.log(LogStatus.ERROR, "Error in Login Positive");
		}*/
	}
	public void checkAddWidget() throws InterruptedException {
		
		OverviewpgPO op = new OverviewpgPO(driver);
		click(op.clickdashboardBtn());
		click(op.clickaddNewWidgetbtn());
		Thread.sleep(500);
		click(op.clickcloseinWidgetMgnt());

	}
	public void checkSearchbtn() throws InterruptedException
	{
		OverviewpgPO op = new OverviewpgPO(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		click(op.clicksearchbtn());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		type(op.getaddvalueinSearch(),"first office");
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		op.clickcancelinSearch().click();
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void click(WebElement locator)
	{
		locator.click();
		test.log(LogStatus.INFO, "click success: " + locator.getText() );
	}
	
	public void type(WebElement locator,String value)
	{
		locator.sendKeys(value);
		test.log(LogStatus.INFO, "Entered Value " + locator.getText());
	}
	
	//@Test(priority = 4)
	public void createNewAppointment() throws IOException, InterruptedException {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(500);
			AccountSettingsPO ap = new AccountSettingsPO(driver);
			Wait =new WebDriverWait(driver, Duration.ofSeconds(10));
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
			click(op.clickcalendariconbtn());
			op.clicknewappointmentbtn().click();
			op.clickapptfirstname().sendKeys("First");
			op.clickapptlastname().sendKeys("Appontment");
			op.clickapptsubject().sendKeys("Appointment schedule");
			//op.clickapptpreparesname().sendKeys("Testpreparer"); // no more in create appt
			op.clickapptphonenumber().sendKeys("2098352720");
			op.clickapptcomments().sendKeys("Test comments!");
			Thread.sleep(1000);
			op.clickapptsendbtn().click();
			Thread.sleep(2000);
			//assertTrue(op.clickapptcreateddialog().getText().contains("The appointment was created successfully."));
			//op.clickapptcreatedclsoebtn().click();
			
	}

	 //@Test(priority = 5)
	public void createApptSameTime() throws IOException, InterruptedException {
		try {
			LogincloPO lp = new LogincloPO(driver);
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(1000);//..........
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickcalendariconbtn()));
			op.clickcalendariconbtn().click();
			op.clicknewappointmentbtn().click();
			op.clickapptfirstname().sendKeys("Second");
			op.clickapptlastname().sendKeys("Appointment");
			op.clickapptsubject().sendKeys("Another appointment at same time");
			//op.clickapptpreparesname().sendKeys("Testpreparer"); //this field is no more
			op.clickapptphonenumber().sendKeys("2098352720");
			op.clickapptcomments().sendKeys("Second appointment at the same time");
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptsendbtn()));//..........
			op.clickapptsendbtn().click();
			//Thread.sleep(500);//..........
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptschconflictconfirmbtn()));//..........
			op.clickapptschconflictconfirmbtn().click();
			logger.info(op.clickapptcreateddialog().getText());
			logger.info("Create Second appointment passed");
			test.log(LogStatus.INFO, "Create Second appointment passed");
			op.clickapptcreatedclsoebtn().click();
			//Thread.sleep(500);//..........
		} catch (Exception e) {
			logger.error("Error in Create Second appointment" + e);
			test.log(LogStatus.ERROR, "Error in Create Second appointment");
		}
	}

	//@Test(priority = 6)
	public void updateAppointment() throws IOException, InterruptedException {
		try {
			Thread.sleep(1000);
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickapptupdatebtn().click();
			Thread.sleep(1000);
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptsubjectupdatemodal()));//..........
			op.clickapptsubjectupdatemodal().clear();
			op.clickapptsubjectupdatemodal().sendKeys("Updated Subject");
			logger.info("Updated Subject");
			op.clickapptphonenumberupdatemodal().clear();
			op.clickapptphonenumberupdatemodal().sendKeys("2098352777");
			logger.info("Updated phonenumber");
			op.clickapptscommentupdatemodal().clear();
			op.clickapptscommentupdatemodal().sendKeys("comments updated");
			logger.info("updated comments");
			op.clickapptupdatemodalbtn().click();
			Thread.sleep(500);//..........
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptcloseupdatemodalbtn()));
			assertTrue(op.clickapptcreateddialog().getText().contains("The appointment was updated successfully."));
			logger.info("Update appointment passed");
			test.log(LogStatus.INFO, "Update appointment passed");
			op.clickapptcloseupdatemodalbtn().click();
			} catch (Exception e) {
			logger.error("Error in Update appointment" + e);
			test.log(LogStatus.ERROR, "Error in Update appointment");
		}
	}

	 //@Test(priority=7)
	public void PasttimeAppointment() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(1000);//..........
			op.clickcalendariconbtn().click();
			op.clicknewappointmentbtn().click();
			op.clickapptstarttime().click();
			Thread.sleep(500);//..........
			op.clickapptsttime7am().click();
			assertTrue(op.clickapptpasttimemesg().getText().contains("Time is in the past"));
			op.clickapptclosebtn().click();
			logger.info("Past Time appointment passed");
			test.log(LogStatus.INFO, "Past Time appointment passed");
		} catch (Exception e) {
			logger.error("Error Past Time Appointment" + e);
			test.log(LogStatus.ERROR, "Error in Past Time Appointment");
		}
	}

	//@Test(priority = 8)
	public void deleteAppointment() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clickapptdeletebtn().click();
			Thread.sleep(500);//..........
			Wait.until(ExpectedConditions.elementToBeClickable(op.clickapptdelconfirmbtn()));
			op.clickapptdelconfirmbtn().click();
			logger.info("Delete appointment passed");
			test.log(LogStatus.INFO, "Delete appointment passed");
			} catch (Exception e) {
			logger.error("Error in Delete appointment" + e);
			test.log(LogStatus.ERROR, "Error in Delete appointment");
		}
	}

	 //@Test(priority = 9)
	public void deleteSecondAppointment() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(500);//..........
			op.clickapptdeletebtn().click();
			Thread.sleep(500);//..........
			op.clickapptdelconfirmbtn().click();
			logger.info("Delete Second Appointment passed");
			test.log(LogStatus.INFO, "Delete Second Appointment passed");
			} catch (Exception e) {
			logger.error("Error in Delete Second Appointment" + e);
			test.log(LogStatus.ERROR, "Error in Delete Second Appointment");
		}
	}

	// @Test(priority = 10)
	public void newMessageSent() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(500);//..........
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clicknotificonbtn()));
			op.clicknotificonbtn().click();
			op.clicknotifnewmesgbtn().click();
			Thread.sleep(1000);
			op.clicknotifpreparerdropdown().click();
			op.clicknotifpreparerdpfirstlist().click();
			Thread.sleep(500);//..........
			op.clicknotifsubject().sendKeys("Automation Test Message");
			op.clicknotifbody().sendKeys("Automation test message body");
			op.clicknotifsendbtn().click();
			logger.info(op.clicknotifmesgsentdialog().getText());
			//assertTrue(op.clicknotifmesgsentdialog().getText().contains("The message was sent successfully."));
			logger.info("New Message Sent passed");
			test.log(LogStatus.INFO, "New Message Sent passed");
			op.clicknotifdonebtn().click();
		} catch (Exception e) {
			logger.error("Error in New Message Sent" + e);
			test.log(LogStatus.ERROR, "Error in New Message Sent");
		}

	}

	 //@Test(priority = 11)
	public void newMessageReply() throws IOException, InterruptedException {
		try {
			Thread.sleep(500);//..........
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clicknotificonbtn().click();
			op.clicknotifreceivedbtn().click();
			Thread.sleep(1000);
			op.clicknotifreplybtn().click();
			op.clicknotifbody().sendKeys("Reply through Automation");
			op.clicknotifsendbtn().click();
		//	logger.info(op.clicknotifmesgsentdialog().getText());
			//assertTrue(op.clicknotifmesgsentdialog().getText().contains("The message was sent successfully."));
			logger.info("New Message Reply passed");
			test.log(LogStatus.INFO, "New Message Reply passed");
			op.clicknotifdonebtn().click();
		} catch (Exception e) {
			logger.error("Error in New Message Reply" + e);
			test.log(LogStatus.ERROR, "Error in New Message Reply");
		}

	}

	// @Test(priority = 12)
	public void deleteMessage() throws IOException, InterruptedException {
		try {
			Thread.sleep(500);//..........
			OverviewpgPO op = new OverviewpgPO(driver);
			op.clicknotifdeletebtn().click();
			op.clicknotifdelmesgdialog().click();
			op.clicknotifdelmesgdialogyesbtn().click();
			logger.info("Delete Message Passed");
			test.log(LogStatus.INFO, "Delete Message Passed");
		} catch (Exception e) {
			logger.error("Error in Delete Message" + e);
			test.log(LogStatus.ERROR, "Error in Delete Message");
		}
	}

	// @Test(priority = 13)
	public void checksReadyToPrint() throws IOException, InterruptedException {
		//try {
			Thread.sleep(1000);//..........
			OverviewpgPO op = new OverviewpgPO(driver);
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchksiconbtn()));
			op.clickchksiconbtn().click();
			op.clickchksfilterdropdown().click();
			op.clickchksfiltertpgbank().click();
			Thread.sleep(1000);//..........
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchksselectallchkbox()));
			//op.clickchksselectallchkbox().click();
			op.clickchksprintbtn().click();
			Thread.sleep(500);//..........
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchksselectallchkbox()));
			logger.info(op.clickchksprintchecksdialog().getText());
			assertTrue(op.clickchksprintchecksdialog().getText().contains("Print Checks"));
			Thread.sleep(500);//..........
			op.clickchksprintcheckscancelbtn().click();
			test.log(LogStatus.INFO, "Check print Passed");
			/*	} catch (Exception e) {
			logger.error("Error in Checks Ready to Print" + e);
			test.log(LogStatus.ERROR, "Error in Checks Ready to Print");
		}*/
	}

	 //@Test(priority = 14)
	public void checksRegister() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			Thread.sleep(500);//..........
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchkscheckregistertab()));
			op.clickchkscheckregistertab().click();
			Thread.sleep(1500);
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchksselectallchkbox()));
			op.clickchksselectallchkbox().click();
			op.clickchksreprintbtn().click();
			Thread.sleep(500);//..........
			//Wait.until(ExpectedConditions.elementToBeClickable(op.clickchksprintcheckscancelbtn()));
			logger.info(op.clickchksreprintchecksdialog().getText());
			op.clickchksprintcheckscancelbtn().click();
			test.log(LogStatus.INFO, "Checks re-print Passed");
		} catch (Exception e) {
			logger.error("Error in Check Register" + e);
			test.log(LogStatus.ERROR, "Error in Check Register");
		}
	}

	 //@Test(priority = 15)
	public void voidCheck() throws IOException, InterruptedException {
		try {
			OverviewpgPO op = new OverviewpgPO(driver);
			WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'TPG']"));
			Actions act = new Actions(driver);
			act.moveToElement(frstRow).moveToElement(op.clickchksthreedotsonhover()).click().build().perform();
			Thread.sleep(500);
			op.clickchksvoidcheckbtn().click();
			op.clickchksvoidcheckdialogcancelbtn().click();
			test.log(LogStatus.INFO, "Void Check Passed");
			} catch (Exception e) {
			logger.error("Error in Check Register" + e);
			test.log(LogStatus.ERROR, "Error in Check Register");
		}
	}

	@AfterClass
	public void teardown() {
		logger.info("in tear down");
		//driver.close();
	//	report.endTest(test);
	//	report.flush();
	}

	@Parameters({"env","year"})
	@Test(priority = 1)
	public void checkLogin(String env,String year) throws IOException, InterruptedException {
		// loginNegative(env);
		// forgotPassword(env);
		loginPositive(env);
	//	checkAddWidget();
		checkSearchbtn();
	}

	@Parameters({"env","year"})
	@Test(priority = 2)
	public void checkAppointments(String env,String year) throws IOException, InterruptedException {
		//switchYear(year);
		
		createNewAppointment();
		createApptSameTime();
		updateAppointment();
		PasttimeAppointment();
		deleteAppointment();
		deleteSecondAppointment();
	}

	@Parameters({"env","year"})
	@Test(priority = 3)
	public void checkMessages(String env,String year) throws IOException, InterruptedException {
		newMessageSent();
		newMessageReply();
		deleteMessage();
	}

	@Parameters({"env","year"})
	@Test(priority = 4)
	public void testChecks(String env,String year) throws IOException, InterruptedException {
		int year_int = Integer.parseInt(year);
		if(year_int!=2019) {
		checksReadyToPrint();
		checksRegister();
		voidCheck();
		}
	}

}
