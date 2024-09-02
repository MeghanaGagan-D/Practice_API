package types_of_parameter;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParameterTest {
@Test
public void createProjecttest()
{
	given()
	.queryParam("projectName", "Scrim45")
	
	.when().get("http://49.249.28.218:8091/project")
	.then().assertThat().statusCode(200)
	.log().all();
	
}
}
