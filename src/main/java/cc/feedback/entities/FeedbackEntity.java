package cc.feedback.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "FEEDBACK")
@XmlRootElement(name = "feedback")
public class FeedbackEntity {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany
	private List<RatingEntity> ratings;

	@JoinColumn(name = "GIVEN_BY")
	@OneToOne
	private EmployeeEntity givenBy;

	@JoinColumn(name = "GIVEN_TO")
	@OneToOne
	private EmployeeEntity givenTo;

	@Column(name = "GIVEN_AT")
	@Temporal(TemporalType.DATE)
	private Date givenAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RatingEntity> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingEntity> ratings) {
		this.ratings = ratings;
	}

	public EmployeeEntity getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(EmployeeEntity givenBy) {
		this.givenBy = givenBy;
	}

	public EmployeeEntity getGivenTo() {
		return givenTo;
	}

	public void setGivenTo(EmployeeEntity givenTo) {
		this.givenTo = givenTo;
	}

	public Date getGivenAt() {
		return givenAt;
	}

	public void setGivenAt(Date givenAt) {
		this.givenAt = givenAt;
	}

}
