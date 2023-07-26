package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> sugg = driver.findElements(By.xpath("//span[contains(.,'selenium')]"));
		for (WebElement e : sugg) {
			System.out.println(e.getText());
		}	
	}
}
