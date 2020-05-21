package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String Text) throws IOException {

		//There are two ways to access to the methos of other class
		//One is inheritance
		//Other is creating object to that class and invoke methods of it.
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click(); //driver.findElement(By.xpath(""))
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		Log.info(Text);

	}
	
    @AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stands for how many differents data types test should run
		//columns stands for how many values per each test
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0] = "nonrestrictereduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "4567888";
		data[1][2] = "Non restrictered user";
		
		return data;
		}
	
	

}
