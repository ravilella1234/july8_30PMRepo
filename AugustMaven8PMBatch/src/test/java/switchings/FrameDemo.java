package switchings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo 
{

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//li[1]//a[1]")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
		//driver.switchTo().frame(1);
		driver.findElement(By.xpath("//span[contains(text(),'Selenium')]")).click();
		driver.switchTo().defaultContent();
		
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("classFrame"))));
		
			
		//driver.switchTo().frame(2);
		//driver.switchTo().frame(driver.findElement(By.name("classFrame")));
		driver.findElement(By.xpath("//a[contains(text(),'DefaultSelenium')]")).click();

	}

}
