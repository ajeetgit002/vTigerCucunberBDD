package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CreateNewAccPage;
import pageObject.LoginPage;
import pageObject.SearchAccountByAccountNamePage;
import utilities.ReadConfig;

public class StepDef extends BaseClass{
	
	/*
	 * 
	 * Login Feature Feature
	 * 
	 * 
	 */
	@Before
	public void setUp() {
		readconfig=new ReadConfig();
	String browser=	readconfig.getBrowser();
	switch (browser.toLowerCase()) {

	case "chrome":
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		
		
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
	     driver = new FirefoxDriver();
		
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
	     driver = new EdgeDriver();
		
		break;
	default:
	driver=null;
	break;
	}
	
	}
	@Given("User Launch Chrome Broswser")
	public void user_launch_chrome_broswser() {
		

		loginpg = new LoginPage(driver);
		accobj = new CreateNewAccPage(driver);
		srchAccName=new SearchAccountByAccountNamePage(driver);
	}

	@Given("User Open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
	}

	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String userName, String password) {

		loginpg.enterUserName(userName);
		loginpg.enterPassword(password);

	}

	@When("click On Login")
	public void click_on_login() {
		loginpg.clickLoginButton();
	}

	@Then("Page Tittle should be {string}")
	public void page_tittle_should_be(String expTitle) {

		String actTitle = driver.getTitle();
		if (actTitle.equals(expTitle)) {
			System.out.println("Passes - title is matched");
		} else {
			System.out.println("Failed - Title is not Matched ");
		}

	}

	@When("User Click on log Out Link")
	public void user_click_on_log_out_link() {
		loginpg.clickLogOut();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {

		String actTitle = driver.getTitle();
		if (actTitle.equals(title)) {
			System.out.println("Passes - title is matched");
		} else {
			System.out.println("Failed - Title is not Matched ");
		}
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {

		//driver.quit();
	}

	/*
	 * 
	 * Create New Account Feature
	 * 
	 * 
	 */

	@Then("User can view Home Page and Titile should be {string}")
	public void user_can_view_home_page_and_titile_should_be(String title) {

		String homePageTitle = driver.getTitle();
		if (title.equals(homePageTitle)) {
			System.out.println("PASSED : Page Title is matched");
		} else {
			System.out.println("FAILED : Page Title is not matched");
		}

	}

	@When("User Click on Marketing")
	public void user_click_on_marketing() {
		accobj.userClickOnMarketing();
	}

	@When("Click On Account")
	public void click_on_account() {
		accobj.userClickOnAccounts();
	}

	@Then("User Can view Comfirmation Header {string}")
	public void user_can_view_comfirmation_header(String header) {
		String expHeader = accobj.veriFyHeader();
		if (header.equals(expHeader)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on Plus icon\\(Create new Account icon)")
	public void user_click_on_plus_icon_create_new_account_icon() {
		accobj.userClickOnCreateNewAccount();
	}

	@Then("User can view confirmation Header {string}")
	public void user_can_view_confirmation_header(String headingOfPage) {
		String headrofPage = accobj.verifyNewAccPage();
		if (headingOfPage.equals(headrofPage)) {
			Assert.assertTrue(true);

		} else {
			assertTrue(false);
		}

	}

	@When("User Enter Account info")
	public void user_enter_account_info() {
		accobj.userEnterAccName(generateName());
		accobj.userEnterAccWebSite("https//yahoo.com");
		accobj.userEnterAccPhone("65554656565");
		accobj.userEnterAccFax("789-558-2545");
		accobj.userEnterAccDecrp("It a practice for BDD Frame work ");

	}

	@When("Click On Save Button Account Should created")
	public void click_on_save_button_account_should_created() {
		accobj.userClickOnSave();
	}

	@When("User enter Account Name in search Text Box")
	public void user_enter_account_name_in_search_text_box() {
		srchAccName.userEnterAccountName("Ajeet Yadav4");
	}

	@When("Select Account Name From DropDown")
	public void select_account_name_from_drop_down() {
		srchAccName.userSelectDrp("Account Name");
	}

	@When("click On Serch Button")
	public void click_on_serch_button() {
		srchAccName.clickOnSearchBtn();

	}

	@Then("User Should found  Account Name In the search Table")
	public void user_should_found_account_name_in_the_search_table() {
	boolean b=	srchAccName.verifyACCfinding("Account Name", "Ajeet Yadav4");
	if(b==true) {
		Assert.assertTrue(true);
		
	}else {
		Assert.assertTrue(false);
	}
	}
	@After
	public void tearDown(Scenario sc) {
//		if(sc.isFailed()==true) {
//		DateFormat dtf=	new SimpleDateFormat("MM_DD_yyyy HH_mm");
//		String date=dtf.format(new Date());
//			String path="C:\\Users\\Ajit\\OneDrive\\Desktop\\RestApiSamplePack\\ProjectCucumberFrameWork\\ScreenShots\\+"+date+"+test.png";
//			TakesScreenshot ts=(TakesScreenshot) driver;
//			File  source=ts.getScreenshotAs(OutputType.FILE);
//			File targe=new File(path);
//			try {
//		Files.copy(source, targe);	
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
		}
		
	} 

}
