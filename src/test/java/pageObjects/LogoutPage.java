package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
	
	By userProfileDropdown = By.xpath("//*[@id=\"navbarSupportedContent1\"]/ul[2]/li[2]/spa-menu-item-dropdown/button/span");
	By signOutOption = By.xpath("//*[@id=\"mat-menu-panel-6\"]/div/a");
	By emailField = By.id("username");
	
	public WebDriverWait wait;
	
	public LogoutPage(WebDriverWait wait) {
		// Constructor
		this.wait = wait;
	}
	
	public void clickUserProfileDropdown() {
		// code to click on the user profile dropdown
		wait.until(ExpectedConditions.elementToBeClickable(userProfileDropdown)).click();
	}
	
	public void clickSignOutOption() {
		// code to click on the Sign out option
		wait.until(ExpectedConditions.elementToBeClickable(signOutOption)).click();
	}
	
	public void waitForEmailField() {
		// Wait for username field
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
	}
}
