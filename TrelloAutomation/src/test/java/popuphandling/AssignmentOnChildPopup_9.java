package popuphandling;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOnChildPopup_9 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]")).click();
		driver.findElement(By.linkText("About your actiTIME")).click();
		Thread.sleep(300);
		driver.findElement(By.linkText("Read Service Agreement")).click();
		String expectedTitle = "actiTIME Online Terms of Service";
		Set<String> allTabsAddress = driver.getWindowHandles();
		for (String tab : allTabsAddress) {
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
			if (driver.getTitle().equals(expectedTitle)) {
				List<WebElement> allHeadings = driver.findElements(By.tagName("h2"));
				for (WebElement heading : allHeadings) {
					System.out.println(heading.getText());
				}
			}
		}
		driver.quit();
	}
}
