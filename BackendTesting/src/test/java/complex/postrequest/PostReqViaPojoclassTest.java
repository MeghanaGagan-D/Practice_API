package complex.postrequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.pojoclass.NinjaProject;

import io.restassured.http.ContentType;

public class PostReqViaPojoclassTest {
	@Test
	public void viaJsonObj()
	{
	Random ran=new Random();
	int ranNum= ran.nextInt(2000);
		
	NinjaProject pojoObj= new NinjaProject("Meghana","scrim"+ranNum,"Created", 0);
		
	given().contentType(ContentType.JSON)
	.body(pojoObj)
	.when().post("http://49.249.28.218:8091/addProject")
	.then().assertThat().statusCode(201)
	.log().all();
	}
}
