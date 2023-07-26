package handlingdisabledelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HandlingDisabledElement_01 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/disabled.html");
		driver.findElement(By.id("d1")).sendKeys("admin");
		RemoteWebDriver d = (RemoteWebDriver) driver;
		d.executeScript("document.getElementById('d2').value='manager'");

	}
}
