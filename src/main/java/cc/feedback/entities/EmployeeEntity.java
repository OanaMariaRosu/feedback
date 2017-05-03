package cc.feedback.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String surname;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	@XmlTransient
	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAM_ID")
	private TeamEntity teamId;

	@Column(name = "DATE_OF_EMPLOYMENT")
	@Temporal(TemporalType.DATE)
	private Date dateOfEmployment;

	@Column(name = "NEXT_REVIEW_DATE")
	@Temporal(TemporalType.DATE)
	private Date nextReviewDate;

	@Column(name = "POSITION_IN_COMPANY")
	private String positionInCompany;

	@OneToMany(mappedBy = "feedbackFrom")
	private List<PendingFeedbackEntity> pendingFeedbacks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public TeamEntity getTeamId() {
		return teamId;
	}

	public void setTeamId(TeamEntity teamId) {
		this.teamId = teamId;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	public Date getNextReviewDate() {
		return nextReviewDate;
	}

	public void setNextReviewDate(Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}

	public String getPositionInCompany() {
		return positionInCompany;
	}

	public void setPositionInCompany(String positionInCompany) {
		this.positionInCompany = positionInCompany;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PendingFeedbackEntity> getPendingFeedbacks() {
		return pendingFeedbacks;
	}

	public void setPendingFeedbacks(List<PendingFeedbackEntity> pendingFeedbacks) {
		this.pendingFeedbacks = pendingFeedbacks;
	}

}
