package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;
import utils.TestContext;

public class LoginSteps {

	//WebDriver driver;
	//WebDriverWait wait;
	TestContext testcontext;
	
	// Constructor to initialize WebDriver and WebDriverWait from TestContext
	public LoginSteps(TestContext testcontext) {
		//this.driver = testcontext.driver;
		//this.wait = testcontext.wait;
		this.testcontext = testcontext;
	}
	
	@Given("User launches ShipAccel application using URL")
	public void user_launches_ship_accel_application_using_url() throws IOException {
//		WebDriverManager.chromedriver().setup();
//		testcontext.driver = new ChromeDriver();
//		testcontext.driver.manage().window().maximize();
//		testcontext.driver.get(url);
		
		testcontext.driver = testcontext.testBase.WebDriverManager();
	}
	
	@When("^User logs in with (.+) and (.+)$")
	public void user_logs_in_with_and(String email, String password) {
		 
		testcontext.wait = new WebDriverWait(testcontext.driver, Duration.ofSeconds(10));
		
		//LoginPage loginPage = new LoginPage(testcontext.wait, testcontext.driver); moved object creation to page object manager
		LoginPage loginPage = testcontext.pageObjectManager.getLoginPage(); 		
		
		//testcontext.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(email);
		loginPage.enterEmail(email);

		//testcontext.driver.findElement(By.id("nextButton")).click();
		loginPage.clickNext();
	
	    //testcontext.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
		loginPage.enterPassword(password);
	
	    //testcontext.driver.findElement(By.id("signinButton")).click();	    
		loginPage.clickSignIn();
	
	    testcontext.wait.until(ExpectedConditions.urlContains("/orders"));
		
	}
	
	@Then("Login Should be successful and user should land on {string} path")
	public void login_should_be_successful_and_user_should_land_on_path(String expectedPath) {
	    
		// Code to check if login is successful by verifying the URL contains the expected path
		
		testcontext.wait = new WebDriverWait(testcontext.driver, Duration.ofSeconds(15));

	    testcontext.wait.until(ExpectedConditions.urlContains(expectedPath));
	    
	    String currentUrl = testcontext.driver.getCurrentUrl();
	    
	    Assert.assertTrue(currentUrl.contains(expectedPath), 
	    		"Login was not successful. Expected URL to contain: " + expectedPath + ", but got: " + currentUrl);
		
	}
	
	@Then("User should see the {string} page")
	public void user_should_see_the_page(String string) {
		
		//LoginPage loginPage = new LoginPage(testcontext.wait, testcontext.driver); moved object creation to page object manager
		LoginPage loginPage = testcontext.pageObjectManager.getLoginPage(); 
	    
		String header = loginPage.waitForHeader();
	    String expectedHeader = "Orders";
	    Assert.assertEquals(header, expectedHeader);
	    
	    if(header.equals(expectedHeader)) {
	    	System.out.println("User is on the Orders page");
	    } else {
	    	System.out.println("User is not on the Orders page");
	    }
		
	}
	
	

}
