package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatabaseSettingsPO {
	public WebDriver driver;
	public DatabaseSettingsPO(WebDriver driver) 
	{
		this.driver=driver;
	}
		//------------------------------cities/zipcodes-----------------------------------------------------------------------
		By databselink = By.xpath("//div[@class = 'link-text'][text() = 'Database']");//Database link
		By citieszipcodeslink = By.id("dbSidebarItem-0");//citieszipcode link in left menu
		By addnewbtn = By.id("btnAddNewRecordUserDB");//Add new button 
		By citieszipcodetxtbox = By.id("txtZipCodeUpsertZipCode");// zip code text box on Add zip code modal
		By citiescitytxtbox = By.id("txtZipCodeUpsertZipCity");// city text box on add zip code modal
		By citiesstatecodetxtbox = By.id("txtZipCodeUpsertZipState");//state code txt box on add zip code modal
		By citiesdistricttxtbox = By.id("txtZipCodeUpsertZipDistrict");//district txt box on add zip code modal
		By citiesaddbtn = By.xpath("//button[@id='btnUpsertZipCode']");
				//By.id("btnUpsertZipCode");// add btn in add zip code modal btnUpsertZipCode
		By citiescancelbtn = By.id("btnCancelAddUpsertZipCode");//cancel btn in the add zip code modal
		By editbtn = By.xpath("//span[text() = 'Edit']");// First Edit button  
		By firstTestCityAdded = By.xpath("//*[contains(text(),'TEST CITY EDITED']"); // first location in cities
		By threedots = By.xpath("//img[@src = '/images/icons/menu_vertical.png']");//three dots on hover
		
		By searchfield = By.id("txtUserDBFilterString");// search field
		//By citiesdeletebtn = By.xpath("//li[text() = 'Delete']"); //Delete city button
		By citiesdeletebtn	= By.xpath("//span[@class = 'jss361']");
		By citiesdeltitle = By.id("confirm-delete-rec-title");// Delete title
		By citiesdeletemodaldelbtn = By.id("btnDoDeleteFormViewer");//delete btn in the delete modal
		//--------------------------Employer/Payer---------------------------------------------------------------------
		By employerspayerslink = By.id("dbSidebarItem-1");// Employers/payerslink on the left menu
		By empfederaleintxtbx = By.id("txtEINIDUpsertEmployerEIN");// federal Ein txt box
		By empnamecontroltxtbx = By.id("txtNameControlUpsertEmployerNamecrtl");//Nmae ctrl field
		By empcompanyname = By.id("txtNameControlUpsertEmployerName");// company name field
		By empuseforeignaddchkbx = By.id("chkDomesticAddrEduInst");// Use foreign add chk box
		By empcareofaddtxtbx = By.id("txtEINIDUpsertEmployerCOAddress");//care of add in domestic add
		By empcompanyaddtxtbx = By.id("txtEINIDUpsertEmployerFirmAddress");// company add field
		By empcitytxtbx = By.id("txtNameControlUpsertEmployerCity");// city field 
		By empstatetxtbx = By.id("selectDropDownUpsertEmployerState");
		By empCAstate = By.id("UpsertEmployeroptSelectCA");//CA state from the list
		By empzipcodetxtbx = By.id("txtNameControlUpsertEmployerZipCode");//zip code
		By empstate1txtbx = By.id("txtEINIDUpsertEmployerState1");//state 1
		By empstate1identftxtbx = By.id("txtEINIDUpsertEmployerStateID1");//state1 identification box 
		By empstate2txtbx = By.id("txtEINIDUpsertEmployerState2");//state 2
		By empstate2identftxtbx = By.id("txtEINIDUpsertEmployerState2");// state 2 identification box
		By empsavebtn = By.id("btnUpsertEmployer");//add button
		By empcancelbtn = By.id("btnCancelAddUUpsertEmployer");//cancel button
		//--------------------------------Care Providers-----------------------------------------------------------------------
		By careproviderslink = By.id("dbSidebarItem-2");// care providers link on the left menu
		By providercode = By.id("txtEINIDUpsertCareProviderProvCode");//provider code text box
		By providertype = By.id("txtNameControlUpsertCareProvider");//provider type txt box
		By providernamecontrol = By.id("txtNameControlUpsertCareProviderNamecrtl");//name control txt box
		By careprovidername = By.id("txtNameControlUpsertCareProviderName");//provider name
		By careproviderphnum = By.id("txtNameControlUpsertCareProviderPhone");
		By provideradd = By.id("txtEINIDUpsertCareProviderAddress");//care provider address
		By providercity = By.id("txtNameControlUpsertCareProviderCity");//care provider city
		By providerstate = By.id("selectDropDownUpsertCareProviderState");//care provider state
		By providerCAstate = By.id("UpsertCareProvideroptSelectCA");//CA state
		By providerzipcode = By.id("txtNameControlUpsertCareProviderZipCode");//care provider zip code
		By providercancelbtn = By.id("btnCancelAddUUpsertCareProvider");//care provider cancel button
		By providersavebtn = By.id("btnUpsertCareProvider");// care provider add button
		//--------------------------------------Referrals---------------------------------------------------------------------------
		By referralslink = By.id("dbSidebarItem-3");//referrals link in the left menu
		By referralsname = By.id("txtReferralNameUpsertReferralName");// referrals name
		By referralscancelbtn = By.id("btnCancelAddUUpsertReferral");// referrals cancel btn
		By referralsaddbtn = By.id("btnUpsertReferral");// referrals add btn
		//--------------------------------------Donee------------------------------------------------------------------
		By doneelink = By.id("dbSidebarItem-4");//donee link in the left menu
		By doneeein = By.id("txtEINIDUpsertDoneeEIN");// donee EIN
		By doneename = By.id("txtNameControlUpsertDoneeName");// donee name
		By doneeadd = By.id("txtEINIDUpsertDoneeAddress");// donee add
		By doneecity = By.id("txtNameControlUpsertDoneeCity");// donee city
		By doneestate = By.id("selectDropDownUpsertDoneeState");// donee state
		By doneeCAstate = By.id("UpsertDoneeoptSelectCA");//donee state CA
		By doneezipcode = By.id("txtNameControlUpsertDoneeZipCode");// donee zip code
		By doneecancelbtn = By.id("btnCancelAddUUpsertDonee");// donee cancel btn
		By doneesavebtn = By.id("btnUpsertDonee");// donee add btn
		//-------------------------------------Bank RTNs-----------------------------------------------------------------------
		By bankrtnslink = By.id("dbSidebarItem-5");//bank rtnslink in the left menu
		By bankrtn = By.id("txtBankRtnUpsertBankRtnNumber");//bank rtn
		By bankname = By.id("txtBankRtnUpsertBankRtnName");//bank name
		By bankcancelbtn = By.id("btnCancelAddUpsertBankRtn");// bank cancel btn
		By banksavebtn = By.id("btnUpsertBankRtn");//bank add btn
		//-------------------------------------Occupations---------------------------------------------------------------------
		By occupationslink = By.id("dbSidebarItem-6");// occupations link
		By occupationname = By.id("txtOccupationUpsertOccupationn");// Occupation name
		By occupationcancelbtn = By.id("btnCancelAddUpsertOccupation");// occupation cancel btn
		By occupationaddbtn = By.id("btnUpsertOccupation");// occupation add btn
		//------------------------------------Site Identifiers-----------------------------------------
		By siteidentifierlink = By.id("dbSidebarItem-7");
		By sitecode = By.id("txtsiteCodeUpsertSiteIdentifier");
		By sitedescription = By.id("txtsiteDescriptionUpsertSiteIdentifier");
		By siteidentifieraddbtn = By.id("btnUpsertReferral");
		//--------------------------------------Users status code---------------------------------------
		By userstatuscodelink = By.id("dbSidebarItem-8"); //userstatus code link in the left menu
		By addnewbtninuserstatuscode = By.id("mdlNewRecordModalUserDBTable"); //add new btn in user status code
		By userstatuscodetxtbox = By.id("txtBankRtnUpsertBankRtnNumber"); //code text box
		By statusdesctextbox = By.id("txtBankRtnUpsertBankRtnName"); // status desc
		By addstatuscodebtn = By.id("btnUpsertBankRtn"); //add status code btn
		By statuscodeeditbtn = By.id("btnEditUserDBTable"); //Edit status code
		//By statuscode
		//------------------------------------Educational Institutions------------------------------------------------------------------------
		By educationalinstlink = By.id("dbSidebarItem-9");//educational inst link in the left menu
		By edufederalein = By.id("txtEINIDUpsertEduInstEIN");// edu frderal EIN
		By eduinstitutionname = By.id("txtNameControlUpsertEduInstName");// Institution name
		By educareofadd = By.id("txtEINIDUpsertEduInstCOAddress");// care of add
		By eduinstitutionadd = By.id("txtEINIDUpsertEduInstFirmAddress");// Institution address
		By educity = By.id("txtNameControlUpsertEduInstCity");// city
		By edustate = By.id("selectDropDownUpsertEduInstState");//state
		By eduCAstate = By.id("UpsertEduInstoptSelectCA");//CA state
		By eduzipcode = By.id("txtNameControlUpsertEduInstZipCode");//zip code
		By eduuseforeignaddchk = By.id("chkDomesticAddrEduInst");//use foreign add chk box
		By educancelbtn = By.id("btnCancelAddUUpsertEduInst");// cancel btn
		By eduaddbtn = By.id("btnUpsertEduInst");//add btn
		//--------------------------------close button to come out of DB--------------------------------------------------------------------------
		By databaseclosebtn = By.id("btnSaveAndCloseSettingsProfile");
		//-------------------------------------------------------zipcode/cities-----------------------------------------------------------
		
		public WebElement clickdatabaselink()
		{
			return driver.findElement(databselink);
		}
		public WebElement clickcitieszipcodeslink()
		{
			return driver.findElement(citieszipcodeslink);
		}
		public WebElement clickaddnewbtn()
		{
			return driver.findElement(addnewbtn);
		}
		public WebElement clickcitieszipcodetxtbox()
		{
			return driver.findElement(citieszipcodetxtbox);
		}
		public WebElement clickcitiescitytxtbox()
		{
			return driver.findElement(citiescitytxtbox);
		}
		public WebElement clickcitiesstatecodetxtbox()
		{
			return driver.findElement(citiesstatecodetxtbox);
		}
		public WebElement clickcitiesdistricttxtbox()
		{
			return driver.findElement(citiesdistricttxtbox);
		}
		public WebElement clickcitiesaddbtn()
		{
			return driver.findElement(citiesaddbtn);
		}
		public WebElement clickcitiescancelbtn()
		{
			return driver.findElement(citiescancelbtn);
		}
		public WebElement clickeditbtn()
		{
			return driver.findElement(editbtn);
		}
		public WebElement getfirstTestCityAdded()
		{
			return driver.findElement(firstTestCityAdded);
		}
		public WebElement clickthreedots()
		{
			return driver.findElement(threedots);
		}
		public WebElement clicksearchfield()
		{
			return driver.findElement(searchfield);
		}
		public WebElement clickcitiesdeletebtn()
		{
			return driver.findElement(citiesdeletebtn);
		}
		public WebElement clickcitiesdeltitle()
		{
			return driver.findElement(citiesdeltitle);
		}
		public WebElement clickcitiesdeletemodaldelbtn()
		{
			return driver.findElement(citiesdeletemodaldelbtn);
		}
		
	//-----------------------------Employer/Payer------------------------------------------------------------------------------
		public WebElement clickemployerspayerslink()
		{
			return driver.findElement(employerspayerslink);
		}
		public WebElement clickempfederaleintxtbx()
		{
			return driver.findElement(empfederaleintxtbx);
		}
		public WebElement clickempnamecontroltxtbx()
		{
			return driver.findElement(empnamecontroltxtbx);
		}
		public WebElement clickempcompanyname()
		{
			return driver.findElement(empcompanyname);
		}
		public WebElement clickempcareofaddress()
		{
			return driver.findElement(empcareofaddtxtbx);
		}
		public WebElement clickempcompanyaddress()
		{
			return driver.findElement(empcompanyaddtxtbx); 
		}
		public WebElement clickempcitytxtbx()
		{
			return driver.findElement(empcitytxtbx);
		}
		public WebElement clickempstatetxtbx()
		{
			return driver.findElement(empstatetxtbx);
		}
		public WebElement clickempCAstatetxtbx()
		{
			return driver.findElement(empCAstate);
		}
		public WebElement clickempzipcodetxtbx()
		{
			return driver.findElement(empzipcodetxtbx);
		}
		public WebElement clickempuseforeignaddchkbx()
		{
			return driver.findElement(empuseforeignaddchkbx);
		}
		public WebElement clickempstate1txtbx()
		{
			return driver.findElement(empstate1txtbx);
		}
		public WebElement clickempstate1identftxtbx()
		{
			return driver.findElement(empstate1identftxtbx);
		}
		public WebElement clickempstate2txtbx()
		{
			return driver.findElement(empstate2txtbx);
		}
		public WebElement clickempstate2identftxtbx()
		{
			return driver.findElement(empstate2identftxtbx);
		}
		public WebElement clickempsavebtn()
		{
			return driver.findElement(empsavebtn);
		}
		//-------------------------------------care providers----------------------------------------------------------------
		public WebElement clickcareproviderslink()
		{
			return driver.findElement(careproviderslink);
		}
		public WebElement clickprovidercode()
		{
			return driver.findElement(providercode);
		}
		public WebElement clickprovidertype()
		{
			return driver.findElement(providertype);
		}
		public WebElement clickprovidernamecontrol()
		{
			return driver.findElement(providernamecontrol);
		}
		public WebElement clickcareprovidername()
		{
			return driver.findElement(careprovidername);
		}
		public WebElement clickcareproviderphnum()
		{
			return driver.findElement(careproviderphnum);
		}
		public WebElement clickprovideradd()
		{
			return driver.findElement(provideradd);
		}
		public WebElement clickprovidercity()
		{
			return driver.findElement(providercity);
		}
		public WebElement clickproviderstate()
		{
			return driver.findElement(providerstate);
		}
		public WebElement clickproviderCAstate()
		{
			return driver.findElement(providerCAstate);
		}
		public WebElement clickproviderzipcode()
		{
			return driver.findElement(providerzipcode);
		}
		public WebElement clickprovidercancelbtn()
		{
			return driver.findElement(providercancelbtn);
		}
		public WebElement clickprovidersavebtn()
		{
			return driver.findElement(providersavebtn);
		}
		//---------------------------------------Referrals--------------------------------------------------------------------
		public WebElement clickreferralslink()
		{
			return driver.findElement(referralslink);
		}
		public WebElement clickreferralsname()
		{
			return driver.findElement(referralsname);
		}
		public WebElement clickreferralscancelbtn()
		{
			return driver.findElement(referralscancelbtn);
		}
		public WebElement clickreferralsaddbtn()
		{
			return driver.findElement(referralsaddbtn);
		}
		//------------------------------------Donee--------------------------------------------------------------------
		public WebElement clickdoneelink()
		{
			return driver.findElement(doneelink);
		}
		public WebElement clickdoneeein()
		{
			return driver.findElement(doneeein);
		}
		public WebElement clickdoneename()
		{
			return driver.findElement(doneename);
		}
		public WebElement clickdoneeadd()
		{
			return driver.findElement(doneeadd);
		}
		public WebElement clickdoneecity()
		{
			return driver.findElement(doneecity);
		}
		public WebElement clickdoneestate()
		{
			return driver.findElement(doneestate);
		}
		public WebElement clickdoneeCAstate()
		{
			return driver.findElement(doneeCAstate);
		}
		public WebElement clickdoneezipcode()
		{
			return driver.findElement(doneezipcode);
		}
		public WebElement clickdoneecancelbtn()
		{
			return driver.findElement(doneecancelbtn);
		}
		public WebElement clickdoneesavebtn()
		{
			return driver.findElement(doneesavebtn);
		}
		//------------------------------------------Bank RTNs-------------------------------------------------------------------
		public WebElement clickbankrtnslink()
		{
			return driver.findElement(bankrtnslink);
		}
		public WebElement clickbankrtn()
		{
			return driver.findElement(bankrtn);
		}
		public WebElement clickbankname()
		{
			return driver.findElement(bankname);
		}
		public WebElement clickbankcancelbtn()
		{
			return driver.findElement(bankcancelbtn);
		}
		public WebElement clickbanksavebtn()
		{
			return driver.findElement(banksavebtn);
		}
		//---------------------------------------------Occupations---------------------------------------------------------------
		public WebElement clickoccupationslink()
		{
			return driver.findElement(occupationslink);
		}
		public WebElement clickoccupationname()
		{
			return driver.findElement(occupationname);
		}
		public WebElement clickoccupationcancelbtn()
		{
			return driver.findElement(occupationcancelbtn);
		}
		public WebElement clickoccupationaddbtn()
		{
			return driver.findElement(occupationaddbtn);
		}
		//--------------------------------Site Identifiers ---------------------------------------------------------------------
		
		public WebElement clicksiteidentifierlink()
		{
			return driver.findElement(siteidentifierlink);
		}
		public WebElement getsitecode()
		{
			return driver.findElement(sitecode);
		}
		public WebElement getsitedescription()
		{
			return driver.findElement(sitedescription);
		}
		public WebElement clicksiteidentifieraddbtn()
		{
			return driver.findElement(siteidentifieraddbtn);
		}
		//--------------------------------------userstatuscode -----------------------------------
		
		public WebElement clickuserstatuscodelink ()
		{
			return driver.findElement(userstatuscodelink);
		}
		public WebElement clickaddnewbtninuserstatuscode()
		{
			return driver.findElement(addnewbtninuserstatuscode);
		}
		public WebElement clickuserstatuscodetxtbox()
		{
			return driver.findElement(userstatuscodetxtbox);
		}
		public WebElement clickstatusdesctextbox()
		{
			return driver.findElement(statusdesctextbox);
		}
		public WebElement clickaddstatuscodebtn()
		{
			return driver.findElement(addstatuscodebtn);
		}
		public WebElement clickstatuscodeeditbtn()
		{
			return driver.findElement(statuscodeeditbtn);
		}
		//---------------------------------Educational Institutions-------------------------------------------------------------
		public WebElement clickeducationalinstitutionslink()
		{
			return driver.findElement(educationalinstlink);
		}
		public WebElement clickedufederalein()
		{
			return driver.findElement(edufederalein);
		}
		public WebElement clickeduinstitutionname()
		{
			return driver.findElement(eduinstitutionname);
		}
		public WebElement clickeducareofadd()
		{
			return driver.findElement(educareofadd);
		}
		public WebElement clickeduinstitutionadd()
		{
			return driver.findElement(eduinstitutionadd);
		}
		public WebElement clickeducity()
		{
			return driver.findElement(educity);
		}
		public WebElement clickedustate()
		{
			return driver.findElement(edustate);
		}
		public WebElement clickeduzipcode()
		{
			return driver.findElement(eduzipcode);
		}
		public WebElement clickeduuseforeignaddchk()
		{
			return driver.findElement(eduuseforeignaddchk);
		}
		public WebElement clickeducancelbtn()
		{
			return driver.findElement(educancelbtn);
		}
		public WebElement clickeduaddbtn()
		{
			return driver.findElement(eduaddbtn);
		}
		public WebElement clickeduCAstate()
		{
			return driver.findElement(eduCAstate);
		}
		
	//--------------------------------------------------------------------------------	
		public WebElement clickdatabaseclosebtn()
		{
			return driver.findElement(databaseclosebtn);
		}

}
