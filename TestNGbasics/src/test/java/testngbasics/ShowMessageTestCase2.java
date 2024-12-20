package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShowMessageTestCase2 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// instead of set property we can use this code
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();

	}

	@Test(priority = 1) // usually the test case executes in alphabetical order,Instead of this we can use priority to set the execution order
						// @Test(priority=1,enabled=false) it will disable the testcase
	                    // @Test(InvocationCount=3) it will execute the testcase 3 times

	public void verifyButtontext() {

		WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actual = buttonname.getText();
		System.out.println(actual);

		String expected = "Show Message";
		Assert.assertEquals(actual, expected);

	}
	// to check the testng report right click on project and refresh after testng execution
	// after refresh a folder named test_output will be created and right click on the folder->showIn-> System Explorer->open the emailable-report to see the report of the recent testng class

	@Test(priority = -1) // it will execute first because -1 is less than priority 1
	public void displayButton() {
		WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean actual = buttonname.isEnabled();
		System.out.println(actual);

		boolean expected = true;
		Assert.assertEquals(actual, expected);
		Assert.assertTrue(actual);// alternate way for Assert.assertEquals(actual, expected);
		Assert.assertEquals(actual, false, "failed due to error");// to give custom message in test report if the test
																	// case fails
	}

}
