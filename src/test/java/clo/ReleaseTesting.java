package clo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
//import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class ReleaseTesting extends Base{

	public WebDriver driver;
	
	
	
	@Parameters("env")
	@BeforeMethod
	public void login(String env) throws IOException
	{
		driver=invokeBrowser(env);
		
		
		
	}
	//@Test(priority = 1)
	public void loadcobrandwebsite()
	{
		try
		{
			driver.get("https://cobrand.qa.crosslinkonline.com/");
		
		LogincloPO lp = new LogincloPO(driver);
		Assert.assertTrue(lp.getusername().isDisplayed());
		Assert.assertTrue(lp.getPassword().isDisplayed());
		Assert.assertTrue(lp.clickLogin().isDisplayed());
		}
		catch(Exception e)
		{
			System.out.println("Error" + e);
		}
	}
	//@Test(priority = 2)
	public void loadqawebsite()
	{
		try {
		driver.get("https://qa.crosslinkonline.com/#");
		LogincloPO lp = new LogincloPO(driver);
		Assert.assertTrue(lp.getusername().isDisplayed());
		Assert.assertTrue(lp.getPassword().isDisplayed());
		Assert.assertTrue(lp.clickLogin().isDisplayed());
		}
		catch(Exception e)
		{
			System.out.println("Error" + e);
		}
	}
		
	//@Test(priority = 3)
	public void loginOffice()
	{
		try
		{
			driver.get("https://cobrand.qa.crosslinkonline.com/");
		
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys("000334");
		lp.getPassword().sendKeys("P@ssword28");
		lp.clickLogin().click();
		}
		catch(Exception e)
		{
			System.out.println("Error" + e);
		}
		
	}
	
	//@Test(priority=4)
	public void loginfranchise()
	{
		driver.get("https://cobrand.qa.crosslinkonline.com/");
		// Login information
		
	}
	//@Test(priority = 5)
	public void loginpreparer()
	{
		driver.get("https://cobrand.qa.crosslinkonline.com/");
		
	}
	
	//@Test(priority = 6)
	public void receiveText() throws InterruptedException
	{
		driver.get("https://cobrand.qa.crosslinkonline.com/");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys("000334");
		lp.getPassword().sendKeys("P@ssword28");
		lp.clickLogin().click();
		lp.clicksecLogin().click();
		lp.clickconfirmationkey().sendKeys("abc");
		lp.clickthrdcontbtn().click();
		OverviewpgPO op=new OverviewpgPO(driver);
		op.clicknotificonbtn().click();//click secure msg
		op.clicknotifpreparerdpfirstlist().click();
		Thread.sleep(500);
		op.clicknotifsubject().sendKeys("Automation Test Message");
		op.clicknotifbody().sendKeys("Automation test message body");
		op.clicknotifsendbtn().click();
		assertTrue(op.clicknotifmesgsentdialog().getText().contains("The message was sent successfully."));
		test.log(LogStatus.INFO, "New Message Sent passed");
		op.clicknotifdonebtn().click();	
		
	}
	
	//@Test(priority = 7)
	public void addRegularAsset()
	{
	 	
	}
	
	//@Test(priority = 8)
	public void documentArchive()
	{
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		//if(driver!=null)
			//driver.close();
	}
	
	@AfterClass
	public void teardown()
	{
		//driver.close();
	}
}
