package egovframework.survey.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.survey.management.service.ManagementService;

@Controller
public class ManagementController {
	
	@Autowired
	public ManagementService service;
	
	@RequestMapping(value="/survey/management.do")
	public String index() throws Exception{
		return "/management/index";
	}
	
	@RequestMapping(value="/survey/regForm.do")
	public String regForm() throws Exception{
		return "/management/regForm";
	}
	
	@RequestMapping(value="/survey/reg.do")
	public String regSruvey() throws Exception{
		return "/management/index";
	}
	
}
