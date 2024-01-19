package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver  rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name='user_name']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='user_password']")
	WebElement userpass;
	
	@FindBy(xpath = "//input[@name='Login']")
	WebElement loginButton;
	@FindBy(linkText = "Sign Out")
	WebElement logOut;
	
	
	public void enterUserName(String userName) {
		username.sendKeys(userName);
	}
	public void enterPassword(String password) {
		userpass.sendKeys(password);
	}
	public void clickLoginButton() {
		
		loginButton.click();
	}
	
	
	public void clickLogOut() {
		logOut.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
