package TestNG_Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Basics_Test {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

	}

	@Parameters("Url")
	@Test
	public void Test1(String Url) throws IOException {

		driver.get(Url);

		driver.findElement(By.id("searchInput")).sendKeys("Selenium" + Keys.ENTER);

		if (driver.getTitle().contains("Selenium")) {

			System.out.println("Title Verification Passed ");
			takeScreenshot("SeleniumResults");

		} else {

			System.out.println("Title Verification Failed");

		}

	}

	public void takeScreenshot(String fileName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".png");

		FileUtils.copyFile(source, destination);

	}

	@AfterMethod
	public void teardown() {

		if (driver != null) {

			// driver.quit();

		}

	}

}