package workonactionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompositeAction {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		WebElement menSection = driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Men']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(menSection).pause(2000).moveToElement(menSection, 73, 0).pause(2000)
				.moveToElement(menSection, 148, 0).pause(2000).moveToElement(menSection, 245, 0).pause(2000)
				.moveToElement(menSection, 353, 0).pause(2000).moveToElement(menSection, 438, 0).pause(2000).perform();

	}
}
