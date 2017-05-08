package cc.feedback.controllers;

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
import cc.feedback.dao.FeedbackDao;
import cc.feedback.dao.TeamDao;
import cc.feedback.dto.TeamScoresDto;
import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.FeedbackEntity;
import cc.feedback.entities.TeamEntity;

@RestController
@EnableAutoConfiguration
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private TeamDao teamDao;

	@RequestMapping(value = "/employee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody EmployeeEntity employee) {
		employeeDao.save(employee);
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> getAllTeamMembers(@RequestParam(value = "id") Long id) {
		TeamEntity team = teamDao.getTeamById(id);
		return team.getTeamMembers();
	}

	@RequestMapping(value = "/employee/pendingReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> getAllPendingReviews(@RequestParam(value = "username") String username) {
		return employeeDao.getAllPendingReviews(username);
	}

	@RequestMapping(value = "/employee/receivedReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FeedbackEntity> getAllFeedbacksGivenToTheEmployee(@RequestParam(value = "username") String username) {
		return feedbackDao.getFeedbacksGivenToEmployee(username);
	}

	@RequestMapping(value = "/employee/givenReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FeedbackEntity> getAllFeedbacksGivenByTheEmployee(@RequestParam(value = "username") String username) {
		return feedbackDao.getFeedbacksGivenByEmployee(username);
	}

	@RequestMapping(value = "/employee/lastReview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FeedbackEntity getLastReviewOfEmployee(@RequestParam(value = "username") String username) {
		return feedbackDao.getLastFeedbackForEmployee(username);

	}

	@RequestMapping(value = "/employee/teamFeedbacks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TeamScoresDto> getScoresGivenByTeam(@RequestParam(value = "username") String username) {
		return feedbackDao.getScoresGivenByTeam(username);
	}

}
