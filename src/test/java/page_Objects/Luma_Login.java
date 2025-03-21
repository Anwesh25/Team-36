package page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Login {
	
	//Constructor ,identify the element, Actions
	
	public static WebDriver driver;
	public Luma_Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[@class='authorization-link'])[1]")
	WebElement firstSignin;
	
	@FindBy(id="email")
	WebElement emaillogin;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(id="send2")
	WebElement clickSignIn;
	
	
	public void FirstSignin() {
		firstSignin.click();
	}
	
	public void setEmail(String email) {
		emaillogin.sendKeys(email);	
	}
	
	public void setpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void ClickSingin() {
		clickSignIn.click();
	}

}
