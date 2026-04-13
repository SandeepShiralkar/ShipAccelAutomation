package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
}
