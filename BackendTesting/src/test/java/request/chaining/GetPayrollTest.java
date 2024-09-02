package request.chaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class GetPayrollTest {
@Test
public void getPayrollTest()
{
	//API-1 get authentication
	Response res = given()
					.formParam("client_id", "ninza-client")			//these things will be given by developer
					.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
					.formParam("grant_type","client_credentials")
	
	.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");

	res.then().log().all();
	
	//capture token from response
	String token= res.jsonPath().get("access_token");
		
	//API-2 get payroll info
	given()
			.auth().oauth2(token)
			.get("http://49.249.28.218:8091/admin/payrolls")
			.then().log().all();
	
	
}
}
