package handlingdropdowns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOrderAndSpelling {
	public static void main(String[] args) throws Throwable {
		List<String> actualDayList = new ArrayList<String>();
		List<String> actualMonthList = new ArrayList<String>();
		List<String> actualYearList = new ArrayList<String>();
		List<String> expectedDayList = new ArrayList<String>();
		List<String> expectedMonthList = new ArrayList<String>();
		List<String> expectedYearList = new ArrayList<String>();
		// Instantiate the browser specific class
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// Call the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Create the webdriverwait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Pass the main URL
		driver.get("https://www.facebook.com/signup");
		// Capture all the dropdowns in the webpage
		List<WebElement> allDropdown = driver.findElements(By.tagName("select"));
		// Iterate one dropdown at a time
		for (WebElement dropdown : allDropdown) {
			// Consider only dropdown which are visible
			if (dropdown.isDisplayed()) {
				// Create the Select class object for the dropdown
				Select dropdownSelect = new Select(dropdown);
				// Capture all the options of all the dropdown
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					// Identify the dropdown under current iteration
					if (dropdown.getAttribute("title").equals("Day")) {
						actualDayList.add(option.getText());
					} else if (dropdown.getAttribute("title").equals("Month")) {
						actualMonthList.add(option.getText());
					} else if (dropdown.getAttribute("title").equals("Year")) {
						actualYearList.add(option.getText());
					}
				}
			}
		}
		// Create fileInputStream object
		FileInputStream fis = new FileInputStream("./src/test/resources/facebookdob.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("doblist");
		int firstRowIndex = sheet.getFirstRowNum();
		int lastRowIndex = sheet.getLastRowNum();
		for (int i = firstRowIndex; i <= lastRowIndex; i++) {
			int firstCellIndex = (int) sheet.getRow(i).getFirstCellNum();
			int lastCellIncrementIndex = (int) sheet.getRow(i).getLastCellNum();
			for (int j = firstCellIndex + 1; j < lastCellIncrementIndex; j++) {
				if (String.valueOf(sheet.getRow(i).getCell(j).getCellType()).equals("STRING")) {
					expectedMonthList.add(sheet.getRow(i).getCell(j).getStringCellValue());
				} else if (String.valueOf(sheet.getRow(i).getCell(j).getCellType()).equals("NUMERIC")) {
					if (lastCellIncrementIndex == 32) {
						expectedDayList.add(String.valueOf((long) sheet.getRow(i).getCell(j).getNumericCellValue()));
					} else if (lastCellIncrementIndex == 120) {
						expectedYearList.add(String.valueOf((long) sheet.getRow(i).getCell(j).getNumericCellValue()));
					}
				}
			}
		}
		System.out.println(actualDayList);
		System.out.println(expectedDayList);
		if (actualDayList.equals(expectedDayList)) {
			System.out.println(
					"Pass: The Day dropdown list box options order and spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Day dropdown list box options order and spelling is incorrect and it is verified.");
		}
		System.out.println(actualMonthList);
		System.out.println(expectedMonthList);
		if (actualMonthList.equals(expectedMonthList)) {
			System.out.println(
					"Pass: The Month dropdown list box options order and spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Month dropdown list box options order and spelling is incorrect and it is verified.");
		}
		System.out.println(actualYearList);
		System.out.println(expectedYearList);
		if (actualYearList.equals(expectedYearList)) {
			System.out.println(
					"Pass: The Year dropdown list box options order and spelling is correct and it is verified.");
		} else {
			System.out.println(
					"Fail: The Year dropdown list box options order and spelling is incorrect and it is verified.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
