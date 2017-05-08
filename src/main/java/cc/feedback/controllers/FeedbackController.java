package cc.feedback.controllers;

import java.util.ArrayList;
import java.util.Date;
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
import cc.feedback.dao.EmployeeDao;
import cc.feedback.dao.FeedbackDao;
import cc.feedback.dao.PendingFeedbackDao;
import cc.feedback.dto.FeedbackDto;
import cc.feedback.entities.CategoryEntity;
import cc.feedback.entities.EmployeeEntity;
import cc.feedback.entities.FeedbackEntity;
import cc.feedback.entities.RatingEntity;

@RestController
@EnableAutoConfiguration
public class FeedbackController {

	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private PendingFeedbackDao pendingFeedbackDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void processFeedback(@RequestBody FeedbackDto feedbackDto) {

		FeedbackEntity feedbackEntity = new FeedbackEntity();
		EmployeeEntity givenBy = employeeDao.getEmployeeByUsername(feedbackDto.getFromUsername());
		EmployeeEntity givenTo = employeeDao.getEmployeeByUsername(feedbackDto.getToUsername());

		feedbackEntity.setGivenAt(new Date());
		feedbackEntity.setGivenBy(givenBy);
		feedbackEntity.setGivenTo(givenTo);

		List<RatingEntity> ratingEntities = new ArrayList<>();
		List<CategoryEntity> categories = categoryDao.getAllCategories();
		for (int i = 0; i < feedbackDto.getComments().size(); i++) {
			RatingEntity ratingEntity = new RatingEntity();
			ratingEntity.setCategory(categories.get(i));
			ratingEntity.setMessage(feedbackDto.getComments().get(i));
			ratingEntity.setRatingFor(feedbackEntity);
			ratingEntity.setScore(Integer.parseInt(feedbackDto.getScores().get(i)));
			ratingEntities.add(ratingEntity);
		}
		feedbackEntity.setRatings(ratingEntities);
		feedbackDao.save(feedbackEntity);

		pendingFeedbackDao.resolveFeedback(givenBy, givenTo);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryEntity> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@RequestMapping(value = "/feedback", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public FeedbackEntity getFeedback(@RequestParam(value = "id") Long id) {
		// get a feedback to see the returned json
		return feedbackDao.getFeedback(id);
	}

}
