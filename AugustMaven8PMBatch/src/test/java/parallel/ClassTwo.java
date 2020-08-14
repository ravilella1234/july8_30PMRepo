package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ClassTwo 
{
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforeMethod  -  ClassTwo");
  }
  
  @Test
  public void f() 
  {
	  System.out.println("testmethod - ClassTwo");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("afterMethod - ClassTwo");
  }

}
