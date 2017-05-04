package cc.feedback.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "TEAM", schema = "sql11172759")
@XmlRootElement(name = "team")
public class TeamEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@OneToMany(mappedBy="team")
	@JsonManagedReference
	private List<EmployeeEntity> teamMembers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<EmployeeEntity> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<EmployeeEntity> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
