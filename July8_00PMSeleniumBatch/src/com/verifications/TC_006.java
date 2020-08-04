package com.verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launchings.BaseTest;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");

		WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		
		loc.sendKeys("sony");
		String text = loc.getAttribute("value");
		System.out.println("Text : " + text);
	}

}
