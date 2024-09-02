package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarerTokenTest {
@Test
public void basicAutenticationTest() {
	given()
			.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3MjQ4MjU4OTgsImlhdCI6MTcyNDgyNDE1MSwianRpIjoiOTQyNGY5NDUtNjUzMy00Nzk1LWFlY2ItMzM2MWM3NTUwYjkxIiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiNzQwNjA5NjItNWUwNi00NDQ1LWJkOTgtZTZlODljMjdjODc4IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiNzQwNjA5NjItNWUwNi00NDQ1LWJkOTgtZTZlODljMjdjODc4IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.bWGRa1mXmvwi4eTk-n0k-10JE5EeijEK16uczvR1FNF4jj2GNScIqz1HB_Yq_LSEHPeeqvOvsHAjdznB2VHIpdX5vXsX-LTYp9cV5OYBApoE7ju7CMeup47w6B1xcRS2dw0xQ7LHbdEvndxPz8tYBkluHVw-SrjtR7FCjqj7qnYEcOJdub5G4pLOtsCVn0ravoKs2ShlJWMbCpKpQZBtmbHHfE1CCoGzaxEoeTgux4KWTV50UCafbDqRN_zrTRp9ViG1MwhzFXvExp8tgruJYFVVs1eMPHXYuVBBbR2mrLvwkagm83nzDfTdaWfQE8f4MgNHnkH1Z7vzENiYmSgufw")
			.log().all()
	.when().get("http://49.249.28.218:8091/projects")
	.then().log().all();
}
}