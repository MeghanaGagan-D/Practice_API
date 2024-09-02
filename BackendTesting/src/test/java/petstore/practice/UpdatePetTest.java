package petstore.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdatePetTest {
@Test
public void createPetTest()
{
	JSONObject json=new JSONObject();
	json.put("id",0);
	json.put("category.id",0);
	json.put("category.name","Cat");
	json.put("name","Richi");
	json.put("status","available");
	
	given().contentType(ContentType.JSON)
	.body(json.toJSONString())
	.when().put("https://petstore.swagger.io/v2/pet")
	.then().assertThat().statusCode(200)
	.log().all();
	
	
}
}
