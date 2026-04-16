package stepDefinitions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.ImportOrdersPage;
import utils.TestContext;




public class ImportOrders {

	//WebDriver driver;
	//WebDriverWait wait;
	public ImportOrdersPage importOrdersPage;
	TestContext testcontext;
	
	
	// Constructor to initialize WebDriver and WebDriverWait from TestContext
	public ImportOrders(TestContext testcontext) {
		//this.driver = testcontext.driver;
		//this.wait = testcontext.wait;
		this.testcontext = testcontext;
	}
	
	@Then("User should be able to import orders from a csv file")
	public void user_should_be_able_to_import_orders_from_a_csv_file() {
		// Write code here that turns the phrase above into concrete actions
		testcontext.wait = new WebDriverWait(testcontext.driver, Duration.ofSeconds(10));
		
		ImportOrdersPage importOrdersPage = testcontext.pageObjectManager.getImportOrdersPage(); 
		
		importOrdersPage.clickAction();
		
		importOrdersPage.clickImportOrders();
		
//		importOrdersPage.clickChooselink();
		
		// Get the absolute path to the CSV file from the project resources
		String csvFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\sample-orders-simplified.csv";
		BufferedReader reader = null;
		String line	= "";
		
		try {
			reader = new BufferedReader(new FileReader(csvFilePath));
			while ((line = reader.readLine()) != null) {
				String[] rows = line.split(",");
				
				for (String index : rows) {
					System.out.printf("%-10s", index);
				}
				System.out.println();
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} 
			
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		importOrdersPage.uploadCSVFile(csvFilePath);
		
		importOrdersPage.clickUploadbutton();
		
		importOrdersPage.clickConfirmMapping();
		
		importOrdersPage.clickAddressVerification();
		
		importOrdersPage.clickRefreshLink();
		
		//Assert.assertTrue(true);
	}
	
	@Then("Imported orders should be visible in the orders list")
	public void imported_orders_should_be_visible_in_the_orders_list() {
		
		testcontext.wait = new WebDriverWait(testcontext.driver, Duration.ofSeconds(10));
		// Write code here that turns the phrase above into concrete actions
		try {
			// Read the CSV file and extract the expected order number
			String csvFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\sample-orders-simplified.csv";
			String expectedOrderNumber = readOrderNumberFromCSV(csvFilePath);
			
			// Get the actual order number from the UI
			ImportOrdersPage importOrdersPage = testcontext.pageObjectManager.getImportOrdersPage();
			String actualOrderNumber = importOrdersPage.getOrderNumber();
			
			// Assert that the expected and actual order numbers match
			Assert.assertEquals(actualOrderNumber, expectedOrderNumber, 
				"Order number mismatch! Expected: " + expectedOrderNumber + " but found: " + actualOrderNumber);
			
			System.out.println("Order successfully imported! Order Number: " + actualOrderNumber);
		} catch (IOException e) {
			Assert.fail("Failed to read CSV file: " + e.getMessage());
		}
	}
	
	// Helper method to read the order number from the CSV file
	private String readOrderNumberFromCSV(String filePath) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			// Skip the header row
			reader.readLine();
			// Read the data row
			String dataRow = reader.readLine();
			if (dataRow != null && !dataRow.isEmpty()) {
				// Split by comma and get the first column (Order ID)
				String[] columns = dataRow.split(",");
				return columns[0].trim();
			}
		} 
		
		finally {
			if (reader != null) {
				reader.close();
			}
		}
		throw new IOException("No order data found in CSV file");
	}
	
	

}