package response.validation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JsonPathForDynamicData {
	@Test
	public void extractData()
	{
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		
		ArrayList<String> list=JsonPath.read(res.asString(),".[*].[?(@.projectName=='scrim1698')].projectd");
		String actProjectId = list.get(0);
		System.out.println(actProjectId);
		Assert.assertEquals(actProjectId, "NH_PROJ_036");
		
	}
}
