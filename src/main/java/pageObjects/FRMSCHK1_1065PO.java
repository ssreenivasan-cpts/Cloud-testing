package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FRMSCHK1_1065PO {
	
	public WebDriver driver;
	public FRMSCHK1_1065PO(WebDriver driver) {
		this.driver=driver;
	}
	
	By patnershipEIN_A = By.id("004000");
	By patnershipName_B = By.id("003000");
	By patnershipAddress = By.id("005000");
	By patnershipZipcode = By.id("009000");
	By irsCenter_C = By.id("015000");
	By residentStatecode = By.id("995000");
	By materialParticipation_Yes = By.id("XXB100");
	By activeParticipatein2019_No = By.id("013000");
	By DomesticPatner_H1 = By.id("018000");
	By profitBeggining = By.id("023000");
	By profitEnding = By.id("024000");
	By lossBeggining = By.id("025000");
	By lossEnding = By.id("026000");
	By capitalBeggining = By.id("027000");
	By capitalEnding = By.id("028000");
	By nonrecourseBeggining_K = By.id("028700");
	By begginingCapitalAccnt_L = By.id("086500");
	By currentyrNetIncome = By.id("087500");
	By withdrawals = By.id("088000");
	By endingCapitalAccnt = By.id("088500");
	By M_No = By.id("902000");
	By part3_1 = By.id("039000");
	By part3_10 = By.id("051000");
	By part3_16A = By.id("DA0300");
	By part3_countryAbbreviation = By.id("DB0300");
	By part3_16B = By.id("DA0400");
	By part3_16B_Amount = By.id("DB0400");
	By part3_16F = By.id("DA0500");
	By part3_16F_Amount = By.id("DB0500");
	By part3_16G = By.id("DA0600");
	By part3_16G_Amount = By.id("DB0600");
	By part3_19A = By.id("EA0300");
	By part3_19_Amount = By.id("EB0300");
	
	public WebElement getpatnershipEIN_A()
	{
		return driver.findElement(patnershipEIN_A);
	}
	public WebElement getpatnershipName_B()
	{
		return driver.findElement(patnershipName_B);
	}
	public WebElement getpatnershipAddress()
	{
		return driver.findElement(patnershipAddress);
	}
	public WebElement getpatnershipZipcode()
	{
		return driver.findElement(patnershipZipcode);
	}
	public WebElement getirsCenter_C()
	{
		return driver.findElement(irsCenter_C);
	}
	public WebElement getresidentStatecode()
	{
		return driver.findElement(residentStatecode);
	}
	public WebElement getmaterialParticipation_Yes()
	{
		return driver.findElement(materialParticipation_Yes);
	}
	public WebElement getactiveParticipatein2019_No()
	{
		return driver.findElement(activeParticipatein2019_No);
	}
	public WebElement getDomesticPatner_H1()
	{
		return driver.findElement(DomesticPatner_H1);
	}
	public WebElement getprofitBeggining()
	{
		return driver.findElement(profitBeggining);
	}
	public WebElement getprofitEnding()
	{
		return driver.findElement(profitEnding);
	}
	public WebElement getlossBeggining()
	{
		return driver.findElement(lossBeggining);
	}
	public WebElement getlossEnding()
	{
		return driver.findElement(lossEnding);
	}
	public WebElement getcapitalEnding()
	{
		return driver.findElement(capitalEnding);
	}
	public WebElement getcapitalBeggining()
	{
		return driver.findElement(capitalBeggining);
	}
	public WebElement getnonrecourseBeggining_K()
	{
		return driver.findElement(nonrecourseBeggining_K);
	}
	public WebElement getbegginingCapitalAccnt_L()
	{
		return driver.findElement(begginingCapitalAccnt_L);
	}
	public WebElement getcurrentyrNetIncome()
	{
		return driver.findElement(currentyrNetIncome);
	}
	public WebElement getwithdrawals()
	{
		return driver.findElement(withdrawals);
	}
	public WebElement getendingCapitalAccnt()
	{
		return driver.findElement(endingCapitalAccnt);
	}
	public WebElement getpart3_10()
	{
		return driver.findElement(part3_10);
	}
	public WebElement getpart3_1()
	{
		return driver.findElement(part3_1);
	}
	public WebElement getpart3_16A()
	{
		return driver.findElement(part3_16A);
	}
	public WebElement getpart3_countryAbbreviation()
	{
		return driver.findElement(part3_countryAbbreviation);
	}
	public WebElement getpart3_16B()
	{
		return driver.findElement(part3_16B);
	}
	public WebElement getpart3_16B_Amount()
	{
		return driver.findElement(part3_16B_Amount);
	}
	public WebElement getpart3_16F()
	{
		return driver.findElement(part3_16F);
	}
	public WebElement getpart3_16F_Amount()
	{
		return driver.findElement(part3_16F_Amount);
	}
	public WebElement getM_No()
	{
		return driver.findElement(M_No);
	}
	public WebElement getpart3_16G()
	{
		return driver.findElement(part3_16G);
	}
	public WebElement getpart3_16G_Amount()
	{
		return driver.findElement(part3_16G_Amount);
	}
	public WebElement getpart3_19A()
	{
		return driver.findElement(part3_19A);
	}
	public WebElement getpart3_19_Amount()
	{
		return driver.findElement(part3_19_Amount);
	}

}
