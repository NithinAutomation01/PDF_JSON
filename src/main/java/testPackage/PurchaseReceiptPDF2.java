package testPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PurchaseReceiptPDF2  extends TempClass {
	static FileOutputStream outputStream;
	static InputStream inStream = null;
	BufferedInputStream fp = null;
	static String Path = "C:\\Users\\user\\Desktop\\test1.xlsx";
	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet("TestWritingtoExcel");
		 Row row = sheet.createRow(0);
		 Cell customerId = row.createCell(0);
		 customerId.setCellValue("CustomerID");
		 Row row1 = sheet.createRow(1);
		 Cell phoneNumber = row1.createCell(0);
		 phoneNumber.setCellValue("Phone number");
		 Row row2 = sheet.createRow(2);
		 Cell billValue = row2.createCell(0);
		 billValue.setCellValue("Bill value");
		ArrayList<String> pdfObject = new ArrayList<String>();
		ArrayList<String> jsonObject = new ArrayList<String>();
		Set<String> commonList = new HashSet<String>(); // common list between the json and the pdf
		jsonObject.add("404-450-9019");
		jsonObject.add("2112.83");
		jsonObject.add("353900108064084");
		
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


		for(String k : pdfObject){
			for(String m:jsonObject){
				if(k.contains(m)){
					commonList.add(m);
				}


			}}

		System.out.println("common list between the json and the pdf are as follows");
		for(String z : commonList){
			if(TempClass.customerId.contains(z)){
				System.out.println("customer id is present");
				System.out.println(z);
				Cell customerId_json = row.createCell(1);
				 customerId_json.setCellValue(z);
				 Cell customerId_pdf = row.createCell(2);
				 customerId_pdf.setCellValue(z);
			}
			
		}	 
		for(String z : commonList){
			if(TempClass.bill_value.contains(z)){
				System.out.println("Bill Id is present");
				System.out.println(z);
				 Cell billValue_json = row2.createCell(1);
				 billValue_json.setCellValue(z);
				 Cell billvalue_pdf = row2.createCell(2);
				 billvalue_pdf.setCellValue(z);
			}
			
		}	 
		for(String z : commonList){
			if(TempClass.phone_number.contains(z)){
				System.out.println("phone number is present");
				System.out.println(z);
				 Cell phonenumber_json = row1.createCell(1);
				 phonenumber_json.setCellValue(z);
				 Cell phonenumber_pdf= row1.createCell(2);
				 phonenumber_pdf.setCellValue(z);
			}
			
		}	 
		try {
			outputStream = new FileOutputStream(Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}}