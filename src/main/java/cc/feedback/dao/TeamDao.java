package cc.feedback.dao;

import java.util.List;

import cc.feedback.entities.TeamEntity;

public interface TeamDao {

	void save(TeamEntity team);

	List<TeamEntity> getAllTeams();

	TeamEntity getTeamById(Long teamId);

}
