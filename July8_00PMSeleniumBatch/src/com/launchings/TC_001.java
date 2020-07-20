package com.launchings;

import org.openqa.selenium.By;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("bankurl");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		//driver.navigate().back();
		
		//Thread.sleep(4000);
		
		//driver.navigate().forward();
		
		//Thread.sleep(4000);
		
		//driver.navigate().refresh();
		
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//ul[@class='buttons']//a[@class='c-button is-theme-solid-green-hollow-white'][contains(text(),'Apply Now')]")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
		//driver.quit();

	}

}
