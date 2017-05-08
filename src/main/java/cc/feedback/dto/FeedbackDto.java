package cc.feedback.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feedback")
public class FeedbackDto {

	private String fromUsername;

	private String toUsername;

	private Date givenAt;

	private List<String> scores;
	
	private List<String> comments;

	public String getFromUsername() {
		return fromUsername;
	}

	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}

	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	public Date getGivenAt() {
		return givenAt;
	}

	public void setGivenAt(Date givenAt) {
		this.givenAt = givenAt;
	}

	public List<String> getScores() {
		return scores;
	}

	public void setScores(List<String> scores) {
		this.scores = scores;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	

}
