package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptExecutor 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\driver sources\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='ravilella'");
		
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		//js.executeScript("window.scrollBy(0,100)");
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		js.executeScript("document.getElementById('pass').scrollIntoView()");
		
		js.executeScript("window.history.back()");
		
		Thread.sleep(3000);
		
		js.executeScript("window.history.forward()");
		
		Thread.sleep(3000);
		
		js.executeScript("window.history.go(0)");
		
		

	}

}
