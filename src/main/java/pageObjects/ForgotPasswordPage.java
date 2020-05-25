package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@id='user_email']");
	By sendMeInstructions = By.xpath("//input[@name='commit']");

	
	public ForgotPasswordPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstructions() {
		
		return driver.findElement(sendMeInstructions);
	}
	


}
