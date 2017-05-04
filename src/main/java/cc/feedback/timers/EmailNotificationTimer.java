package cc.feedback.timers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.entities.EmployeeEntity;

@Component
public class EmailNotificationTimer {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Scheduled(cron = "0 0 1 * * *")
	public void checkForFeedbackTimes() {
		List<EmployeeEntity> employees =  employeeDao.getEmployeesThatHaveReviewsSoon();
	}
}
