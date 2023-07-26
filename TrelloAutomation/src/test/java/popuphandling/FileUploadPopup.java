package popuphandling;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("C:\\Users\\GOURAV\\Desktop\\Selenium\\naukri.html");
	File f=new File("./src/test/resources/ResumeTest.txt");
	String absPath = f.getAbsolutePath();
	driver.findElement(By.id("cv")).sendKeys(absPath);
	Thread.sleep(3000);
	driver.quit();
}
}
