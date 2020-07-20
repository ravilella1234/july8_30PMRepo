package excelOperations;

public class DataManagement 
{

	public static void main(String[] args) throws Exception 
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
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<cols;cNum++)
			{
				System.out.println(xls.getCellData(sheetName, cNum, rNum));
			}
			
		}
		
	}

}
