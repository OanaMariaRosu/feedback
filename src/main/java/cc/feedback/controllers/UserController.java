package cc.feedback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.entities.EmployeeEntity;

@RestController
@EnableAutoConfiguration
public class UserController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeEntity> getAll() {
		return employeeDao.getAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody EmployeeEntity employee) {
		employeeDao.save(employee);
	}

}
