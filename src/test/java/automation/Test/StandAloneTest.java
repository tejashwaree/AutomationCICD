package automation.Test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

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

import automation.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		//WebDriver driver = WebDriverManager.chromedriver().create();
		 
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		//login
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("teju4321@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rahulshetty1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		//list of all elements
		List<WebElement> prod = driver.findElements(By.cssSelector(".col-lg-4"));
		String item = "ADIDAS ORIGINAL";
		WebElement product = prod.stream().filter(prods -> prods.findElement(By.cssSelector("b")).getText().equals(item)).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		//wait until message appears
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait until animation disappears
		//ng-animating
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//checking item is added in cart is correct
		List<WebElement> cartProd = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean match = cartProd.stream().anyMatch(cartProds->cartProds.getText().equalsIgnoreCase(item));
		Assert.assertTrue(match);
		
		//checkout
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("456");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Teju Ajbale");
		//select country
//		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
//		driver.findElement(By.xpath("(//button[@type='button'])[2]/span")).click();
		//by using action class
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "ind").build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.cssSelector("[placeholder='Select Country']"))));
		a.click(driver.findElement(By.xpath("(//button[@type='button'])[2]/span"))).build().perform();
		driver.findElement(By.cssSelector(".btnn")).click();
		
		//check order id and message
		String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		
		//driver.quit();
		
		
	}

}
