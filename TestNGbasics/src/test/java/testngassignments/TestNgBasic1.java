package testngassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgBasic1 {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// instead of set property we can use this code
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();

	}

	@Test
	public void verifyButtonText() {
		
		WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
		String actual = buttonname.getText();
		System.out.println(actual);

		String expected = "Show Selected Value";
		Assert.assertEquals(actual, expected);

	}
@Test
public void clickMale() {
	
	WebElement male_radio_btn = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
	male_radio_btn.click();
    boolean actual=male_radio_btn.isSelected();
	System.out.println(actual);
	
	
	boolean expected =true;
	Assert.assertEquals(actual, expected);
	
}

@Test
public void verifyFemaleBtn() {
	WebElement female_radio_btn = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
	
    boolean actual=female_radio_btn.isSelected();
	System.out.println(actual);
	
	
	boolean expected =false;
	Assert.assertEquals(actual, expected);
	
}
@Test
public void showmsgDisplay() {
	WebElement buttonname = driver.findElement(By.xpath("//button[@id='button-one']"));
	boolean actual=buttonname.isDisplayed();
	System.out.println(actual);

	boolean expected = true;
	Assert.assertEquals(actual, expected);
	
}

}
