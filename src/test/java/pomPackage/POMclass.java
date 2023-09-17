package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class POMclass extends BaseClass {
@FindBy(id="email") WebElement email;
@FindBy(id="password") WebElement password;
@FindBy(id="next") WebElement signin;

//initiate page element
// create constructor
public POMclass() {
	PageFactory.initElements(driver,this);
}

// creaye methods for actions to be done over web elements
public void enteremail( String Email) {
	email.sendKeys(Email);
}
public void enterpassword(String Password) {
	password.sendKeys(Password);
}
public void signinbtn() {
	signin.click();
}
public String verify() {
	return driver.getTitle();
	
}
}
