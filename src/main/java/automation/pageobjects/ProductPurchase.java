package automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import automation.AbstractCompoenent.AbstarctComponent;

public class ProductPurchase extends AbstarctComponent{
	WebDriver driver;
	
	public ProductPurchase(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
	}
	

	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	By productBy = By.cssSelector(".col-lg-4");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	

	
	
	
	public List<WebElement> getProdcutList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		
		WebElement product = getProdcutList().stream().filter(prods -> prods.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return product;
	}
	
	public CheckoutPage addToCArt(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		Thread.sleep(1000);
		goToCartPage();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	

	
}