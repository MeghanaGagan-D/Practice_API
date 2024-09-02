package request.chaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.pojoclass.ShopperLoginPOJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TaskShopperStackTest {
@Test
public void shopperTest()
{
	ShopperLoginPOJO pojo=new ShopperLoginPOJO("meghaapi@gmail.com", "GTm@9590", "SHOPPER");
	Response res = given().contentType(ContentType.JSON)
			.body(pojo)
	.when().post("https://www.shoppersstack.com/shopping/users/login");
	res.then().log().all()
				.assertThat().statusCode(200);
	
	//capture Shopper Id from response
	int shopperId= res.jsonPath().get("data.userId");
	System.out.println(shopperId);
	
	//capture token from response
	String token= res.jsonPath().get("data.jwtToken");
	System.out.println(token);
	
	//add product to cart
	Response res2 = given()
			.get("https://www.shoppersstack.com/shopping/products/alpha");
	res2.then().log().all();
	
	//capture product Id from response
		int productId= res2.jsonPath().get("data[0].productId");
		System.out.println(productId);
}
}
