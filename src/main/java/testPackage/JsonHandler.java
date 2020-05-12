package testPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

public class JsonHandler {
	static String telephonenumber;
	static String billamt;
	static String  upgradedFee;
	static String displayName;
	static String oldDeviceName;
	static String RetailPrice;
	static String CurrentPlanPrice;
	static String totalTaxes;
	static Object obj;
	static Properties p;
	static JSONObject jsonObject;
	static ArrayList<String> jsonObj1 = new ArrayList<String>();
	public JsonHandler(){
		Controlsheet cSheet = new Controlsheet();
		FileReader reader = null;
         JSONParser parser = new JSONParser();
				try {
					obj = parser.parse(new FileReader(Controlsheet.JsonPath));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}
				jsonObject = (JSONObject) obj;
				
				telephonenumber = JsonPath.read( obj,"$.data.lineInfoList[0].mtn");
				 billamt = JsonPath.read( obj,"$.data.totalPaidToday");
	              upgradedFee = JsonPath.read( obj,"$.data.lineInfoList[0].upgradeFee");
		       displayName= JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.displayName");
		        oldDeviceName = JsonPath.read( obj,"$.data.lineInfoList[0].cartLineDevice.oldDeviceName");
		       	RetailPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLineDevice.retailPrice");
		       CurrentPlanPrice = JsonPath.read(obj,"$.data.lineInfoList[0].cartLinePlan.planPrice");
		       totalTaxes =  JsonPath.read(obj,"$.data.totalTaxes");
		       jsonObj1.add(telephonenumber);
		       jsonObj1.add(billamt);
		       jsonObj1.add(upgradedFee);
		       jsonObj1.add(displayName);
		       /*jsonObj1.add(oldDeviceName);
		       jsonObj1.add(RetailPrice);
		       jsonObj1.add(CurrentPlanPrice);
		       jsonObj1.add(totalTaxes);*/
}}
