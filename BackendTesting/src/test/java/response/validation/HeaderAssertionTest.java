package response.validation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderAssertionTest {
@Test
public void validateHeaderTest()
{
	Response res = given().get("http://49.249.28.218:8091/projects");
	res.then().log().all();
	
	res.then().assertThat().contentType(ContentType.JSON);
	
	res.then().assertThat().statusCode(200);
	
	res.then().assertThat().header("Connection", "keep-alive");
}
}
