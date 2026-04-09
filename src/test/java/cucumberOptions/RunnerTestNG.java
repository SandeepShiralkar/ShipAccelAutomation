package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/shipAccelfeatures",
		glue = {"stepDefinitions","utils"},
		dryRun = false,
		monochrome = true,
		tags = "",
		plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json", "junit:target/cucumber-reports.xml"}
		)

public class RunnerTestNG extends AbstractTestNGCucumberTests {

}
