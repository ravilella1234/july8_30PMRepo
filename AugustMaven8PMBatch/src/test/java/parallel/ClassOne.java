package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ClassOne 
{
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforeMethod  -  ClassOne");
  }
  
  @Test
  public void f() 
  {
	  System.out.println("testmethod - ClassOne");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("afterMethod - ClassOne");
  }

}
