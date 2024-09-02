package com.sample.crud.withbdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchPartialUpdateTest {
@Test
public void partialUpdateProjecttest()
{
	/*Creating Json pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("projectName","Scrim");
	
	given().contentType(ContentType.JSON)
	.body(jsonObj.toJSONString())
	.when().patch("http://49.249.28.218:8091/project/NH_PROJ_8794")
	.then().assertThat().statusCode(200)
	.log().all();
	
}
}
