package workonactionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActitimeLoginByAction {
	WebDriver driver;
	@Test
	public void loginByActionTest() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		//Identify the username
		WebElement usernameTextField = driver.findElement(By.id("username"));
		//Identify the Password
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		//Identify the Login button
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		//Create the object for Actions class
		Actions actions = new Actions(driver);
		actions.sendKeys(usernameTextField, "admin").sendKeys(passwordTextField, "manager").click(loginButton).build().perform();
		driver.manage().window().minimize();
		driver.quit();
	}
}
