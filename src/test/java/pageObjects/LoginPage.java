package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriverWait wait;
	public WebDriver driver;
	

	public LoginPage (WebDriverWait wait, WebDriver driver) {
		// Constructor
		this.wait = wait;
		this.driver = driver;
	}
	
	By emailField = By.id("username");
	By nextButton = By.id("nextButton");
	By passwordField = By.id("password");
	By signInButton = By.id("signinButton");
	By header = By.xpath("//*[@id=\"enhancedOrderMgmtDashboardHost\"]/div/main/div/div[1]/h1");
	
	public void enterEmail(String email) {
		// Code to enter username
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
	}
	
	public void clickNext() {
		// code to click on the next button
		driver.findElement(nextButton).click();
	}
	
	public void enterPassword(String password) {
		// Code to enter password
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	}
	
	public void clickSignIn() {
		// code to click on the sign in button
		driver.findElement(signInButton).click();
	}
	
	public String waitForHeader() {
		// Wait for the header to be visible
		return driver.findElement(header).getText();
	}
	
}
