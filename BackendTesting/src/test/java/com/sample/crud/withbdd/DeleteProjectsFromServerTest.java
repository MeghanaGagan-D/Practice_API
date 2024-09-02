package com.sample.crud.withbdd;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DeleteProjectsFromServerTest {
@Test
public void deleteProjectTest() {
	given().delete("http://49.249.28.218:8091/project/NH_PROJ_8794")
	.then().assertThat().statusCode(204)
	.log().all();
}
}
