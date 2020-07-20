package com.project.MavenProject3PMBatch;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties parentProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filePath= null;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ', '_');
	}
	
	
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath+"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"//or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectPath+"//environment.properties");
		parentProp = new Properties();
		parentProp.load(fis);
		String keyValue = parentProp.getProperty("env");
		System.out.println(keyValue);
		
		fis = new FileInputStream(projectPath+ "//"+ keyValue + ".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectPath + "//log4jconfig.properties"); 
		PropertyConfigurator.configure(fis);
		
		report=ExtentManager.getInstance();
	}
	
	public static void launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			Date d1 = new Date();
			System.out.println("BeforeChrome : " +d1);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 9");
			option.addArguments("--disable-notifications");
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
		}
		else if(browser.equals("firefox"))
		{
			Date d1 = new Date();
			System.out.println("BeforeFirefox : " + d1);
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("juneFFprofile");
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			option.addPreference("dom.webnotifications.enabled", false);
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\May Drivers\\geckodriver.exe");
			driver= new FirefoxDriver(option);
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
	}

	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}
		return element;
		
	}

	public static void typeText(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(locatorKey)).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(option);
		//driver.findElement(By.id(locatorKey)).sendKeys(option);
	}
	
	
	public static Boolean isLinkEquals(String expectedLink)
	{
		String actualLink = driver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(@class,'')][contains(text(),'Customer Service')]")).getAttribute("innerHTML");
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	
	public static void reportSuccess(String passMessage) 
	{
		test.log(LogStatus.PASS, passMessage);
	}

	public static void reportFailure(String failMessage) 
	{
		test.log(LogStatus.FAIL, failMessage);
	}

}
