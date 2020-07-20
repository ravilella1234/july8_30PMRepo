package parallel;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuitesParllel 
{

	public static void main(String[] args) 
	{
		/*
		 * String[] s = new String[5]; s[0]="ravi"; s[1]="lella";
		 * 
		 * String[] s1 = new String[] {"ravi","lella"};
		 */
		
		TestNG testng = new TestNG();
		testng.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
		testng.setSuiteThreadPoolSize(2);
		testng.run();

	}

}
