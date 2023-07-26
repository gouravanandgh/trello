package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDoubleClick {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.vtiger.com/");
		WebElement targetElement = driver.findElement(By.partialLinkText("Resources"));
		Actions a = new Actions(driver);
		a.moveToElement(targetElement).perform();
		driver.findElement(By.partialLinkText("Customers")).click();
		WebElement loginLink = driver.findElement(By.id("loginspan"));
		a.doubleClick(loginLink).perform();
		if (driver.getTitle().equals("Login - Vtiger")) {
			System.out.println("Pass: The Login page is displayed and it is verified.");
		} else {
			System.out.println("Fail: The Login page is not displayed and it is verified.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
