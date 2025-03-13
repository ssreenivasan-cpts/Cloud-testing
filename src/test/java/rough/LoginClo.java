/**
 * 
 */
package rough;

import java.io.IOException;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObjects.LogincloPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class LoginClo extends Base {
	
	public WebDriver driver;

	//@Test
	public WebDriver openHomePage() throws IOException
	{
		//*************change this before running
		//driver = invokeBrowser();
		driver.get("https://qa.crosslinkonline.com/#");
		//driver.get(prop.getProperty("url"));
		//create a obj for logincloPO 
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.clickLogin().click();
		lp.clicksecLogin().click();
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
		lp.clickcontbtnIRS().click();
		lp.clickcanceltour().click();
		return driver;
	
		
	}
	
	@Test
	public void testOTP() throws IOException, InterruptedException
	{
		//driver = invokeBrowser("prod");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome(); -- error when upgraded to sel 4.
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//driver=new ChromeDriver(capabilities);
		driver.get("https://crosslinkonline.com/");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys("autotest");
		lp.getPassword().sendKeys("P@ssword3");
		lp.clickLogin().click();
		Thread.sleep(1000);
		//Wait.until(ExpectedConditions.elementToBeClickable(lp.clicksecLogin()));
		lp.clicksecLogin().click();
		WebElement confirmkey =driver.findElement(By.id("txtConfirmKey"));
				//By.xpath("//*[@id=\"mfaEnterCodeContainer\"]/div/div/div[2]/form/div[2]/div/input"));
		String otpKeyStr = "7XZ43POG3SJY54TD";
		Totp totp = new Totp(otpKeyStr);
		String twoFcode = totp.now();
		confirmkey.sendKeys(twoFcode);
		//Wait.until(ExpectedConditions.elementToBeClickable(lp.clickmarkaspublic()));
		Thread.sleep(1000);
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
		lp.clickmarkaspublic().click();
		lp.clickthrdcontbtn().click();
	}
	
	
	

}
