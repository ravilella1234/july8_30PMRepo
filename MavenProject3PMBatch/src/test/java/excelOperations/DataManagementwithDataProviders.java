package excelOperations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataManagementwithDataProviders 
{
	
	@Test(dataProvider = "getData")
	public void testcase(String Runmode, String Col1, String Col2,String Col3,String Col4)
	{
		
	}
	
	@DataProvider
	public Object[][] getData() throws Exception 
	{
		ExcelAPI xls = new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestA";
		
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
		Object[][] data = new Object[rows][cols];
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				data[dataRow][cNum]=xls.getCellData(sheetName, cNum, rNum);
			}
			dataRow++;
		}
		return data;
		
	}

}
