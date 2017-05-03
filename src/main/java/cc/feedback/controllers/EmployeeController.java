package cc.feedback.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.dao.TeamDao;
import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.PendingFeedbackEntity;
import cc.feedback.entities.TeamEntity;

@RestController
@EnableAutoConfiguration
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private TeamDao teamDao;

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody EmployeeEntity employee) {
		employeeDao.save(employee);
	}

	@RequestMapping(value = "/employee/{id}/team", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> save(@RequestParam Long id) {
		TeamEntity team = teamDao.getTeamById(id);
		List<EmployeeEntity> teamMembers = new ArrayList<>();
		teamMembers.add(team.getTeamLeader());
		teamMembers.addAll(team.getTeamMembers());
		return teamMembers;
	}

	@RequestMapping(value = "/employee/{id}/pendingReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PendingFeedbackEntity> getAllPendingReviews(@RequestParam Long id) {
		return employeeDao.getAllPendingReviews(id);
	}


}