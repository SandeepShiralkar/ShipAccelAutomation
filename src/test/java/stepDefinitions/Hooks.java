package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContext;

public class Hooks {

	TestContext testContext;
	
	public Hooks(TestContext testContext) {
		
		this.testContext = testContext;	
	}
	
	@Before
	public void BeforeScenario() throws IOException {
		// Initialization happens in TestContext constructor
		// This hook ensures test context is properly set up before each scenario
	}
	
	@After
	public void AfterScenario() throws IOException {
		
		if (testContext.driver != null) {
			testContext.driver.quit();
		}
		//testContext.testBase.WebDriverManager().quit()
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		// This hook can be used for actions after each step, such as taking screenshots on failure
		if (scenario.isFailed()) {
			// Code to capture and attach screenshot to the report
			// byte[] screenshot = ((TakesScreenshot) testContext.driver).getScreenshotAs(OutputType.BYTES);
			// scenario.attach(screenshot, "image/png", "screenshot");
			File sourcePath = ((TakesScreenshot) testContext.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "screenshot");
		}
	}
}
