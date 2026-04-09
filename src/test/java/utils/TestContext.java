package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageObjectManager;

public class TestContext {

	
	public WebDriver driver;
	public WebDriverWait wait;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	
	public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }
    
    public TestContext() throws IOException {
		// Default constructor
    	pageObjectManager = new PageObjectManager(wait, testBase.WebDriverManager());
    	testBase = new TestBase();
    
    }
	
}
