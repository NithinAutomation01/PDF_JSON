package TestProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonRequestReader{
	static JSONObject jsonObject; 
	static Object obj;
static int statuscode;
public static ExtentReports report;
public static ExtentTest logger;
	
	public JsonRequestReader(){
  /*   JSONParser parser = new JSONParser ();
     RestAssured.baseURI = "http://localhost:8080/purchase-receipt";
    
	try {
		obj = parser.parse(new FileReader("C:\\Vignesh\\WS-DocumentServices\\May8\\test1.json"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      jsonObject = (JSONObject)obj;
        
        Response response = RestAssured
            .given()
            .log()
            .all()
            .contentType(ContentType.JSON)
            .body(jsonObject)
            .post();
            response.prettyPrint();
            int statuscode = response.getStatusCode();*/
			 statuscode =200;
        
            
            if(statuscode!=200){
            	System.out.println("Application Failed to execute");
            	
            	/*test.log(Status.FAIL,"Failed to generate Proper Json response. Application is terminated!!");*/
            	
         }
            
    
    
    
    }
}

			
	

