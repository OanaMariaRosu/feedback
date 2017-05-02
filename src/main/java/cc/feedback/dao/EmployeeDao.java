package cc.feedback.dao;


import java.util.List;

import cc.feedback.entities.EmployeeEntity;

public interface EmployeeDao {

	void save(EmployeeEntity employee);

	List<EmployeeEntity> getAll();

}
