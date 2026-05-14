package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Data_Parameterization {

	WebDriver driver;

	@Parameters("Url")
	@BeforeTest
	public void setup(String Url) {

		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@DataProvider(name = "SearchData")
	public Object[][] getData() {
		return new Object[][] {

				{ "Samsung" },

				{ "Apple" },

		};
	}

	@Test(dataProvider = "SearchData")
	public void SearchTest(String data) {

		WebElement searchbar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		searchbar.clear();

		searchbar.sendKeys(data + Keys.ENTER);

	}

	@BeforeGroups("")

	public void beforeGroup() {

	}

	@AfterGroups("")
	public void afterGroup() {

	}

}
