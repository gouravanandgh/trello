package popuphandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOnChildPopup_7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		//Close all the tabs except the current tab
		Set<String> allTabs = driver.getWindowHandles();
		for (String tab : allTabs) {
			driver.switchTo().window(tab);
			if (driver.getTitle().equals("actiTIME - Time Tracking Software")) {
				System.out.println("This Tab will not be closed.");
			}else {
				driver.close();
			}
		}
	}

}
