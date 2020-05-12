package TestProj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGeneration {
	 ExtentReports extent;
	 ExtentTest logger;
	 static ArrayList<String> commonList = new ArrayList<String>();
	 static ArrayList<String> pdfObject = new ArrayList<String>();
		static FileReader reader = null;
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		static Scanner sc;
		static Properties p; 
		static FileInputStream ExcelFile= null;
		 
		
		
	/*System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\workspace\\VerizonPOC\\driver\\chromedriver.exe");*/
	/*	WebDriver driver = new ChromeDriver();*/
		
		 
		 @BeforeTest
		 public void startReport(){
		
extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReporting/ReportGenerated.html", true);
extent
.addSystemInfo("Host Name", "Infosys_POC")
.addSystemInfo("Environment", "Dev Environment")
.addSystemInfo("User Name", "Infosys_QA_Team");

extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
}	
		 @Test(description="Verify if the save button is enabled")
		 public void TC001_JsonRequest_validation(){
			 logger = extent.startTest("TC001_JsonRequest_Validation");
			 logger.log(LogStatus.INFO ,"This test case is about  validating Json request generates a valid response");

			 JsonRequestReader jsonReader=new JsonRequestReader();
				int stat_code =JsonRequestReader.statuscode;
				System.out.println(stat_code);
				if(stat_code ==200){
					logger.log(LogStatus.PASS, "Test Case Passed");
				}else{
					 logger.log(LogStatus.FAIL, "Test Case Failed");
					 Assert.assertTrue(false);
					 System.exit(0);
					
					
				}
			
		 }
		 @Test
		 public void TC002_JsonDataGeneration(){
			 logger = extent.startTest("TC002_JsonData_Generation");
			 logger.log(LogStatus.INFO ,"This test case is about  validating json values are obtained using the script");
			    JsonRequestReader jsonReader=new JsonRequestReader();	
				JsonHandler jHandler = new JsonHandler();
				System.out.println("Iteration of json values");
				for(String jsonValues :JsonHandler.jsonObj1){
					System.out.println("json values"+jsonValues);
				}
					boolean ans = JsonHandler.jsonObj1.isEmpty();
					if (ans==false){
						logger.log(LogStatus.PASS, "Test Case Passed");
					}else{
						 logger.log(LogStatus.FAIL, "Test Case Failed");
						 Assert.assertTrue(false);
					}
				}
		 
		 @Test
		 public void TC003_PDFDataGeneration(){
			 logger = extent.startTest("TC003_PDF_data_generation");
			 logger.log(LogStatus.INFO ,"This test case is about  validating PDF values are obtained using the script");
			 JsonRequestReader jsonReader=new JsonRequestReader();	
				JsonHandler jHandler = new JsonHandler();
				PdfHandler pHandler=new PdfHandler();
				System.out.println("Iteration of json values");
				for(String pdfValues :PdfHandler.pdfObject){
					System.out.println("json values"+pdfValues);
				}
					boolean ans = PdfHandler.pdfObject.isEmpty();
					if (ans==false){
						logger.log(LogStatus.PASS, "Test Case Passed");
					}else{
						 logger.log(LogStatus.FAIL, "Test Case Failed");
						 Assert.assertTrue(false);
					}
				}
				
		 @Test
		 public void TC004_CommonDataGeneration(){
			 logger = extent.startTest("TC004_CommonData_generation");
			 logger.log(LogStatus.INFO ,"This test case is about analysing the common values between the pdf output and Json");
			 JsonRequestReader jsonReader=new JsonRequestReader();	
				JsonHandler jHandler = new JsonHandler();
				PdfHandler pHandler=new PdfHandler();
				for(String k : PdfHandler.pdfObject){
					for(String m:JsonHandler.jsonObj1){
						if(k.contains(m)){
							commonList.add(m);
						}


					}}
					boolean ans = commonList.isEmpty();
					if (ans==false){
						logger.log(LogStatus.PASS, "Test Case Passed");
					}else{
						 logger.log(LogStatus.FAIL, "Test Case Failed");
						 Assert.assertTrue(false);
					}
				}
				
		 @Test
		 public void TC005_ExcelDataValidation(){
			 logger = extent.startTest("TC005_ExcelValidation");
			 logger.log(LogStatus.INFO ,"This test case is about analysing the common values between the pdf output and Json");
				try {
					reader = new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\src\\main\\java\\TestProj\\FileHandler.properties");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				p =new Properties();
				try {
					p.load(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			try {
				ExcelFile = new FileInputStream(p.getProperty("Write_Excel"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				try {
					workbook = new XSSFWorkbook(ExcelFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sheet = workbook.getSheetAt(0);
				int colcount = sheet.getLastRowNum();
				System.out.println(colcount);
				for(int b= 1;b<=colcount;b++){
					String val = sheet.getRow(b).getCell(5).getStringCellValue();
					System.out.println(val);
						if(val.equals("FAIL")){
							 logger.log(LogStatus.FAIL, "Test Case Failed : Check the Excelsheet for more info");
							 Assert.assertTrue(false);
						
						}}
							 logger.log(LogStatus.PASS, "Test Case Pass");
							 
						}
		 
				
				
				
		 
		
		 @AfterMethod
		 public void getResult(ITestResult result){
		 if(result.getStatus() == ITestResult.FAILURE){
		 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
		 /*logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());*/
		 }else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 // ending test
		 //endTest(logger) : It ends the current test and prepares to create HTML report
		 extent.endTest(logger);
		 }
		 @AfterTest
		 public void endReport(){
	 
		                extent.flush();
		                extent.close();
		
		 
		 }
		
	}

