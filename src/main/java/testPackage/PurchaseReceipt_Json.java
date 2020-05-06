package testPackage;

import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class PurchaseReceipt_Json
{
	
	static ArrayList<String> FirstName = new ArrayList<String>();
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("PurchaseReceipt_RequestJson.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
          /*  System.out.println(employeeList);*/
             
            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
            
           
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("customerId");
         
    /*    //Get employee first name
        String firstNa = (String) employeeObject.get("firstName");    
        System.out.println(firstNa);
        FirstName.add(firstNa);
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");  
        System.out.println(lastName);
         
        //Get employee website name
        String website = (String) employeeObject.get("website");    
        System.out.println(website);*/
    }
}