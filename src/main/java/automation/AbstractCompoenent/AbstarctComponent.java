package automation.AbstractCompoenent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.pageobjects.ConfirmationPage;
import automation.pageobjects.OrderPage;

public class AbstarctComponent {
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*=myorders]")
	WebElement orderHeader;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	public AbstarctComponent(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void waitForElementToAppear(By findby) 
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitForWebElementToAppear(WebElement findBy1) 
	{	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy1));
	}
	
	public OrderPage goToOrderPage(){
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
	public void goToCartPage() {
		cart.click();
	}
	
}