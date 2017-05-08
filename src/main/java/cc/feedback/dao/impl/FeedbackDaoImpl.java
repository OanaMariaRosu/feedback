package cc.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackEntity> getFeedbacksGivenToEmployee(String username) {
		Query query = entityManager.createQuery("Select F FROM FeedbackEntity F WHERE F.givenTo.userName =:userName");
		query.setParameter("userName", username);
		List<FeedbackEntity> results = query.getResultList();

		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackEntity> getFeedbacksGivenByEmployee(String username) {
		Query query = entityManager.createQuery("Select F FROM FeedbackEntity F WHERE F.givenBy.userName =:userName");
		query.setParameter("userName", username);
		List<FeedbackEntity> results = query.getResultList();

		return results;
	}

	@Override
	public FeedbackEntity getLastFeedbackForEmployee(String username) {
		Query query = entityManager.createQuery("Select F FROM FeedbackEntity F LEFT JOIN F.ratings r WHERE F.givenBy.userName =:userName Order by F.givenAt desc");
		query.setParameter("userName", username);
		FeedbackEntity feedback = (FeedbackEntity) query.getResultList().get(0);
		feedback.getRatings();
		return feedback;
	}

}
