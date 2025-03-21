package TestCases;

import org.testng.annotations.Test;


import page_Objects.Luma_Regestratrion;

public class TC_01_Registration extends BaseClass_0 {
	
	Luma_Regestratrion lr ;
	@Test
	public void LumaRegistration() {
		lr = new Luma_Regestratrion(driver);
		lr.clickcreateanaccount();
		lr.setFirstname(rb.getString("Firstname"));
	//	System.out.println("the Firstname has enter 098");
		log.info("First Name entered Successfully");
		lr.setLastname(rb.getString("lastname"));
	//	System.out.println("the lastname has enter");
		log.info("Last Name entered Successfully");
		lr.setEmail(rb.getString("Email"));
	//	System.out.println("the Email has enter");
		log.info("Email Address entered Successfully");
		lr.setpassword(rb.getString("password"));
	//	System.out.println("the password has enter");
		log.info("Password entered Successfully");
		lr.setConfirmpassword(rb.getString("confirmpassword"));
	//	System.out.println("the Confirmpassword has enter");
		log.info("Confirm password entered Successfully");
		lr.clickcreateanaccountbtn();
		log.info("Clicked on login");
	}

}
