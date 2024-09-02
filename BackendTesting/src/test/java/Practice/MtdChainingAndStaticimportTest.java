package Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MtdChainingAndStaticimportTest {
	@Test
	public void sampleTest()
	{
		
		/*get("https://reqres.in/api/users?page=2").prettyPrint();*/
		
		
		get("https://reqres.in/api/users?page=2").then().log().all();
	}

}
