package petstore.practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletePetTest {
@Test
public void deletePetsTest()
{
	given().delete("https://petstore.swagger.io/v2/pet/9223372036854775807")
	.then().assertThat().statusCode(200)
	.log().all();
}
}
