package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicTestCase1 {

	WebDriver driver;

	@BeforeMethod

	public void launchBrowser() {
		// instead of set property we can use this code
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@Test
	public void verifyTabtitle() {

		String actual_title = driver.getTitle();// application tab title
		System.out.println(actual_title);

		String expec_title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		// String expec_title="anju";
		// testng uses assertions to compare actual and expected results

		Assert.assertEquals(actual_title, expec_title);// always import from org.testng.Assert; first value should be
														// actual then expected to get meaningful output

	}

	@Test

	public void verifySignin() {

		WebElement visibletxt = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		String actual = visibletxt.getText();
		System.out.println(actual);

		String expected = "Hello, sign in";
		Assert.assertEquals(actual, expected);

	}

}
