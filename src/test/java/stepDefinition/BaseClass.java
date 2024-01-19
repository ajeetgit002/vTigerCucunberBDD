package stepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.CreateNewAccPage;
import pageObject.LoginPage;
import pageObject.SearchAccountByAccountNamePage;
import utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpg;
	public CreateNewAccPage accobj;
public SearchAccountByAccountNamePage srchAccName;
	public ReadConfig readconfig;
	
	public String generateName() {
		String name=RandomStringUtils.randomAlphabetic(6);
		return name;
	}
	
	
	
	
	
	
	
	
}
