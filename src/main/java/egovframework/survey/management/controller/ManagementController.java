package egovframework.survey.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {
	
	@RequestMapping(value="/survey/management.do")
	public String index(){
		return "/management/index";
	}
	
}
