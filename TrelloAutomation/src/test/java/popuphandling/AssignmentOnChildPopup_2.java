package popuphandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentOnChildPopup_2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://secure.indeed.com/");
		driver.findElement(By.id("apple-signin-button")).click();
		driver.findElement(By.id("login-facebook-button")).click();
		Set<String> allWinHand = driver.getWindowHandles();
		//For closing all the browser except the specific browser.
		for (String winHand : allWinHand) {
			driver.switchTo().window(winHand);
			if (driver.getTitle().equals("Facebook")) {
				System.out.println("This browser is not closed.");
			}else
				driver.close();
		}
	}
}
