package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
@Test
public void getTest()
{
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(res.prettyPrint());
	
}
}
