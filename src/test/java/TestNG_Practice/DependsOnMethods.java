package TestNG_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Util.Utils;

@Listeners(TestListener.class)

public class DependsOnMethods extends Utils {

	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void setUp() throws MalformedURLException {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");
	    
	    String tempDir = System.getProperty("java.io.tmpdir");
	    options.addArguments("user-data-dir=" + tempDir + "/chrome-profile");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@DataProvider(name = "searchData")
	public Object[][] getSearchData() {
		return new Object[][] {

				{ "apple macbook air m13" }, { "samsung galaxy s21" },

		};

	}

	@Test
	public void launchAmazon() {

		driver.get("https://www.amazon.in/");

		// throw new RuntimeException("Intentional Exception ");

	}

	@Test(dependsOnMethods = "launchAmazon", dataProvider = "searchData")
	public void search(String searchData) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement search = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));

		search.clear();
		search.sendKeys(searchData + Keys.ENTER);

	}

	@Test(dependsOnMethods = "search")
	public void addToCart() {

		List<WebElement> products = driver.findElements(
				By.xpath("//div[@data-component-type='s-search-result'] //button[@name='submit.addToCart']"));

		for (WebElement product : products) {

			if (product.isDisplayed()) {

				product.click();
				break;

			}
		}

	}

	@Test(dependsOnMethods = "addToCart")
	public void cartPage() {

		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

		WebElement subtotal = driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']"));

		System.out.println(subtotal.getText());
	}

	@AfterTest
	public void tearDown() {

		if (driver != null) {

			driver.manage().deleteAllCookies();
			driver.quit();

		} // adding comments

	}

}