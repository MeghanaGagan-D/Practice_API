package response.validation;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BodyAssertionTest {
	@Test
	public void validateHeaderTest()
	{
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		
		res.then().assertThat().body("[0].projectId", Matchers.equalTo("NH_PROJ_013"));
		res.then().assertThat().body("[10].createdBy", Matchers.equalTo("Meghana"));
		
		String data = res.jsonPath().get("[0].projectId");
		System.out.println(data);
		
		String data2 = res.jsonPath().get("[10].createdBy");
		System.out.println(data2);
		
		
		
	}
}
