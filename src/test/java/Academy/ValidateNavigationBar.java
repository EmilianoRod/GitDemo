package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	
	public void basePageNavigation() throws IOException {
		
		
		//There are two ways to access to the methos of other class
		//One is inheritance
		//Other is creating object to that class and invoke methods of it.
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser with actual text.- Error..
		AssertJUnit.assertTrue(l.getNavigationBar().isDisplayed());
		Log.info("Navigation bar is displayed");

		
	}
	
	@AfterTest
	
	public void teardown() {
		driver.close();
	}
	
	

}
