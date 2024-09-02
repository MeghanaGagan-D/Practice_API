package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DigestAuthTest {
@Test
public void digestAutenticationTest() {
	given()
			.auth().digest("rmgyantra", "rmgy@9999")
			.log().all()
	.when().get("http://49.249.29.5:8091/login")
	.then().log().all();
}
}
