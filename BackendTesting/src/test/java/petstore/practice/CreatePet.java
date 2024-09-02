package petstore.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePet {
@Test
public void createPetTest()
{
	JSONObject json=new JSONObject();
	json.put("id",0);
	json.put("category.id",0);
	json.put("category.name","dog");
	json.put("name","Tusker");
	json.put("status","available");
	
	given().contentType(ContentType.JSON)
	.body(json.toJSONString())
	.when().post("https://petstore.swagger.io/v2/pet")
	.then().assertThat().statusCode(200)
	.log().all();
	
	
}
}
