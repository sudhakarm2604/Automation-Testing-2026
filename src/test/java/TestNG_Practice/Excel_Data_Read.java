package TestNG_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class Excel_Data_Read {

	@Test
	public void Exceldataread() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream("testdata.xlsx");

		// XSSWorkbook wb = new XSSFWorkbook(fis);

	}

}
