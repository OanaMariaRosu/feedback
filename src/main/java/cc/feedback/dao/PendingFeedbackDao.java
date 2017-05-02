package cc.feedback.dao;

import cc.feedback.entities.EmployeeEntity;

public interface PendingFeedbackDao {

	void resolveFeedback(EmployeeEntity from, EmployeeEntity to);
}
