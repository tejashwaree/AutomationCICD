package automation.Test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.TestCompoenents.BaseTest;
import automation.TestCompoenents.Retry;
import automation.pageobjects.CheckoutPage;
import automation.pageobjects.LandingPage;
import automation.pageobjects.ConfirmationPage;
import automation.pageobjects.ProductPurchase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"}, retryAnalyzer= Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
		landingPage.loginApplication("teju4321@gmail.com", "Ra454ulshetty1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMsg());	
	}
	
	@Test
	public void productErrorValidations() throws IOException, InterruptedException
	{
		ProductPurchase productPurchase = landingPage.loginApplication("teju4321@gmail.com", "Rahulshetty1");
		List<WebElement> prod = productPurchase.getProdcutList();
		String item = "ADIDAS ORIGINAL";
		CheckoutPage checkout = productPurchase.addToCArt(item);
		//CheckoutPage checkout = new CheckoutPage(driver);
		Boolean match = checkout.verifyProductDisplay("Adidas orogianl123");
		Assert.assertFalse(match);
	
		
		
		
	}

}
