package TestProj;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jayway.jsonpath.JsonPath;

public class PurchaseReceiptPDF2_Base4{
	static FileOutputStream outputStream;
	static InputStream inStream = null;
	BufferedInputStream fp = null;
	static String telephonenumber;
	static String billamt;
	static String  upgradedFee;
	static String displayName;
	static String oldDeviceName;
	static String RetailPrice;
	static String CurrentPlanPrice;
	static String totalTaxes;
	static String Path = "C:\\Users\\user\\Desktop\\Demofolder\\Result.xlsx";
	public static void main(String[] args) throws Exception, IOException, ParseException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet("Purchase_receipt");
		 
		 // Reading json data 
			JSONParser parser = new JSONParser();
			
			Object obj = parser.parse(new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			telephonenumber = JsonPath.read( obj,"$.data.lineInfoList[0].mtn");
			 billamt = JsonPath.read( obj,"$.data.totalPaidToday");
              upgradedFee = JsonPath.read( obj,"$.data.lineInfoList[0].upgradeFee");
	        		 
	        displayName= JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.displayName");
	        oldDeviceName = JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.oldDeviceName");
	       	
	        RetailPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLineDevice.retailPrice");
	       CurrentPlanPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLinePlan.planPrice");
	       totalTaxes =  JsonPath.read(obj,"$.data.totalTaxes");
	       
	       for(int i =0;i<6;i++){
	           sheet.setColumnWidth(i,5000);  
	  		 }
	      
	       CellStyle style = workbook.createCellStyle(); //Create new style
           style.setWrapText(true);
		 //Headers section
		 Row rowtitle = sheet.createRow(0);
		 Cell FieldValue = rowtitle.createCell(0);
		 FieldValue.setCellStyle(style);
		 FieldValue.setCellValue("FieldValue");
		 Cell JsonValue = rowtitle.createCell(1);
		 JsonValue.setCellValue("Json Value");
		 Cell PdfValue = rowtitle.createCell(2);
		 PdfValue.setCellValue("PDF value");
		 Cell Result = rowtitle.createCell(3);
		 Result.setCellValue("Comparison Result");
		 Cell Remarks = rowtitle.createCell(4);
		 Remarks.setCellValue("Remarks");
		 
		 
		 
		 Row row = sheet.createRow(1); // Telephone Number
		 Cell customerId = row.createCell(0);
		 customerId.setCellValue("Telephone number");
		 
		 
		 Row row10 = sheet.createRow(2); // Bill Amount
		 Cell BillAmount = row10.createCell(0);
		 BillAmount.setCellValue("billAmount");
		 
		 Row row11 = sheet.createRow(3); // upgraded fee
		 Cell upgrade= row11.createCell(0);
		 upgrade.setCellValue("upgradedFee");
		 
		 Row row12 = sheet.createRow(4); // upgraded fee
		 Cell display= row12.createCell(0);
		 display.setCellValue("displayName");
		 
		 
		 
		
		ArrayList<String> pdfObject = new ArrayList<String>();
		ArrayList<String> jsonObj1 = new ArrayList<String>();
		Set<String> commonList = new HashSet<String>(); // common list between the json and the pdf
		jsonObj1.add(telephonenumber);
		jsonObj1.add(billamt);
		jsonObj1.add(upgradedFee);
		jsonObj1.add(displayName);
		jsonObj1.add(oldDeviceName);
		jsonObj1.add(RetailPrice);
		jsonObj1.add(CurrentPlanPrice);
		jsonObj1.add(totalTaxes);
		
		try {
			inStream = new FileInputStream(".\\driver\\purchaseReceipt_PDF.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedInputStream fp=new BufferedInputStream(inStream);
		PDDocument document=null;
		try {
			document=PDDocument.load(fp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pdfContent = null;
		try {
			pdfContent = new PDFTextStripper().getText(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] split = pdfContent.split(" ");
		int val =split.length;
		for(int i =0;i<val;i++){
			String temp = split[i];
			pdfObject.add(temp);
			temp="";
		}

		for(String kkk : pdfObject){
			System.out.println(kkk);
		}

		for(String k : pdfObject){
			for(String m:jsonObj1){
				if(k.contains(m)){
					commonList.add(m);
				}


			}}
		/*for(String k : jsonObj1){
			for(String m:pdfObject){
				if(m.contains(k)){
					commonList.add(m);
				}


			}}*/
		
		System.out.println("The common list between the two are as follows");
		for(String common : commonList){
		System.out.println(common);
		}

			//telephone number validation
		for(String z : commonList){
			int count=0;
			if(telephonenumber.contains(z)){
				
				System.out.println(z);
				Cell cust_json = row.createCell(1);
				 cust_json.setCellValue(z);
				 Cell cust_pdf = row.createCell(2);
				 cust_pdf.setCellValue(z);
			      Cell custome_message = row.createCell(3);
				 custome_message.setCellValue("Telephone number is present and matches with the json");
			count++;
			}
		else{	if(count>=1){
			Cell billValue_json = row.createCell(4);
			billValue_json.setCellValue("Does not match with the json");
			}}
			
		}	 //Bill Amount validation
		for(String z : commonList){
			int count=0;
			if(billamt.contains(z)){
				
				System.out.println(z);
				Cell customerId_json = row10.createCell(1);
				 customerId_json.setCellValue(z);
				 Cell customerId_pdf = row10.createCell(2);
				 customerId_pdf.setCellValue(z);
			      Cell custome_message1 = row10.createCell(3);
				 custome_message1.setCellValue("Bill Amount is present and matches with the json");
			count++;
			}
		else{	if(count>=1){
			Cell billValue_json1 = row10.createCell(4);
			billValue_json1.setCellValue("Does not match with the json");
			}}
			
		}
		
		// upgraded fee
		int temp =0;
		for(String z : commonList){
			
			if(upgradedFee.contains(z)){
				
				System.out.println(z);
				Cell cust_json = row11.createCell(1);
				 cust_json.setCellValue(z);
				 Cell cust_pdf = row11.createCell(2);
				 cust_pdf.setCellValue(z);
			      Cell custome_message = row11.createCell(3);
				 custome_message.setCellValue("upgradedfee  is present and matches with the json");
			temp++;
			}}
		if(temp==0){
			Cell billValue_json1 = row12.createCell(4);
			billValue_json1.setCellValue("Does not match with the json");
		}
					
		// display Name
		       int temp1 =0;
				for(String z : commonList){
					
					if(displayName.contains(z)){
						
						System.out.println("containsssss"+z);
						Cell cust_json = row12.createCell(1);
						 cust_json.setCellValue(z);
						 Cell cust_pdf = row12.createCell(2);
						 cust_pdf.setCellValue(z);
					      Cell custome_message = row12.createCell(3);
						 custome_message.setCellValue("Display Name  is present and matches with the json");
					temp1++;
					}
				}if(temp1==0){
						Cell billValue_json1 = row12.createCell(4);
						billValue_json1.setCellValue("Does not match with the json");
						  Cell custome_message = row12.createCell(1);
							 custome_message.setCellValue(displayName);
				
				}
					
			
				
				
		try {
			outputStream = new FileOutputStream(Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			workbook.write(outputStream);
			System.out.println("Excel sheet writing got done successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}}