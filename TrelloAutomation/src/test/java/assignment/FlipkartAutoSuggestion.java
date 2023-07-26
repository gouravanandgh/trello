package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAutoSuggestion {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iphone 14 pro max");
		List<WebElement> allAutoSuggestions = driver.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for (WebElement autoSuggestion : allAutoSuggestions) {
			System.out.println(autoSuggestion.getText());
		}
		driver.findElement(By.xpath("//li[text()='iphone 14 pro max 1 tb']")).click();
	}
}
