package com.verifications;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.launchings.BaseTest;

public class TC_009 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		
		String actualLink = driver.findElement(By.linkText("New Releases")).getAttribute("innerHTML");
		String expecteLink = "New Release";
		
		SoftAssert s = new SoftAssert();
		//s.assertEquals(actualLink, expecteLink);
		s.assertTrue(actualLink.equals(expecteLink), "Both links are not equal...");
		
		s.assertTrue(false, "err1");
		
		s.assertTrue(true, "err2");
		
		s.assertTrue(false, "err3");
		
		driver.findElement(By.linkText("New Releases")).click();
		
		s.assertAll();

	}

}
