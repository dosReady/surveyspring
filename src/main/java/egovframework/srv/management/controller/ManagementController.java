package egovframework.srv.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.srv.management.service.ManagementService;

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
	
	@RequestMapping(value="/survey/reg.do" )
	public@ResponseBody String regSruvey(@RequestBody String val1, HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(val1);
		return "{}";
	}
	
}
