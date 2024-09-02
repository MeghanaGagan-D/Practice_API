package serialization.deserialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
	value= {"teamSize", "projectName", "teamSize", "status"}
)

@JsonIgnoreProperties
(
	value= {"teamSize"}, 
			allowSetters=true
)

class Project{	//POJO class [plain old java object]
	private String createdBy;
	@JsonProperty(value="created By")
	private String projectName;
	private String status;
	private int teamSize;
	
	public Project(String createdBy,String projectName, String status, int teamSize ) {
		this.createdBy=createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public Project() {}	
}

class JacksonSerialization {
public static void main(String[] args) throws Exception, DatabindException, IOException {
	Project pObj= new Project("Meghana","Leo","Created", 0);
	
	ObjectMapper objM=new ObjectMapper();
	objM.writeValue(new File("./project.json"), pObj);
	System.out.println("converted from java object to json-->>SERIALIZATION");
	
}
}
