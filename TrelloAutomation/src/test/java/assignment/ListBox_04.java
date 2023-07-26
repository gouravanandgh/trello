package assignment;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ListBox_04 {
	@Test
	public void getAllValuesAlphabetical() {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/days.html");
		List<WebElement> allOptions = driver.findElements(By.tagName("options"));
		
	}
}
