package testPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PurchaseReceiptPDF  {
	static InputStream inStream = null;
	BufferedInputStream fp = null;
	public static void main(String[] args) {
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
			System.out.println(z);
			
		}

		}}