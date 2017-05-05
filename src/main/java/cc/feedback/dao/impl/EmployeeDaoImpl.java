package cc.feedback.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.PendingFeedbackEntity;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(EmployeeEntity employee) {
		entityManager.persist(employee);
		entityManager.flush();
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		return entityManager.find(EmployeeEntity.class, id);
	}

	@Override
	public EmployeeEntity getEmployeeByUsername(String userName) {
		Query query = entityManager.createQuery("Select E FROM EmployeeEntity E WHERE E.userName =:userName");
		query.setParameter("userName", userName);
		List<EmployeeEntity> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public List<EmployeeEntity> getAllPendingReviews(Long id) {
		EmployeeEntity employee = getEmployeeById(id);
		List<PendingFeedbackEntity> pendingReviews = employee.getPendingFeedbacks();
		
		List<EmployeeEntity> employees = new ArrayList<>();
		for (PendingFeedbackEntity entity:pendingReviews) {
			employees.add(entity.getFeedbackFor());
		}
		return employees;
	}

	@Override
	public List<EmployeeEntity> getEmployeesThatHaveReviewsSoon() {
		Calendar now = Calendar.getInstance();
		return null;
//		Instant d1i = Instant.ofEpochMilli(now.getTimeInMillis());
//	    Instant d2i = Instant.ofEpochMilli(d2.getTimeInMillis());
//
//	    LocalDateTime startDate = LocalDateTime.ofInstant(d1i, ZoneId.systemDefault());
//	    LocalDateTime endDate = LocalDateTime.ofInstant(d2i, ZoneId.systemDefault());
//
//	    return ChronoUnit.WEEKS.between(startDate, endDate);
	}

}
