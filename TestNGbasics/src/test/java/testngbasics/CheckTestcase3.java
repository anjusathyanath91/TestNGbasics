package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckTestcase3 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();

	}

	@Test(dependsOnMethods = "displayButton")//since line 46 of dependend method displayButton() fails it will skip the testcase in output console we can see the line
	                                         //SKIPPED: testngbasics.CheckTestcase3.verifyButtontext

	public void verifyButtontext() {

		WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actual = buttonname.getText();
		System.out.println(actual);

		String expected = "Show Message";
		Assert.assertEquals(actual, expected);

	}

	@Test

	public void displayButton() {
		WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean actual = buttonname.isEnabled();
		System.out.println(actual);

		boolean expected = true;  //if it false will fail because the button is displayed 
		Assert.assertEquals(actual, expected);
	}
}
