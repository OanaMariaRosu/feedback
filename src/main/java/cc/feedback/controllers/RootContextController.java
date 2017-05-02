package cc.feedback.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootContextController {

	@RequestMapping("/")
	public String home() {
		return "hello";
	}

}
