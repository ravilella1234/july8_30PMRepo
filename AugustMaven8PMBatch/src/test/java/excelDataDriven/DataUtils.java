package excelDataDriven;

import java.util.Hashtable;

import com.project.AugustMaven8PMBatch.BaseTest;

public class DataUtils extends BaseTest
{

	public static Object[][] getTestData(ExcelAPI e, String sheetName, String testCaseName)
	{
				
		int testStartRowNum=0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Starts from row :- " + testStartRowNum);
		
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//calculate the rows of data
		int rows=0;
		while(!e.getCellData(sheetName, 0,dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are :- " + rows);
		
		//calculate total columns
		int cols=0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total columns are :-" + cols);

		int dataRow=0;
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table =null;
		
		//read the data
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>();
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum]= e.getCellData(sheetName, cNum, rNum);
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
	  
	return data;
		
	}
}
