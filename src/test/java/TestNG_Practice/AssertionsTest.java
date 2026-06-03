package TestNG_Practice;

import org.testng.annotations.Test;

public class AssertionsTest {

	@Test(dependsOnMethods = "Test2")
	public void Test1() {

		System.out.println("Test Method");

	}

	@Test(alwaysRun = false)
	public void Test2() {

		System.out.println("Test Method 2");	

	}

}
