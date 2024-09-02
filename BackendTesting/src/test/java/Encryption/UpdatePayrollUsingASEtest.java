package Encryption;

import static io.restassured.RestAssured.given;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class UpdatePayrollUsingASEtest {
@Test
public void updatePayrollTest() throws Exception, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
{
	String jsonBody="{ \"employee\": { \"empId\":\"NH_00035\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 3000, \"lta\": 0, \"lwf\": 0, \"netPay\": 10000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 2000, \"status\": “Active/Disabled” }";
	String privateKey="AcO3tEam@j!tu_#1";
	
	EncryptAndDecryptUtility ed= new EncryptAndDecryptUtility();
	String encryptedData = ed.encrypt(jsonBody, privateKey);
	System.err.println(encryptedData);
	
	Response res = given()
						.body(encryptedData)
	.when().put("http://49.249.28.218:8091/payroll");
	res.then().log().all();
	
	String decryptedData = ed.decrypt(res.getBody().asString(), privateKey);
	System.out.println(decryptedData);




}

}
