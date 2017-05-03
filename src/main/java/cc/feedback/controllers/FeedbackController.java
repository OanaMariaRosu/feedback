package cc.feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feedback.dao.FeedbackDao;
import cc.feedback.dao.PendingFeedbackDao;
import cc.feedback.entities.FeedbackEntity;

@RestController
@EnableAutoConfiguration
public class FeedbackController {

	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private PendingFeedbackDao pendingFeedbackDao;

	@RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void processFeedback(@RequestBody FeedbackEntity feedback) {
		feedbackDao.save(feedback);
		pendingFeedbackDao.resolveFeedback(feedback.getGivenBy(), feedback.getGivenTo());

	}

}