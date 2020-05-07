package testPackage;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

public class PJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		
			Object obj = parser.parse(new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			 String telephonenumber = JsonPath.read( obj,"$.data.lineInfoList[0].mtn");
			 String billamt = JsonPath.read( obj,"$.data.totalPaidToday");
             
	          String upgradedFee = JsonPath.read( obj,"$.data.lineInfoList[0].upgradeFee");
	        		 
	        String displayName= JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.displayName");
	        String oldDeviceName = JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.oldDeviceName");
	       	
	        String RetailPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLineDevice.retailPrice");
	        String CurrentPlanPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLinePlan.planPrice");
	        String totalTaxes =  JsonPath.read(obj,"$.data.totalTaxes");
			 System.out.println(telephonenumber);
			 System.out.println(billamt);
			 System.out.println(upgradedFee);
			 System.out.println(displayName);
			 System.out.println(oldDeviceName);
			 System.out.println(RetailPrice);
			 System.out.println(CurrentPlanPrice);
			

		
	}
}