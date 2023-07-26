package handlingframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame_02 {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/page1.html");
	driver.findElement(By.id("t1")).sendKeys("a");
	driver.switchTo().frame("f1");
	driver.findElement(By.id("t2")).sendKeys("b");
	driver.switchTo().defaultContent();
	driver.findElement(By.id("t1")).sendKeys("c");
	WebElement f = driver.findElement(By.id("f1"));
	driver.switchTo().frame(f);
	driver.findElement(By.id("t2")).sendKeys("d");
}
}
