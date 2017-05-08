package cc.feedback.dao;


import java.util.List;

import cc.feedback.entities.EmployeeEntity;

public interface EmployeeDao {

	void save(EmployeeEntity employee);

	EmployeeEntity getEmployeeByUsername(String userName);

	EmployeeEntity getEmployeeById(Long id);

	List<EmployeeEntity> getAllPendingReviews(String username);

	List<EmployeeEntity> getEmployeesThatHaveReviewsSoon();

}
