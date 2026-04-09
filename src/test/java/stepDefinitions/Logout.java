package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutPage;
import utils.TestContext;

public class Logout {

	TestContext testcontext;
	
	public Logout(TestContext testcontext) {
		this.testcontext = testcontext;
	}
	
	@When("User Signs out from the ShipAccel application")
	public void user_signs_out_from_the_ship_accel_application() {
	    		
		//WebDriverWait wait = new WebDriverWait(testcontext.driver, Duration.ofSeconds(15));
		// click on the user profile dropdown
		//LogoutPage logoutPage = new LogoutPage(testcontext.wait); moved object creation to page object manager
		LogoutPage logoutPage = testcontext.pageObjectManager.getLogoutPage();
		
		//testcontext.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbarSupportedContent1\"]/ul[2]/li[2]/spa-menu-item-dropdown/button/span"))).click();
		logoutPage.clickUserProfileDropdown();
		
		// click on the Sign out option
		//testcontext.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-menu-panel-6\"]/div/a"))).click();
		logoutPage.clickSignOutOption();
		
	}

	@Then("User should be navigated to the login page and see Email field.")
	public void user_should_be_navigated_to_the_login_page_and_see_email_field() {
		
		//LogoutPage logoutPage = new LogoutPage(testcontext.wait); moved object creation to page object manager
		LogoutPage logoutPage = testcontext.pageObjectManager.getLogoutPage();
		
		// Wait for username field
		logoutPage.waitForEmailField();
	    
	    
	}
	
	

	 
}
