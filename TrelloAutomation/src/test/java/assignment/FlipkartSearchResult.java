package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartSearchResult {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 14 pro max"+Keys.ENTER);
		List<WebElement> allIphoneList = driver.findElements(By.className("_4rR01T"));
		List<WebElement> allPrices = driver.findElements(By.className("_30jeq3 _1_WHN1"));
		for (int i = 0; i <= allIphoneList.size(); i++) {
			System.out.println(allIphoneList.get(i).getText()+"=========>"+allPrices.get(i).getText());
		}
		driver.quit();
	}
}
