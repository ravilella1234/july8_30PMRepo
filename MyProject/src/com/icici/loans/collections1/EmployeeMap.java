package com.icici.loans.collections1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmployeeMap 
{

	public static void main(String[] args) 
	{
		Map<Integer, Employ> hasMap = new HashMap<Integer, Employ>();
		
		Employ e1 = new Employ(101, "ravikanth_1");
		Employ e2 = new Employ(102, "ravikanth_2");
		Employ e3 = new Employ(103, "ravikanth_3");
		Employ e4 = new Employ(104, "ravikanth_4");
		
		hasMap.put(e1.getEmpNo(), e1);
		hasMap.put(e2.getEmpNo(), e2);
		hasMap.put(e3.getEmpNo(), e3);
		hasMap.put(e4.getEmpNo(), e4);
		
		Set<Entry<Integer, Employ>> entries = hasMap.entrySet();
		
		for( Entry<Integer, Employ> emp : entries)
		{
			Integer key = emp.getKey();
			System.out.println(key);
			Employ value = emp.getValue();
			value.display();
			
		}
		

	}

}
