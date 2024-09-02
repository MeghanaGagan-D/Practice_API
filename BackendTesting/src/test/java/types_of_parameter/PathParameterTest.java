package types_of_parameter;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParameterTest {
@Test
public void createProjecttest()
{
	/*Creating JSon pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("projectName","Scrim45");
	
	given().contentType(ContentType.JSON)
	.pathParam("projectId", "NH_PROJ_207")
	.body(jsonObj.toJSONString())
	.when().patch("http://49.249.28.218:8091/project/{projectId}")
	.then().assertThat().statusCode(200)
	.log().all();
	
}
}
