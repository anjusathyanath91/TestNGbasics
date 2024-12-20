package testngassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgWait {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/jquery-progress-bar.php");
		driver.manage().window().maximize();

	}
	@Test
	public void verifyButtonColour() {

		WebElement button_autoclosable = driver.findElement(By.xpath("//button[@id='downloadButton']"));
		
		String bgcolour=button_autoclosable.getCssValue("background-color");
		System.out.println(bgcolour);
		
		
		String expected = "rgba(246, 246, 246, 1)";

		
		Assert.assertEquals(bgcolour, expected);

}
	@Test
	public void checkEnable() {
		WebElement buttonname = driver.findElement(By.xpath("//button[@id='downloadButton']"));
		boolean actual = buttonname.isEnabled();
		System.out.println(actual);

		boolean expected = true; 
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void waitToDownload() {
		
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        WebElement startbtn = driver.findElement(By.xpath("//button[text()='Start Download']"));
	        startbtn.click();
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Cancel Download']")));
	        WebElement complete = driver.findElement(By.xpath("//div[text()='Complete!']"));
	        String actual = complete.getText();
	        
	        String expected="Complete!";
	        Assert.assertEquals(actual, expected);
		
	}
	
}
