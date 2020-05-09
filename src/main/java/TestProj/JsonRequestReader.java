package TestProj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonRequestReader {
	static JSONObject jsonObject; 
	static Object obj;

	
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
				int statuscode =202;
            System.out.println(statuscode);
            if(statuscode!=200){
            	System.out.println("Application Failed to execute");
            	System.exit(0);
            					}
            
    
    
    
    }
}

			
	

