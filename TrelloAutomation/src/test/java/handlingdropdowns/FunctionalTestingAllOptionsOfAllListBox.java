package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTestingAllOptionsOfAllListBox {
	public static void main(String[] args) {
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
					if (dropdown.getAttribute("title").equals("Day")) {
						dropdownSelect.selectByVisibleText(option.getText());
						if (option.isSelected()) {
							System.out.println(option.getText()+" is selected.");
						}else
							System.out.println(option.getText()+" is not selected.");
					}else if (dropdown.getAttribute("title").equals("Month")) {
						dropdownSelect.selectByVisibleText(option.getText());
						if (option.isSelected()) {
							System.out.println(option.getText()+" is selected.");
						}else
							System.out.println(option.getText()+" is not selected.");
					}else if (dropdown.getAttribute("title").equals("Year")) {
						dropdownSelect.selectByVisibleText(option.getText());
						if (option.isSelected()) {
							System.out.println(option.getText()+" is selected.");
						}else
							System.out.println(option.getText()+" is not selected.");
					}
				}
			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
