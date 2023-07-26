package handlingdropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMultipleOptions {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("C:/Users/GOURAV/Desktop/Selenium/daydropdown.html");
		WebElement dayDropdown = driver.findElement(By.tagName("select"));
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByIndex(0);
		daySelect.selectByIndex(4);
		daySelect.selectByIndex(9);
		Thread.sleep(3000);
		driver.manage().window().minimize();
		driver.quit();
	}
}
