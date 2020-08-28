package excelDataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class FianlRun 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  System.out.println(data.get("UserName"));
	  System.out.println(data.get("UserPassword"));
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelAPI e = new ExcelAPI("C:/Users/DELL/Desktop/suitex.xlsx");
	  String sheetName = "data";
	  String testCaseName = "LoginTest";
	  
	return DataUtils.getTestData(e, sheetName, testCaseName);
  }
}
