/**
 * 
 */
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ssreenivasan
 *
 */
//all the page objects in Login page
public class LogincloPO {
	
	public WebDriver driver;//driver has no life
	//to give life to driver,create a constructor
		public LogincloPO(WebDriver driver) {
			this.driver=driver;
		}
	//By is a locator
	//objects at the top
	By username = By.id("txtUsernameLogin");
	By password = By.id("txtPasswordLogin");
	By loginbtn = By.id("btnLoginButtonLogin");
	By rememberPassword = By.id("chkRememberMeLogin");
	By seccontbtn = By.id("btnContinueMFAMethod"); 
	By markaspublic = By.id("markAsPublic");
	By confirmationkey = By.id("txtConfirmKey");
	By pwdexpireCancelbtn =By.id("btnCancelDialog");
	By verificationCode = By.xpath("//*[@id=\"mfaEnterCodeContainer\"]/div/div/div[2]/form/div[2]/div/input");
			//*[@id='loginContainer']/div/div/div[2]/form/div[2]/div/input");
			//("//input[@type='text'])[0]");
	By deviceLabel = By.id("txtDevLabelMFA");
	By thrdcontbtn = By.id("btnContinueMFACODE");
	By contbtnIRS = By.id("btnContinueIRSMessage");
	By canceltour = By.id("btnStartTour");
	By forgotpasswordbtn = By.id("divForgotPassLogin");//added 4/9
	By sendcodebtn = By.id("btnSendCodeFP");//added 4/9
	By fpusername = By.id("txtUsernameFP");//added 4/9 - username field for forgot password
	
	public WebElement getusername()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement clickrememberPassword()
	{
		return driver.findElement(rememberPassword);
	}
	public WebElement clickLogin()
	{
		return driver.findElement(loginbtn);
	}
	public WebElement clicksecLogin()
	{
		return driver.findElement(seccontbtn);
	}
	public WebElement clickpwdexpireCancelbtn()
	{
		return driver.findElement(pwdexpireCancelbtn);
	}
	public WebElement clickmarkaspublic()
	{
		return driver.findElement(markaspublic);
	}
	public WebElement clickconfirmationkey()
	{
		return driver.findElement(confirmationkey);
	}
	public WebElement getverificationCode()
	{
		return driver.findElement(verificationCode);
	}
	public WebElement getdeviceLabel()
	{
		return driver.findElement(deviceLabel);
	}
	public WebElement clickthrdcontbtn()
	{
		return driver.findElement(thrdcontbtn);
	}
	public WebElement clickcontbtnIRS()
	{
		return driver.findElement(contbtnIRS);
	}
	public WebElement clickcanceltour()
	{
		return driver.findElement(canceltour);
	}
	public WebElement clickforgotpassword()
	{
		return driver.findElement(forgotpasswordbtn);
	}
	public WebElement clicksendcodebtn()
	{
		return driver.findElement(sendcodebtn);
	}
	public WebElement getfpusername()
	{
		return driver.findElement(fpusername);
	}
	public WebElement clickfpusername()
	{
		return driver.findElement(fpusername);
	}
	
}
