package automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractCompoenent.AbstarctComponent;

public class OrderPage extends AbstarctComponent{
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> products;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement nameOnCard;
	

	public boolean verifyOrderDisplay(String item)
	{
		//List<String> productList = products.ge;
		Boolean match = products.stream().anyMatch(cartProds->cartProds.getText().equalsIgnoreCase(item));
		return match; 
	}
	
	
}