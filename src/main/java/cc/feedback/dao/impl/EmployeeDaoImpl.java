package cc.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.entities.EmployeeEntity;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void save(EmployeeEntity employee) {
		entityManager.persist(employee);
		entityManager.flush();
	}

	@Override
	public List<EmployeeEntity> getAll() {
		String hql = "Select E FROM EmployeeEntity E";
		Query query = entityManager.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<EmployeeEntity> results = query.getResultList();
		return results;
	}

}
