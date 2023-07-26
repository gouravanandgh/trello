package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CareInsurance {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.careinsurance.com/rhicl/proposalcp/renew/index-care");
		driver.findElement(By.id("policynumber")).sendKeys("123");
		driver.findElement(By.id("dob")).click();
		new Select(driver.findElement(By.className("ui-datepicker-year"))).selectByVisibleText("1994");
		new Select(driver.findElement(By.className("ui-datepicker-month"))).selectByVisibleText("Jan");
		driver.findElement(By.linkText("10")).click();
		driver.findElement(By.id("alternative_number")).sendKeys("9845098450");
		driver.findElement(By.id("renew_policy_submit")).click();
		if (driver.findElement(By.id("policynumberError")).getText().equals("Please enter valid Policy No.")) {
			System.out.println("Pass: The warning messege is same as expected and it is verified.");
		} else {
			System.out.println("Fail: The warning messege is not same as expected and it is verified.");
		}
		driver.manage().window().minimize();
		driver.quit();
	}
}
