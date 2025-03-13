package clo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AccountSettingsPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.TaxreturnBarPO;
import resources.Base;

public class SSBaccountsettings extends Base {
	
	Logger logger= LogManager.getLogger(getClass());
	public WebDriver driver;
	
	
	@Parameters("env")
	@BeforeClass
	public void login(String env) throws IOException, InterruptedException 
	{
		driver= invokeBrowser(env);
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		OverviewpgPO op = new OverviewpgPO(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(1000);
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		//lp.clickmarkaspublic().click();
		lp.clickconfirmationkey().sendKeys("abcde");
		logger.info("Entered confrmation key");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  	op.clickdashboardBtn().click();
	
	}
	
	public void click(WebElement locator)
	{
		locator.click();
		//test.log(LogStatus.INFO, "click success: " + locator.getText() );
	}
	
	public void type(WebElement locator,String value)
	{
		locator.sendKeys(value);
		test.log(LogStatus.INFO, "Entered Value " + locator.getText());
	}
	
	@Test(priority=1)
	public void setup() throws InterruptedException	{
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ap.clickaccountsettingsbtn().click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		ap.clickcreatenewLogin().click();
		type(ap.getusernameinaddnewlogin(),"TestLogin");
		type(ap.getdisplayNameinAddnewlogin(),"TestLogin");
		type(ap.getemailinAddnewlogin(),"ssreenivasan@crosslinktax.com");
		type(ap.getconfirmemailinAddnewlogin(),"ssreenivasan@crosslinktax.com");
		click(ap.getaccesslevelinAddnewlogin());
		click(ap.getprepinaccesslevel());
		click(ap.getsaveinAddnewlogin());
		click(ap.clikdoneincreateloginerror());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		click(ap.clikcancelinAddnewlogin());
		click(ap.clikcancelbtninSettingsProfile());
	}
	
	//@Test(priority=2)
	public void overviewPage() throws InterruptedException {
		//clickSearch();
		help();
	}
	
	public void clickSearch()
	{
		AccountSettingsPO as=new AccountSettingsPO(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.cliksearchbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikcancelinsearchbtn());
	}
	
	public void help() throws InterruptedException {
		
		AccountSettingsPO as=new AccountSettingsPO(driver);
		click(as.clikhelpbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikgettoknowthisLink());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click(as.clikstartedNextbtn());
		as.clikstartedNextbtn().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(500);
		//click(as.clikstartedNextbtn());
		as.clikstartedNextbtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click(as.clikstartedNextbtn());
		as.clikstartedNextbtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(500);
		as.clikstartedNextbtn().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikstartedNextbtn());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clikdonebtninHelp());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(as.clickaccountsdropdown());
		
	}
	
	@Test
	public void editTechPhoneNumber()
	{
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		ap.clickaccountsettingsbtn().click();
		ap.clikcobrandingbtn().click();
		ap.cliktechsupportnumber().clear();
		ap.cliktechsupportnumber().sendKeys("8005553434");
		ap.cliksavetechsupportnumbr().click();
		ap.cliksaveandnextbtnincobranding().click();
		//goes to manage licence
		//Assert.assertTrue(ap.cliktoggleofclicencemgmgt().isEnabled());
		//click all the previous button
		
		}
	
	@Test
	public void testaccessLevels()
	{
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		ap.clickaccountsettingsbtn().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ap.clickaddNewALbtn().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ap.clicksavebtn_addnew_AL().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ap.clickcancelbtn_addnew_AL().click();	
	}
	
	

}
