/**
 * 
 */
package clo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.FRMW2PO;
import pageObjects.InterviewModePO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class InterviewMode extends Base {
	
	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
	
	@Test
	public void getStarted() throws InterruptedException
	{
		InterviewModePO im = new InterviewModePO(driver);
		im.clickinterviewicon().click();
		im.clickintvmarriedicon().click();
		im.clickintvaddTPW2frmbtn().click();
		im.clickintvhadchldicon().click();
		im.clickintviconpgNextbtn().click();
		//---------
		im.clickintvMFJbox().click();
		im.clickintvFSpgNextbtn_19().click();
		//
		im.getintvTPfirstname().sendKeys("AUTO");
		im.getintvTPlastname().sendKeys("Lastname");
		im.getintvTPdob().sendKeys("04041978");
		im.getintvTPoccupation().sendKeys("Manager");
		im.getintvTPhomeph().sendKeys("6103055825");
		im.getintvSPfirstname().sendKeys("Spouse");
		im.getintvSPlastname().sendKeys("Lastname");
		im.getintvSPdob().sendKeys("05121982");
		im.getintvSPoccupation().sendKeys("HomeMaker");
		im.clickintvperinfopgNextbtn18().click();//next btn for 2018
		//
		im.getintvusaddress().sendKeys("12 leo st");
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
		//take screenshot
		String path = TakeScreenshot();
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.PASS, "Took screen shot", imagePath);
		im.clickintvdepspgNextbtn().click();
		//
		im.clickintvaddTPW2frmbtn().click();
		FRMW2PO w2=new FRMW2PO(driver);
		w2.getwages().sendKeys("25000");
		w2.getFedtax().sendKeys("5000");
		//address?
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
		String path1 = TakeScreenshot();
		String imagePath1 = test.addScreenCapture(path1);
		
		}


@BeforeClass
public void login() throws IOException, InterruptedException
{
	driver= invokeBrowser("qa");
	driver.get(prop.getProperty("url"));
	logger.info("URL open-Success");
	LogincloPO lp = new LogincloPO(driver);
	lp.getusername().sendKeys("qassbadmin");
			//prop.getProperty("preparerlogin1"));
	lp.getPassword().sendKeys("P@ssword1");
			//prop.getProperty("preparerpswd1"));
	Thread.sleep(1000);
	lp.clickLogin().click();
	logger.info("Username and Password success");
	OverviewpgPO op = new OverviewpgPO(driver);
	//Thread.sleep(1000);-----------------1st change
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//WebDriverWait wait = new WebDriverWait(driver,10);
	//wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
	lp.clicksecLogin().click();
	logger.info("clicked secLogin");
	lp.clickmarkaspublic().click();
	logger.info("Clicked markaspublic");
	lp.clickthrdcontbtn().click();
	logger.info("clicked thirdcontbtn");
	Thread.sleep(2000);
    op.clickoverview().click();
}


@AfterClass
public void teardown()
{
 logger.info("in tear down");
	//driver.close();
	report.endTest(test);
	report.flush();
} 
}


