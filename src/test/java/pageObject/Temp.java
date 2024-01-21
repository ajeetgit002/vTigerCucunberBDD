package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Temp {

	public static void main(String[] args) {
		
		
		WebDriverManager.firefoxdriver().setup();
	    WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888");
	  
			}
}
