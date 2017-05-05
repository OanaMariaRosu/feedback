package cc.feedback.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.FeedbackDao;
import cc.feedback.entities.FeedbackEntity;

@Repository
@Transactional
public class FeedbackDaoImpl implements FeedbackDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(FeedbackEntity feedbackEntity) {
		entityManager.persist(feedbackEntity);
		entityManager.flush();
	}

	@Override
	public FeedbackEntity getFeedback(Long id) {
		return entityManager.find(FeedbackEntity.class, id);
	}

}
