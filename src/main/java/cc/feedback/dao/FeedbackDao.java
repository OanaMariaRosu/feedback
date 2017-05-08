package cc.feedback.dao;

import java.util.List;

import cc.feedback.entities.FeedbackEntity;

public interface FeedbackDao {

	void save(FeedbackEntity feedbackEntity);

	FeedbackEntity getFeedback(Long id);

	List<FeedbackEntity> getFeedbacksGivenToEmployee(String username);

	List<FeedbackEntity> getFeedbacksGivenByEmployee(String username);

	FeedbackEntity getLastFeedbackForEmployee(String username);
}
