package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAlert {
	
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/javascript-alert.php");
		driver.manage().window().maximize();

	}
@Test
public void verifyAlert() {
	WebElement clickme_greenbutton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	clickme_greenbutton.click();
	String actual=driver.switchTo().alert().getText();
	System.out.println(actual);
	String expected="I am a Javascript alert box!";
	Assert.assertEquals(actual, expected);
}
}
