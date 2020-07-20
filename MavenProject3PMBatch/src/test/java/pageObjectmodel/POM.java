package pageObjectmodel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.MavenProject3PMBatch.BaseTest;

public class POM  extends BaseTest
{
	
  @BeforeMethod
  @Parameters("browser")
  public void startprocess(String bType) throws Exception
  {
	init();  
	launchBrowser(bType);
	navigateUrl("automationurl");
  }
  
  @Test
  public void login() throws Exception 
  {
	  Login obj = new Login(driver);
	  obj.customerLogin();
	  Assert.assertEquals(obj.verifyCustomerLogin(), "Authentication failed.");
  }

  @AfterMethod
  public void endProcess() 
  {
	  
  }

}
