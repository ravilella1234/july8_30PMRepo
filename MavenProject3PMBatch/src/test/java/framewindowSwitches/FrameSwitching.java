package framewindowSwitches;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameSwitching 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		//driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		//driver.switchTo().frame(0);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("packageListFrame"))));
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		driver.switchTo().defaultContent();
		
		//driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("packageFrame"))));
		driver.findElement(By.linkText("Selenium")).click();
		driver.switchTo().defaultContent();
		
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("classFrame"))));
		//driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		driver.findElement(By.linkText("DefaultSelenium")).click();

	}

}
