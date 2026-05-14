package TestNG_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadLocal {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
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
