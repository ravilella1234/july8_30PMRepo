package parallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestMethodParallelExecution 
{
	
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("iam beforemethod");
  }
  
  @Test
  public void test1() 
  {
	  System.out.println("iam test1");
  }
  
  @Test
  public void test2() 
  {
	  System.out.println("iam test2");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("iam afterMethod");
  }

}
