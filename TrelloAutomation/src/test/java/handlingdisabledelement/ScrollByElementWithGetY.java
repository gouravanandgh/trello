package handlingdisabledelement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollByElementWithGetY {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bbc.com/");
		int y = driver.findElement(By.xpath("//span[text()='Future Planet']")).getLocation().getY();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0," + y + ")");
	}

}
