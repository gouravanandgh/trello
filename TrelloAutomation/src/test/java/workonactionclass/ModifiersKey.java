package workonactionclass;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModifiersKey {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/");
	Actions actions = new Actions(driver);
	WebElement usernameTextField = driver.switchTo().activeElement();
	actions.keyDown(usernameTextField,Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("a").keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	
}
}
