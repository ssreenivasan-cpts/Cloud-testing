/**
 * 
 */
package clo;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import resources.Base;
import utilities.CloUtil;
import utilities.MonitoringMail;
import utilities.TestConfig;

/**
 * @author ssreenivasan
 *
 */
public class Listener extends Base implements ITestListener {

	public static String messagebody;
	public void onTestStart(ITestResult result) {
		//test= report.startTest(result.getName().toUpperCase());
		Reporter.log("Test started");
		Reporter.log("<br>");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		//report.startTest(result.getName());--did not work
		System.out.println(" in success listner");
		System.out.println("~~PASSED~~"+ result.getName());
		Reporter.log("Test Passed");
		test.log( LogStatus.PASS, " ~~ PASSED~~ " + result.getName() );
		/*try {
			CloUtil.captureScreenshot();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a target=\"_blank\" href="+CloUtil.screenshotName1+">Screenshot</a>");
		Reporter.log("<br>");
		
		test.log(LogStatus.PASS, "Took screen shot",test.addScreenCapture(CloUtil.screenshotName));*/
		
	/*	report.endTest(test);
		report.flush();*/
	//	report.close();
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" in faliure listner");
		System.out.println("~~FAILED~~"+ result.getName());
		Reporter.log("~Test failed~");
		try {
			CloUtil.captureScreenshot();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a target=\"_blank\" href="+CloUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		test.log(LogStatus.FAIL, result.getName() + " ~~FAIL~~ " + result.getThrowable());
		test.log(LogStatus.FAIL, result.getName() + test.addScreenCapture(CloUtil.screenshotName));
				//test.addScreenCapture(CloUtil.screenshotName1));
	/*	report.endTest(test);
		report.flush();*/
		//report.close();
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("~~SKIPPED~~ "+ result.getName());
		Reporter.log("Test skipped");
		try {
			CloUtil.captureScreenshot();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output","false");
		//Reporter.log(CloUtil.screenshotName);
		Reporter.log("<a target=\"_blank\" href="+CloUtil.screenshotName1+"> Click To See Screenshot</a> ");
		Reporter.log("<br>");
		test.log(LogStatus.SKIP, result.getName() + "SKIPPED WITH EXCEPTION" + result.getThrowable());
		test.log(LogStatus.SKIP, result.getName() + test.addScreenCapture(CloUtil.screenshotName));
	/*	report.endTest(test);
		report.flush();*/
	//	report.close();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("~~FAILED WITH SUCCESSPERCENTAGE~~ "+ result.getName());
		
	}

	public void onStart(ITestContext context) {
		System.out.println("~~STARTED~~ "+ context.getName());
		Reporter.log("Test started");
		Reporter.log("<br>");
	//	test = report.startTest(context.getName().toUpperCase());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("~~FINISHED~~  "+ context.getName());
		Reporter.log("Test Finished");
		Reporter.log("<br>");
		//test.log(logStatus., details);
		
	}
	
	
}
