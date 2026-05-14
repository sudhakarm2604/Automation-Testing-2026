package Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Utils {

	static WebDriver driver;

	public static ExtentReports extent;

	public static void TakeScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(
					"C:\\Users\\Sudhakar M\\Eclipse Coding\\TestNG_Projects_2026\\Screenshots\\Screenshot.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static ExtentReports getExtentReport() {

		String path = System.getProperty("user.dir") + "\\ExtentReports\\extentReport.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(path);

		spark.config().setReportName("TestNG Practice Report");

		spark.config().setDocumentTitle("Selenium Framework Report");

		extent = new ExtentReports();

		extent.attachReporter(spark);

		extent.setSystemInfo("OS", System.getProperty("os.name"));

		extent.setSystemInfo("User", System.getProperty("user.name"));

		return extent;

	}

}
