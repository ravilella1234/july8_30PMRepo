package com.icici.loans.collections1;

public class Employ 
{
	private int empNo;
	private String empName;
	
	public Employ(int empNo, String empName) 
	{
		super();
		this.empNo = empNo;
		this.empName = empName;
	}
	
	
	
	public int getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}


	public void display()
	{
		System.out.println("EmpID : " + empNo + "   "+ "EMPNAME : " + empName);
	}
	
	public static void main(String[] args) 
	{
		Employ e = new Employ(100, "ravilella");
		e.display();
	}
	
	
}
