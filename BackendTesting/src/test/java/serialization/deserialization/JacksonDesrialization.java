package serialization.deserialization;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDesrialization {
public static void main(String[] args) throws Exception, DatabindException, IOException {
	ObjectMapper objM=new ObjectMapper();
    Project pObj=objM.readValue(new File("./project.json"), Project.class);
    
    System.out.println(pObj.getProjectName());
    System.out.println(pObj.getCreatedBy());
    System.out.println(pObj.getTeamSize());
    System.out.println(pObj.getStatus());
}
}
