package popuphandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOnChildPopup_8 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		Set<String> allTabs = driver.getWindowHandles();
		//Print the title of all the Tabs
		for (String tab : allTabs) {
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}
}
