package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass_0 {
	
	public Logger log;
	
	public static WebDriver driver;
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters({"browser","URL"})
	public void openApplication(String br, String url) {
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		rb = ResourceBundle.getBundle("Data");
		
		log = Logger.getLogger("ACE_HYB_F_3603");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	
	public String captureScreenshot(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE); 
		String Dest = System.getProperty("user.dir")+"\\Screenshot_01\\"+tname+"_"+timestamp+".png";
		try {
		FileUtils.copyFile(src, new File(Dest));
		}catch(Exception e) {
			e.getMessage();
		}
		return Dest;
		
		
		
	}
	
	
	
	
	
	
	
	

}
