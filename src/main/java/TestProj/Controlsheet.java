package TestProj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Controlsheet {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Scanner sc;
	static Properties p; 
	static FileInputStream ExcelFile= null;
	static String JsonPath;
	static String PdfPath;
	
	public Controlsheet(){
		try {
			ExcelFile = new FileInputStream("C:\\Users\\user\\workspace\\VerizonPOC\\ControlSheet.xlsx");
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
		 JsonPath= sheet.getRow(1).getCell(1).getStringCellValue();
			System.out.println(JsonPath);
			PdfPath= sheet.getRow(1).getCell(2).getStringCellValue();
			/*String Excel_Result_Path = sheet.getRow(1).getCell(3).getStringCellValue();*/
	}

}
