package response.validation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ResponseTimeAssertionTest {
	@Test
	public void validateResTimeTest()
	{
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		
		//to capture the time is milli seconds
		long resTime = res.time();
		
		//to capture the time in seconds
		long resTimeInSec = res.timeIn(TimeUnit.SECONDS);
		
		System.out.println(resTime);
		System.out.println(resTimeInSec);
		
		res.then().assertThat().time(Matchers.lessThan(900L));
		
		res.then().assertThat().time(Matchers.greaterThan(300L));
		
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
	}
}
