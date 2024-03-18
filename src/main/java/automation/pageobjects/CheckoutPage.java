package automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractCompoenent.AbstarctComponent;

public class CheckoutPage extends AbstarctComponent{
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
	}
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement cvv1;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement nameOnCard;
	
	By selectCountry = By.cssSelector("[placeholder='Select Country']");
	

	@FindBy(css="[placeholder='Select Country']")
	WebElement countryInitail;
	
	@FindBy(xpath="(//button[@type='button'])[2]/span")
	WebElement country;
	
	@FindBy(css=".btnn")
	WebElement button;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProduct;
	
	public boolean verifyProductDisplay(String item)
	{
		Boolean match = cartProduct.stream().anyMatch(cartProds->cartProds.getText().equalsIgnoreCase(item));
		return match; 
	}
	
	public void goToCheckout()
	{
		checkout.click();
	}
	public void checkoutPage(String cvv, String name)
	{
		cvv1.sendKeys(cvv);
		nameOnCard.sendKeys(name);
		Actions a = new Actions(driver);
		a.sendKeys(countryInitail,"ind").build().perform();
		waitForElementToAppear(selectCountry);
		a.click(country).build().perform();
		
	}
	public ConfirmationPage submit()
	{
		button.click();
		ConfirmationPage orderPage = new ConfirmationPage(driver);
		return orderPage;
	}
}