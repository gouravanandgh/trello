package workonactionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	Actions actions = new Actions(driver);
	//actions.contextClick().perform();
	WebElement facebookLogo = driver.findElement(By.cssSelector("img[alt='Facebook']"));
	actions.contextClick(facebookLogo).perform();
	//driver.manage().window().minimize();
	driver.quit();
}
}
