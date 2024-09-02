package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostProjectToServerTest {
@Test
public void createProjecttest()
{
	/*Creating Json pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("createdBy","Meghana");
	jsonObj.put("status","Created");
	jsonObj.put("teamSize",0);
	jsonObj.put("projectName","Scrim9590");
	
	
	/*Setting content type*/
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	
	/*Specifying pay load or body*/
	req.body(jsonObj.toJSONString());
	
	/*Sending POST request*/
	Response res = req.post("http://49.249.28.218:8091/addProject");
	
	/*validation*/
	res.then().assertThat().statusCode(201);
	
	res.then().log().all();
	
}
}
