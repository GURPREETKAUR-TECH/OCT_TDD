package testngPractice;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Google {
	WebDriver driver;
	SoftAssert c;
@BeforeSuite
public void driversetup() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\OCT_TDD\\chromedriver-win64\\chromedriver.exe");
	driver=new ChromeDriver();
}
	@BeforeClass
	public void window() {
		driver.manage().window().maximize();
		
	}
	@BeforeTest
	public void wait1() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void url() {
		driver.get("https://www.google.co.in/webhp");
	}
	@DataProvider
	public Object[][]keywords() {
		 return new Object[][] {{"amritvela"},{"simran"},{"nitnem"},{"bhagti"}};
	}
	
	@Test(priority=1)	
	public void title() {
		String title=driver.getTitle();
		System.out.println(title);
	  c=new SoftAssert();
	  c.assertEquals(title,"yahoo");
	  c.assertAll();
	 System.out.println("further execution");
		
	}
	@Test(priority=2,dataProvider="keywords")
	public void search(String value) throws InterruptedException {
		driver.findElement(By.id("APjFqb")).sendKeys(value);
		Thread.sleep(3000);
	}
	
//	@AfterMethod
//	public void close() {
//		driver.close();
//	}
	
}



