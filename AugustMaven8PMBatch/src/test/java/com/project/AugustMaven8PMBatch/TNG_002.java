package com.project.AugustMaven8PMBatch;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest
{
	
  
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  	init();
		test = report.startTest("TC_004");
		test.log(LogStatus.INFO, "Initilizing Properties files....");
		
		launch(bType);
		test.log(LogStatus.INFO, "Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + childProperty.getProperty("amazonurl"));
  }
  
  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	    selectOption("amazondropdown_name","Books");
		test.log(LogStatus.PASS, "Selected the option Books By using locator :-" + or.getProperty("amazondropdrop_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		test.log(LogStatus.FAIL, "Entered the text Harry Potter By using the locator :- " + or.getProperty("amazonserachtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on Element By using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }
  
    

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	    report.endTest(test);
		report.flush();
		
		driver.quit();
  }

}
