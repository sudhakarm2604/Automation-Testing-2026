package TestNG_Practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadLocal {

	WebDriver driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();

		driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

	}

	@Test
	public void testGoogle() {

		driver.get("https://www.google.com/");

	}

	@Test
	public void testAmazon() {

		driver.get("https://www.amazon.in/");

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			// driver.quit();
		}

	}

}
