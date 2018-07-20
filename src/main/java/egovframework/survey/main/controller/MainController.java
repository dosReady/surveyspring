package egovframework.survey.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.survey.main.service.MainService;

@Controller
public class MainController {
	
	
	@Autowired
	public MainService service;
	
	@RequestMapping(value ="/survey/index.do")
	public String index(ModelMap model){
		
		return "/main/content1";
	}
	
}
