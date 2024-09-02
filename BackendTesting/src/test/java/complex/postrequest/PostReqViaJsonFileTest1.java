package complex.postrequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReqViaJsonFileTest1 {
	@Test
	public void viaJsonObj()
	{
	File fileObj= new File("./NinjaProject.json");
	given().contentType(ContentType.JSON)
	.body(fileObj)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201)
	.log().all();
	}
}
