package TestNG_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@DataProvider(name = "searchData")
	public Object[][] getSearchData() {
		return new Object[][] {

				{ "apple macbook air m13" },
				{ "samsung galaxy s21" },

		};

	}

	@Test
	public void launchAmazon() {

		driver.get("https://www.amazon.in/");

		// throw new RuntimeException("Intentional Exception ");

	}

	@Test(dependsOnMethods = "launchAmazon", dataProvider = "searchData")
	public void search(String searchData) {

		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

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

		}

	}

}