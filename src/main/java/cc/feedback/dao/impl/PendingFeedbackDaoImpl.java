package cc.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.PendingFeedbackDao;
import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.PendingFeedbackEntity;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class PendingFeedbackDaoImpl implements PendingFeedbackDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void resolveFeedback(EmployeeEntity from, EmployeeEntity to) {
		String hql = "Select P from PendingFeedbackEntity P where P.givenTo =:feedbackTo AND P.feedbackFrom=:feedbackFrom";
		Query query = entityManager.createQuery(hql);
		query.setParameter("feedbackTo", to.getId());
		query.setParameter("feedbackFrom", from.getId());
		List<PendingFeedbackEntity> results = query.getResultList();

		if (!results.isEmpty()) {
			entityManager.remove(results.get(0));
			entityManager.flush();
		}
	}

}
