package TestProj;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonRequestReader {

	
	public JsonRequestReader(){

			File jsonFile = new File("PurchaseReceipt_RequestJson.json");
			
			RestAssured.baseURI = "url to be filled";
			Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.body(jsonFile)
				.post();
				response.prettyPrint();
				System.out.println(response.getStatusCode());
			
			JsonPath jsonPath = response.jsonPath();
			
			
			/*String number = jsonPath.get("id");
			System.out.println(number);*/
			
			
		}


	}

