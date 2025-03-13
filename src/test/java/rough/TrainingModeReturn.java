/**
 * 
 */
package rough;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import clo.AddaNewReturn;
import pageObjects.LogincloPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class TrainingModeReturn extends Base  {
	
	public WebDriver driver;
	Logger logger = LogManager.getLogger(getClass());
	
	@BeforeClass
	public void login() throws IOException, InterruptedException
	{
		driver = invokeBrowser("qa");
		LogincloPO lp = new LogincloPO(driver);
		//if (env.equalsIgnoreCase("qa")) {
			driver.get("https://qa.crosslinkonline.com/#");
			lp.getusername().clear();
			Thread.sleep(500);
			lp.getusername().sendKeys(prop.getProperty("username"));
			lp.getPassword().sendKeys(prop.getProperty("password"));
			lp.clickLogin().click();
			logger.info("Username and Password success");
			lp.clicksecLogin().click();
			lp.clickmarkaspublic().click();
			logger.info("URL open-Success");
			lp.clickthrdcontbtn().click();
			lp.clickcontbtnIRS().click();
			//lp.clickcanceltour().click();
			logger.info("In OverView Page");
		
	}
	
	//@Test
	public void createaReturn() throws IOException, InterruptedException
	{
	//AccountSettings as = new AccountSettings();
	//as.toggleTrainingMode();
	Thread.sleep(1000);
	AddaNewReturn an = new AddaNewReturn();
	//an.addareturn("qa");
//	as.toggleTrainingModeOff();
	}

	
}
