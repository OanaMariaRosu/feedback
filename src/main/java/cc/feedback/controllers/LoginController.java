package cc.feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cc.feedback.dao.EmployeeDao;
import cc.feedback.dto.LoginDto;
import cc.feedback.entities.EmployeeEntity;

@RestController
@EnableAutoConfiguration
public class LoginController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeEntity login(@RequestBody LoginDto body) throws Exception {
		System.out.println(body.getPassword() + " " +body.getUserName() );
		EmployeeEntity result = employeeDao.getEmployeeByUsername(body.getUserName());
		if(result != null) {
			return result.getPassword().equals(body.getPassword()) ? result : null;
		} else {
			throw new Exception();
		}
	}
	
}
