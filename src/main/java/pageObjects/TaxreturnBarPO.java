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
public class TaxreturnBarPO {
	
	public WebDriver driver;
	public TaxreturnBarPO(WebDriver driver) {
		this.driver=driver;
	}
	//------------VerifyReturnBtn
	By verifyReturnbtn = By.id("verifyReturn");
	By interviewClientbtn = By.id("interviewClient");
	//--SAVEANDCLOSE OPTIONS
	By btnSaveAndClose = By.id("menuOptions13");
	By btnArrowOptions = By.id("mainMenuBtn");//("btnOptionsHeaderBarForms");
	By btnSaveTaxReturn = By.id("btnSaveAndClose"); //To save taxreturn
	By btnreloadbilling = By.id("menuOptions1"); //Reload Billing
	//Send Text Msg 
	By btnSendTxtMsg = By.id("menuOptions4");
	By btntxtmsgcontent = By.xpath("//textarea[@id='txtTextLinkMessagBody']");
	By SendbtninTextmsg = By.id("btnSendTextLink");
	By OkinTextmsgSuccessbtn = By.id("btnTextMessageSucceed");
	By copytotraining = By.xpath("//p[contains(text(),'Copy To Training')]");
			//By.id("menuoptions12");
	//VERIFY ERRORS DIALOG BOX FOR BOTH VERIFYRETURNBTN AND TRANSMIT RETURN BTN
	By closeinverify = By.id("btnCloseErrorRejectModal");
	By printbtn = By.id("printIcon");
	By OKinVerifysuccessbtn =By.xpath("//button[@id='btnErrorRejectVerifyOK']");
			//By.id("btnFormViewerVerifyOK"); //click verify btn and if no errors,this pops up  btnFormViewerVerifyOK
			//By.xpath("//img[@id='printClient']");
	//--------------PRINT OPTIONS------------------------
	By finalTaxReturnbtn =By.xpath("//*[@id='printOptions2']");	
	By bankDocsbtn = By.id("printOptions3");
			//.xpath("//*[@id='printOptions3']");
	//----INSIDE PRINT BTN		
	By printInVerifybtn = By.id("btnSubmitErrorRejectModal");
	By printFinalReturnbtn = By.id("btnPrint");
	By remoteSignbtn = By.id("printActionsDialogBtnRemoteSign");
	By saveRtrnInRemotesign = By.xpath("//button[@id='btnClosePrintActionsDialog'][2]");
	//---INSIDE PRINT BANK DOCS
	By printBankDocsbtn = By.id("printActionsDialogBtnPrint");
	By closebtninPDFdoc = By.xpath("//span[contains(text(),'Close')]");
			//By.id("btnClosePrintActionsDialog");
	//signatures
	By signatureBtn = By.id("signaturesIcon");
	By signBtn = By.name("taxpayersignButton");
	By signbtninReturnErrors = By.id("btnSubmitErrorRejectModal");
	By sendBtninCaptureSignature = By.id("sendSigNextSendBtn");
	By cancelBtn = By.id("btnCancelSignDoc");
	By okbtninRemoteSignRequest = By.id("btnCompletedRemoteSignClose");
	By cancelbtninremotesignerror = By.xpath("//button[@id='messageDialogId']/span[contains(text(),'Cancel')]");
	//"//button[@id='messageDialogId']/span[contains(text(),'Cancel')]")
	//-----TransmitReturn adding on 7/24
	By transmitReturnbtn = By.id("transmitReturnIcon");
	//Notes
	By notesbtn = By.id("btnReturnNotes");
	By addNewNote = By.xpath("//*[contains(text(),'Add New Note')]");
	By msginNote = By.id("txtBookmarkDescription");
	//payjunction changed 10/26
	By paymentsbtn = By.id("paymentClientIcon");
			//By.id("btnReturnPayments");
	By interviewbtn = By.id("interviewMode");
	By helpbtn = By.id("helpClient");
	
	//Payjunction
//	By paymentsbtn = By.id("paymentClient");
	By receivedFrom = By.id("txtrcvdFrom");
	By amount = By.id("txttaxamount");
	By refNumb = By.id("txtrefNum");
	By savebtn = By.id("btnManualPaymentSave");
	By paymentsavedPrompt = By.id("prompt-msg");
	//------------nidhi 
	By signMethodDropdown = By.id("sendSigSigningMethod"); 
	By remoteSigOption = By.xpath("*[@id='ddlSelectSigningMethod']/option[2]");
	By remoteEmailRadioBtn = By.xpath("//input[@name = 'contactMethod'][@value 	='qa1@petzent.com']");
	
	By nextBtn = By.id("btnSubmitErrorRejectModal"); 
			//By.xpath("//button/span[Contains(text(), 'Next']");
		
	public WebElement clkverifyReturnbtn()
	{
		return driver.findElement(verifyReturnbtn);
	}
	public WebElement clkinterviewClientbtn()
	{
		return driver.findElement(interviewClientbtn);
	}
	public WebElement clkbtnSaveAndClose()
	{
		return driver.findElement(btnSaveAndClose);
	}
	public WebElement clkbtnArrowOptions()
	{
		return driver.findElement(btnArrowOptions);
	}
	
	public WebElement clkcloseinverify()
	{
		return driver.findElement(closeinverify);
	}
	public WebElement clkprintbtn()
	{
		return driver.findElement(printbtn);
	}
	public WebElement clkOKinVerifysuccessbtn()
	{
		return driver.findElement(OKinVerifysuccessbtn);
	}
	
	public WebElement clkfinalTaxReturnbtn()
	{
		return driver.findElement(finalTaxReturnbtn);
	}
	public WebElement clkbankDocsbtn()
	{
		return driver.findElement(bankDocsbtn);
	}
	public WebElement clkprintInVerifybtn()
	{
		return driver.findElement(printInVerifybtn);
	}
	public WebElement clkprintFinalReturnbtn()
	{
		return driver.findElement(printFinalReturnbtn);
	}
	public WebElement clkremoteSignbtn()
	{
		return driver.findElement(remoteSignbtn);
	}
	public WebElement clksaveRtrnInRemotesign()
	{
		return driver.findElement(saveRtrnInRemotesign);
	}
	public WebElement clkprintBankDocsbtn()
	{
		return driver.findElement(printBankDocsbtn);
	}
	public WebElement clkclosebtninPDFdoc()
	{
		return driver.findElement(closebtninPDFdoc);
	}	
	public WebElement clktransmitReturnbtn()
	{
		return driver.findElement(transmitReturnbtn);
	}
	public WebElement clksignatureBtn()
	{
		return driver.findElement(signatureBtn);
	}
	public WebElement clksignBtn()
	{
		return driver.findElement(signBtn);
	}
	public WebElement clksignbtninReturnErrors()
	{
		return driver.findElement(signbtninReturnErrors);
	}
	 
	public WebElement clksignMethodDropdown()
	{
		return driver.findElement(signMethodDropdown);
	}
	public WebElement clksendBtninCaptureSignature()
	{
		return driver.findElement(sendBtninCaptureSignature);
	}
	public WebElement clkcancelBtn()
	{
		return driver.findElement(cancelBtn);
	}
	
	public WebElement clkokbtninRemoteSignRequest()
	{
		return driver.findElement(okbtninRemoteSignRequest);
	}
	public WebElement clkcancelbtninremotesignerror()
	{
		return driver.findElement(cancelbtninremotesignerror);
	}
	public WebElement clknotesbtn()
	{
		return driver.findElement(notesbtn);
	}
	public WebElement clkpaymentsbtn()
	{
		return driver.findElement(paymentsbtn);
	}
	public WebElement getreceivedFrom()
	{
		return driver.findElement(receivedFrom);
	}
	public WebElement getamount()
	{
		return driver.findElement(amount);
	}
	public WebElement getrefNumb()
	{
		return driver.findElement(refNumb);
	}
	public WebElement clksavebtn()
	{
		return driver.findElement(savebtn);
	}
	public WebElement clkpaymentsavedPrompt()
	{
		return driver.findElement(paymentsavedPrompt);
	}
	public WebElement clkinterviewbtn()
	{
		return driver.findElement(interviewbtn);
	}
	public WebElement clkhelpbtn()
	{
		return driver.findElement(helpbtn);
	}
	public WebElement clkbtnSaveTaxReturn()
	{
		return driver.findElement(btnSaveTaxReturn);
	} 
	public WebElement clkbtnreloadbilling()
	{
		return driver.findElement(btnreloadbilling);
	}
	public WebElement clkbtnSendTxtMsg()
	{
		return driver.findElement(btnSendTxtMsg);
	}
	public WebElement gettxtmsgcontent()
	{
		return driver.findElement(btntxtmsgcontent);
	}
	public WebElement clkSendbtninTextmsg()
	{
		return driver.findElement(SendbtninTextmsg);
	}
	public WebElement clkOkinTextmsgSuccessbtn()
	{
		return driver.findElement(OkinTextmsgSuccessbtn);
	}
	
	public WebElement clksignoptionDropdown()
	{
		return driver.findElement(signMethodDropdown);
	}
	public WebElement clkRemoteSigoption()
	{
		return driver.findElement(remoteSigOption);
	}
	public WebElement clkEmailRadioBtn()
	{
		return driver.findElement(remoteEmailRadioBtn);
	}
	public WebElement clkNextBtn()
	{
		return driver.findElement(nextBtn);
	}
	public WebElement clkcopytotraining() {
				
		return driver.findElement(copytotraining);
	}


	
	
}
