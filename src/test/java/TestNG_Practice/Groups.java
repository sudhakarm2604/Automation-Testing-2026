package TestNG_Practice;

import org.testng.annotations.Test;

public class Groups {

	@Test(groups = "smoke")
	public void test1() {

		System.out.println("Test1");

	}

	@Test(groups = "regression")
	public void test2() {

		System.out.println("Test1 regresion");

	}

	@Test(groups = "smoke")
	public void test3() {

		System.out.println("Test1 smoke");

	}

	@Test(groups = "regression")
	public void test4() {

		System.out.println("Test1 regression");

	}

}
