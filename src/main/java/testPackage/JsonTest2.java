package testPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest2{
public static void main(String[] args) throws ParseException
{
    //JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();
    
  
    try (FileReader reader = new FileReader("C:\\Users\\user\\workspace\\VerizonPOC\\PurchaseReceipt_RequestJson.json"))
    {
   Object obj = jsonParser.parse(reader);

   JSONObject jsonObject = (JSONObject) obj;
  
   JSONObject data =  (JSONObject) jsonObject.get("data");
   JSONObject customer =  (JSONObject) data.get("customer");
   JSONObject customerName =  (JSONObject) customer.get("customerName");
 /* System.out.println(customer.get("customerId"));
   System.out.println(customerName.get("firstName"));
   System.out.println(customerName.get("fullName"));
   
   System.out.println(data.get("lineInfoList"));
   */
   
   JSONObject paymentInfolist =  (JSONObject) data.get("storeInfo");
   System.out.println(paymentInfolist);
   JSONObject totalpaidToday =  (JSONObject) paymentInfolist.get("totalPaidToday");
   System.out.println(totalpaidToday);
   
  
   
 

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } 
}}