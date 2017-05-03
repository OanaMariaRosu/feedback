package cc.feedback.dto;

import java.util.Date;
import java.util.List;

import cc.feedback.entities.RatingEntity;

public class FeedbackDto {

	private Long fromId;

	private Long toId;

	private Date givenAt;

	private List<RatingEntity> ratings;

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public Date getGivenAt() {
		return givenAt;
	}

	public void setGivenAt(Date givenAt) {
		this.givenAt = givenAt;
	}

	public List<RatingEntity> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingEntity> ratings) {
		this.ratings = ratings;
	}

}
