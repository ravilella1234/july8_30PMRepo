package com.verifications;

import org.openqa.selenium.By;

import com.launchings.BaseTest;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		
		//String actualLink = driver.findElement(By.linkText("New Releases")).getText();
		String actualLink = driver.findElement(By.linkText("New Releases")).getAttribute("href");
		String expecteLink = "New Release";
		
		System.out.println("Actual Link :" +  actualLink);
		System.out.println("Expected Link :  " + expecteLink);
		
		//if(actualLink.equals(expecteLink))
		//if(actualLink.equalsIgnoreCase(expecteLink))
		if(actualLink.contains(expecteLink))
			System.out.println("Both links are equal...");
		else
			System.out.println("Both links are not equal....");

	}

}
