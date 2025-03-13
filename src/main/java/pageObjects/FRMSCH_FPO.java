package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FRMSCH_FPO {
	
	public WebDriver driver;
	public FRMSCH_FPO(WebDriver driver) {
		this.driver=driver;
	}
	
	By activity_A = By.id("003000");
	By activitycode_B = By.id("004000");
	By cash_C = By.id("005000");
	By E_yes = By.id("010000");
	By F_No = By.id("012500");
	By QBIindicator = By.id("880000");
	By part1_1b = By.id("015000");
	By part11_28 = By.id("051000");
	By part1_1a = By.id("014300");
	
	
	public WebElement getactivity_A()
	{
		return driver.findElement(activity_A);
	}
	public WebElement getactivitycode_B()
	{
		return driver.findElement(activitycode_B);
	}
	public WebElement getcash_C()
	{
		return driver.findElement(cash_C);
	}
	public WebElement getE_yes()
	{
		return driver.findElement(E_yes);
	}
	public WebElement getF_No()
	{
		return driver.findElement(F_No);
	}
	public WebElement getQBIindicator()
	{
		return driver.findElement(QBIindicator);
	}
	public WebElement getpart1_1b()
	{
		return driver.findElement(part1_1b);
	}
	public WebElement getpart11_28()
	{
		return driver.findElement(part11_28);
	}
	public WebElement getpart1_1a()
	{
		return driver.findElement(part1_1a);
	}
	

}
