package com.project.MavenProject3PMBatch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_003 extends BaseTest
{
	@BeforeTest
	@Parameters("browser")
	public void startprocess(String bType) throws Exception 
	{
		init();
		launchBrowser(bType); 
		navigateUrl("amazonurl");
	}
	
	@Test
	public void test()
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedLink = "Customer Servic";
		
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.equals(expectedLink), "Links are not equal...");
		
		SoftAssert s = new SoftAssert();
		
		//s.assertEquals(actualLink, expectedLink);
		s.assertTrue(actualLink.equals(expectedLink), "Links are not equal...");
		
		s.assertTrue(false, "error1");
		
		s.assertTrue(true, "error2");
		
		s.assertTrue(false, "error3");
		
		s.assertTrue(true, "error4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		
		s.assertAll();
	}

}
