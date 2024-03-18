package automation.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.AbstractCompoenent.AbstarctComponent;

public class ConfirmationPage extends AbstarctComponent{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
	}
	

	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String message()
	{
		String message1 = message.getText();
		return message1;
		
	}
}