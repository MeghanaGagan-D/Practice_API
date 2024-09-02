package data.driven.testing;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excel.utility.ExcelUtility;
import io.restassured.http.ContentType;

public class DDTUsingDataProviderFromExcelTest {
@Test(dataProvider ="getData")
public void createMultipleProjrcttest(String projectName, String status)
{
	String reqBody="{\r\n"
			+ "  \"createdBy\": \"Meghana\",\r\n"
			+ "  \"projectName\": \""+projectName+"\",\r\n"
			+ "  \"status\": \""+status+"\",\r\n"
			+ "  \"teamSize\": 0\r\n"
			+ "}" ;
	
	
	given().contentType(ContentType.JSON)
			.body(reqBody)
		.when().post("http://49.249.28.218:8091/addProject") 
		.then().log().all() ;
}
	@DataProvider
	public Object[][] getData() throws Exception
	{
		ExcelUtility elib=new ExcelUtility();
		int rowCount = elib.getRowCount("project");
		Object[][] objArr= new Object[rowCount][2];
		
		for(int i=0; i<rowCount; i++) {
		objArr[i][0]= elib.getDataFromExcel("project", i+1, 0);
		objArr[i][1]= elib.getDataFromExcel("project", i+1, 1);
		}
		return objArr;
	}
}
