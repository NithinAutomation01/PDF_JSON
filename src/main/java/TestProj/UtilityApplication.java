package TestProj;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UtilityApplication  {
	public UtilityApplication(String next) {
		super();
		// TODO Auto-generated constructor stub
	}
	static ArrayList<String> commonList = new ArrayList<String>();
	static FileReader reader = null;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Scanner sc;
	/*public static void main(String args[]){*/
	@Test
	public void testExecutionflow(){
		sc = new Scanner(System.in);
    System.out.println("please enter the Subroutine for which the validation to be performed");
    String next = sc.next();
    /*System.out.println("please key in the json location");
    String json_location = sc.next();
    System.out.println("please key in the pdf location");
    String pdf_location = sc.next();*/
    JsonRequestReader jsonReader=new JsonRequestReader();	
	JsonHandler jHandler = new JsonHandler();
	ExcelHandler eHandler = new ExcelHandler(next);
	PdfHandler pHandler=new PdfHandler();
	

	
	//Iteration of PDf String objects
	System.out.println("Iteration of Pdf Objects");
	for(String pdfvalues :PdfHandler.pdfObject){
		System.out.println("pdf valuues"+pdfvalues);
	}
	
	
	
	//Iteration of Json values
	System.out.println("Iteration of json values");
	for(String jsonValues :JsonHandler.jsonObj1){
		System.out.println("json values"+jsonValues);
	}
	
	/*Comparison between the PDf and Json for getting common objects and adding to the
	   common list arraylist*/
	
	for(String k : PdfHandler.pdfObject){
		for(String m:JsonHandler.jsonObj1){
			if(k.contains(m)){
				commonList.add(m);
			}


		}}
	// Common values between Pdf and json
	for(String z :commonList){
		System.out.println("common values"+z);
	}

	
	
	
	//Telephone validation and subsequent printing
	int count=0;
	for(String z : commonList){
	if(JsonHandler.telephonenumber.contains(z)){
		eHandler.telephonevalidation(z);
		count++;
		}}
			if(count==0){
		eHandler.telephoneInvalidation(JsonHandler.telephonenumber);
		}
	
			//DisplayName validation and subsequent Printing
			
	
		       int count1 =0;
				for(String z : commonList){
					
					if(JsonHandler.displayName.contains(z)){
						eHandler.displayNameValidation(z);
						count1++;
					}}
			if(count1==0){
				eHandler.displayNameInvalidation(JsonHandler.displayName);
				
				}
		
			
			
			//Bill Amount validation and subsequent printing
			
			
	int count2=0;
	for(String z : commonList){
		if(JsonHandler.billamt.contains(z)){
		eHandler.billAmountValidation(z);
		count2++;
		}}
	if(count2==0){
		
		eHandler.billAmountInvalidation(JsonHandler.billamt);
	}

	
	   // upgraded fee validation and subsequent printing
	
	int count3 =0;
	for(String z : commonList){
		
		if(JsonHandler.upgradedFee.contains(z)){
			eHandler.upgradedFeevalidation(z);
		count3++;
		}}
	if(count3==0){
		eHandler.upgradedFeevalidation(JsonHandler.upgradedFee);
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
}
