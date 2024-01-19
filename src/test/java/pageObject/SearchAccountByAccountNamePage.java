package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAccountByAccountNamePage {
	
	
	WebDriver ldriver;
	
	public SearchAccountByAccountNamePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	
	@FindBy(xpath = "//input[@name='search_text']")
	WebElement serchTxt;	
	
	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']//select[@name='search_field']")
	WebElement searchDrp;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement searchBtn;
	
	
	// This method will perform input value into search textbox
	public void userEnterAccountName(String accName) {
		serchTxt.sendKeys(accName);
		
		
	}

	public void userSelectDrp(String valueForSelect) {
		Select slt=new Select(searchDrp);
		slt.selectByVisibleText(valueForSelect);
		
	}
	public void clickOnSearchBtn() {
		searchBtn.click();
		
	}
	
	public boolean verifyACCfinding(String uniqueAccNameGetData,String dataToVrfy) {
		List<WebElement> list=ldriver.findElements(By.xpath("//table[@class='lvt small']//tr[1]//td"));
		boolean foundData=false;
		
		
		int colCount=0;
		for(int i=0;i<=list.size()-1;i++) {
		WebElement we=	list.get(i);
		String headers=we.getText();
		if(uniqueAccNameGetData.equals(headers)) {
			i=i+1;
			colCount=i;
			
		}
	
		
	}
		List<WebElement> weuniqueColDataList=ldriver.findElements(By.xpath("//table[@class='lvt small']//td["+colCount+"]"));
		
		for(int j=0;j<=weuniqueColDataList.size()-1;j++) {
		WebElement weUniueData=	weuniqueColDataList.get(j);
		String allUniqueData=weUniueData.getText();
		if(dataToVrfy.equalsIgnoreCase(allUniqueData)) {
			foundData=true;
		}
		}
		return foundData;
	}
	}
	

