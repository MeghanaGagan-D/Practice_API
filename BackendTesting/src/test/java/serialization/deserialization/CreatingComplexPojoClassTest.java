package serialization.deserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* JSON--->>
 {
  	"projectName" : "orange",
  	"projectstatus" : "created",
  	"teamSize" :10,
  	"teamMember" : ["Jhon", "Devid", "Stev"],
  	"projectManager" : {
  							"name" : "sagar",
  							"empID" : "tp04"
  						}
  }
 */

class Project1 {
	String projectName;
	String projectstatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	Project1(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
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

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}
}

class ProjectManager {
	String name;
	String empID;

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

}

public class CreatingComplexPojoClassTest {
	public static void main(String[] args) throws Exception, DatabindException, IOException {

		List<String> teamMemberName = new ArrayList<String>();
		teamMemberName.add("Jhon");
		teamMemberName.add("Stev");
		teamMemberName.add("David");

		ProjectManager pm = new ProjectManager("sagar", "tp04");

		Project1 pObj = new Project1("Meghana", "Created", 0, teamMemberName, pm);
		System.out.println(pObj.projectName);

		// serialization
		ObjectMapper objM = new ObjectMapper();

		objM.writeValue(new File("./project1.json"), pObj);

	}
}
