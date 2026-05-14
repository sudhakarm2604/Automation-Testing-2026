package TestNG_Practice;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Util.Utils;

public class TestListener implements ITestListener {
	
	WebDriver driver;

	ExtentReports extent = Utils.getExtentReport();

	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());

		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.pass("Test is passed");

		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.fail("Test is failed: " + result.getThrowable());

		// Simple fix: get driver from test instance
		Object testInstance = result.getInstance();
		WebDriver driver = null;
		try {
			driver = (WebDriver) testInstance.getClass().getMethod("getDriver").invoke(testInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Utils.TakeScreenshot(driver);

		test.addScreenCaptureFromPath(
				"C:\\Users\\Sudhakar M\\Eclipse Coding\\TestNG_Projects_2026\\Screenshots\\screenshot.png");

		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Test is skipped");

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test is starting");

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test is ending");

		extent.flush();

		ITestListener.super.onFinish(context);
	}

}