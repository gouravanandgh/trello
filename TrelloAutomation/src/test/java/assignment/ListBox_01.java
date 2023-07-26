package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ListBox_01 {
@Test
public void listBoxTest() {
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/days.html");
	WebElement listBox = driver.findElement(By.id("a"));
	Select s = new Select(listBox);
	WebElement opt = s.getWrappedElement();
	System.out.println(opt.getText());
	driver.close();
}
}
