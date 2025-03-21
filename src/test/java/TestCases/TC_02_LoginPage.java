package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLUtils;
import page_Objects.Luma_Login;

public class TC_02_LoginPage  extends BaseClass_0{
	
	@Test(dataProvider="Luma_TestData")
	public void LoginTest(String Email, String password) {
		
		Luma_Login lp = new Luma_Login(driver);
		lp.FirstSignin();
		lp.setEmail(Email);
		lp.setpassword(password);
		lp.ClickSingin();
	}
	
	@DataProvider(name="Luma_TestData")
	String [][] getData() throws IOException {
		String path = "C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\ACE_HYB_F_3603\\src\\test\\java\\TestData\\Luma_TestData_.xlsx";
		//Identify the RowCount
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		//Identify the Cell Count
		int cellcount = XLUtils.getcellcount(path, "Sheet1", 1);
		// row = 3;cell = 1
		// Retrieve the data
		String Logindata[][]= new String[rownum][cellcount]; //(1,0),(1,1)
				for(int i=1; i<=rownum; i++) {  // it will represents the rows
					for(int j=0;j<cellcount;j++) { //it will represents the cell
						Logindata[i-1][j] = XLUtils.getcelldata(path, "Sheet1", i, j);
					}
				}
				return Logindata;
	}

}
