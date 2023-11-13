package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class LoginTest extends BaseHRMClass {
	PomLogin pomlog;
	// creating constructor
	public LoginTest() {
		super(); // calling constructor of parent class
	}

	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshot("Login");
		pomlog=new PomLogin();
	}
	
	@Test(priority=1)
	public void title() {
		String actual=pomlog.verifytitle();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object[][] details(){
		Object result[][]=Excelsheet.readdata("Sheet1"); //DataProvider will read data from excel sheet Sheet1
		return result;
		
	}
	@Test(priority=2,dataProvider="details")
	public void login(String uname,String pswd) throws InterruptedException {
	pomlog.typeusername(uname);
	Thread.sleep(2000);
	pomlog.typepassword(pswd);
		//pomlog.clickloginbtn();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
}
 