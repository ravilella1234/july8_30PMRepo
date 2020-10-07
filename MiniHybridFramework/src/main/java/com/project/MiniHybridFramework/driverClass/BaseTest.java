package com.project.MiniHybridFramework.driverClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.project.MiniHybridFramework.utilities.ExcelAPI;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static  Properties baseProperties;
	public static  Properties childProperties; 
	public static ExcelAPI xls;
	
	public static void load() throws Exception
	{
		fis = new FileInputStream(projectPath+"//src//test//resources//environment.properties");
		baseProperties = new Properties();
		baseProperties.load(fis);
		String envType = baseProperties.getProperty("env");
		System.out.println(envType);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + envType + ".properties");
		childProperties = new Properties();
		childProperties.load(fis);
		String url = childProperties.getProperty("zohourl");
		System.out.println(url);
		
		//init the xls file
		xls = new ExcelAPI(childProperties.getProperty("suiteA_xls"));
		
		//How do i come to know which suite excel file to load ?
	}
	
	
	@BeforeTest
	public void  init() throws Exception
	{
		System.out.println("iam before Test.....");
		load();
	}
	
	@AfterTest
	public void end()
	{
		System.out.println("iam after Test.....");
	}

}
