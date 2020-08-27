package excelDataDriven;

public class DataDriven 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:/Users/DELL/Desktop/testdata.xlsx");

		System.out.println(e.getRowCount("login"));
		
		System.out.println(e.columnCount("login"));
		
		System.out.println(e.getCellData("login", 1, 2));
		
		System.out.println(e.getCellData("login", "UserName", 1));
		
		e.setCellData("login", 4, 2, "failed");
	}

}
