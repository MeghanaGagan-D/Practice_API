package request.chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.pojoclass.AddEmployeePojoClass;
import com.pojoclass.NinjaProject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddEmployeeToProjectTest {
	@Test
	public void addEmployeeTest()
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
	String proName= res.jsonPath().get("projectName");
	System.out.println(proName);
	
	//API-2 creating employee
	AddEmployeePojoClass pobj=new AddEmployeePojoClass("QA", "05-05-1998","masha@gmail.com", "Masha", 3.5, "9790654567", proName, "Test Engineers", "masha" );
	
	Response res2 = given().contentType(ContentType.JSON)
	.body(pobj)
	
	.when().post("http://49.249.28.218:8091/employees");
	
	res.then().assertThat().statusCode(201)
	.log().all();
	
	}
}
