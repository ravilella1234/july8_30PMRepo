package excelOperations;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataManagementwithHashTable 
{
	
	@Test(dataProvider = "getData")
	public void testcase(Hashtable<String, String> data)
	{
		if(data.get("Runmode").equals("Y"))
		System.out.println(data.get("Runmode") + "--- " +data.get("Browser"));
	}
	
	@DataProvider
	public Object[][] getData() throws Exception 
	{
		ExcelAPI xls = new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "LoginTest";
		
		int testStartRowNum = 0;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Stars from row :- " + testStartRowNum);
		
		
		int colStarRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		
		//calculate the rows of data
		int rows = 0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are : - " + rows);
		
		
		
		
		//calculate the total columns
		int cols = 0;
		while(!xls.getCellData(sheetName, cols, colStarRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns are :- " + cols);
		
		
		
		//read the data
		int dataRow =0;
		Object[][] data = new Object[rows][1];
		Hashtable<String, String>  table = null;
		
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//data[dataRow][cNum]=xls.getCellData(sheetName, cNum, rNum);
				String key = xls.getCellData(sheetName, cNum, colStarRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
		
	}

}
