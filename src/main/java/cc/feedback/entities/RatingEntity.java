package cc.feedback.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "RATING", schema = "sql11172759")
@XmlRootElement(name = "rating")
public class RatingEntity {

	@Id
	@GeneratedValue
	private Long id;

	@JoinColumn(name = "CATEGORY_ID")
	@OneToOne
	private CategoryEntity category;
	
	@JoinColumn(name = "FEEDBACK_ID")
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private FeedbackEntity ratingFor;

	private String message;

	private Integer score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public FeedbackEntity getRatingFor() {
		return ratingFor;
	}

	public void setRatingFor(FeedbackEntity ratingFor) {
		this.ratingFor = ratingFor;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
