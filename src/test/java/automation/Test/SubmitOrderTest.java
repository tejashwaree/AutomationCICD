package automation.Test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.TestCompoenents.BaseTest;
import automation.TestCompoenents.Retry;
import automation.pageobjects.CheckoutPage;
import automation.pageobjects.LandingPage;
import automation.pageobjects.OrderPage;
import automation.pageobjects.ConfirmationPage;
import automation.pageobjects.ProductPurchase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class SubmitOrderTest extends BaseTest{
	String item = "ADIDAS ORIGINAL";
	//new comments are added
	
	@Test(dataProvider ="getData", groups= {"Purchase"}, retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		ProductPurchase productPurchase = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> prod = productPurchase.getProdcutList();
		
		CheckoutPage checkout = productPurchase.addToCArt(input.get("productName"));
		//CheckoutPage checkout = new CheckoutPage(driver);
		Boolean match = checkout.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		checkout.goToCheckout();
		checkout.checkoutPage("456","Teju Ajbale");
		ConfirmationPage orderPage = checkout.submit();
		//check order id and message
		//OrderPage orderPage = new OrderPage(driver);
		String message = orderPage.message();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
	}
	
	@Test(dependsOnMethods ="submitOrder")
	public void orderHistoryTest() {
		//verify order is placed in order history
		//ADIDAS ORIGINAL
		ProductPurchase productPurchase = landingPage.loginApplication("teju4321@gmail.com", "Rahulshetty1");
		OrderPage orderPage = productPurchase.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(item));
		}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{

		List<HashMap<String, String>> data = getJsonDatatoHashMap(System.getProperty("user.dir")+ 
				"\\src\\test\\java\\automation\\TestData\\purchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData1(){
//		return new Object[][] {{"teju4321@gmail.com","Rahulshetty1","ADIDAS ORIGINAL"},{"fgst@gmail.com","Abcd@1234","ZARA COAT 3"}};
//		
//	}
//	HashMap<Object,Object> map = new HashMap<Object, Object>();
//	map.put("email", "teju4321@gmail.com");
//	map.put("password", "Rahulshetty1");
//	map.put("productName", "ADIDAS ORIGINAL");
//	
//	HashMap<Object,Object> map1 = new HashMap<Object, Object>();
//	map1.put("email", "fgst@gmail.com");
//	map1.put("password", "Abcd@1234");
//	map1.put("productName", "ZARA COAT 3");
}
