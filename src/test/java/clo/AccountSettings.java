package clo;

import static org.testng.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
//import com.helger.commons.base64.Base64;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class AccountSettings extends Base {
	Logger logger = LogManager.getLogger(getClass());

	public WebDriver driver;

	//@Test(priority = 15)
	public void switchYear() throws IOException, InterruptedException {
		// try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		// 2017
		Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		ap.clickswtichoptionyear2023().click();
		ap.clickswitchbtn().click();
		logger.info("switched to the year 2017");
		test.log(LogStatus.INFO, "switched to the year 2017");
		Thread.sleep(2000);
		// 2018
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		ap.clickswitchoptionyear2019().click();
		ap.clickswitchbtn().click();
		logger.info("Switched back to the year 2018");
		test.log(LogStatus.INFO, "Switched to the year 2018");
		Thread.sleep(2000);
		// 2019
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		ap.clickswitchoptionyear2020().click();
		ap.clickswitchbtn().click();
		//back to current year
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		ap.clickswitchoptionyear2022().click();
		ap.clickswitchbtn().click();
		//ap.clickswitchoptionyear2022().click();
		logger.info("Switched back to the year 2023");
		test.log(LogStatus.INFO, "Switched back to the year 2023");
	}
	/*
	 * catch(Exception e) { logger.error("Error in Switch Year" + e);
	 * test.log(LogStatus.ERROR, "Error in Switch Year"); } }
	 */

    //@Test(priority =16)
	public void changePassword() throws IOException, InterruptedException {
		try {
			AccountSettingsPO ap = new AccountSettingsPO(driver);
			Thread.sleep(2000);
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
			ap.clickaccountsdropdown().click();
			Thread.sleep(1000);
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickchangepasswordlink()));
			ap.clickchangepasswordlink().click();
			ap.clickcurrentpassword().sendKeys("P@ssword1");
			ap.clicknewpassword().sendKeys("P@ssword1");
			ap.clickretypepassword().sendKeys("P@ssword1");
			ap.clickchangepasswordbtn().click();
			logger.info("Password has been changed successfully");
			test.log(LogStatus.INFO, "Password has been changed successfully");
		} catch (Exception e) {
			logger.error("Error in Change Password" + e);
			test.log(LogStatus.ERROR, "Error in Change Password");
		}

	}

	@Test(priority = 17)
	public void changePasswordCancel() throws IOException, InterruptedException {
		// try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickchangepasswordlink()));
		ap.clickchangepasswordlink().click();
		ap.clickcurrentpassword().sendKeys("P@ssword1");
		ap.clicknewpassword().sendKeys("P@ssword4");
		ap.clickretypepassword().sendKeys("P@ssword4");
		ap.clickcancelbtn().click();
		logger.info("Change password cancelled successfully");
		test.log(LogStatus.INFO, "Change password cancelled successfully");
		/*
		 * } catch(Exception e) { logger.error("Error in Change Password Cancel" + e);
		 * test.log(LogStatus.ERROR, "Error in Change Password Cancel"); }
		 */

	}

	@Test(priority = 18)
	public void toggleTrainingMode() throws IOException, InterruptedException {
//	try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
		ap.clicktoggletrainingmodelink().click();
		logger.info("Switched to training mode");
		test.log(LogStatus.INFO, "Switched to training mode");
	}

	/*
	 * catch(Exception e) { logger.error("Error in Toggle Training Mode" + e);
	 * test.log(LogStatus.ERROR, "Error in Toggle Training Mode"); }
	 * 
	 * }
	 */
	@Test(priority = 19)
	public void toggleTrainingModeOff() throws IOException, InterruptedException {
//	try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clicktoggletrainingmodelink()));
		ap.clicktoggletrainingmodelink().click();
		logger.info("Traning Mode off");
		test.log(LogStatus.INFO, "Training Mode off");
	}

	/*
	 * catch(Exception e) { logger.error("Error in Training Mode off" + e);
	 * test.log(LogStatus.ERROR, "Error in Traning Mode off"); } }
	 */
	@Test(priority = 20)
	public void captureSignature() throws IOException, InterruptedException {
		// try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(2000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickcapturesignaturelink()));
		ap.clickcapturesignaturelink().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickupdateCaptureSign()));
		ap.clickupdateCaptureSign().click();
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		Thread.sleep(500);
		builder.moveToElement(ap.clickcapsigbox()).perform();
		builder.clickAndHold(ap.clickcapsigbox()).perform();
		builder.moveByOffset(250, 50).perform();
		builder.moveToElement(ap.clickcapsigbox()).perform();
		builder.clickAndHold(ap.clickcapsigbox()).perform();
		builder.moveByOffset(90, 15).perform();
		builder.moveToElement(ap.clickcapsigbox()).perform();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickcapsigacceptbtn()));
		ap.clickcapsigacceptbtn().click();
		// ap.clickcapsigcancelbtn().click();
		ap.clickokbtninSignUpdated().click();
		logger.info("Captured signature successfully");
		test.log(LogStatus.INFO, "Captured signature successfully");
	}

	/*
	 * catch(Exception e) { logger.error("Error in Capture Signature" + e);
	 * test.log(LogStatus.ERROR, "Capture Signature"); } }
	 */
	@Test(priority = 21)
	public void loginSettings() throws IOException, InterruptedException {
		// try {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		ap.clickloginsettingslink().click();
		logger.info(ap.clickloginsettingsgstitle().getText());
		assertTrue(ap.clickloginsettingsgstitle().getText().contains("Login Preferences"));
		ap.clickloginsetgscancelbtn().click();
		logger.info("Login settings passed");
		test.log(LogStatus.INFO, "Login settings Passed");
	}
	/*
	 * catch(Exception e) { logger.error("Error in Login Settings" + e);
	 * test.log(LogStatus.ERROR, "Login Settings"); } }
	 */

	@Test(priority = 22)
	public void officeAccountSettings() {
		AccountSettingsPO as = new AccountSettingsPO(driver);
		as.clickbreadcrumblinkforFirstOfc().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		as.clickaccountsdropdown().click();
		as.clikuserIdWallet().click();
	}
	
	@Test(priority = 23)
	public void checkImage() {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		ap.clickaccountsdropdown().click();
		ap.clikuploadImagebtnindropdown().click();
		ap.clikclickheretouploadanimagebtn().click();
		// autoit
	//	ap.clikuploadimgbtninchooseyourAvatar().click();

	}

	@Parameters("env")
	@BeforeClass
	public void login(String env) throws IOException, InterruptedException {
		driver = invokeBrowser(env);
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		// Wait.until(ExpectedConditions.elementToBeClickable(lp.getusername()));
		Thread.sleep(1000);
		lp.getusername().sendKeys("000334");// prop.getProperty("preparerlogin1")
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));// prop.getProperty("preparerpswd1")
		Thread.sleep(500);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		OverviewpgPO op = new OverviewpgPO(driver);
		Thread.sleep(2000);
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		lp.clickconfirmationkey().sendKeys("abcde");
		logger.info("Enteredconfirmation key");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		Thread.sleep(2000);
		
		op.clickdashboardBtn().click();
		//changeto23(env,2023);
		
		  AccountSettingsPO ap = new AccountSettingsPO(driver);
		  Wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		  Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		  ap.clickaccountsdropdown().click();
		  Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		  ap.clickswitchlink().click(); // Thread.sleep(1000); 
		  Wait = new WebDriverWait(driver,Duration.ofSeconds(05));
		  Wait.until(ExpectedConditions.elementToBeClickable(ap.
		  clickswitchselectyeardropdown()));
		  ap.clickswitchselectyeardropdown().click();
		  ap.clickswitchbtn().click();
		  Thread.sleep(2000);
		 

	}

	@Test(priority = 15)
	public void changeto23(String env,int year) throws InterruptedException, IOException
	{
			  
		  test.log(LogStatus.INFO, "opened a preparer"); AddaReturnpgPO ap = new
		  AddaReturnpgPO(driver); ap.clkCloseNewRtrnbtn().click(); 
		  switchYear(year);
		  OverviewpgPO op = new OverviewpgPO(driver);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Thread.sleep(1000); op.clickdashboardBtn().click(); openaPreparer(env, 334);
		  switchYear(year);
		 
	}
	


public void switchYear(int year) throws IOException, InterruptedException {
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		Thread.sleep(500);
		ap.clickaccountsdropdown().click();
		Thread.sleep(500);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
	//	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
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
			test.log(LogStatus.INFO,"switched to the year 2018");
			break;
		case 2019:
			ap.clickswitchoptionyear2019().click();
			logger.info("switched to the year 2019");
			test.log(LogStatus.INFO,"switched to the year 2019");
			break;
		case 2020: 
			ap.clickswitchoptionyear2020().click();
			logger.info("switched to the year 2020");
			test.log(LogStatus.INFO,"switched to the year 2020");
			break;
		case 2021: 
			ap.clickswitchoptionyear2021().click();
			logger.info("switched to the year 2021");
			test.log(LogStatus.INFO,"switched to the year 2021");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ap.clickswitchbtn().click();
		
	}

	public void testQRcode(String env,String year) {
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();	   
		String qrCodeImage = driver.findElement(By.xpath("//img[@class='qr-code']")).getAttribute("src");
		
		  String qrCodeResult = decodeQRCode(qrCodeImage);
	    //BufferedImage bufferedImage = ImageIO.read(qrCodeImage);
	   // LuminanceSource source = new LuminanceSource(bufferedImage);
	  //  BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

	  //  Result result = new MultiFormatReader().decode(bitmap);
	   // return result.getText();
	
		
	}

	 private static String decodeQRCode(Object qrCodeImage) {
	        Result result = null;

	        try {
	            BufferedImage bufferedImage;

	            // if not (probably it is a URL
	            if (((String) qrCodeImage).contains("http")) {
	                bufferedImage = ImageIO.read((new URL((String)qrCodeImage)));

	                // if is a Base64 String
	            } else {
	             //   byte[] decoded = Base64.decode((String)qrCodeImage);
	              //  bufferedImage = ImageIO.read(new ByteArrayInputStream(decoded));
	            }

	          //  LuminanceSource source = new LuminanceSource(bufferedImage);
	          //  BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

	         //   result = new MultiFormatReader().decode(bitmap);
	        } catch (Exception e) {
	          //  log.error("Error reading the QR Code", e);
	        }
	        return result.getText();
	    }

	@AfterClass
	public void teardown() {
		logger.info("in tear down");
		// driver.close();
		// report.endTest(test);
		// report.flush();
	}

}