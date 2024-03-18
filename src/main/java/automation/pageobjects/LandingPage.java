package automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractCompoenent.AbstarctComponent;

public class LandingPage extends AbstarctComponent{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail")).sendKeys("teju4321@gmail.com");
	//page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	public ProductPurchase loginApplication(String email, String pasword) {
		userEmail.sendKeys(email);
		password.sendKeys(pasword);
		submit.click();
		ProductPurchase productPurchase = new ProductPurchase(driver);
		return productPurchase;
	}

	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMsg() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
