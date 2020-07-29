package com.launchings;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	private static final Logger log= Logger.getLogger(TC_003.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initilizing Properties files....");
		
		launch("chromebrowser");
		log.info("Opened the Browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + childProperty.getProperty("amazonurl"));
		
		selectOption("amazondropdrop_id","Books");
		log.info("Selected the option Books By using locator :-" + or.getProperty("amazondropdrop_id"));
		
		typeText("amazonserachtext_id","Harry Potter");
		log.info("Entered the text Harry Potter By using the locator :- " + or.getProperty("amazonserachtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element By using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		
				
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	
}
