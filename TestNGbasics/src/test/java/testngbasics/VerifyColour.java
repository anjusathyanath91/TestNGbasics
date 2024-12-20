package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyColour {

	WebDriver driver;
SoftAssert softassert=new SoftAssert();//soft assert object 

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/bootstrap-alert.php");
		driver.manage().window().maximize();

	}
	@Test
	
	public void verifyButtontext() {

		WebElement button_autoclosable = driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		
		String actual=button_autoclosable.getCssValue("background-color");
		System.out.println(actual);
		
		/*Hard Assert*/
		String expected = "rgba(40, 167, 69, 1)";//if it fails it throws an exception it is called hard assert

		
		//Assert.assertEquals(actual, expected);
		//System.out.println("helloo!!");
		
		//while using assert nd any failure occurs then all the lines after that error
		//wont execute.
		//This is because it is hard assert
		//For overcoming this we use softassert
		//in softassert it won't throw exception 
		
		softassert.assertEquals(actual, expected);
		
		
		String textofbtn=button_autoclosable.getText();
		String expected_txt="Autoclosable success1";//wrong text given to get error 
		System.out.println(textofbtn);
		softassert.assertEquals(textofbtn, expected_txt);//in softassert we can use multiple assertion
		softassert.assertAll();//to throw exception should need assertAll

	}

}
