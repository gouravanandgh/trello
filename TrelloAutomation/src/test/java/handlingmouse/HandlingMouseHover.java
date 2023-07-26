package handlingmouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingMouseHover {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.vtiger.com/");
		WebElement target = driver.findElement(By.partialLinkText("Resources"));
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.partialLinkText("Contact Us")).click();
		WebElement phNo = driver.findElement(By.xpath("//p[contains(.,'Bengaluru')]/../p[2]"));
		System.out.println(phNo.getText());
		driver.quit();
	}
}
