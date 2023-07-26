package workonactionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UsageOfMoveToElement {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		//Identify the forgotten password
		WebElement forgotpwd = driver.findElement(By.linkText("Forgotten password?"));
		Actions actions = new Actions(driver);
		actions.moveToElement(forgotpwd).click().perform();
		driver.manage().window().minimize();
		driver.quit();
	}
}
