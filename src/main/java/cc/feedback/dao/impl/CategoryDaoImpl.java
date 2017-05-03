package cc.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.CategoryDao;
import cc.feedback.entities.CategoryEntity;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CategoryEntity> getAllCategories() {
		Query query = entityManager.createQuery("SELECT c FROM CategoryEntity c");
		return query.getResultList();
	}

}
