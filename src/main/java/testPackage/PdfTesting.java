package testPackage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfTesting {

	public static void main(String[] args) throws Exception {
		ArrayList<String> firstList = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver",
				"./driver/chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				driver.get("http://www.pdf995.com/samples/pdf.pdf");
				driver.manage().window().maximize();
				String Currentlink=driver.getCurrentUrl();
				URL url=new URL(Currentlink);
				InputStream is=url.openStream();
				BufferedInputStream fp=new BufferedInputStream(is);
				PDDocument document=null;
				document=PDDocument.load(fp);
				String pdfContent= new PDFTextStripper().getText(document);
						String[] split = pdfContent.split(" ");
						int val =split.length;
						for(int i =0;i<val;i++){
							String temp = split[i];
							 firstList.add(temp);
							 temp="";
						}
						for(String k : firstList){
							System.out.println(k);
						}
				/*System.out.println(pdfContent);
				boolean contains = pdfContent.contains("Gavin Bell of dfkjsddfSilicon Graphics has adapted");
				if(contains==true){
					System.out.println("contains");
				}else{
					System.out.println("does not contain");
				}
				
				*/
				
			}
		}
	
