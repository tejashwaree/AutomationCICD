package automation.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.TestCompoenents.BaseTest;
import automation.pageobjects.CheckoutPage;
import automation.pageobjects.ConfirmationPage;
import automation.pageobjects.LandingPage;
import automation.pageobjects.ProductPurchase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitonImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductPurchase productPurchase;
	public CheckoutPage checkout;
	ConfirmationPage orderPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException{
		landingPage =lauchApplication();
	}
	
	@Given ("^Log in with username (.+) and password (.+)$")
	public void Log_in_with_username_and_password(String username, String password) {
		productPurchase = landingPage.loginApplication(username, password);
	}
	
	@When ("^I add product (.+) from cart$")
	public void I_add_product(String productName) throws InterruptedException {
		List<WebElement> prod = productPurchase.getProdcutList();
		checkout = productPurchase.addToCArt(productName);
	}
	
	@When ("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		Boolean match = checkout.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkout.goToCheckout();
		checkout.checkoutPage("456","Teju Ajbale");
		orderPage = checkout.submit();
	}
	
	@Then ("{string} is displayed on Confirmation page")
	public void message_displayed_on_Confirmation_age(String string){
		String message = orderPage.message();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then ("{string} is displayed")
	public void errormessage_displayed(String string) {
		Assert.assertEquals(string, landingPage.getErrorMsg());	
		driver.close();
	}
	
	
	
}
