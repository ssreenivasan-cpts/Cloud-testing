package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AccountSettingsPO {
	public WebDriver driver;
	public AccountSettingsPO(WebDriver driver) {
		this.driver=driver;
	}
		By accountsdropdown = By.id("spnProfileHeaderBar");//account dropdown on top right
		By switchlink =By.id("btnSwitchTaxYear"); // new switch yr id 2020
				//By.xpath("//div[@class = 'link-text'][text() = 'Switch']");//Switch year link
		By switchselectyeardropdown = By.xpath("//Select[@name = 'season']");// select year dropdown in switch account modal
		By switchoptionyear2017 = By.xpath("//option[@value = '2018']");// select year 2017 from the dropdown
		By switchbtn = By.id("btnDoSwtichAccount");//switch button in the switch account modal
		By switchoptionyear2018 = By.xpath("//option[@value = '2019']");// select year 2018 from the dropdown
		By switchoptionyear2019 = By.xpath("//option[@value = '2020']");//select year 2019 from the dropdown
		By switchoptionyear2020 = By.xpath("//option[@value = '2021']");//select year 2020 from dropdown
		By switchoptionyear2021 = By.xpath("//option[@value = '2022']");//select year 2021 from dropdown
		By switchoptionyear2022 = By.xpath("//option[@value = '2023')");// select year 2022 from dropdown
		By switchoptionyear2023 = By.xpath("//option[@value = '2024')");// select year 2023 from dropdown
		//By switchoptionyear2024= By.xpath("//op")
		
		By switchcancelbtn = By.id("btnCancelSwtichAccount");// Cancel button in the switch modal
		//-----------------------------------------------------------------------------------------------------
		By changepasswordlink = By.xpath("//div[@class = 'link-text'][text() = 'Change Password']");// change password link
		By currentpassword = By.id("txtOldPasswordMA");// current password textbox in change pswd modal
		By newpassword = By.id("txtNewPasswordMA");//new password textbox in change pswd modal
		By retypepassword = By.id("txtRetypePasswordMA");//re- type password text box in change pswd modal
		By cancelbtn = By.id("btnContinueToLoginActivateAcc");//cancel btn in the change pswd modal
		By changepasswordbtn = By.id("btnContinueToLoginActivateAcc");//change password btn in the change pswd modal
		//----------------------------------------------------------------------------------------------------------
		By toggletrainingmodelink = By.xpath("//div[@class = 'link-text'][text() = 'Toggle Training Mode']");//Toggle training mode link
		//----------------------------------------------------------------------------------------------------------------------
		By capturesignaturelink = By.xpath("//div[@class = 'link-text'][text() = 'Capture ERO Signature']");// capture signature
		By capsigclearbtn  = By.xpath("//span[text() = 'Clear']");// clear btn in capture signature modal
		By capsigcancelbtn = By.xpath("//span[text() = 'Cancel']");// cancel btn in capture signature modal
		By capsigacceptbtn = By.xpath("//span[text() = 'Accept']");// Preview btn in capture signature modal
		By capsigbox = By.xpath("//canvas[@width = '476']");//box to capture signature
		By updateCaptureSign = By.id("btnAcceptSignDoc");//updatessignature button jan20
		By okbtninSignUpdated = By.id("btnConfirmDialog");//ok in signature updated
		//--------------------------------------------------------------------------------------------------------------------
		By loginsettingslink = By.xpath("//div[@class = 'link-text'][text() = 'Login Preferences']");//Login settings
		By loginsettingstitle = By.id("simple-modal-title");// title of login settings modal
		By loginsettingscancelbtn = By.xpath("//span[text() = 'Cancel']");//cancel btn in login settings modal
		By loginsettingssavebtn = By.xpath("//span[text() = 'Save']");//Save button in login settings modal
		By loginsettingschkbox = By.id("startInterviewchk");// chk box in the login settings modal
		//---------------------------------------------------------------------------------------------------------------------
		By copytolivelink = By.xpath("//*[@id='menuOptions11']");
				//By.id("menuOptions11");
		By copiedsuccessfullyPromptmsg = By.id("prompt-msg");//does not locate
		//------------------------------------------------------------------------------------------------------
		By accountsettingsbtn =By.id("btnSideBarAccountSettings");		
	    By dbsettingsbtn = By.id("tabDatabaseSettingsProfile");
		By createnewLogin = By.xpath("//button[@id='btnAddNewLoginSetup']");
				//By.id("btnAddNewLoginSetup"); 
		By usernameinaddnewlogin = By.id("txtLoginIDAddNewLogin");
		By displayNameinAddnewlogin = By.id("txtLoginNameAddNewLogin");
		By emailinAddnewlogin = By.id("txtEmailAddressAddNewLogin");
		By confirmemailinAddnewlogin = By.id("txtConfirmEmailAddressAddNewLogin");
		By accesslevelinAddnewlogin = By.id("ddlAccessLevelAddNewLogin");
		By prepinaccesslevel = By.xpath("//option[text()='Reseller Admin']");
		By saveinAddnewlogin = By.id("btnAddAddNewLogin");
		By doneincreateloginerror = By.id("btnHideSettingsError");
		By cancelinAddnewlogin = By.id("btnCancelAddNewLogin");
		By closebtninSettingsProfile = By.id("btnSaveAndCloseSettingsProfile");
		By cancelbtninSettingsProfile = By.id("btnConfirmDialog");
		//---------------------------------------
		By helpbtn =By.id("imgHelpTitleBar");
		By gettoknowthisLink=By.xpath("//*[contains(text(),'Get')]");
		By startedNextbtn = By.xpath("//span[contains(text(),'Next')]");
		/*By dashboardNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By reminderNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By messagingNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By navigationpaneNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By navigatonbarNextbtn= By.xpath("//span[contains(text(),'Next')]");
		By overviewNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By accountsNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By officesNextbtn =By.xpath("//span[contains(text(),'Next')]");
		By taxretrnsNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By searchNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By exitwindowNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By helpNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By closemenuNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By persprofileNextbtn = By.xpath("//span[contains(text(),'Next')]");
		By openmenuNextbtn = By.xpath("//span[contains(text(),'Next')]"); */
		By donebtninHelp = By.xpath("//span[contains(text(),'Done')]");
		//ssbtopbar search 
		By searchbtn = By.id("imgSrchTitleBar");
		By cancelinsearchbtn = By.id("btnSearchBarCancel");
		//Accesslevel(AL)2023----------------------------------------------------------
		By expandAccessLevelbtn = By.id("icobtnExpandAccessLevelsLoginSetup");
		By addNewALbtn = By.id("btnAddNewAccessRole"); 
		By savebtn_addnew_AL = By.id("btnAddNewAL");
		By cancelbtn_addnew_AL = By.id("btnCloseAddALModal");
		By resetbtn_addnew_AL = By.id("btnReset");
		
		//2020-adding for PROD NAHMIC
		By arrowforaccntsettings = By.xpath("//label[@for='spnAccountProfileTitleBar'");
		//----
		By loginbtn = By.id("miClickableRowLogins");
		By ancillaryproducts = By.id("miClickableRowAncillary Products");
		By cobrandingbtn = By.id("miClickableRowCobranding");
		By mnglicensingbtn = By.id("miClickableRowManage Licensing");
		//inside mngLicensing 
		By assignbtn4 = By.id("btnLicencingSetupEdit5");
		By assignLicencetobtn = By.id("office-select");
		By select18004option = By.xpath("//option[@value='1217'])");
		By savebtninAssignLicense =  By.xpath("//button/span[contains(text(),'Save')]");
		By removeLicence = By.id("btnLicencingSetupEdit3");
		By rmvbtninUnassignLicence = By.id("btnConfirmDialog");
		//managelicenceaddedin2022
		By toggleofclicencemgmgt = By.xpath("//span[contains(text(),'Toggle Office License Management");
		By managebtnforfirstoffice = By.id("btnTableRow0");
		By cancelbtnforfirstmanagebtn = By.xpath("span[contains(text(),'Cancel");
		//previous buttons
		By previousbtninMngLicense = By.id("btnLicensingSetupPrev");
	
		//inside cobranding
		By techsupportnumber = By.id("techSupportCobrandSetup");
		By savetechsupportnumbr = By.id("btnTechSupportSave");
		By saveandnextbtnincobranding = By.id("btnNextCobrandingSetup");
		//inside ancillary products
		By managebtn = By.xpath("//button/span[contains(text(),'Manage')]");
		By editaddonfee = By.id("markfeerequireid");
		By saveinancillaryproduct = By.id("btnUpdateBillingState");
		//inside Login
		By createaNewLogin = By.id("btnAddNewLoginSetup");
		//user details in create new login
		By username = By.id("txtLoginIDAddNewLogin");
		By displayname = By.id("txtLoginNameAddNewLogin");
		By emailid = By.id("txtEmailAddressAddNewLogin");
		By confirmemailid = By.id("txtConfirmEmailAddressAddNewLogin");
		By accessLevel = By.id("ddlAccessLevelAddNewLogin");
		By savebtninNewLogin = By.id("btnAddAddNewLogin");
		By cancelbtninNewLogin = By.id("btnCancelAddNewLogin");
		//CheckImage
		By uploadImagebtnindropdown = By.id("btnUploadImage");
		By clickheretouploadanimagebtn = By.xpath("//span[contains(text(),'Click Here To Select An Image File')]");
		By uploadimgbtninchooseyourAvatar = By.xpath("//span[contains(text(),'Upload Image')]");
		//Office Account settings-2023
		By userIdWallet = By.xpath("//div[contains(text(),'UserID Wallet')]");
		By officeWallet = By.xpath("//div[contains(text(),'Office Wallet')]");
		By breadcrumblinkforFirstOfc = By.xpath("//span[contains(text(),'breadcrumb-link')]");
				//+ "////li[@id='breadcrumbLink1']");
				//By.id("breadcrumbLink1");
		
		
		
		public WebElement clickaccountsdropdown()
		{
			return driver.findElement(accountsdropdown);
		}
		public WebElement clickswitchlink()
		{
			return driver.findElement(switchlink);
		}
		public WebElement clickswitchselectyeardropdown()
		{
			return driver.findElement(switchselectyeardropdown);
		}
		public WebElement clickswitchoptionyear2017()
		{
			return driver.findElement(switchoptionyear2017);
		}
		public WebElement clickswitchbtn()
		{
			return driver.findElement(switchbtn);
		}
		public WebElement clickswitchoptionyear2018()
		{
			return driver.findElement(switchoptionyear2018);
		}
		public WebElement clickswitchoptionyear2019()
		{
			return driver.findElement(switchoptionyear2019);
		}
		public WebElement clickswitchcancelbtn()
		{
			return driver.findElement(switchcancelbtn);
		}
		public WebElement clickswitchoptionyear2020() {
			// TODO Auto-generated method stub
			
			return driver.findElement(switchoptionyear2020);
		}
		public WebElement clickswitchoptionyear2021() {
			// TODO Auto-generated method stub
			
			return driver.findElement(switchoptionyear2021);
		}
		
		public WebElement clickswitchoptionyear2022() {
			// TODO Auto-generated method stub
			
			return driver.findElement(switchoptionyear2022);
		}
		public WebElement clickswtichoptionyear2023()
		{
			return driver.findElement(switchoptionyear2023);
		}
		
		//----------------------------------------------------------------------------------------------------------
		public WebElement clickchangepasswordlink()
		{
			return driver.findElement(changepasswordlink);
		}
		public WebElement clickcurrentpassword()
		{
			return driver.findElement(currentpassword);
		}
		public WebElement clicknewpassword()
		{
			return driver.findElement(newpassword);
		}
		public WebElement clickretypepassword()
		{
			return driver.findElement(retypepassword);
		}
		public WebElement clickcancelbtn()
		{
			return driver.findElement(cancelbtn);
		}
		public WebElement clickchangepasswordbtn()
		{
			return driver.findElement(changepasswordbtn);
		}
		
		//------------------------------------------------------------------------------------------------------	
		public WebElement clicktoggletrainingmodelink()
		{
			return driver.findElement(toggletrainingmodelink);
		}
		//----------------------------------------------------------------------------------------------------
		
		public WebElement clickcapturesignaturelink()
		{
			return driver.findElement(capturesignaturelink);
		}
		public WebElement clickcapsigclearbtn()
		{
			return driver.findElement(capsigclearbtn);
		}
		public WebElement clickcapsigcancelbtn()
		{
			return driver.findElement(capsigcancelbtn);
		}
		public WebElement clickcapsigacceptbtn()
		{
			return driver.findElement(capsigacceptbtn);
		}
		public WebElement clickcapsigbox()
		{
			return driver.findElement(capsigbox);
		}
		public WebElement clickupdateCaptureSign()
		{
			return driver.findElement(updateCaptureSign);
		}
		public WebElement clickokbtninSignUpdated()
		{
			return driver.findElement(okbtninSignUpdated);
		}
		//--------------------------------------------------------------------------------------------------------
		
		public WebElement clickloginsettingslink()
		{
			return driver.findElement(loginsettingslink);
		}
		public WebElement clickloginsettingsgstitle()
		{
			return driver.findElement(loginsettingstitle);
		}
		public WebElement clickloginsetgscancelbtn()
		{
			return driver.findElement(loginsettingscancelbtn);
		}
		public WebElement clickloginsettingssavebtn()
		{
			return driver.findElement(loginsettingscancelbtn);
		}
		public WebElement clickloginsettingschkbox()
		{
			return driver.findElement(loginsettingschkbox);
		}
		  
		public WebElement clickcopytolivelink()
		{
			return driver.findElement(copytolivelink);
		}
		public WebElement clickcopiedsuccessfullyPromptmsg()
		{
			return driver.findElement(copiedsuccessfullyPromptmsg);
		}
		//--------------------------------------------------------------------------------------------------------
		
		public WebElement clickaccountsettingsbtn()
		{
			return driver.findElement(accountsettingsbtn);
		}
		public WebElement clickdbsettingsbtn()
		{
			return driver.findElement(dbsettingsbtn);
		}
		public WebElement clickcreatenewLogin()
		{
			return driver.findElement(createnewLogin);
		}
		public WebElement getusernameinaddnewlogin()
		{
			return driver.findElement(usernameinaddnewlogin);
		}
		public WebElement getdisplayNameinAddnewlogin()
		{
			return driver.findElement(displayNameinAddnewlogin);
		}
		public WebElement getemailinAddnewlogin()
		{
			return driver.findElement(emailinAddnewlogin);
		}
		public WebElement getconfirmemailinAddnewlogin()
		{
			return driver.findElement(confirmemailinAddnewlogin);
		}
		public WebElement getaccesslevelinAddnewlogin()
		{
			return driver.findElement(accesslevelinAddnewlogin);
		}
		public WebElement getprepinaccesslevel()
		{
			return driver.findElement(prepinaccesslevel);
		}
		public WebElement getsaveinAddnewlogin()
		{
			return driver.findElement(saveinAddnewlogin);
		} 
		public WebElement clikdoneincreateloginerror()
		{
			return driver.findElement(doneincreateloginerror);
		} 
		public WebElement clikcancelinAddnewlogin()
		{
			return driver.findElement(cancelinAddnewlogin);
		}
		
		public WebElement clikclosebtninSettingsProfile()
		{
			return driver.findElement(closebtninSettingsProfile);
		} 
		
		public WebElement clikcancelbtninSettingsProfile()
		{
			return driver.findElement(cancelbtninSettingsProfile);
		} 
		//----help
		
		public WebElement clikhelpbtn()
		{
			return driver.findElement(helpbtn);
		} 
		public WebElement clikgettoknowthisLink()
		{
			return driver.findElement(gettoknowthisLink);
		}
		public WebElement clikstartedNextbtn()
		{
			return driver.findElement(startedNextbtn);
		}
		public WebElement clikdonebtninHelp()
		{
			return driver.findElement(donebtninHelp);
		}
		// ---searchinssb
		public WebElement cliksearchbtn()
		{
			return driver.findElement(searchbtn);
		}
		public WebElement clikcancelinsearchbtn()
		{
			return driver.findElement(cancelinsearchbtn);
		}
		
		//Access Level 
		public WebElement clickexpandAccessLevelbtn()
		{
			return driver.findElement(expandAccessLevelbtn);
		}
		public WebElement clickaddNewALbtn()
		{
			return driver.findElement(addNewALbtn);
		}
		public WebElement clicksavebtn_addnew_AL()
		{
			return driver.findElement(savebtn_addnew_AL);
		}
		public WebElement clickcancelbtn_addnew_AL()
		{
			return driver.findElement(cancelbtn_addnew_AL);
		}
		public WebElement clickresetbtn_addnew_AL()
		{
			return driver.findElement(resetbtn_addnew_AL);
		}
		//PROD NAHMIC
		
		public WebElement clikarrowforaccntsettings()
		{
			return driver.findElement(arrowforaccntsettings);
		}
		public WebElement clikmnglicensingbtn()
		{
			return driver.findElement(mnglicensingbtn);
		}
		public WebElement clikassignbtn4()
		{
			return driver.findElement(assignbtn4);
		}
		public WebElement clikassignLicencetobtn()
		{
			return driver.findElement(assignLicencetobtn);
		}
		public WebElement clikselect18004option()
		{
			return driver.findElement(select18004option);
		}
		public WebElement clikremoveLicence()
		{
			return driver.findElement(removeLicence);
		}
		public WebElement cliksavebtninAssignLicense()
		{
			return driver.findElement(savebtninAssignLicense);
		}
		public WebElement clikrmvbtninUnassignLicence()
		{
			return driver.findElement(rmvbtninUnassignLicence);
		}
		public WebElement cliktoggleofclicencemgmgt()
		{
			return driver.findElement(toggleofclicencemgmgt);
		}
	
		public WebElement clikloginbtn()
		{
			return driver.findElement(loginbtn);
		}
		public WebElement clikancillaryproducts()
		{
			return driver.findElement(ancillaryproducts);
		}
		public WebElement clikcobrandingbtn()
		{
			return driver.findElement(cobrandingbtn);
		}
		public WebElement cliktechsupportnumber()
		{
			return driver.findElement(techsupportnumber);
		}
		public WebElement cliksavetechsupportnumbr()
		{
			return driver.findElement(savetechsupportnumbr);
		}
		
		public WebElement cliksaveandnextbtnincobranding()
		{
			return driver.findElement(saveandnextbtnincobranding);
		}
		public WebElement clikmanagebtn()
		{
			return driver.findElement(managebtn);
		}
		public WebElement clikeditaddonfee()
		{
			return driver.findElement(editaddonfee);
		}
		public WebElement cliksaveinancillaryproduct()
		{
			return driver.findElement(saveinancillaryproduct);
		}
		public WebElement clikcreateaNewLogin()
		{
			return driver.findElement(createaNewLogin);
		}
		public WebElement clikusername()
		{
			return driver.findElement(username);
		}
		public WebElement clikdisplayname()
		{
			return driver.findElement(displayname);
		}
		public WebElement clikemailid()
		{
			return driver.findElement(emailid);
		}
		public WebElement clikconfirmemailid()
		{
			return driver.findElement(confirmemailid);
		}
		public WebElement clikaccessLevel()
		{
			return driver.findElement(accessLevel);
		}
		public WebElement cliksavebtninNewLogin()
		{
			return driver.findElement(savebtninNewLogin);
		}
		public WebElement clikcancelbtninNewLogin()
		{
			return driver.findElement(cancelbtninNewLogin);
		}
		
		public WebElement clikuploadImagebtnindropdown()
		{
			return driver.findElement(uploadImagebtnindropdown);
		}
		public WebElement clikclickheretouploadanimagebtn()
		{
			return driver.findElement(clickheretouploadanimagebtn);
		}
		public WebElement clikuploadimgbtninchooseyourAvatar()
		{
			return driver.findElement(uploadimgbtninchooseyourAvatar);
		}
		public WebElement clikuserIdWallet()
		{
			return driver.findElement(userIdWallet);
		}
		public WebElement clikofficeWallet()
		{
			return driver.findElement(officeWallet);
		}
		public WebElement clickbreadcrumblinkforFirstOfc()
		{
			return driver.findElement(breadcrumblinkforFirstOfc);
		}
		
		
}








