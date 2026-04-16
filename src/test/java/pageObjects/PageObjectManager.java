package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

	public LoginPage loginPage;
	public WebDriverWait wait;
	public WebDriver driver;
	public LogoutPage logoutPage;
	public ImportOrdersPage importOrdersPage;
	
	public PageObjectManager(WebDriverWait wait, WebDriver driver) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public LoginPage getLoginPage() {
		loginPage = new LoginPage(wait, driver);
		return loginPage;
	}
	
	public LogoutPage getLogoutPage() {
		logoutPage = new LogoutPage(wait);
		return logoutPage;
	}
	
	public ImportOrdersPage getImportOrdersPage() {
		importOrdersPage = new ImportOrdersPage(wait, driver);
		return importOrdersPage;
	}
}
