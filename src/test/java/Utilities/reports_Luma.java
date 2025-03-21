package Utilities;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass_0;

	public class reports_Luma implements ITestListener{
		
		public ExtentSparkReporter report;
		//It provides the Basic Information of the document--> (report name,document title, theme of the report)
		public ExtentReports extent;
		// It provides the Basic Inforamtion of the User --> (Username,hostname,OS,browser,Environment)
		public ExtentTest test;
		// It provides the basic information about TestCases --> Pass,failed,skipped
		
		
		//pre-defined methods (onStart,onTestSuccess,onTestFaiure,onTestSkipped,onFinish)
		
		public void onStart(ITestContext tr) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String rename = "Luma_Test_report"+timeStamp+".html";
			report = new ExtentSparkReporter("C:\\Users\\Personal\\Desktop\\LMS\\LMS_Backend\\LMS_backend_code\\ACE_HYB_F_3603\\extentReport_Luma\\"+rename);
			
			report.config().setDocumentTitle("Luma_Registration");
			report.config().setReportName("Luma_Registration_clothing");
			report.config().setTheme(Theme.DARK);
			
			
			extent = new ExtentReports();
			extent.attachReporter(report);
			
			extent.setSystemInfo("Username", "anwesh");
			extent.setSystemInfo("Hostname", "Local Host");
			extent.setSystemInfo("OS", "Windows10");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Environment", "QA");
		}
		
		public void onTestSuccess(ITestResult tr) {
			test = extent.createTest(tr.getName());
			
			test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestFailure(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
			
			try {
				String impactlocation = new BaseClass_0().captureScreenshot(tr.getName());
				test.addScreenCaptureFromPath(impactlocation); // add the screenshot into report
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void onTestSkipped(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		}
		
		public void onFinish(ITestContext context) {
			extent.flush();
		}
}