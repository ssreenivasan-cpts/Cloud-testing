/**
 * 
 */
package rough;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import pageObjects.PreparerinCompleteSetupPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class DeleteaPreparer extends Base {
	
	public WebDriver driver;
	Logger logger= LogManager.getLogger(getClass());
	
	@Test
	public void newPrep()
	{
		try {
			logger.info("In adding a new prep test case");
			OverviewpgPO op = new OverviewpgPO(driver);
			//op.clickCreateNewPrep().click();
			logger.info("Clicked New preparer button");
			Thread.sleep(1000);
			PreparerinCompleteSetupPO pc= new PreparerinCompleteSetupPO(driver);
			pc.clickDelete_btnexecuteaction3().click();
			logger.info("Preparer Deleted");
			pc.clickClosebtn().click();
			logger.info("Closing the setup.Going to Overview page");
			Thread.sleep(1000);	
		} catch (Exception e) {
			logger.error("Error " + e);
		}
	}
	
	@BeforeClass
	public void login() throws IOException
	{
		//*************change this before running
		//driver= invokeBrowser();
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("preparerlogin"));
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));
		lp.clickLogin().click();
		logger.info("Username and Password success");
		lp.clicksecLogin().click();
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
		lp.clickcontbtnIRS().click();
		lp.clickcanceltour().click();
		logger.info("In OverView Page");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
