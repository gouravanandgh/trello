package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinks {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	//Print all the link text
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	Thread.sleep(3000);
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	for (WebElement links : allLinks) {
		System.out.println(links.getText());
	}
}
}
