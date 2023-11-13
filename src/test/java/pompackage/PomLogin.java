package pompackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{  // pom for login page
	
	//Object repository // keeping values that subjected to change in a variable.
	@FindBy(css= "#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input") WebElement username; //@FindBy=driver.findElement(By.
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input") WebElement password;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement loginbutton;
	
	//initiate page elements - creating constructor
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	// create methods- all possible actions that can be performed on elements
	public void typeusername(String name) throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); // wait till the element is visible
		username.sendKeys(name);
		
	}
	public void typepassword(String pswd) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); // wait till the element is visible
		password.sendKeys(pswd);
	}
	public void clickloginbtn() {
		loginbutton.click();
	}
	public String verifytitle() { // to verify the title of the page
		return driver.getTitle();
	}

}
