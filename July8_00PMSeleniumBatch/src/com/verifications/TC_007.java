package com.verifications;

import com.launchings.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		init();
		test = report.startTest("TC_007");
		test.log(LogStatus.INFO, "Initilizing Properties files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + childProperty.getProperty("amazonurl"));
		
		String expecteLink = "New Release";
		
		if(!verifyLink(expecteLink))
			reportFailue("Both links are not equal...");
		else
			reportSuccess("Both links are equal...");
		
		report.endTest(test);
		report.flush();

	}

		

}
