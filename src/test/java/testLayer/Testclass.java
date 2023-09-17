package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.POMclass;
import testdata.Excelsheet;

public class Testclass extends BaseClass {
	POMclass pom;
// create constructor to call parent class constructor using 'super' keyword
	public Testclass() {
		super();
	}
	@BeforeMethod
	public void initialsetup() {
		initiate();
		 pom=new POMclass();
		 screenshots("OCT_TDD");
	}
	@Test(priority=1)
	public void title() {
		String actual=pom.verify();
		Assert.assertEquals(actual,"Sign in");
	}
	@DataProvider
	public Object[][]details(){
		Object[][] result=Excelsheet.readdata("sheet1");
		return result;
	}
	@Test(dataProvider="details")
	public void signin(String email,String password) throws InterruptedException {
		pom.enteremail(email);
		Thread.sleep(3000);
		pom.enterpassword(password);
		Thread.sleep(3000);
		//pom.signinbtn();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
