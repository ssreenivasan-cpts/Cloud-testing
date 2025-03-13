/**
 * 
 */
package rough;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import pageObjects.LogincloPO;
import resources.Base;

/**
 * @author ssreenivasan
 *
 */
public class Chromeprofiling extends Base {
	
	public WebDriver driver;
	
	@Test
	public void firsttry() throws IOException, InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir=C:\\Users\\ssreenivasan\\AppData\\Local\\Google\\Chrome\\User Data");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		driver=new ChromeDriver(options);
		//driver.get("https://qa.crosslinkonline.com/#");
		//driver.
	
	}
}
