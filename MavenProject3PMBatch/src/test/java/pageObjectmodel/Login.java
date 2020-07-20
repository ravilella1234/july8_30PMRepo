package pageObjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	@FindBy(linkText="Sign in") WebElement signIn;
	@FindBy(id="email") WebElement customerEmail;
	@FindBy(id="passwd") WebElement customerPassword;
	@FindBy(xpath="//p[@class='submit']//span[1]") WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") WebElement getActualError;
	
	
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerLogin() throws Exception
	{
		signIn.click();
		Thread.sleep(2000);
		customerEmail.sendKeys("qatest87866@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyCustomerLogin()
	{
		return getActualError.getText();
	}

}
