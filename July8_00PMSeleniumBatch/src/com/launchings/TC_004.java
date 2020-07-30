package com.launchings;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{
	
	
	public static void main(String[] args) throws Exception 
	{
		
		
		init();
		test = report.startTest("TC_004");
		test.log(LogStatus.INFO, "Initilizing Properties files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + childProperty.getProperty("amazonurl"));
		
		selectOption("amazondropdown_name","Books");
		test.log(LogStatus.PASS, "Selected the option Books By using locator :-" + or.getProperty("amazondropdrop_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		test.log(LogStatus.FAIL, "Entered the text Harry Potter By using the locator :- " + or.getProperty("amazonserachtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on Element By using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
	
		report.endTest(test);
		report.flush();
	}

	
}
