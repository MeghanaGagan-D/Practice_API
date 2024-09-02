package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {
@Test
public void basicAutenticationTest() {
	Response res = given()
			.formParam("client_id", "ninza-client")			//these things will be given by developer
			.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
			.formParam("grant_type","client_credentials")

.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	
	//capture token from response
	String token= res.jsonPath().get("access_token");

	given()
			.auth().oauth2(token)
			.log().all()
	.when().get("http://49.249.28.218:8091/projects")
	.then().log().all();
}
}
