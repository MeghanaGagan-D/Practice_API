package response.validation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class ExtectDataUsingComplexJsonPath {
	//need to add json path dependency
	
	@Test
	public void extractData()
	{
		Response res = given().get("http://49.249.28.218:8091/projects");
		
		ArrayList<String> list = JsonPath.read(res.asString(),".[*].projectId");
		
		for(String data:list)
		{
			System.out.println(data);
		}
	}
}
