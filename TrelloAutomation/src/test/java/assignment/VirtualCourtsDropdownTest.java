package assignment;

import java.io.FileInputStream;
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

public class VirtualCourtsDropdownTest {
	public static void main(String[] args) throws Throwable {
		List<String> actualCourtList = new ArrayList<String>();
		List<String> expectedCourtList = new ArrayList<String>();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://vcourts.gov.in/virtualcourt/");
		List<WebElement> virtualCourts = driver.findElements(By.id("fstate_code"));
		for (WebElement court : virtualCourts) {
			Select courtSelect = new Select(court);
			List<WebElement> allCourtOptions = courtSelect.getOptions();
			for (WebElement courtOption : allCourtOptions) {
				actualCourtList.add(courtOption.getText());
				courtSelect.selectByVisibleText(courtOption.getText());
				if (courtOption.isSelected()) {
					System.out.println(courtOption.getText() + " is selected.");
				} else {
					System.out.println(courtOption.getText() + " is not selected.");
				}
			}
		}
		FileInputStream fis = new FileInputStream("./src/test/resources/vcourts.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("vclist");
		int firstRowIndex = sheet.getFirstRowNum();
		int lastRowIndex = sheet.getLastRowNum();
		for (int i = firstRowIndex + 1; i <= lastRowIndex; i++) {
			expectedCourtList.add(sheet.getRow(i).getCell(1).getStringCellValue());
		}
		System.out.println(actualCourtList);
		System.out.println(expectedCourtList);
		if (actualCourtList.equals(expectedCourtList)) {
			System.out.println("The Virtual Court list order and spelling is correct and it is verified.");
		} else {
			System.out.println("The Virtual Court list order and spelling is incorrect and it is verified.");
		}

		driver.manage().window().minimize();
		driver.quit();
	}
}
