package TestNG_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Data_Provider {

	WebDriver driver;

	@Parameters("Url")
	@Test
	public void test(String Url) {

		driver = new ChromeDriver();
		// driver.get(Url);

	}

	@DataProvider(name = "data", parallel = true)
	public Object[][] getData() {
		return new Object[][] {

				{ "https://www.google.com/" }, { "https://www.facebook.com/" }, { "https://www.amazon.in/" },

		};

	}

	@Test(dataProvider = "data")
	public void test1(String data) {

		driver.get(data);

	}

}
