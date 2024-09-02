package complex.postrequest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqViaJsonObjectTest {
	@Test
	public void viaJsonObj()
	{
	/*Creating Json pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("createdBy","Meghana");
	jsonObj.put("status","Created");
	jsonObj.put("teamSize",0);
	jsonObj.put("projectName","Scrim1");
	
	given().contentType(ContentType.JSON)
	.body(jsonObj.toJSONString())
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201)
	.log().all();
	}
}
