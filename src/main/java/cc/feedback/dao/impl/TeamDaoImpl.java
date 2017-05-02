package cc.feedback.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cc.feedback.dao.TeamDao;
import cc.feedback.entities.TeamEntity;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class TeamDaoImpl implements TeamDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(TeamEntity team) {
		entityManager.persist(team);
		entityManager.flush();

	}

	@Override
	public List<TeamEntity> getAllTeams() {
		Query query = entityManager.createQuery("Select E FROM TeamEntity E");
		return query.getResultList();
	}

	@Override
	public TeamEntity getTeamById(Long teamId) {
		return entityManager.find(TeamEntity.class, teamId);
	}

}
