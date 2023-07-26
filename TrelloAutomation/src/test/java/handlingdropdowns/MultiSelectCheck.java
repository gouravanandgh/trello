package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectCheck {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("C:/Users/GOURAV/Desktop/Selenium/daydropdown.html");
		WebElement dayDropdown = driver.findElement(By.tagName("select"));
		Select daySelect = new Select(dayDropdown);
		// Multiselect check
		if (daySelect.isMultiple()) {
			System.out.println("Boolean True: Multi Select");
			Thread.sleep(3000);
		} else {
			System.out.println("Boolean False: Single Select");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
