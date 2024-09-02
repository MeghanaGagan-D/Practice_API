package com.sample.crud.withbdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectsFromServerTest {
@Test
public void getProjectTest() {
	
	given().get("http://49.249.28.218:8091/projects")
	.then().assertThat().statusCode(200)
	.log().all();
	
}
}
