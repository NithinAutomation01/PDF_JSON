package TestProj;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {
	static Properties p; 
	static FileOutputStream outputStream;

	static FileReader reader = null;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Row row;
	static Row row12;
	static Row row10;
	static Row row11;
	//telephone number positive validation scenario
	public void telephonevalidation(String z){
		Cell cust_json = ExcelHandler.row.createCell(1);
		 cust_json.setCellValue(z);
		 Cell cust_pdf = ExcelHandler.row.createCell(2);
		 cust_pdf.setCellValue(z);
	      Cell custome_message = ExcelHandler.row.createCell(3);
		 custome_message.setCellValue("Telephone number is present and matches with the json");
		 Cell color_val = row.createCell(5);
		  color_val.setCellValue("PASS"); 
		 try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}// telephone number negative validation scenarios
public void telephoneInvalidation(String z){
		Cell billValue_json1 = row.createCell(4);
		billValue_json1.setCellValue("Does not match with the json");
		  Cell custome_message = row.createCell(1);
			 custome_message.setCellValue(z);
			 Cell color_val = row.createCell(5);
			  color_val.setCellValue("FAIL"); 
			  try {
					outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
					workbook.write(outputStream);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}


//Display Name positive validation scenarios
public void displayNameValidation(String z ){
	Cell cust_json = row12.createCell(1);
	 cust_json.setCellValue(z);
	 Cell cust_pdf = row12.createCell(2);
	 cust_pdf.setCellValue(z);
     Cell custome_message = row12.createCell(3);
	 custome_message.setCellValue("Display Name  is present and matches with the json");
	 try {
			outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
			workbook.write(outputStream);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

//DisplayName Negative Validation Scenarios
public void displayNameInvalidation(String displayName){
	Cell val = ExcelHandler.row12.createCell(4);
	val.setCellValue("Does not match with the json");
	  Cell msg = ExcelHandler.row12.createCell(1);
		 msg.setCellValue(displayName);
		 Cell CL = ExcelHandler.row12.createCell(5);
		  CL.setCellValue("FAIL"); 
		  try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}

// Bill Amount positive validations
	public void billAmountValidation(String z){
		Cell customerId_json = ExcelHandler.row10.createCell(1);
		 customerId_json.setCellValue(z);
		 Cell customerId_pdf = row10.createCell(2);
		 customerId_pdf.setCellValue(z);
	      Cell custome_message1 = row10.createCell(3);
		 custome_message1.setCellValue("Bill Amount is present and matches with the json");
		 Cell color_val = row10.createCell(5);
		  color_val.setCellValue("PASS"); 
		 try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	//Bill Amount negative validations
	
	public void billAmountInvalidation(String billamt){
		Cell billAmount = row10.createCell(4);
		billAmount.setCellValue("Does not match with the json");
		Cell msg = ExcelHandler.row10.createCell(1);
		 msg.setCellValue(billamt);
		 Cell CL = ExcelHandler.row10.createCell(5);
		  CL.setCellValue("FAIL");
		  try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}
	//upgraded fee positive validations
	public void upgradedFeevalidation(String z){
		Cell cust_json = row11.createCell(1);
		 cust_json.setCellValue(z);
		 Cell cust_pdf = row11.createCell(2);
		 cust_pdf.setCellValue(z);
	      Cell custome_message = row11.createCell(3);
		 custome_message.setCellValue("upgradedfee  is present and matches with the json");
		 Cell color_val = row11.createCell(5);
		  color_val.setCellValue("PASS"); 
		  try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void upgradedFeeInvalidation(String upgradedFee){
		Cell billAmount = row11.createCell(4);
		billAmount.setCellValue("Does not match with the json");
		Cell msg = ExcelHandler.row11.createCell(1);
		 msg.setCellValue(upgradedFee);
		 Cell CL = ExcelHandler.row10.createCell(5);
		  CL.setCellValue("FAIL");
		  try {
				outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
				workbook.write(outputStream);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ExcelHandler(String next){
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
		workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(next);
		 XSSFCellStyle style1 =  workbook.createCellStyle();  
		 for(int i =0;i<5;i++){
         sheet.setColumnWidth(i,6000);  
		 }

		//Header Section ---scope to iterate
		 //Headers section
		 Row rowtitle = sheet.createRow(0);
		 Cell FieldValue = rowtitle.createCell(0);
		 FieldValue.setCellValue("FieldValue");
		 Cell JsonValue = rowtitle.createCell(1);
		 JsonValue.setCellValue("Json Value");
		 Cell PdfValue = rowtitle.createCell(2);
		 PdfValue.setCellValue("PDF value");
		 Cell Result = rowtitle.createCell(3);
		 Result.setCellValue("Comparison Result");
		 Cell Remarks = rowtitle.createCell(4);
		 Remarks.setCellValue("Remarks");
		 Cell status = rowtitle.createCell(5);
		 status.setCellValue("Status");
		 
		 
		 // Row Creation Section
		 row = sheet.createRow(1); // Telephone Number
		 Cell customerId = row.createCell(0);
		 customerId.setCellValue("Telephone number");
		 
		 
		 row10 = sheet.createRow(2); // Bill Amount
		 Cell BillAmount = row10.createCell(0);
		 BillAmount.setCellValue("billAmount");
		 
		  row11 = sheet.createRow(3); // upgraded fee
		 Cell upgrade= row11.createCell(0);
		 upgrade.setCellValue("upgradedFee");
		 
		 row12 = sheet.createRow(4); // upgraded fee
		 Cell display= row12.createCell(0);
		 display.setCellValue("DisplayName");
		 
		 
try {
			outputStream = new FileOutputStream(p.getProperty("Write_Excel"));
			workbook.write(outputStream);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	

}

