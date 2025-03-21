package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Regestratrion {
	
	public static WebDriver driver;
	public  Luma_Regestratrion(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}	
	
	// identify the elements
	@FindBy(xpath="(//a[text()='Create an Account'])[1]")
	WebElement linkcreateanaccount;
	
	@FindBy(id="firstname")
	WebElement Firstname;
	
	@FindBy(id="lastname")
	WebElement Lastname;
	
	@FindBy(id="email_address")
	WebElement Email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="password-confirmation")
	WebElement ConfirmPassword;

	@FindBy(xpath="//*[@type='submit'][@class='action submit primary']")
	WebElement btncreateanaccount;
	
	
	public void clickcreateanaccount() {
		linkcreateanaccount.click();
	}
	
	public void setFirstname(String Fname) {
		Firstname.sendKeys(Fname);
	}
	
	public void setLastname(String Lname) {
		Lastname.sendKeys(Lname);
	}
	
	public void setEmail(String email_Addr) {
		Email.sendKeys(email_Addr);
	}
	
	public void setpassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void setConfirmpassword(String Cpass) {
		ConfirmPassword.sendKeys(Cpass);
	}
	
	public void clickcreateanaccountbtn() {
		btncreateanaccount.click();
	}
	
}
