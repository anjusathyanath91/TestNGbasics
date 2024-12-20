package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgRadio {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();

	}
	@Test(priority=1)
	public void verifyButtonText() {
		
		WebElement show_selected_value_btn = driver.findElement(By.xpath("//button[@id='button-one']"));
		
		String actual=show_selected_value_btn.getText();
		System.out.println(actual);
		
		String expected="Show Selected Value";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority=2)
	public void verifyMaleRadiobtn() {
		
		WebElement male_radio_btn = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		male_radio_btn.click();
		boolean actual=male_radio_btn.isSelected();
		System.out.println(actual);
		boolean expected=true;
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=3)
	public void verifyFemaleRadioBtn() {
		
		WebElement female_radio_btn = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		boolean actual=female_radio_btn.isSelected();
		System.out.println(actual);
		boolean expected=false;
		Assert.assertEquals(actual, expected);
	}
}
