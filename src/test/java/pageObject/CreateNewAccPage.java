package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccPage {

	WebDriver ldriver;

	public CreateNewAccPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}

	// Find web Element on web Page

	@FindBy(linkText = "Marketing")
	WebElement marketiongLink;

	public void userClickOnMarketing() {
		marketiongLink.click();
		
	}

	@FindBy(linkText = "Accounts")
	WebElement accountLink;

	public void userClickOnAccounts() {
		accountLink.click();
	}

	@FindBy(xpath = "//img[@alt='Create Account...']")
	WebElement createnewAcc;

	public void userClickOnCreateNewAccount() {
		createnewAcc.click();
	}

	@FindBy(xpath = "//span[text()='Creating New Account']")
	WebElement creteAccPage;

	public String verifyNewAccPage() {
		String heading = creteAccPage.getText();
		return heading;
	}

	@FindBy(name = "accountname")
	WebElement accName;

	public void userEnterAccName(String accname) {
		accName.sendKeys(accname);
	}

	@FindBy(name = "website")
	WebElement accWebsite;

	public void userEnterAccWebSite(String website) {
		accWebsite.sendKeys(website);
	}

	@FindBy(id = "phone")
	WebElement accPhone;

	public void userEnterAccPhone(String phone) {
		accPhone.sendKeys(phone);
	}

	@FindBy(id = "fax")
	WebElement accFax;

	public void userEnterAccFax(String fax) {
		accFax.sendKeys(fax);
	}

	@FindBy(name = "description")
	WebElement accDec;

	public void userEnterAccDecrp(String description) {
		accFax.sendKeys(description);
	}

	@FindBy(xpath = "//div[@id='basicTab']//table[@class='dvtContentSpace']/descendant-or-self::div[2]//input[@title='Save [Alt+S]']")
	WebElement accsave;

	public void userClickOnSave() {

		accsave.click();

	}

	@FindBy(xpath = "//td[text()='Marketing > ']")
	WebElement header1;

	public String veriFyHeader() {
		String headerF = header1.getText();

		return headerF;

	}
}
