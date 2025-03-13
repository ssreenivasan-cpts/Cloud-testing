/**
 * 
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;

import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class CloUtil extends Base {
	
	public static String screenshotPath;
	public static String screenshotName;
	public static String screenshotName1;
	public static String error;
	
	@Parameters("env")
	public static void captureScreenshot() throws IOException {
		
		String datestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
		File ScrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		screenshotName =  "error.png";
		screenshotName1 = datestamp+".png";
		FileUtils.copyFile(ScrShot, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		//filename = "./Screenshots/verifyerrorssnapshot.png";
		//FileUtils.copyFile(ScrShot,new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName1));
				//new File( "./target/surefire-reports/html" + screenshotName1));-did not work
				//new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName1));
		System.out.println(System.getProperty("user.dir") + "\\reports\\" + screenshotName);
		System.out.println(" in capture screenshot ");       
		
	}

}
