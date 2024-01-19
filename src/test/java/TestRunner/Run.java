package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features =".//Features/", ///      Run single feature 
				//features =".//Features/",            // Run All Feature 
				//features=   {".//Features/CreateAc.feature",".//Features/LoginFeature.feature"}, // Run Specific Features 
		glue="stepDefinition",
		dryRun = false,
		
		//tags="@regression",        // Run Only @ regression run
			//	tags= "@Sanity or @regression",        //Run that feature which have one feature @Sanity or @regression 
				//tags= "@Sanity and @regression",       // Run That feature Which Both feature  @Sanity and @regression
				//tags= "@Sanity and not  @regression", //Skip @regression  feature
		//tags="@Sanity",
		monochrome = true,
				plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				//plugin = {"pretty","html:target/Reports/reports.html"}
		
		
		)
public class Run extends AbstractTestNGCucumberTests {
	//
}
