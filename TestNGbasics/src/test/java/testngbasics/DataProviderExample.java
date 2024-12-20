package testngbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExample {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

	}

	/* single dimensional
	 @Test(dataProvider = "searchproduct", dataProviderClass = DataProviders.class)
	public void searchProduct(String product) {
		System.out.println(product);
		WebElement search = driver.findElement(By.xpath("//input[@id='single-input-field']"));
        search.sendKeys(product);
	}
	*/
	
	/*2 dimesional */
	@Test(dataProvider = "loginfb", dataProviderClass = DataProviders.class)
	public void loginPage(String uname,String paswrd) {
		driver.get("https://www.facebook.com/");
		WebElement username = driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys(uname);
		WebElement pwd = driver.findElement(By.xpath("//input[@id='pass']"));
		pwd.sendKeys(paswrd);
	}

}

//data provider feed data to test cases