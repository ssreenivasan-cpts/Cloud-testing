/**
 * 
 */
package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.OverviewpgPO;
//import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author ssreenivasan
 *
 */
public class Base {
	
	public static WebDriver driver= null;
	public Properties prop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public ExtentReports report;
	public ExtentReports report1;
	public static ExtentTest test;
	public static ExtentTest test1;
	
	public String filename;
	public String projectPath = System.getProperty("user.dir");
	public static WebDriverWait Wait;
	//---
	
	public WebDriver invokeBrowser(String env) throws IOException
	{
		//System.setProperty("webdriver.chrome.driver", projectPath +"/driver/chromedriver.exe");
		//System.setProperty("-Dorg.freemarker.loggerLibrary=none");
		prop = new Properties();
		FileInputStream fs=new FileInputStream(projectPath +"/src/main/java/resources/data.properties");
		prop.load(fs);
		String browsername = prop.getProperty("browser");
		System.out.println("BROWSER : " + browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		if(env.equalsIgnoreCase("qa"))
		{	
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssreenivasan\\chromedrivernew\\chromedriver.exe");
			options.addArguments("--start-maximized");
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
		}
		}
		else if(browsername.equals("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssreenivasan\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");	
			//to reduce the marionette warnings in console
			//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			}
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssreenivasan\\Downloads\\chromedriver_new\\chromedriver.exe");
		
				//projectPath +"/driver/chromedriver.exe");
				//"C:\\Users\\ssreenivasan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		/*prop = new Properties();
		FileInputStream fs=new FileInputStream(projectPath +"/src/main/java/resources/data.properties");
		prop.load(fs);*/
	//	report = new ExtentReports(System.getProperty("user.dir") + "./reports/testExecutionReport.html",true,DisplayOrder.NEWEST_FIRST);
		//new ExtentReports(System.getProperty("user.dir") + "./target/surefire-reports/testExecutionReport.html",false,DisplayOrder.NEWEST_FIRST);
				//new ExtentHtml("./reports/testExecutionReport.html");
		//new ExtentReports()
				//new ExtentReporter(System.getProperty("user.dir") + "./reports/testExecutionReport.html",true);
				//new ExtentReports("AddareturnReport.html",true);//where to save the report//H:\\CLO\\
		//extent = new ExtentReports();
		//test = report.startTest("Adding a New Tax Return");//changed now
	//	test.log(LogStatus.INFO,"Browser Maximized");//changed now
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	
	public boolean isElementPresent(WebElement webElement)
	{
		
		 if(webElement.isEnabled())
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}
	
	
	public XSSFSheet getCellData()
	{
		try {
			//user.dir will give the current project path
		
		
		//change to / if moving the proj
		workbook = new XSSFWorkbook(projectPath + "\\excel\\addareturndata.xlsx");
		sheet = workbook.getSheet("Sheet1");
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return sheet;
	}
	
	
	public void AltplusC(String arg1,WebElement arg2) throws InterruptedException
	{
		arg2.sendKeys(Keys.chord(Keys.ALT,"c"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		if(driver.findElement(By.id("choiceListRow1")).isDisplayed() || driver.findElement(By.xpath("//td[text()='95304']")).isDisplayed())
			{
			if(arg1.equals("prepID"))
			{
				driver.findElement(By.id("choiceListRow1")).click();
				/*
				 * WebElement we = driver.findElement(By.id("choiceListRow1"));
				 * actions.doubleClick(we).perform();
				 */
				driver.findElement(By.id("btnConfirmChoiceList")).click();
				
			}
			else if(arg1.equals("efin"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
				/*
				 * WebElement we = driver.findElement(By.id("choiceListRow0"));
				 * actions.doubleClick(we).perform();
				 */
				
			}
			else if(arg1.equals("zipcode"))
			{
				driver.findElement(By.xpath("//td[text()='95336']")).click();
				//WebElement we = driver.findElement(By.xpath("//td[text()='95336']"));
				//actions.doubleClick(we).perform();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("EmpName"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				/*WebElement we = driver.findElement(By.id("choiceListRow0"));
				actions.doubleClick(we).perform();*/
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("schc_bizcode"))
			{
				driver.findElement(By.id("choiceListRow1")).click();//changed from 2
				/*WebElement we = driver.findElement(By.id("choiceListRow4"));
				actions.doubleClick(we).perform();*/
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("proptype"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				//WebElement we = driver.findElement(By.id("choiceListRow0"));
				//actions.doubleClick(we).perform();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("payersEIN"))
			{
				driver.findElement(By.id("choiceListRow1")).click();
				//WebElement we = driver.findElement(By.id("choiceListRow1"));
				//actions.doubleClick(we).perform();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("linkto"))
			{
				driver.findElement(By.id("choiceListRow4")).click();
						//(By.xpath("//td[contains(text(),'87')")).click();
				//WebElement we = driver.findElement(By.id("choiceListRow4"));
				//actions.doubleClick(we).perform();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
				
			}
			else if(arg1.equals("idtype")) {
				driver.findElement(By.id("choiceListRow0")).click();
			/*	WebElement we = driver.findElement(By.id("choiceListRow0"));
				actions.doubleClick(we).perform();*/
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}//bankapp
			else if(arg1.equals("cellphcarrier")) {
				//JavascriptExecutor jse = (JavascriptExecutor) driver;
				//jse.executeScript("scroll(0,1000);");
				driver.findElement(By.id("choiceListRow4")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
				//WebElement we = driver.findElement(By.id("choiceListRow4"));
				//actions.doubleClick(we).perform();
			}
			else if(arg1.equals("activitycode")) {
				driver.findElement(By.id("choiceListRow0")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("spouseoccup"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("child"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			else if(arg1.equals("sck_zip"))
			{
				driver.findElement(By.id("choiceListRow0")).click();
				driver.findElement(By.id("btnConfirmChoiceList")).click();
			}
			
		}
	
		else
		{
			driver.findElement(By.id("btnCancelChoiceList")).click();
			System.out.println("choices not found");
		}
	}
	
	
	
	public WebDriver saveTaxReturn() throws InterruptedException
	{
		driver.findElement(By.id("btnOptionsHeaderBarForms")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='menuOptions9']")).click();//save button in the bar
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		return driver;
	}
	
	@Parameters("env")
	@Test
	public String TakeScreenshot()
	{
		
		String Datestamp = new SimpleDateFormat("yy_MM_dd_HH_mm").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File ScreenShots = ts.getScreenshotAs(OutputType.FILE);	
		try {
			filename =System.getProperty("user.dir") + "\\reports\\"+Datestamp+"snapshot.png";
					//"./reports/verifyerrorssnapshot.png";
					//"H:\\CLO\\AddaReturnReport.png";
					//"C:\\CLOAutoSnaps\\verifyerror.png";
		
			FileUtils.copyFile(ScreenShots, new File(filename));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
		//return ScreenShots;
		
	}
	@BeforeSuite
	public void startReports()
	{
		report = new ExtentReports(System.getProperty("user.dir") + "./reports/testExecutionReport.html",true,DisplayOrder.NEWEST_FIRST);
		test= report.startTest("Add a Return");
	}
	
	@AfterSuite
	public void endReports()
	{
		System.out.println("in aftersuite");
		report.endTest(test);
		report.flush();
	//	report.close();//--added recently
	}
	@Parameters({ "env" })
	public void openaPreparer(String env,int prepID) throws IOException, InterruptedException {
			OverviewpgPO op = new OverviewpgPO(driver);
			//Thread.sleep(1000);
	    	//test.log(LogStatus.INFO, "opened a preparer");
			Reporter.log("opened a preparer-1");
			if(env.equalsIgnoreCase("qa")){
				//Wait.until(ExpectedConditions.elementToBeClickable(op.clickoffices()));// changed from sleep
				Thread.sleep(1000);
				op.clickoffices().click();
				Thread.sleep(1000);
				//logger.info("Clicked Offices");
				test.log(LogStatus.INFO, "Clicked Offices");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

				if(prepID == 334) {
					
					JavascriptExecutor jse = ((JavascriptExecutor) driver);
					//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					jse.executeScript("scrollTo(0,9500);");
					Thread.sleep(500);
					op.clickviewbtnfor334().click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
					op.clickpreparertab().click();
					Thread.sleep(500);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
					//Wait.until(ExpectedConditions.elementToBeClickable(op.clickviewprepbtn()));
					Thread.sleep(500);
					op.clickviewprepbtn().click(); 
					Thread.sleep(500);
					
				}
				else if(prepID == 333) {
					Thread.sleep(2000);
					op.clickviewbtnfor333().click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
					op.clickpreparertab().click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
					//Wait.until(ExpectedConditions.elementToBeClickable(op.clickviewprepbtn()));
					op.clickqaViewprepbtnfor333();
				}
				/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				//Wait.until(ExpectedConditions.elementToBeClickable(op.clickviewprepbtn()));
				op.clickviewprepbtn().click(); */
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				}
			else if(env.equalsIgnoreCase("prod")){
				//Wait.until(ExpectedConditions.elementToBeClickable(op.clickpreparertab()));
				op.clickpreparertab().click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				op.clickprodViewprepbtn().click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				}
			else if(env.equalsIgnoreCase("dev")){
				Wait.until(ExpectedConditions.elementToBeClickable(op.clickoffices()));
				op.clickoffices().click();
				//logger.info("Clicked Offices");
				test.log(LogStatus.INFO, "Clicked Offices");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				op.clickdevViewbtn().click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				op.clickpreparertab().click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				op.clickdevViewprepbtn().click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			}
			Thread.sleep(500);
			op.clickTaxreturns().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			Assert.assertTrue(isElementPresent(op.clickNewTaxreturnsbtn()), "Add New Tax Return disabled");
			Thread.sleep(500);
			//Handling Unable to fetch error 
			//check_fetcherror_button();
			op.clickNewTaxreturnsbtn().click();
	}
	
	public boolean check_fetcherror_button() {
	   WebElement fetchErrorDonebtn = driver.findElement(By.xpath("//button/span[contains(text(),'Done')]"));
	   try {
	   if(fetchErrorDonebtn.isDisplayed())
		{
			fetchErrorDonebtn.click();
			LocalDateTime dt = LocalDateTime.now();
			System.out.println("Unable to fetch error Time" + dt);
			return true;
			
		}
	   }
	   catch(Exception e)
	   {
		   System.out.println("No Error Button");
	   }
	return false;
	   
	} 
	
}
