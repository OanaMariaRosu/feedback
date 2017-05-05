package cc.feedback.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PENDING_FEEDBACK", schema = "sql11172759")
@XmlRootElement(name = "pendingFeedback")
public class PendingFeedbackEntity {

	@Id
	@GeneratedValue
	private Long id;

	@JoinColumn(name = "FEEDBACK_FOR")
	@OneToOne
	@JsonBackReference
	private EmployeeEntity feedbackFor;

	@JoinColumn(name = "FEEDBACK_FROM")
	@ManyToOne
	@JsonBackReference
	private EmployeeEntity feedbackFrom;

	@Column(name = "DUE_DATE")
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeEntity getFeedbackFor() {
		return feedbackFor;
	}

	public void setFeedbackFor(EmployeeEntity feedbackFor) {
		this.feedbackFor = feedbackFor;
	}

	public EmployeeEntity getFeedbackFrom() {
		return feedbackFrom;
	}

	public void setFeedbackFrom(EmployeeEntity feedbackFrom) {
		this.feedbackFrom = feedbackFrom;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
