package cc.feedback.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TEAM")
@XmlRootElement(name = "team")
public class TeamEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@JoinColumn(name="TEAM_LEADER_ID")
	@OneToOne
	private EmployeeEntity teamLeader;

	@OneToMany(mappedBy="teamId")
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

	public EmployeeEntity getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(EmployeeEntity teamLeader) {
		this.teamLeader = teamLeader;
	}

	public List<EmployeeEntity> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<EmployeeEntity> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
