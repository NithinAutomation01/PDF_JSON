package TestProj;

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
		FileReader reader = null;
		try {
			reader = new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\src\\main\\java\\TestProj\\FileHandler.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 p=new Properties();
		try {
			p.load(reader);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				JSONParser parser = new JSONParser();
				
				try {
					obj = parser.parse(new FileReader(p.getProperty("Request_json")));
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
		       jsonObj1.add(oldDeviceName);
		       jsonObj1.add(RetailPrice);
		       jsonObj1.add(CurrentPlanPrice);
		       jsonObj1.add(totalTaxes);
}}
