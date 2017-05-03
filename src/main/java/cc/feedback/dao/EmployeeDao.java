package cc.feedback.dao;


import java.util.List;

import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.PendingFeedbackEntity;

public interface EmployeeDao {

	void save(EmployeeEntity employee);

	EmployeeEntity getEmployeeByUsername(String userName);

	EmployeeEntity getEmployeeById(Long id);

	List<PendingFeedbackEntity> getAllPendingReviews(Long id);

}
