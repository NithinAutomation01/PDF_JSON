package TestProj;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfHandler {
	
	static ArrayList<String> pdfObject = new ArrayList<String>();
	static FileInputStream inStream;
	public PdfHandler(){
		Controlsheet cSheet = new Controlsheet();
		
		try {
			inStream = new FileInputStream(Controlsheet.PdfPath);
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

		
	}

}
