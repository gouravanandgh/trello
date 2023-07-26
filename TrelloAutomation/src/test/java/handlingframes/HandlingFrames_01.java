package handlingframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames_01 {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("file:///C:/Users/GOURAV/Desktop/Selenium/page1.html");
	driver.switchTo().frame(0);
	driver.findElement(By.id("t2")).sendKeys("jsp");
	driver.switchTo().parentFrame();
	driver.findElement(By.id("t1")).sendKeys("qsp");
	
}
}
