package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CleartripAssignment {
	@Test
	public void cleartrip() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cleartrip.com/");
		WebElement blrSelect = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
		blrSelect.sendKeys("Bangalore");
		wait.until(ExpectedConditions.elementToBeClickable(blrSelect));
		driver.findElement(By.xpath("//p[contains(.,'BLR')]")).click();
		WebElement mumSelect = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
		mumSelect.sendKeys("Mumbai");
		wait.until(ExpectedConditions.elementToBeClickable(mumSelect));
		driver.findElement(By.xpath("//p[contains(.,'BOM')]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'flex flex-middle')])[3]")).click();
		driver.findElement(By.xpath("(//div[text()='15'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Search flights']")).click();
		List<WebElement> flights = driver.findElements(By.className("fw-500 fs-2 c-neutral-900"));
		for (WebElement flight : flights) {
			System.out.println(flight.getText());
		}
		List<WebElement> departures = driver.findElements(By.className("m-0 fs-5 fw-400 c-neutral-900"));
		for (WebElement depart : departures) {
			System.out.println(depart.getText());
		}
		driver.quit();
	}
}
