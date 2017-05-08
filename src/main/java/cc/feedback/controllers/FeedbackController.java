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

import cc.feedback.dao.CategoryDao;
import cc.feedback.dao.FeedbackDao;
import cc.feedback.dao.PendingFeedbackDao;
import cc.feedback.dto.FeedbackDto;
import cc.feedback.entities.CategoryEntity;
import cc.feedback.entities.FeedbackEntity;

@RestController
@EnableAutoConfiguration
public class FeedbackController {

	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private PendingFeedbackDao pendingFeedbackDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void processFeedback(@RequestBody FeedbackDto feedbackDto) {
		System.out.println(feedbackDto.getFromUsername());
		System.out.println(feedbackDto.getToUsername());
		System.out.println(feedbackDto.getScores());
		System.out.println(feedbackDto.getComments());
		// TODO: build FeedbackEntity
		// feedbackDao.save(feedback);
		//pendingFeedbackDao.resolveFeedback(feedback.getGivenBy(), feedback.getGivenTo());
	}
	
	@RequestMapping(value="/category", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryEntity> getAllCategories() {
		return categoryDao.getAllCategories();
	}
	
	@RequestMapping(value="/feedback", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FeedbackEntity getFeedback(@RequestParam(value="id") Long id) {
		// get a feedback to see the returned json
		return feedbackDao.getFeedback(id);
	}
	
}
