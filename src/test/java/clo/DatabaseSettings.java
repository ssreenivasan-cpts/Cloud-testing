package clo;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.AccountSettingsPO;
import pageObjects.AddaReturnpgPO;
import pageObjects.DatabaseSettingsPO;
import pageObjects.LogincloPO;
import pageObjects.OverviewpgPO;
import resources.Base;

public class DatabaseSettings extends Base {
	Logger logger= LogManager.getLogger(getClass());
	public WebDriver driver;
	
	@Test(priority =22)
	public void dbAddCity() throws IOException, InterruptedException
	{
		
		  //Thread.sleep(1000);
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		goToDatabase();
		Thread.sleep(500);
		dp.clickcitieszipcodeslink().click();
		dp.clickaddnewbtn().click();
		dp.clickcitieszipcodetxtbox().sendKeys("12345");
		dp.clickcitiescitytxtbox().sendKeys("Test City");
		dp.clickcitiesstatecodetxtbox().sendKeys("CA");
		dp.clickcitiesaddbtn().click();
		//Thread.sleep(1000);
		//dp.clicksearchfield().sendKeys("12345");
		//WebElement testzip = driver.findElement(By.xpath("//tr/td[text() = '12345']"));
		//assertTrue(testzip.contains("12345"));
		//System.out.println("New city added");
		logger.info("New city added");
		test.log(LogStatus.INFO,"New city added");
		}
	
		
	
	@Test(priority = 23)
	public void dbEditCity() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickcitieszipcodetxtbox().clear();
		dp.clickcitieszipcodetxtbox().sendKeys("12346");
		dp.clickcitiescitytxtbox().clear();
		dp.clickcitiescitytxtbox().sendKeys("Test City Edited");
		Thread.sleep(1000);
		dp.clickcitiesaddbtn().click();
		logger.info("City Edited Sucessfully");
		test.log(LogStatus.INFO,"City Edited Sucessfully");
			}
	
	@Test(priority = 24)
	public void dbDeleteCity() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		//dp.clickdatabaseclosebtn().click();
		//switchto2018();
		//goToDatabase();
		dp.clickcitieszipcodeslink().click();
		//dp.getfirstTestCityAdded().getText().compareTo("TEST CITY EDITED,CA");
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("City Deleted Successfully");
		test.log(LogStatus.INFO,"City Deleted Successfully");
		}
	
	private void switchto2018() throws InterruptedException {
			AccountSettingsPO ap = new AccountSettingsPO(driver);
			Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//	Thread.sleep(2000);
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
			ap.clickaccountsdropdown().click();
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
			ap.clickswitchlink().click();
			Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
			ap.clickswitchselectyeardropdown().click();
			ap.clickswitchoptionyear2018().click();
			ap.clickswitchbtn().click();
			logger.info("Switched back to the year 2018");
			test.log(LogStatus.INFO,"Switched back to the year 2018");
			}
	
	private void switchto2019() throws InterruptedException {
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		ap.clickaccountsdropdown().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
		Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		ap.clickswitchoptionyear2019().click();
		ap.clickswitchbtn().click();
		logger.info("Switched back to the year 2019");
		test.log(LogStatus.INFO,"Switched back to the year 2019");
		}
	private void goToDatabase() throws InterruptedException
	{
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);
		Thread.sleep(1000);
		//ap.clickaccountsdropdown().click(); //notworking
		//Thread.sleep(1000);
	//	dp.clickdatabaselink().click();
		ap.clickaccountsettingsbtn().click();
		ap.clickdbsettingsbtn().click();
		
	}
	
	@Test(priority = 25)
	public void dbaddEmployer() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickemployerspayerslink().click();
		dp.clickaddnewbtn().click();
		dp.clickempfederaleintxtbx().sendKeys("111111111");
		dp.clickempnamecontroltxtbx().sendKeys("Test");
		dp.clickempcompanyname().sendKeys("Automation company");
		dp.clickempcompanyaddress().sendKeys("7575 Linne Rd");
		dp.clickempcitytxtbx().sendKeys("Tracy");
		dp.clickempstatetxtbx().click();
		dp.clickempCAstatetxtbx().click();
		dp.clickempzipcodetxtbx().sendKeys("95304");
		dp.clickempstate1identftxtbx().sendKeys("123456789");
		dp.clickempsavebtn().click();
		//System.out.println(" New Employer added Successfully");
		logger.info("New Employer added Successfully");
		test.log(LogStatus.INFO,"New Employer added Successfully");
		
	}
	
	@Test(priority = 26)
	public void dbeditEmployer() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickempfederaleintxtbx().clear();
		dp.clickempfederaleintxtbx().sendKeys("111111112");
		dp.clickempnamecontroltxtbx().clear();
		dp.clickempnamecontroltxtbx().sendKeys("TestUpdated");
		dp.clickempcompanyname().clear();
		dp.clickempcompanyname().sendKeys("Automation company Update");
		dp.clickempcompanyaddress().clear();
		dp.clickempcompanyaddress().sendKeys("7576 Linne Rd");
		dp.clickempcitytxtbx().sendKeys("Tracy");
		dp.clickempstatetxtbx().click();
		dp.clickempCAstatetxtbx().click();
		dp.clickempzipcodetxtbx().sendKeys("95304");
		dp.clickempsavebtn().click();
		logger.info("New Employer Editted Successfully");
		test.log(LogStatus.INFO,"New Employer Editted Successfully");
		
	}
	
	@Test(priority = 27)
	public void dbDeleteEmployer() throws IOException, InterruptedException
	{
	
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2019();
		goToDatabase();*/
		dp.clickemployerspayerslink().click();
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Employer Deleted Successfully");
		test.log(LogStatus.INFO,"Employer Deleted Successfully");
		
}
	
	@Test(priority = 28)
	public void dbaddCareProvider() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickcareproviderslink().click();
		dp.clickaddnewbtn().click();
		dp.clickprovidercode().sendKeys("11111111");
		dp.clickprovidertype().sendKeys("Test type");
		dp.clickprovidernamecontrol().sendKeys("Proctrl");
		dp.clickcareprovidername().sendKeys("Test Careprovider");   
		dp.clickcareproviderphnum().sendKeys("2098857252");
		dp.clickprovideradd().sendKeys("128 Indigo dr");
		dp.clickprovidercity().sendKeys("Mountain House");
		dp.clickproviderstate().click();
		dp.clickproviderCAstate().click();
		dp.clickproviderzipcode().sendKeys("95391");
		dp.clickprovidersavebtn().click();
		logger.info("New Care provider added successfully");
		test.log(LogStatus.INFO,"New Care provider added successfully");
		
		}
	
	@Test(priority = 29)
	public void dbeditCareProvider() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickprovidercode().clear();
		dp.clickprovidercode().sendKeys("11111112");
		dp.clickcareprovidername().clear();
		dp.clickcareprovidername().sendKeys("NameUpdated Careprovider");
		dp.clickprovideradd().sendKeys("128 ritta dr");
		dp.clickprovidercity().sendKeys("Mountain House");
		dp.clickproviderstate().click();
		dp.clickproviderCAstate().click();
		dp.clickproviderzipcode().sendKeys("95391");
		dp.clickprovidersavebtn().click();
		logger.info("Care provider editted successfully");
		test.log(LogStatus.INFO,"Care provider editted successfully");
		
		}
		
	@Test(priority = 30)
	public void dbDeleteCareProvider() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2018();
		goToDatabase();*/
		dp.clickcareproviderslink().click();
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		//dp.clickthreedots().click();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		//dp.clickcitiesdeletebtn().click();
		//assertTrue(dp.clickcitiesdeltitle().getText().contains("Test City Edited,CA"));
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Care Provider Deleted Successfully");
		test.log(LogStatus.INFO,"Care Provider Deleted Successfully");
		
	}
		
	@Test(priority = 31)
	public void dbaddReferrals() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickreferralslink().click();
		dp.clickaddnewbtn().click();
		dp.clickreferralsname().sendKeys("12345");
		dp.clickreferralsaddbtn().click();
		logger.info("Refferrals added successfully");
		test.log(LogStatus.INFO,"Refferrals added successfully");
	}
	
	//@Test(priority = 32)
	public void dbeditReferrals() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickreferralsname().clear();
		dp.clickreferralsname().sendKeys("12354");
		dp.clickreferralsaddbtn().click();
		logger.info(" Refferrals editted successfully");
		test.log(LogStatus.INFO,"Refferrals editted successfully");
		
	}
	
	@Test(priority = 33)
	public void dbDeleteReferrals() throws IOException, InterruptedException
	{
	
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2019();
		goToDatabase();*/
		dp.clickreferralslink().click();
		//WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'Test City Edited,CA']"));
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		//dp.clickthreedots().click();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		//dp.clickcitiesdeletebtn().click();
		//assertTrue(dp.clickcitiesdeltitle().getText().contains("Test City Edited,CA"));
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		//WebElement donebtn = driver.findElement(By.id("btnHideSettingsError"));
		
		/*if(donebtn.isDisplayed())
		{
			donebtn.click();
		}*/
		logger.info(" Referrals Deleted Successfully");
		test.log(LogStatus.INFO,"Referrals Deleted Successfully");
	
	}

	@Test(priority = 34)
	public void dbaddDonee() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickdoneelink().click();
		dp.clickaddnewbtn().click();
		dp.clickdoneeein().sendKeys("11111111");
		dp.clickdoneename().sendKeys("Automation Donee");
		dp.clickdoneeadd().sendKeys("1111 Test Street");
		dp.clickdoneecity().sendKeys("Test City");
		dp.clickdoneestate().click();
		dp.clickdoneeCAstate().click();
		dp.clickdoneezipcode().sendKeys("91119");
		dp.clickdoneesavebtn().click();
		logger.info(" Donee added successfully");
		test.log(LogStatus.INFO,"Donee added successfully");
		
	}
	
	@Test(priority = 35)
	public void dbeditDonee() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickdoneeein().clear();
		dp.clickdoneeein().sendKeys("111111112");
		dp.clickdoneename().clear();
		dp.clickdoneename().sendKeys("Updated Automation Donee");
		dp.clickdoneeadd().clear();
		dp.clickdoneeadd().sendKeys("1111 Updated Street");
		dp.clickdoneecity().clear();
		dp.clickdoneecity().sendKeys("Updated City");
		dp.clickdoneestate().click();
		dp.clickdoneeCAstate().click();
		dp.clickdoneezipcode().sendKeys("91119");
		dp.clickdoneesavebtn().click();
		logger.info(" Donee editted successfully");
		test.log(LogStatus.INFO,"Donee editted successfully");
		
	}
	
	@Test(priority = 36)
	public void dbDeleteDonee() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2018();
		goToDatabase();*/
		dp.clickdoneelink().click();
		//WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'Test City Edited,CA']"));
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		//dp.clickthreedots().click();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		//WebElement delbtn = driver.findElement(By.xpath("//*[@id='action-menu']/div[2]/ul/li/text())"));
		//dp.clickcitiesdeletebtn().click();
		//assertTrue(dp.clickcitiesdeltitle().getText().contains("Test City Edited,CA"));
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info(" Donee Deleted Successfully");
		test.log(LogStatus.INFO,"Donee Deleted Successfully");
		
	}
	
	@Test(priority = 37)
	public void dbaddBankRTN() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickbankrtnslink().click();
		dp.clickaddnewbtn().click();
		dp.clickbankrtn().sendKeys("000111111111");
		dp.clickbankname().sendKeys("Automation Bank");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dp.clickbanksavebtn().click();
		logger.info(" Bank RTN added successfully");
		test.log(LogStatus.INFO,"Bank RTN added successfully");
	}
	
	@Test(priority = 38)
	public void dbeditBankRTN() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickbankrtn().clear();
		dp.clickbankrtn().sendKeys("111111112");
		dp.clickbankname().clear();
		dp.clickbankname().sendKeys("Updated Bank");
		dp.clickbanksavebtn().click();
		logger.info(" Bank RTN editted successfully");
		test.log(LogStatus.INFO,"Bank RTN editted successfully");
	
	}
	
	@Test(priority = 39)
	public void dbDeleteBankRTN() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2019();
		goToDatabase();*/
		dp.clickbankrtnslink().click();
		//WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'Test City Edited,CA']"));
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		//dp.clickthreedots().click();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		//WebElement delbtn = driver.findElement(By.xpath("//*[@id='action-menu']/div[2]/ul/li/text())"));
		//dp.clickcitiesdeletebtn().click();
		//assertTrue(dp.clickcitiesdeltitle().getText().contains("Test City Edited,CA"));
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Bank RTN Deleted Successfully");
		test.log(LogStatus.INFO,"Bank RTN Deleted Successfully");
		
	}
		
	@Test(priority = 40)
	public void dbaddOccupations() throws IOException, InterruptedException
	{
		
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickoccupationslink().click();
		dp.clickaddnewbtn().click();
		dp.clickoccupationname().sendKeys("Automation Occupation");
		dp.clickoccupationaddbtn().click();
		logger.info("New Occupation added successfully");
		test.log(LogStatus.INFO,"New Occupation added successfully");
 
	}
	
	@Test(priority = 41)
	public void dbeditOccupations() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickoccupationname().clear();
		dp.clickoccupationname().sendKeys("Automation Occupation");
		dp.clickoccupationaddbtn().click();
		logger.info("Occupation  editted successfully");
		test.log(LogStatus.INFO,"Occupation  editted successfully");
	}	
	
	
	@Test(priority = 42)
	public void dbDeleteOccupations() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		/*dp.clickdatabaseclosebtn().click();
		switchto2018();
		goToDatabase();*/
		dp.clickoccupationslink().click();
		//WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'Test City Edited,CA']"));
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Occupations Deleted Successfully");
		test.log(LogStatus.INFO,"Occupations Deleted Successfully");

	}
		
	@Test(priority = 43)
	public void dbaddSiteIdentifiers() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clicksiteidentifierlink().click();
		dp.clickaddnewbtn().click();
		dp.getsitecode().sendKeys("AAACODE");
		dp.getsitedescription().sendKeys("Automation");
		dp.clicksiteidentifieraddbtn().click();
		logger.info("New Site Identifier added successfully");
		test.log(LogStatus.INFO,"New Site Identifier added successfully");
		
	}
	
	@Test(priority = 44)
	public void dbeditSiteIdentifiers() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clicksiteidentifierlink().click();
		dp.clickeditbtn().click();
		dp.getsitecode().clear();
		dp.getsitecode().sendKeys("AAAedited");
		dp.getsitedescription().sendKeys("Edited");
		dp.clicksiteidentifieraddbtn().click();
		logger.info("New Site Identifier edited successfully");
		test.log(LogStatus.INFO,"New Site Identifier added successfully");
		
	}
	@Test(priority = 45)
	public void dbdeleteSiteIdentifiers() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clicksiteidentifierlink().click();
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Occupations Deleted Successfully");
		test.log(LogStatus.INFO,"Occupations Deleted Successfully");
	}
	@Test(priority = 46)
	public void dbaddUserStatusCode() throws InterruptedException 
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		dp.clickuserstatuscodelink().click();
		dp.clickaddnewbtn().click();
		dp.clickuserstatuscodetxtbox().sendKeys("11111");
		dp.clickstatusdesctextbox().sendKeys("TEST DESC");
		dp.clickaddstatuscodebtn().click();
	}
	
	@Test(priority = 47)
	public void dbeditUserStatusCode() throws InterruptedException 
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickuserstatuscodetxtbox().clear();
		dp.clickuserstatuscodetxtbox().sendKeys("111112");
		dp.clickstatusdesctextbox().clear();
		dp.clickstatusdesctextbox().sendKeys("TEST DESC Edited");
		dp.clickaddstatuscodebtn().click();
	}
	@Test(priority = 48)
	public void dbDeleteUserStatusCode() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickuserstatuscodelink().click();
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("USER STATUS CODE DELETERD");
	}
	
	
	@Test(priority = 49)
	public void dbaddEducationalInstitute() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeducationalinstitutionslink().click();
		dp.clickaddnewbtn().click();
		dp.clickedufederalein().sendKeys("111111111");
		dp.clickeduinstitutionname().sendKeys("Automation Institute");
		dp.clickeduinstitutionadd().sendKeys("7577 automation rd");
		dp.clickeducity().sendKeys("Tracy");
		dp.clickeduCAstate().click();
		dp.clickeduzipcode().sendKeys("95441");
		dp.clickeduaddbtn().click();
		logger.info("New Educational Institution  added  successfully");
		test.log(LogStatus.INFO,"New Educational Institution  added  successfully");
	
	}
	
	@Test(priority = 50)
	public void dbeditEducationalInstitute() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeditbtn().click();
		dp.clickedufederalein().clear();
		dp.clickedufederalein().sendKeys("111111112");
		dp.clickeduinstitutionname().clear();
		dp.clickeduinstitutionname().sendKeys("Updated Institute");
		//dp.clickeduinstitutionadd().clear();
		dp.clickeduinstitutionadd().sendKeys("7577 Updated rd");
		dp.clickeducity().clear();
		dp.clickeducity().sendKeys("Uptated Tracy");
		dp.clickeduCAstate().click();
		dp.clickeduzipcode().sendKeys("95441");
		dp.clickeduaddbtn().click();
		logger.info("Educational Institution editted  successfully");
		test.log(LogStatus.INFO,"Educational Institution editted  successfully");
	}

	@Test(priority = 51)
	public void dbDeleteEducationalInstitute() throws IOException, InterruptedException
	{
		DatabaseSettingsPO dp = new DatabaseSettingsPO(driver);	
		Thread.sleep(1000);
		dp.clickeducationalinstitutionslink().click();
		//WebElement frstRow = driver.findElement(By.xpath("//tr/td[text() = 'Test City Edited,CA']"));
		Actions act = new Actions(driver);
		act.moveToElement(dp.clickeditbtn()).moveToElement(dp.clickthreedots()).click().build().perform();
		//dp.clickthreedots().click();
		act.moveToElement(driver.findElement(By.cssSelector("#anchorDeleteButton"))).click().perform();
		//WebElement delbtn = driver.findElement(By.xpath("//*[@id='action-menu']/div[2]/ul/li/text())"));
		//dp.clickcitiesdeletebtn().click();
		//assertTrue(dp.clickcitiesdeltitle().getText().contains("Test City Edited,CA"));
		Thread.sleep(1000);
		dp.clickcitiesdeletemodaldelbtn().click();
		logger.info("Educational Institute Deleted Successfully");
		test.log(LogStatus.INFO,"Educational Institute Deleted Successfully");
		Thread.sleep(2000);
		dp.clickdatabaseclosebtn().click();

	}	
	
	@BeforeClass
	public void login() throws IOException, InterruptedException
	{
		driver= invokeBrowser("qa");
		driver.get(prop.getProperty("url"));
		logger.info("URL open-Success");
		LogincloPO lp = new LogincloPO(driver);
		lp.getusername().sendKeys("000334");//prop.getProperty("preparerlogin1")
		lp.getPassword().sendKeys(prop.getProperty("preparerpass"));//prop.getProperty("preparerpswd1")
		Thread.sleep(1000);
		lp.clickLogin().click();
		logger.info("Username and Password success");
		OverviewpgPO op = new OverviewpgPO(driver);
		Thread.sleep(1000);
		lp.clicksecLogin().click();
		logger.info("clicked secLogin");
		//lp.clickmarkaspublic().click();
		lp.clickconfirmationkey().sendKeys("abcde");
		logger.info("Entered confirmation key");
		lp.clickthrdcontbtn().click();
		logger.info("clicked thirdcontbtn");
		Thread.sleep(2000);
	    changeto23("env",2023);//no environment used 
		
	}
	
	public void changeto23(String env,int year) throws InterruptedException, IOException
	{
			  
		  test.log(LogStatus.INFO, "opened a preparer");
		  AddaReturnpgPO ap = new AddaReturnpgPO(driver); 
		  switchYear(year);
		  OverviewpgPO op = new OverviewpgPO(driver);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Thread.sleep(1000); 
		  op.clickdashboardBtn().click();		 
	}
	
public void switchYear(int year) throws IOException, InterruptedException {
		
		AccountSettingsPO ap = new AccountSettingsPO(driver);
		Wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickaccountsdropdown()));
		Thread.sleep(500);
		ap.clickaccountsdropdown().click();
		Thread.sleep(500);
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		//Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchlink()));
		ap.clickswitchlink().click();
	//	Wait.until(ExpectedConditions.elementToBeClickable(ap.clickswitchselectyeardropdown()));
		ap.clickswitchselectyeardropdown().click();
		switch(Integer.valueOf(year))
		{
		case 2017:
			ap.clickswitchoptionyear2017().click();
			logger.info("switched to the year 2017");
			test.log(LogStatus.INFO,"switched to the year 2017");
			break;
		case 2018:
			ap.clickswitchoptionyear2018().click();
			logger.info("switched to the year 2018");
			test.log(LogStatus.INFO,"switched to the year 2018");
			break;
		case 2019:
			ap.clickswitchoptionyear2019().click();
			logger.info("switched to the year 2019");
			test.log(LogStatus.INFO,"switched to the year 2019");
			break;
		case 2020: 
			ap.clickswitchoptionyear2020().click();
			logger.info("switched to the year 2020");
			test.log(LogStatus.INFO,"switched to the year 2020");
			break;
		case 2021: 
			ap.clickswitchoptionyear2021().click();
			logger.info("switched to the year 2021");
			test.log(LogStatus.INFO,"switched to the year 2021");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		ap.clickswitchbtn().click();
		
	}

	
	
	@AfterClass
	public void teardown()
	{
	 logger.info("in tear down");
		driver.close();
		//report.endTest(test);
	//	report.flush();
	} 
}

	