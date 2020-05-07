package testPackage;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PJson {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject data = (JSONObject) jsonObject.get("data");
			JSONObject customer = (JSONObject) data.get("customer");

			String customerId = (String) customer.get("customerId").toString();
			System.out.println("customerId: " + customerId.toString());
			JSONObject customerName = (JSONObject) customer.get("customerName");
			String fname = (String) customerName.get("firstName").toString();
			String lname = (String) customerName.get("lastName").toString();

			System.out.println("Name: " + fname + " " + lname);

			JSONArray lineInfoListArray = (JSONArray) data.get("lineInfoList");

			JSONObject lineInfoList = (JSONObject) lineInfoListArray.get(0);
			
			
			JSONObject cartLineItems = (JSONObject) lineInfoList.get("cartLineDevice");
			JSONObject imgmap = (JSONObject) cartLineItems.get("oldDeviceSku");
			

			/*for (Object ob : cartLineItems) {

				JSONObject a = (JSONObject) ob;
				System.out.println(a.get("displayName") + "|" + a.get("dpBuyoutAmount") + "|" + a.get("oldDeviceName"));

			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}