package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTooltip {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/window-popup.php ");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void tooltipText() {
		WebElement fb_like_btn = driver.findElement(By.xpath("//a[text()='  Like us On Facebook ']"));
		String actual = fb_like_btn.getAttribute("title");
		System.out.println(actual);
		String expected = "Follow @obsqurazone on Facebook";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void tooltipFont() {
		WebElement fb_like_btn = driver.findElement(By.xpath("//a[text()='  Like us On Facebook ']"));
		String actual = fb_like_btn.getCssValue("font-style");
		System.out.println(actual);
		String expected = "normal";
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 3)
	public void textofButton() {
		WebElement fb_like_btn = driver.findElement(By.xpath("//a[text()='  Like us On Facebook ']"));
		String actual = fb_like_btn.getText();
		System.out.println(actual);
		String expected = "Like us On Facebook";
		Assert.assertEquals(actual, expected);

	}
}
