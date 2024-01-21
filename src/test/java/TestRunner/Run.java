package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
				features=   {".//Features/CreateAc.feature",".//Features/LoginFeature.feature"}, // Run Specific Features 
		glue="stepDefinition",
		dryRun = false,
		tags="@Sanity",
		monochrome = true,
				plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				
		
		
		)
public class Run extends AbstractTestNGCucumberTests {
	//
}
