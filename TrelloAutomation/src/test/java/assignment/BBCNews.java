package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BBCNews {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bbc.com/");
	String allNews = driver.findElement(By.xpath("(//ul[@class='top-list__list'])[1]")).getText();
	System.out.println(allNews);
	driver.quit();
}
}
