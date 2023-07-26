package assignment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ListBox_02 {
@Test
public void getTheUniqueValues() {
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/days.html");
	WebElement listBox = driver.findElement(By.id("a"));
	Select select=new Select(listBox);
	List<WebElement> allOptions = select.getOptions();
	Set set=new HashSet ();
	set.addAll(allOptions);
	for (Object object : set) {
		System.out.println(object);
	}
	driver.quit();
}
}
