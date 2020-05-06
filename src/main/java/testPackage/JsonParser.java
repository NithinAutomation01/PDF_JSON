package testPackage;


	
	import java.awt.List;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;

	import javax.xml.crypto.Data;

	import org.json.simple.parser.JSONParser;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;

	import com.jayway.jsonpath.JsonPath;


	public class JsonParser {
		
		    public static void main(String[] args)
		     {

		    	JSONParser jsonParser = new JSONParser();

		        try {     
		        	/*JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\ramve6x\\Desktop\\POC\\Filestocompare\\TradeInThermal.postman_collection.json"));
		        	    
		          
		            JSONArray jsonArray = (JSONArray) jsonObject.get("info");
		            Iterator<String> iterator = jsonArray.iterator();
		            
		            while(iterator.hasNext()) {
		               System.out.println(iterator.next());
		            }*/
		            
		            Object obj = jsonParser.parse(new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"));
		            JSONObject jsonObjectt = (JSONObject) obj;

		            JSONArray data = (JSONArray)jsonObjectt.get("item");
		            
		            JSONObject data2 = (JSONObject) jsonObjectt.get("info");
		            
		            System.out.println(data2.toJSONString());
		            
		            /*String name = JSONParser.read( jsonObjectt,"$.item[0].request.method");*/
		            
		            int itemsize= data.size();
		            
		           System.out.println(itemsize);
		            
		          /*  System.out.println(name);*/
		            
		           // System.out.println(f10);
		            
	               //  Iterator<JSONObject> iterator = data2.iterator();
		            
		           // while(iterator.hasNext()) {
		              // System.out.println(iterator.next());
		         //   }
		            
		      }
		        catch (FileNotFoundException e) {
		            e.printStackTrace();
		         } catch (IOException e) {
		               e.printStackTrace();
		         } catch (Exception e) {
		               e.printStackTrace();
		         }
		            
		            	}
	}