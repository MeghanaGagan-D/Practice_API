package com.sample.crud.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetProjectsFromServerTest {
@Test
public void getProjectTest() {
	Response res = get("http://49.249.28.218:8091/projects");
	
	//assertion for status code
	res.then().assertThat().statusCode(200);
	
	res.then().log().all();
}
}
