package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchLinks {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("wipro jobs"+Keys.ENTER);
		List<WebElement> allLinks = driver.findElements(By.tagName("h3"));
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
		}
		driver.quit();		
	}
}