package com.sample.crud.withbdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostProjectToServerTest {
@Test
public void createProjecttest()
{
	/*Creating Json pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("createdBy","Meghana");
	jsonObj.put("status","Created");
	jsonObj.put("teamSize",0);
	jsonObj.put("projectName","Scrim67");
	
	given().contentType(ContentType.JSON)
	.body(jsonObj.toJSONString())
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201)
	.log().all();
	
}
}
