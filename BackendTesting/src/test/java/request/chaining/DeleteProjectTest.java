package request.chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.pojoclass.NinjaProject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteProjectTest {
	@Test
	public void deleteTest()
	{
	Random ran=new Random();
	int ranNum= ran.nextInt(2000);
		
	//API-1 creating project
	NinjaProject pojoObj=new NinjaProject("Meghana", "Spinz"+ranNum, "Created", 0);
	
	Response res = given().contentType(ContentType.JSON)
	.body(pojoObj)
	
	.when().post("http://49.249.28.218:8091/addProject");
	res.then().log().all().assertThat().statusCode(201);
	
	//capturing project name from the response
	String projectId= res.jsonPath().get("projectId");
	System.out.println(projectId);
	
	//API-2 deleting project
	given().delete("http://49.249.28.218:8091/project/"+projectId)
	.then().log().all()
	.assertThat().statusCode(204);
	
	}
}
