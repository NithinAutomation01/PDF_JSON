package testPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfSampling2 extends JsonPathTesting {
	  static InputStream inStream = null;
	  BufferedInputStream fp = null;
		public static void main(String[] args) {
			ArrayList<String> firstList = new ArrayList<String>();
			ArrayList<String> secondList = new ArrayList<String>();
			secondList.add("And");
			secondList.add("text");
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
								 firstList.add(temp);
								 temp="";
							}
							
						 
							/*for(String k : firstList){
								System.out.println(k);
							}*/
							
							for(String k1 : secondList){
								System.out.println(k1);
							}
							
							ArrayList<String> thirdList= new ArrayList<String>();  
							//iterator using for-each loop  
							for(String tempList : FirstName) {   //tempList is  a variable  
							thirdList.add(secondList.contains(tempList) ? "Yes" : "No");  
							
							
							}  
							
							for(String k : thirdList){
								System.out.println(k);
								}
							
							
							
		}}