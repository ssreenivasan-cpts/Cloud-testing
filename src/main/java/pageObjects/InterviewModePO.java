package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InterviewModePO {
	
		public WebDriver driver;
		public InterviewModePO(WebDriver driver) {
			this.driver=driver;
		}

By interviewicon = By.id("interviewModeIcon");//Interview mode icon on the top menu 
By confirmintvforms = By.id("btnConfirmDialog");
By cancelintvforms = By.id("btnConfirmDialog");
By intvmarriedicon = By.xpath("//*[@id='002000']");
By intvsingleicon = By.xpath("//*[@id='ivmsingle0']");
//By.xpath("//*[@id='zmarried0']");
//By.xpath("//*[@id='icons8-one_ring']");
//By.id("zmarried0");//Married icon in interv mode
By intvhadchldicon = By.xpath("//*[@id='003000']");//Had children icon in intv mode
By intvhadjobicon = By.xpath("//*[@id='006000']");//Had Job Icon in intv mode
By intviconpgNextbtn = By.id("Z005150");// Next btn in the Intrv icon page for 2020
By intvpaidDaycareexp = By.id("#FF3D00");//daycareexp 20
By intvearnedInterest = By.id("#d7ecf7"); //Earned Interest
By intvhadPension = By.id("#A5D6A7"); //pension
By intvownedRentals= By.id("#3949AB"); //for schE


//----------------------------Filing Status Page-------------------------------------------------------------
By intvMFJbox = By.id("003000");// Married Filling Jointly text box
By intvSinglebox = By.id("001000");//Single Filing 
By intvFSpgNextbtn = By.id("Z020921");//Next btn in Filing status pg-TY2018
By intvFSpgNextbtn_19 = By.id("Z030280");//Next btn in Filing status pg-TY2022 Z030280

//------------------------Personal Information Page--------------------------------------------------------------
By intvTPfirstname = By.id("PNMA00");//Tax payer's first name txt box
By intvTPlastname = By.id("PNMC00");// Tax payer's last name
By intvTPdob = By.id("PDOB00");//TP's DOB field 
By intvTPoccupation = By.id("132200");//TP's occupation
By intvTPhomeph = By.id("HOME00");//TP's home phone number
By intvTPIDnumber = By.id("LA0300"); //TP ID number-- 2023
By intvTPIDstate = By.id("LB0300"); //TP ID state
By intvTPIDdateissued = By.id("LD0300");// TP ID date issued
By intvTPIDdateexpired = By.id("LC0300");//TP id expiry date
By intvTPIDtype = By.id("lA0300");//TP id type
By intvTPremotesignconsent = By.id("RMST00"); //TP remote sign consent
By intvremotesignchargesconsent = By.id("RMSC00"); //
								//-----Spouse's Personal Info-----
By intvSPfirstname = By.id("SNMA00");//Sp's first name
By intvSPlastname = By.id("SNMC00");//SP's last name
By intvSPdob = By.id("SDOB00");//SP's dob
By intvSPoccuaption = By.id("132700");//SP's occupation
By intvSPrmtesignconsent = By.id("RMSS00"); //spouse remote signature yes prod
By intvperinfopgNextbtn18 = By.id("Z0204745");// Next btn in Personal information page 2018
By intvperinfopgNextbtn19 = By.id("Z0203955");// Next btn in Personal information page 2019
By intvperinfopgNextbtn20 = By.id("Z020921");// Next btn in pers info page 2020 Z0204635 Z020921

//--------------------------------------Address Information----------------------------------------------------------------------
By intvusaddress = By.id("dadd00");// US add field
By intvcity = By.id("dcty00");// city field
By intvstate = By.id("dsta00");//state field
By intvzip = By.id("dzip00");//zip field
By intvlivedinUS = By.id("001000");// US citizen or lived in US  check
By intvTPhomeinUS = By.id("001500");//TP home more than half in US
By intvaddinfopgNextbtn = By.id("Z021310");//Next button in Add Info page
//----------------------------------Additional personal Information--------------------------------------------------------------------------------
By intvadditionalperinfopgNextbtn = By.id("Z022455");// Next button //changed for LA
By intvadditionalperinfopgNextbtn_State = By.id("Z022455");//2020  
//-----------------------------------Dependents and Others cared For----------------------------------------------
By intvyesdepstoclaim = By.id("001000");//Dependents to claim- Yes
By intvaddDependent = By.id("Z040860");//add dependent for prod
By intvyeshomeorsupport = By.id("003000");// Provide home/support - Yes
By intvdepspgNextbtn = By.id("Z0401750");// Next button
//-------------------------------------Dependent information page---------------------------------
By intvdependentFirstname = By.id("AA0300"); //dependent first name
By intvdependentLastname = By.id("AB0300"); //dependent last name
By intvdependentSSN = By.id("AD0300"); // dependent SSN
By intvdependentDOB = By.id("AY0300");//denendent DOB 
By intvdependentRelationshipstatus = By.id("AE0300"); // dependent status
By monthslivedwithTP = By.id("cJ0300");
By intvLiveswithyouchkbx = By.id("cB0300"); //liveswithyou 
By intvNoteligible = By.id("cJ0300"); //Child not eligible for EIC
By intvdependentCareExp = By.id("cS0300"); //daycareexpenses
By intvdependentinfoNextbtn = By.id("Z0415265"); //Next btn

//---------------------------------------Type Of Income ---------------------------------------------------------------------------
By intvaddTPW2frmbtn = By.id("Z0511100");// add Taxpayer Form btn-
By intvaddTPw2frombrn_State = By.id("Z0511095");
By intvtypofincNextbtn = By.id("Z05118465");// next btn in Type of Income pg Z05118465
By intvtypofincNextbtn20 = By.id("Z05119535");//type of income next btn 


By intvtypeofincSP1099INTbtn = By.id("Z0513915"); //type of income spouse 1099INT
By intvtypeofincTP1099Rbtn = By.id("Z0515965"); //TP 1099R
By intvtypeofincSCHEbtn = By.id("Z05114705");//sche btn

//---------------1099INT-----------------------------------------------------------------------

By intvpayersFEDID = By.id("005000"); //payer ID
By intvinterestInc = By.id("011000"); //interest income
By intvchoiceforInteresttype = By.id("011500"); //interest type
By intvFedincomewithheld = By.id("020000"); //FED withhold
By intvInterestincomeNextbtn = By.id("ZI03650"); //Next btn

//-------------------1099R------------------------------------------------------------------------
By intv1099RPayerID = By.id("005000");
By intv1099RGrossdistr = By.id("011000");
By intv1099RTaxableamt = By.id("011000");
By intv1099REmplycontr = By.id("011000");
By intv1099RDistribcode = By.id("011000");
By intv1099RNextbtn = By.id("ZI051155");
//---------SCHE---------------------------------------------------------------------------------
By intvscENextbtn = By.id("ZI20990"); //Next btn in schE


//--------------------------------W2 Form---------------------------------------------------------------------------
By intvw2_15_state = By.id("CA0300");//2023
By intvw2_15_empid = By.id("CB0300");
By intvw2_16_statewages = By.id("CC0300");
By intvw2_17_statetax = By.id("CD0300");

By intvW2frmNextbtn18 = By.id("ZI011025");// Next button in W2 frm2018
By intvW2frmNextbtn19 = By.id("ZI011015");// Next button in W2 frm2019 Z05118465
By intvW2frmNextbtn = By.id("Z05118465"); //Next button in W2 frm2020
//By intv


//-------------------------------Adjustments/Deductions Interview-----------------------------------------------------------------------------
By intvadjustmentspgNextbtn = By.id("Z065125");// next button 

//------------------------------------Credits Interview------------------------------------------------------------------------------------
By intvCreditspgAddform = By.id("Z070245");//Addform btn prod
By intvcreditspgNextbtn = By.id("Z07575");//Next button 
By intvcreditspgNextbtn20 = By.id("Z0701650"); //next btn in prod 2020


//-----------------------------------ChildcareInformation---------------------------------------
By intvChildcareName = By.id("AA0300");
By intvChildcareAmtpaid = By.id("BC0300");
By intvChildcarestreet = By.id("AC0300");
By intvChildcareZip = By.id("AG0300");
By intvChildcareIDinfo_SSN = By.id("aE0300");
By intvChildcareDonebtn = By.id("Z0711485");


//------------------------------------RebateRecoveryint----------------------------------------

By intvnostimulusreceived1 = By.id("m15000");
By intvnostimulusreceived2 = By.id("m20000");
By nextbtnRebaterecovsheet = By.id("Z07648");

//-------------------------------Health Care Coverage-------------------------------------------------------------------------
By intvhealthemployer = By.id("HCQ200");// By Employer in Health Care -only in 2018
By intmarketplcoverage_No = By.id("HCQn00"); //No marketplace coverage - only in 2019 
By intvhealthpgNextbtn = By.id("Z080205");// Next button Z080150
By intvhealthpgNextbtn20 =By.id("Z080150");//Next btn 2020 prod
By intvtaxcreditcalcpgNextbtn = By.id("Z0812010"); //Nextbtn in tax credits page-with state 

//--------------------------------Other Misc Items------------------------------------------------------------------
By intvmiscpgNextbtn = By.id("Z095140");// next button  
By intvmiscpgNextbtn20 = By.id("Z095145");//20202 next btn 
By intvotherMiscInterview20 = By.id("Z0902345"); //2020miscinterview Z0902325
By intvotherMiscInterview2ndNextbtn = By.id("Z0902325"); //2nd Misc Interview page Next btn

//------------------------------------EIC Checklist----------------------------------------------
By intvEicchecklistNextbtn = By.id("Z1091240"); 
//-----------------------------------PaidPrepDuediligencechecklist------------------------------
By intvPaidprepduediligneceNextbtn = By.id("Z1102315");
//--------------------------------FRM8867-------------------------------------------------------
//Using FRM8867PO for rest of the ids.
By intvFrm8867Nextbtn = By.id("Z1102750");

//--------------------------------State Returns-----------------------------------------------------------------------

By intvstateretpgNextbtn = By.id("Z10068");// Next button Z1091240
By intvstateretpgNextbtn20 =By.id("Z100330"); //2020 

//--------------------------------Results-------------------------------------------------------

By intvresultsNextbtn20 = By.id("Z800227"); //2020 Z800265

//-----------------------------Filing Options-------------------------------------------------------------------------------
By intvRTfinprod = By.id("814000");//changed -saranya
//By.id("fldTog8140");// RT financial Product field
By intvmailincheckbx = By.id("FIL100"); //2020
By intvFilingoptionsNextbtn = By.id("Z8011534"); //2020
//------------------------------FIling info----------------------------------------------------
By intvfinishbtn = By.id("Z803755");//Finish button


//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//2020
 
public WebElement clickinterviewicon()
{
	return driver.findElement(interviewicon);
}
public WebElement clickintvmarriedicon()
{
	return driver.findElement(intvmarriedicon);
} 
public WebElement clickintvsingleicon()
{
	return driver.findElement(intvsingleicon);
} 
public WebElement clickconfirmintvforms()
{
	return driver.findElement(confirmintvforms);
}
public WebElement clickcancelintvforms()
{
	return driver.findElement(cancelintvforms);
}
public WebElement clickintvhadchldicon()
{
	return driver.findElement(intvhadchldicon);
}
public WebElement clickintvhadjobicon()
{
	return driver.findElement(intvhadjobicon);
}
public WebElement clickintviconpgNextbtn()
{
	return driver.findElement(intviconpgNextbtn);
}
//forPROD
public WebElement clickintvpaidDaycareexp()
{
	return driver.findElement(intvpaidDaycareexp);
}
public WebElement clickintvearnedInterest()
{
	return driver.findElement(intvearnedInterest);
}
public WebElement clickintvhadPension()
{
	return driver.findElement(intvhadPension);
}
public WebElement clickintvownedRentals()
{
	return driver.findElement(intvownedRentals);
}
//----------------------------------------------------Filling Status-------------------------------------------------------------------------------------------------------------
public WebElement clickintvMFJbox()
{
	return driver.findElement(intvMFJbox);
}
public WebElement clickintvSinglebox()
{
	return driver.findElement(intvSinglebox);
}
public WebElement clickintvFSpgNextbtn()
{
	return driver.findElement(intvFSpgNextbtn);
}
public WebElement clickintvFSpgNextbtn_19()
{
	return driver.findElement(intvFSpgNextbtn_19);
}
//-----------------------------------------------------Personal Information Page------------------------------------------------------------------------------------------------------
public WebElement getintvTPfirstname()
{
	return driver.findElement(intvTPfirstname);
}
public WebElement getintvTPlastname()
{
	return driver.findElement(intvTPlastname);
}
public WebElement getintvTPdob()
{
	return driver.findElement(intvTPdob);
}
public WebElement getintvTPoccupation()
{
	return driver.findElement(intvTPoccupation);
}
public WebElement getintvTPhomeph()
{
	return driver.findElement(intvTPhomeph);
}

public WebElement getintvTPIDnumber()
{
	return driver.findElement(intvTPIDnumber);
}
public WebElement getintvTPIDstate()
{
	return driver.findElement(intvTPIDstate); //IDstate
}
public WebElement getintvTPIDdateissued()
{
	return driver.findElement(intvTPIDdateissued);
}
public WebElement getintvTPIDdateexpired()
{
	return driver.findElement(intvTPIDdateexpired);
}
public WebElement getintvTPIDtype()
{
	return driver.findElement(intvTPIDtype);
}
public WebElement getintvTPremotesignconsent()
{
	return driver.findElement(intvTPremotesignconsent);
} 

public WebElement getintvremotesignchargesconsent()
{
	return driver.findElement(intvremotesignchargesconsent);
} 
public WebElement getintvSPfirstname()
{
	return driver.findElement(intvSPfirstname);
}
public WebElement getintvSPlastname()
{
	return driver.findElement(intvSPlastname);
}
public WebElement getintvSPdob()
{
	return driver.findElement(intvSPdob);
}
public WebElement getintvSPoccupation()
{
	return driver.findElement(intvSPoccuaption);
}

public WebElement getintvSPrmtesignconsent()
{
	return driver.findElement(intvSPrmtesignconsent);
}

public WebElement clickintvperinfopgNextbtn18()
{
	return driver.findElement(intvperinfopgNextbtn18);
}
public WebElement clickintvperinfopgNextbtn19()
{
	return driver.findElement(intvperinfopgNextbtn19);
} 
public WebElement clickintvperinfopgNextbtn20()
{
	return driver.findElement(intvperinfopgNextbtn20);
}
//-------------------------------------------------------------Address Information-----------------------------------------------------------------------------------------------------
public WebElement getintvusaddress()
{
	return driver.findElement(intvusaddress);
}
public WebElement getintvcity()
{
	return driver.findElement(intvcity);
}
public WebElement getintvstate()
{
	return driver.findElement(intvstate);
}
public WebElement getintvzip()
{
	return driver.findElement(intvzip);
}
public WebElement getlivedinUS()
{
	return driver.findElement(intvlivedinUS);
}
public WebElement getintvTPhomeinUS()
{
	return driver.findElement(intvTPhomeinUS);
}
public WebElement clickaddinfopgNextbtn()
{
	return driver.findElement(intvaddinfopgNextbtn);
}
//-----------------------------------------------------------Additional personal information-----------------------------------------------------------------------------------------------------------------------------
public WebElement clickintvadditionalinfopgNextbtn()
{
	return driver.findElement(intvadditionalperinfopgNextbtn);
}
public WebElement clickintvadditionalperinfopgNextbtn()
{
	return driver.findElement(intvadditionalperinfopgNextbtn);
}

public WebElement clickintvadditionalperinfopgNextbtn_State()
{
	return driver.findElement(intvadditionalperinfopgNextbtn_State);
}
//------------------------------------------------------------Dependents--------------------------------------------------------------------------------------------------------------
public WebElement clickintvyesdepstoclaim()
{
	return driver.findElement(intvyesdepstoclaim);
}

public WebElement clickintvaddDependent()
{
	return driver.findElement(intvaddDependent);
}

public WebElement clickintvyeshomeorsupport()
{
	return driver.findElement(intvyeshomeorsupport);
}
public WebElement clickintvdepspgNextbtn()
{
	return driver.findElement(intvdepspgNextbtn);
}

//--------------------------------------------------------Dependentinfo-------------------------
public WebElement clickintvdependentFirstname()
{
	return driver.findElement(intvdependentFirstname);
}
public WebElement clickintvdependentLastname()
{
	return driver.findElement(intvdependentLastname);
}
public WebElement clickintvdependentSSN()
{
	return driver.findElement(intvdependentSSN);
}
public WebElement clickintvdependentDOB()
{
	return driver.findElement(intvdependentDOB);
}
public WebElement clickintvdependentRelationshipstatus()
{
	return driver.findElement(intvdependentRelationshipstatus);
}
public WebElement clickmonthslivedwithTP()
{
	return driver.findElement(monthslivedwithTP);
}

public WebElement clickintvLiveswithyouchkbx()
{
	return driver.findElement(monthslivedwithTP);
}
public WebElement clickintvNoteligible()
{
	return driver.findElement(intvNoteligible);
}
public WebElement clickintvdependentCareExp()
{
	return driver.findElement(intvdependentCareExp);
}
public WebElement clickintvdependentinfoNextbtn()
{
	return driver.findElement(intvdependentinfoNextbtn);
}

//----------------------------------------------------------------------Type of Income---------------------------------------------------------------------------------------------
public WebElement clickintvaddTPW2frmbtn()
{
	return driver.findElement(intvaddTPW2frmbtn);
}
public WebElement clickintvaddTPW2frmbtn_State()
{
	return driver.findElement(intvaddTPw2frombrn_State);
}
public WebElement clickintvtypofincNextbtn()
{
	return driver.findElement(intvtypofincNextbtn);
}
public WebElement clickintvtypofincNextbtn20()
{
	return driver.findElement(intvtypofincNextbtn20);
}
public WebElement clickintvtypeofincSP1099INTbtn()
{
	return driver.findElement(intvtypeofincSP1099INTbtn);
}
public WebElement clickintvtypeofincTP1099Rbtn()
{
	return driver.findElement(intvtypeofincTP1099Rbtn);
}
public WebElement clickintvtypeofincSCHEbtn()
{
	return driver.findElement(intvtypeofincSCHEbtn);
}

//--------------------------------------------------------------------1099INT-----------------
public WebElement clickintvpayersFEDID()
{
	return driver.findElement(intvpayersFEDID);
}
public WebElement clickintvinterestInc()
{
	return driver.findElement(intvinterestInc);
}
public WebElement clickintvchoiceforInteresttype()
{
	return driver.findElement(intvchoiceforInteresttype);
}
public WebElement clickintvInterestincomeNextbtn()
{
	return driver.findElement(intvInterestincomeNextbtn);
}
public WebElement clickintvFedincomewithheld()
{
	return driver.findElement(intvFedincomewithheld);
}
//----------------------------------------------------1099R-------------------------------------
public WebElement clickintv1099RPayerID()
{
	return driver.findElement(intv1099RPayerID);
}
public WebElement clickintv1099RGrossdistr()
{
	return driver.findElement(intv1099RGrossdistr);
}
public WebElement clickintv1099RTaxableamt()
{
	return driver.findElement(intv1099RTaxableamt);
}
public WebElement clickintv1099REmplycontr()
{
	return driver.findElement(intv1099REmplycontr);
}
public WebElement clickintv1099RDistribcode()
{
	return driver.findElement(intv1099RDistribcode);
}
public WebElement clickintv1099RNextbtn()
{
	return driver.findElement(intv1099RNextbtn);
}
//--------------------------------------------------------SCHE----------------------------------
public WebElement clickintvscENextbtn()
{
	return driver.findElement(intvscENextbtn);
}
//---------------------------------------------------------------------W2 Form-----------------------------------------------------------------

public WebElement getintvw2_15_state()
{
	return driver.findElement(intvw2_15_state);
}
public WebElement getintvw2_15_empid ()
{
	return driver.findElement(intvw2_15_empid );
}
public WebElement getintvw2_16_statewages()
{
	return driver.findElement(intvw2_16_statewages);
}
public WebElement getintvw2_17_statetax()
{
	return driver.findElement(intvw2_17_statetax);
}
public WebElement clickintvW2frmNextbtn18()
{
	return driver.findElement(intvW2frmNextbtn18);
}
public WebElement clickintvW2frmNextbtn19()
{
	return driver.findElement(intvW2frmNextbtn19);
}
public WebElement clickintvW2frmNextbtn20()
{
	return driver.findElement(intvW2frmNextbtn);
}
//-------------------------------------------------------------------Adjustments/Deductions Interview----------------------------------------------------------------------------------------------------------
public WebElement clickintvadjustmentspgNextbtn()
{
	return driver.findElement(intvadjustmentspgNextbtn);
}
//----------------------------------------------------------------------------Credits-----------------------------------------------------------------------------------------------

public WebElement clickintvCreditspgAddform()
{
	return driver.findElement(intvCreditspgAddform);
}

public WebElement clickintvcreditspgNextbtn()
{
	return driver.findElement(intvcreditspgNextbtn);
}

public WebElement clickintvcreditspgNextbtn20()
{
	return driver.findElement(intvcreditspgNextbtn20);
}
//-----------------------------------ChildcareInformation---------------------------------------

public WebElement getintvChildcareName()
{
	return driver.findElement(intvChildcareName);
}
public WebElement getintvChildcareAmtpaid()
{
	return driver.findElement(intvChildcareAmtpaid);
}
public WebElement getintvChildcarestreet()
{
	return driver.findElement(intvChildcarestreet);
}
public WebElement getintvChildcareZip()
{
	return driver.findElement(intvChildcareZip);
}
public WebElement getintvChildcareIDinfo_SSN()
{
	return driver.findElement(intvChildcareIDinfo_SSN);
}
public WebElement getintvChildcareDonebtn()
{
	return driver.findElement(intvChildcareDonebtn);
}

//---------------------------------------------- Recovery Rebate sheet------------------------------


public WebElement getintvnostimulusreceived1()
{
	return driver.findElement(intvnostimulusreceived1);
}
public WebElement getintvnostimulusreceived2()
{
	return driver.findElement(intvnostimulusreceived2);
}
public WebElement clicknextbtnRebaterecovsheet()
{
	return driver.findElement(nextbtnRebaterecovsheet);
}
//--------------------------------------------------------------------------Health care coverage---------------------------------------------------------------------------------------------------------------
public WebElement clickintvhealthemployer()
{
	return driver.findElement(intvhealthemployer);
}
public WebElement clickintmarketplcoverage_No()
{
	return driver.findElement(intmarketplcoverage_No);
}
public WebElement clickintvhealthpgNextbtn()
{
	return driver.findElement(intvhealthpgNextbtn);
}
public WebElement clickintvhealthpgNextbtn20()
{
	return driver.findElement(intvhealthpgNextbtn20);
}
public WebElement clickintvtaxcreditcalcpgNextbtn()
{
	return driver.findElement(intvtaxcreditcalcpgNextbtn);
}
//-------------------------------------------------------------------------Other Misc-------------------------------------------------------------------------------------------------------------
public WebElement clickintvmiscpgNextbtn()
{
	return driver.findElement(intvmiscpgNextbtn);
}

public WebElement clickintvmiscpgNextbtn20()
{
	return driver.findElement(intvmiscpgNextbtn20);
}
//--------------------------------------------------------------------other Misc Interview page
public WebElement clickintvotherMiscInterview20()
{
	return driver.findElement(intvotherMiscInterview20);
}
public WebElement clickintvotherMiscInterview2ndNextbtn()
{
	return driver.findElement(intvotherMiscInterview2ndNextbtn);
}
//----------------------------------------------------------- intvEicchecklist-------------
public WebElement clickintvEicchecklistNextbtn()
{
	return driver.findElement(intvEicchecklistNextbtn);
}

//-----------------------------------PaidPrepDuediligencechecklist------------------------------
public WebElement clickintvPaidprepduediligneceNextbtn()
{
	return driver.findElement(intvPaidprepduediligneceNextbtn);
}
//-------------------------------------------------------------------FRM8867--------------------
public WebElement clickintvstateretpgNextbtn20()
{
	return driver.findElement(intvstateretpgNextbtn20);
}
public WebElement clickintvresultsNextbtn20()
{
	return driver.findElement(intvresultsNextbtn20);
}
public WebElement clickintvRTfinprod()
{
	return driver.findElement(intvRTfinprod);
}
public WebElement clickintvmailincheckbx()
{
	return driver.findElement(intvmailincheckbx);
}
public WebElement clickintvFilingoptionsNextbtn()
{
	return driver.findElement(intvFilingoptionsNextbtn);
}




//-------------------------------------------------------------------------State Returns-------------------------------------------------------------------------------------------------------
public WebElement clickintvstateretpgNextbtn()
{
	return driver.findElement(intvstateretpgNextbtn);
}
//------------------------------------------------------------------------Filing Options-----------------------------------------------------------------------------------------------
public WebElement getintvRTfinprod()
{
	return driver.findElement(intvRTfinprod);
}
public WebElement clickintvfinishbtn()
{
	return driver.findElement(intvfinishbtn);
}
}
