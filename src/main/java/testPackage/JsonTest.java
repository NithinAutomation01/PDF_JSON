package testPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Map;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.ParseException;
	import com.fasterxml.jackson.core.JsonFactory;
	import com.fasterxml.jackson.core.type.TypeReference;
	import com.fasterxml.jackson.databind.JsonNode;
	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.jayway.jsonpath.JsonPath;

	public class JsonTest{
		
		    public static void main(String[] args)
		     {

		    	JSONParser jsonParser = new JSONParser();
		    	ObjectMapper mapper = new ObjectMapper();
		    	JsonFactory factory = new JsonFactory();
		    	
		        try {     
		        	/*JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\ramve6x\\Desktop\\POC\\Filestocompare\\TradeInThermal.postman_collection.json"));
		        	    
		          
		            JSONArray jsonArray = (JSONArray) jsonObject.get("info");
		            Iterator<String> iterator = jsonArray.iterator();
		            
		            while(iterator.hasNext()) {
		               System.out.println(iterator.next());
		            }*/
		           
		            Object obj = jsonParser.parse(new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\driver\\purchaseReceipt_PDF.pdf"));
		            JSONObject joo = (JSONObject) obj;
		            JSONArray data = (JSONArray)joo.get("item");
		            

		          //  JSONArray data = (JSONArray)jsonObject.get("paymentInfoList");
		                                 
		          
		            
		            String telephonenumber = JsonPath.read( joo,"$.data.lineInfoList[0].mtn");
		            
		         //   int itemsize= data.size();
		            
		      //     System.out.prtln("List size = " + itemsize);
		            
		            
		           
		            
		            
		            Map<String, Object> reqmap = mapper.readValue(new File(
		                    "C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"), new TypeReference<Map<String, Object>>() 
		            {
		            	
		            	
		            });
		           
		           
		           //JsonPath.read( joo,"$.data.customer") System.out.println("customer details = "  + JsonPath.read( joo,"$.data.customer"));
		            
		           Map<String, Object> customermap = mapper.readValue(JsonPath.read( joo,"$.data.customer.customerName").toString(), Map.class); 
		           String cfn = customermap.get("firstName").toString();
		           System.out.println("Customer firstname = " + cfn);
		                    
		           
		           String billamt = JsonPath.read( joo,"$.data.totalPaidToday");
		                     
		          String uf = JsonPath.read( joo,"$.data.lineInfoList[0].upgradeFee");
		        		 
		            String dn = JsonPath.read( joo,"$.data.lineInfoList[0].cartLineDevice.displayName");
		        	String odn = JsonPath.read( joo,"$.data.lineInfoList[0].cartLineDevice.oldDeviceName");
		       	
		        	String rp = JsonPath.read(joo,"$.data.lineInfoList[0].cartLineDevice.retailPrice");
		        	String clp = JsonPath.read(joo,"$.data.lineInfoList[0].cartLinePlan.planPrice");
		        String tx =  JsonPath.read(joo,"$.data.totalTaxes");
		        	
		        System.out.println("Telephone number = " + telephonenumber);
		        	System.out.println("Total bill amount = " + billamt);  
		        	System.out.println("Upgrade Fee = "+ uf);
		        	System.out.println("Display Name =  "+ dn);
		        	System.out.println("Old Device name = "+ odn);
		        	
		        	System.out.println("Retail price = "+ rp);
		        	System.out.println("Plan Price = "+ clp);
		        	System.out.println("Total Tax = " + tx);
		        	
		        	//Map<String, Object> lil = mapper.readValue(JsonPath.read( joo,"$.data.lineInfoList[0]").toString(), Map.class); 
			           
			        //.out.println( lil);
		          /* // System.out.println(f10);
		           * 
		            
	               //  Iterator<JSONObject> iterator = data2.iterator();
		            
		           // while(iterator.hasNext()) {
		              // System.out.println(iterator.next());
		         //   }
		            ArrayList<String> li = new ArrayList<String>();	
		            for(int i =0;i<itemsize;i++)
		            	
		            {
		            
		             li.add(JsonPath.read(jsonObjectt, "$.item[" + i + "].name").toString());
		          System.out.println("item" + i + "=" + li.get(i));
		            }
		         
		          */
		      }
		        
		        
		        catch (FileNotFoundException e) {
		            e.printStackTrace();
		         } catch (IOException e) {
		               e.printStackTrace();
		         } catch (ParseException e) {
		               e.printStackTrace();
		         }
		     }
		           	      	            	
	}