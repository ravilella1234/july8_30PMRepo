package com.project.MavenProject3PMBatch;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_001 
{
  @Test(priority = 1)
  public void f() 
  {
	  System.out.println("f");
  }
  
  @Test(priority = 2 , enabled = false)
  public void z() 
  {
	  System.out.println("z");
  }
  
  @Test(priority = 3)
  public void a() 
  {
	  System.out.println("a");
  }
  
  @BeforeMethod
  public void bMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void aMethod() {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void bClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void aClass() {
	  System.out.println("afterClass");
  }

  @BeforeTest
  public void bTest() {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void aTest() {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void bSuite() {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void aSuite() {
	  System.out.println("afterSuite");
  }

}
