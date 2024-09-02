package serialization.deserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* JSON--->>
 {
  	"projectName" : "orange",
  	"projectstatus" : "created",
  	"teamSize" :10,
  	"teamMember" : ["Jhon", "Devid", "Stev"],
  	"projectManager" : [{
  							"name" : "sagar",
  							"empID" : "tp01"
  						},
  						{
  							"name" : "sai",
  							"empID" : "tp02"
  						}
  }
 */

class Project2{
	String projectName;
	String projectstatus;
	int teamSize;
	List<String> teamMember;
	List<ProjectManager1> projectManager;
	
	 Project2(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager1 projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager=this.projectManager;
	}

	public List<ProjectManager1> getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(List<ProjectManager1> projectManager) {
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	
}

class ProjectManager1 {
	List<String> name;
	List<String> empID;

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public void setEmpID(List<String> empID) {
		this.empID = empID;
	}

	public List<String> getEmpID() {
		return empID;
	}

public ProjectManager1(List<String> name, List<String> empID) {
	super();
	this.name = name;
	this.empID = empID;
}

}

public class CreatingComplexPojoClassTest2 {
	public static void main(String[] args) throws Exception, DatabindException, IOException {
	
	List<String> teamMemberName= new ArrayList<String>();
	teamMemberName.add("Jhon");
	teamMemberName.add("Stev");
	teamMemberName.add("David");
	
	List<String> mangerName= new ArrayList<String>();
	mangerName.add("sagar");
	mangerName.add("sai");
	
	List<String> mangerId= new ArrayList<String>();
	mangerId.add("tp01");
	mangerId.add("tp02");
	
	ProjectManager1 pm=new ProjectManager1(mangerName, mangerId);
		
	Project2 pObj= new Project2("Meghana", "Created", 0, teamMemberName, pm);
	System.out.println(pObj.projectName);
	
	//serialization
	ObjectMapper objM= new ObjectMapper();
	
	objM.writeValue(new File("./project1.json"), pObj);
	
	
	}
}
	