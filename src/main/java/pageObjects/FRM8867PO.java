package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FRM8867PO {

	public WebDriver driver;
	public FRM8867PO(WebDriver driver) {
		this.driver=driver;
	}
	
	//part1
	By yes_1 = By.id("000500");
	By yes_2 = By.id("003500");
	By yes_3 = By.id("009500");
	By No_4 = By.id("016000");
	By yes_5 = By.id("024500");
	By yes_6 = By.id("027500");
	By yes_7 = By.id("030500");
	//Part111
	By yes_10 = By.id("041500");
	By yes_11 = By.id("042500");
	By yes_12 = By.id("043500");
	By yes_15 = By.id("045500");
	By line5_A_d = By.id("092500");
	By line5_A_a = By.id("091000");//prod20
	
	public WebElement getyes_1()
	{
		return driver.findElement(yes_1);
	}
	public WebElement getyes_2()
	{
		return driver.findElement(yes_2);
	}
	public WebElement getyes_3()
	{
		return driver.findElement(yes_3);
	}
	public WebElement getNo_4()
	{
		return driver.findElement(No_4);
	}
	public WebElement getyes_5()
	{
		return driver.findElement(yes_5);
	}
	public WebElement getyes_6()
	{
		return driver.findElement(yes_6);
	}
	public WebElement getyes_7()
	{
		return driver.findElement(yes_7);
	}
	public WebElement getyes_10()
	{
		return driver.findElement(yes_10);
	}
	public WebElement getyes_11()
	{
		return driver.findElement(yes_11);
	}
	public WebElement getyes_12()
	{
		return driver.findElement(yes_12);
	}
	public WebElement getyes_15()
	{
		return driver.findElement(yes_15);
	}
	public WebElement getline5_A_d()
	{
		return driver.findElement(line5_A_d);
	}
	public WebElement getline5_A_a()
	{
		return driver.findElement(line5_A_a);
	}
}
