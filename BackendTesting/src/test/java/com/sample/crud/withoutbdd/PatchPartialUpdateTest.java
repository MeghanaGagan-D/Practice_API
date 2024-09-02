package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchPartialUpdateTest {
@Test
public void partialUpdateProjecttest()
{
	/*Creating Json pay load*/
	JSONObject jsonObj= new JSONObject();
	jsonObj.put("projectName","Scrim");
	
	
	/*Setting content type*/
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	
	/*Specifying pay load or body*/
	req.body(jsonObj.toJSONString());
	
	/*Sending POST request*/
	Response res = req.patch("http://49.249.28.218:8091/project/NH_PROJ_8791");
	
	/*validation*/
	res.then().assertThat().statusCode(200);
	
	res.then().log().all();
	
}
}
