package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportOrdersPage {
	
	public WebDriverWait wait;
	public WebDriver driver;
	

	public ImportOrdersPage (WebDriverWait wait, WebDriver driver) {
		// Constructor
		this.wait = wait;
		this.driver = driver;
	}
	
	By actionButton = By.xpath("//*[@id=\"enhancedOrderMgmtDashboardHost\"]/div/main/div/div[2]/div/div/div/div[1]/ecomm-enhanced-order-mgmt-toolbar/pbds-toolbar/div/div[1]/div/div/div[3]");
	By importOrdersButton = By.xpath("//*[@id=\"main_body\"]/div[3]/div/button[4]");
	//By choosefileLink = By.xpath("//*[@id=\"fileUpload\"]/div/div[2]/div/div/span[1]");
	By uploadButton = By.id("upload-btn");
	By confirmMappingButton = By.xpath("//mat-dialog-actions//button[contains(.,'Confirm Mapping')]");
	By addressVerficationButton = By.xpath("//mat-dialog-actions//button[contains(.,'Apply to All Addresses')]");
	By refreshLink = By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')][contains(.,'Orders imported')]//span[normalize-space()='Refresh']");
	By fileInput = By.xpath("//input[@type='file']");
	public By orderNumber = By.xpath("//*//div[contains(@class,'selectable-link-action') and normalize-space()='0001']");
	
	public void uploadCSVFile(String filePath) {
		// Code to upload the CSV file
		driver.findElement(fileInput).sendKeys(filePath);
	}
	
	public void clickAction() {
		// Code to click on the action button
		//driver.findElement(actionButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(actionButton)).click();
	}
	
	public void clickImportOrders() {
		// Code to click on the Import Orders button
		//driver.findElement(importOrdersButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(importOrdersButton)).click();
	}
	
//	public void clickChooselink() {
//		// Code to click on the choose file link
//		//driver.findElement(choosefileLink).click();
//		wait.until(ExpectedConditions.elementToBeClickable(choosefileLink)).click();
//	}
	
	public void clickUploadbutton() {
		// Code to click on the Upload File button
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadButton)).click();
	}
	
	public void clickConfirmMapping() {
		// Code to click on the confirm mapping button
		//driver.findElement(confirmMappingButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmMappingButton)).click();
	}
	
	public void clickAddressVerification() {
		// Code to click on the address verification button
		//driver.findElement(addressVerficationButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addressVerficationButton)).click();
	}
	
	public void clickRefreshLink() {
		// Code to click on the refresh link
		//driver.findElement(refreshLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(refreshLink)).click();
	}
	
	public String getOrderNumber() {
		// Code to get the order number of the first order in the list
		return driver.findElement(orderNumber).getText();
		
	}
	
}