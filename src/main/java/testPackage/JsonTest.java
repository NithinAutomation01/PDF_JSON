package testPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest{
public static void main(String[] args) throws ParseException
{
    //JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();
    
  
    try (FileReader reader = new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"))
    {
   Object obj = jsonParser.parse(reader);

   JSONObject jsonObject = (JSONObject) obj;
  
   JSONObject ja_data =  (JSONObject) jsonObject.get("data");
   
   
  /* JSONObject ja_data1 =  (JSONObject) ja_data.get("customer");
   System.out.println(ja_data1.get("customerId"));*/
   			
   

   for(Iterator iterator = ja_data.keySet().iterator(); iterator.hasNext();) {
       String key = (String) iterator.next();
       System.out.println(key +":"+ja_data.get(key));
   }         
      

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } 
}}