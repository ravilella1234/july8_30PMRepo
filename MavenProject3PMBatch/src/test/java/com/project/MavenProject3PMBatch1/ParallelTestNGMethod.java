package com.project.MavenProject3PMBatch1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTestNGMethod 
{
	
	WebDriver driver;
	
  @Test(enabled = false)
  public void test1() 
  {
	  System.out.println("iam test1 Method..." + Thread.currentThread().getId());
  }
  
  @Test(enabled = false)
  public void test2() 
  {
	  System.out.println("iam test2 Method..." + Thread.currentThread().getId());
  }
  
  @Test(enabled = false)
  public void test3() 
  {
	  System.out.println("iam test3 Method..." + Thread.currentThread().getId());
  }
  
  
  @Test
  public void amazon()
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in");
  }
  
  @Test
  public void flipkart()
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com");
	  
  }
  
  
}
