package com.sample.crud.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteProjectsFromServerTest {
@Test
public void deleteProjectTest() {
	Response res = delete("http://49.249.28.218:8091/project/NH_PROJ_183");
	
	//assertion for status code
	res.then().assertThat().statusCode(204);
	
	res.then().log().all();
}
}
