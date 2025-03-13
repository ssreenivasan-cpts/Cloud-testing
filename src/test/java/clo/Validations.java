package clo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.AddaReturnpgPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class Validations extends Base {
	
	public WebDriver driver;
	
	@Parameters({"env"})
	@BeforeTest
	public void login(String env) throws IOException
	{
		driver = invokeBrowser(env);
		driver.get(prop.getProperty("url"));
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.clickLogin().click();
		lp.clicksecLogin().click();
		lp.clickconfirmationkey().sendKeys("a");
		lp.clickthrdcontbtn().click();
	}
	
	
	public void openaPreparer(String env,int prepID) throws IOException, InterruptedException {
			OverviewpgPO op = new OverviewpgPO(driver);
			Reporter.log("opened a preparer-1");
			System.out.println(env);
			if(env.equalsIgnoreCase("qa")){
				//Wait.until(ExpectedConditions.elementToBeClickable(op.clickoffices()));// changed from sleep
				Thread.sleep(1000);
				op.clickoffices().click();
				test.log(LogStatus.INFO, "Clicked Offices");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(prepID == 334) {
					
					JavascriptExecutor jse = ((JavascriptExecutor) driver);
					jse.executeScript("scrollTo(0,4500);");
					Thread.sleep(500);
					op.clickviewbtnfor334().click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					op.clickpreparertab().click();
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Wait.until(ExpectedConditions.elementToBeClickable(op.clickviewprepbtn()));
					Thread.sleep(500);
					op.clickviewprepbtn().click(); 
				}
				else if(prepID == 333) {
					Thread.sleep(2000);
					op.clickviewbtnfor333().click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					op.clickpreparertab().click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Wait.until(ExpectedConditions.elementToBeClickable(op.clickviewprepbtn()));
					op.clickqaViewprepbtnfor333();
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			else if(env.equalsIgnoreCase("prod")){
				//Wait.until(ExpectedConditions.elementToBeClickable(op.clickpreparertab()));
				op.clickpreparertab().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				op.clickprodViewprepbtn().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			else if(env.equalsIgnoreCase("dev")){
				Wait.until(ExpectedConditions.elementToBeClickable(op.clickoffices()));
				op.clickoffices().click();
				//logger.info("Clicked Offices");
				test.log(LogStatus.INFO, "Clicked Offices");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				op.clickdevViewbtn().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				op.clickpreparertab().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				op.clickdevViewprepbtn().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			Thread.sleep(500);
			op.clickTaxreturns().click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(isElementPresent(op.clickNewTaxreturnsbtn()), "Add New Tax Return disabled");
			Thread.sleep(500);
			op.clickNewTaxreturnsbtn().click();
	}
	

	@Parameters({"env","year"})
	@Test(priority = 1)
	public void search(String env,String year) throws IOException, InterruptedException
	{
		openaPreparer("qa",334);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clkCloseNewRtrnbtn().click();
		AddaReturnpgPO ar = new AddaReturnpgPO(driver);
		ar.clicksearchtextbox().sendKeys("2121");
		ar.clicksearchtextbox().click();
		ar.clickfirstsearchresult().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(500);
		ar.clickallReturnsBtn().click();
		ar.clicksearchtextbox().click();
		ar.clickcancelinsearchbtn().click();
		ar.clickArrownexttoNewreturnplus().click();
		ar.clickimportmobilereturn().click();
		ar.clickcancelbtninimportmobilertrns().click();
		
		
	}
	@Parameters({"env","year"})
	@Test
	public void validateTaxreturnpage(String env,String year) throws IOException, InterruptedException
	{
		openaPreparer("qa",334);
		AddaReturnpgPO ap = new AddaReturnpgPO(driver);
		ap.clkCloseNewRtrnbtn().click();
		OverviewpgPO op = new OverviewpgPO(driver);
		op.clickfirstTaxRtrnOpenbtn().click(); //opens the first tax return
		
		
	}
	
	@Parameters({"env"})
	@AfterTest
	public void teardown()
	{
		//driver.close();
		//report.endTest(test);
		//report.flush();
	}

}
