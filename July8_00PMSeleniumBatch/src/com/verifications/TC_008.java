package com.verifications;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.launchings.BaseTest;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		
		String actualLink = driver.findElement(By.linkText("New Releases")).getAttribute("innerHTML");
		String expecteLink = "New Releases";
		
		//Assert.assertEquals(actualLink, expecteLink);
		Assert.assertTrue(actualLink.equals(expecteLink), "Both links are not equal...");

		driver.findElement(By.linkText("New Releases")).click();
	}

}
