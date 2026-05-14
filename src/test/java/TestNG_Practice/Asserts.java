package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Asserts {

	// Hard Assert : If the assertion is failed then the execution will be stopped
	// and the remaining code will not be executed.
	@Test
	public void testLogin() {

		String expected = "Admin";

		String actual = "Admin";

		System.out.println("Before Assert");

		Assert.assertEquals(actual, expected);

		System.out.println("After Assert");

		// Assert.fail();

	}

	// Soft Assert : If the assertion is failed then the execution will not be
	// stopped and the remaining code will be executed.

	@Test
	public void testsoftAssert() {

		SoftAssert soft = new SoftAssert();

		System.out.println("Before Soft Assert");

		soft.assertEquals(5, 5);

		soft.assertAll();

		System.out.println("After Soft Assert ");

	}

}