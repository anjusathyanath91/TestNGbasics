package testngbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAnnotations {

	
	@BeforeSuite
	public void beforeSuite() {
	System.out.println("Executing before suite");	
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Executing before class");	
			
		}
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("Executing before group");	
			
		}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executing before Method");	
			
		}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Executing before test");	
			
		}
	@AfterClass
	public void afterClass() {
		System.out.println("Executing after class");	
			
		}
	@AfterGroups
	public void afterGroup() {
		System.out.println("Executing after group");	
			
		}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executing aftr method");	
			
		}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Executing aftr test");	
			
		}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Executing aftr suite");	
			
		}
	
	@Test
	public void test1() {
		System.out.println("Executing test1 method");	
			
		}
	
}
